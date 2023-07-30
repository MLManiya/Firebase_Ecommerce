package com.example.firebase_ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen_Activity extends AppCompatActivity {
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        runnable = new Runnable() {
            @Override
            public void run() {
                //    if(login==0)
                //    {
                Intent intent = new Intent(Splash_Screen_Activity.this, Home_Activity.class);
                startActivity(intent);
                finish();
                //   }
//                else
//                {
//                    Intent intent = new Intent(Splash_image_activity.this, MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable,2000);
    }
}