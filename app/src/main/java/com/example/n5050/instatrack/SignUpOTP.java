package com.example.n5050.instatrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUpOTP extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_otp);
        button=(Button) findViewById(R.id.btnCheckOtp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentOTP=new Intent(getApplicationContext(),SignUpUserName.class);
                startActivity(intentOTP);
            }
        });
    }
}
