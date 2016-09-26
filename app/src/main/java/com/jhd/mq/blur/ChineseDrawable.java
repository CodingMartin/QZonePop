package com.jhd.mq.blur;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

/**
 * Desc:
 * Author:Martin
 * Date:2016/9/26
 */

public class ChineseDrawable extends Drawable {

    public int firstDrawable;
    public int secondDrawable;
    public Bitmap mFirstBitmap;
    public Bitmap mSecondBitmap;
    public int gap = 3;
    private Paint mPaint;

    public ChineseDrawable(Context context, @DrawableRes int firstDrawable, @DrawableRes int secondDrawable) {
        this.firstDrawable = firstDrawable;
        this.secondDrawable = secondDrawable;
        mFirstBitmap = BitmapFactory.decodeResource(context.getResources(), firstDrawable);
        mSecondBitmap = BitmapFactory.decodeResource(context.getResources(), secondDrawable);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override public int getIntrinsicHeight() {
        return Math.max(mFirstBitmap.getHeight(), mSecondBitmap.getHeight());
    }

    @Override public int getIntrinsicWidth() {
        return mFirstBitmap.getWidth() + gap + mSecondBitmap.getWidth();
    }

    @Override public void draw(Canvas canvas) {
        canvas.drawBitmap(mFirstBitmap, 0, 0, mPaint);
        canvas.drawBitmap(mSecondBitmap, mFirstBitmap.getWidth() + gap, 0, mPaint);
    }

    @Override public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
