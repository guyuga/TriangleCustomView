package com.guyuga.trianglecustomview.BackgroundJobs;

import android.widget.TextView;

import com.guyuga.trianglecustomview.Services.PointsService;

/**
 * Created by guyug on 21/3/2017.
 */

public class CalculateAreaJob implements Runnable {

    private TextView mArea;

    public CalculateAreaJob(TextView area) {
        mArea = area;
    }

    @Override
    public void run() {
        final double area = PointsService.getInstance().calculateArea();
        mArea.post(new Runnable() {
            @Override
            public void run() {
                mArea.setText(String.valueOf(area));
            }
        });
    }
}
