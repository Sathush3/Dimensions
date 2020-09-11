package com.coursework.opencvtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.coursework.opencvtest.identifyImage.uploadFragment;
import com.coursework.opencvtest.onScreenRuler.Measure;
import com.google.android.material.navigation.NavigationView;




public class MainScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static String TAG = "MainScreen";
    private DrawerLayout drawer;
    Button cameraButton;
    Intent shareIntent;
    String shareBody = "This is  great App! " +
            "Get at this link";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        cameraButton = findViewById(R.id.camera_click);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainScreen.this, Measure.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera:
                Intent intent = new Intent(MainScreen.this, Measure.class);
                startActivity(intent);

//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new cameraFragment()).commit();
                break;
            case R.id.nav_upload:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new uploadFragment()).commit();
                Intent intent1 = new Intent(MainScreen.this,secondary.class);
                startActivity(intent1);

                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new profileFragment()).commit();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My App");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Share via"));

                break;
            case R.id.nav_send:
                Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}