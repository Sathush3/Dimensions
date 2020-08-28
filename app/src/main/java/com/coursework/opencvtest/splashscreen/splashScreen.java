package com.coursework.opencvtest.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.coursework.opencvtest.MainScreen;
import com.coursework.opencvtest.R;

public class splashScreen extends AppCompatActivity {

    // splashscreen to main screen time
    private static int SPLASH_SCREEN = 5000;
    //variables for splash screen
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        Log.d("app", "working: ");


        //Hooks
        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.title);
        slogan = findViewById(R.id.tagline);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainScreenIntent = new Intent(splashScreen.this, MainScreen.class);
                startActivity(mainScreenIntent);
                finish();
            }
        }, SPLASH_SCREEN);

    }
}