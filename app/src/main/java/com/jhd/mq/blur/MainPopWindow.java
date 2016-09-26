package com.jhd.mq.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;

/**
 * Desc:
 * Author:Martin
 * Date:2016/9/26
 */

public class MainPopWindow extends PopupWindow {
    private final View view;
    private TextView tvTimeDay;
    private TextView tvTimeWeek;
    private TextView tvTimeMonth;
    private ChineseCalendarView calendarView;
    private RecyclerView recyclerView;
    private MainMenuAdapter mAdapter;
    private MainActivity mMainActivity;

    public MainPopWindow(final Context context) {
        super(context);
        mMainActivity = (MainActivity) context;
        view = LayoutInflater.from(context).inflate(R.layout.layout_main_pop, null);
        setContentView(view);
        tvTimeDay = (TextView) view.findViewById(R.id.tv_time_day);
        tvTimeWeek = (TextView) view.findViewById(R.id.tv_time_week);
        tvTimeMonth = (TextView) view.findViewById(R.id.tv_time_month);
        calendarView = (ChineseCalendarView) view.findViewById(R.id.calendarView);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String week = DateUtil.getWeekOfDate(new Date());
        tvTimeDay.setText(String.valueOf(day));
        tvTimeWeek.setText(week);
        tvTimeMonth.setText(String.format("%d/%d", month, year));
        mAdapter = new MainMenuAdapter();
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 4));
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_right);
        final LayoutAnimationController controller = new LayoutAnimationController(animation,0.25f);
        controller.setOrder(LayoutAnimationController.ORDER_RANDOM);
        recyclerView.setLayoutAnimation(controller);
        //设置控件显示的顺序；
        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //设置控件显示间隔时间；
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        update();
//
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override public boolean onTouch(View v, MotionEvent event) {
                dismiss();
                return false;
            }
        });

        setOnDismissListener(new OnDismissListener() {
            @Override public void onDismiss() {
                setVisibility(0);


            }
        });

        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0000000000);
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);

    }

    private void setVisibility(int visiable) {
        int count = recyclerView.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = recyclerView.getChildAt(i);
            child.setAlpha(visiable);
        }
    }

    @Override public void showAtLocation(View parent, int gravity, int x, int y) {
        new BlurTask(mMainActivity).execute();
        super.showAtLocation(parent, gravity, x, y);
    }


    class BlurTask extends AsyncTask<Void, Void, Bitmap> {
        WeakReference<MainActivity> mReference;

        public BlurTask(MainActivity activity) {
            mReference = new WeakReference<>(activity);

        }

        @Override protected Bitmap doInBackground(Void... params) {
            Bitmap bitmap = ScreenUtils.captureWithoutStatusBar(mMainActivity);
            Bitmap bitmap1 = ImageUtils.fastBlur(mMainActivity, bitmap, 0.3f, 15);
            return bitmap1;
        }

        @Override protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            view.setBackgroundDrawable(new BitmapDrawable(bitmap));
            setVisibility(1);
            recyclerView.startLayoutAnimation();
        }
    }

}
