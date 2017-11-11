package com.example.n5050.instatrack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

public class SplashHome extends AppCompatActivity {
    ProgressBar progressBar;
    public static int splash_time_out=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_home);
        ProgressBar progressBar=(ProgressBar) findViewById(R.id.progressBar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              /*  if (SharedPrefManager.getInstance(getApplicationContext()).isLogin())  {
                    if (SharedPrefManager.getInstance(getApplicationContext()).getUserType().contains("tutor")) {
                        Intent in = new Intent(SplashActivity.this, TutorProfile.class);
                        startActivity(in);
                        finish();
                    } else{
                        Intent intent = new Intent(SplashActivity.this, StudentProfile.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Intent in = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(in);
                    finish();
                } */
            }
        }, splash_time_out);

    }

}
