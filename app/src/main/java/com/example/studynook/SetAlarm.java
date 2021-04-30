package com.example.studynook;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SetAlarm extends AppCompatActivity {

    private TimePicker alarmTime;
    private Button setAlarm;
    private Integer hour, minute;
//    protected int alarmId;
//    private TextView alarmTitle;
//    private CheckBox recurring, mon, tue, wed, thu, fri, sat, sun;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_alarm);

        ActionBar actionBar = getSupportActionBar();
        ColorDrawable color = new ColorDrawable(Color.parseColor("#FFA49C"));
        actionBar.setBackgroundDrawable(color);
        actionBar.setTitle("Set Alarm");

        // Initialise and assign variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set home selected
        bottomNavigationView.setSelectedItemId(R.id.schedule);

        // Switch to different tab when selected
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.schedule:
                        return true;
                    case R.id.resources:
                        startActivity(new Intent(getApplicationContext(), ResourcesPage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.wellbeing:
                        startActivity(new Intent(getApplicationContext(), WellBeingPage.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.create:
                        startActivity(new Intent(getApplicationContext(), CreatePage.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });

        alarmTime = findViewById(R.id.timePick);
        setAlarm = findViewById(R.id.setAlarm);

        hour = alarmTime.getCurrentHour();
        minute = alarmTime.getCurrentMinute();

        Intent intent = getIntent();
        intent.putExtra("hour", hour);
        intent.putExtra("minute", minute);

//        alarmTitle = findViewById(R.id.alarmTitle);
//        recurring = findViewById(R.id.recurring);
//        mon = findViewById(R.id.monday);
//        tue = findViewById(R.id.tuesday);
//        wed = findViewById(R.id.wednesday);
//        thu = findViewById(R.id.thursday);
//        fri = findViewById(R.id.friday);
//        sat = findViewById(R.id.saturday);
//        sun = findViewById(R.id.sunday);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_bar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.notibutton:
                //startActivity(new Intent(this, ));
                overridePendingTransition(0, 0);
                return true;

            case R.id.profilebutton:
                startActivity(new Intent(getApplicationContext(), ProfilePage.class));
                overridePendingTransition(0, 0);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}