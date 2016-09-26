package com.jhd.mq.blur;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Desc:
 * Author:Martin
 * Date:2016/9/26
 */

public class ChineseCalendarView extends LinearLayout {
    public ChineseCalendarView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public ChineseCalendarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public ChineseCalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP) public ChineseCalendarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        inflate(context, R.layout.layout_nong_li_view, this);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        ImageView imageView = (ImageView) findViewById(R.id.iv_nongli);
        imageView.setImageDrawable(CalendarUtil.getNLDayOfDrawable(getContext()));
        TextView textView = (TextView) findViewById(R.id.tv_month);
        textView.setText(String.format("%d月", Calendar.getInstance().get(Calendar.MONTH) + 1));
    }
}
