package com.guyuga.trianglecustomview.Entities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by guyug on 21/3/2017.
 * simple canvas for drawing XY grid
 */

public class AxisView extends View {

    private Paint mPaint;

    public AxisView(Context context, int color) {
        super(context);
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setStrokeWidth(5f);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        canvas.drawLine(0, height/2, width, height/2, mPaint);
        canvas.drawLine(width/2, 0, width/2, height, mPaint);
    }
}
