package comsci.kwan.healthtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import comsci.kwan.healthtest.healthyshop.MainActivity;

public class Starts extends AppCompatActivity {
    private static final long SPLASH_TIME=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starts);

            TimerTask task=new TimerTask() {
                @Override
                public void run() {
                    Intent mainIntent=new Intent().setClass(Starts.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }
            };
            Timer timer=new Timer();
            timer.schedule(task,SPLASH_TIME);
        }
    }


