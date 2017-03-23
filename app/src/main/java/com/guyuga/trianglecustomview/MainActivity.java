package com.guyuga.trianglecustomview;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.guyuga.trianglecustomview.BackgroundJobs.CalculateAreaJob;

public class MainActivity extends AppCompatActivity {

    private static final int MILLIS_IN_FUTURE = 6000;
    private static final int INTERVAL = 1000;
    private TextView timer;
    private TextView area;
    private CountDownTimer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = (TextView) findViewById(R.id.txt_timer);
        area = (TextView) findViewById(R.id.txt_area);

        initTimer();
    }

    private void initTimer() {
        mTimer = new CountDownTimer(MILLIS_IN_FUTURE,INTERVAL) {
            @Override
            public void onTick(long l) {
                int secondsLeft = (int) (l / 1000);
                timer.setText(getString(R.string.timer_pre_text,secondsLeft));
            }

            @Override
            public void onFinish() {
                timer.setText(getString(R.string.timer_pre_text,0));
                new CalculateAreaJob(area).run();
                this.start();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        mTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        mTimer = null;
        super.onDestroy();
    }
}
