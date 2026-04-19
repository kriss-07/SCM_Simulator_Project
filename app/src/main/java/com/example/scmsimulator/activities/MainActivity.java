package com.example.scmsimulator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.scmsimulator.managers.Storage;
import com.example.scmsimulator.R;

public class MainActivity extends AppCompatActivity {
    private Storage storage;
    private TextView activeCrewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        storage = Storage.getInstance();
        activeCrewText = findViewById(R.id.text_active_crew);
        
        setupNavigationButton(R.id.btn_recruit, RecruitActivity.class);
        setupNavigationButton(R.id.btn_quarters, QuartersActivity.class);
        setupNavigationButton(R.id.btn_simulator, SimulatorActivity.class);
        setupNavigationButton(R.id.btn_med_base, MedBaseActivity.class);
        setupNavigationButton(R.id.btn_mission_control, MissionControlActivity.class);
        setupNavigationButton(R.id.btn_statistics, StatisticsActivity.class);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        activeCrewText.setText("Total Crew Members: " + storage.getAllCrew().size());
    }

    private void setupNavigationButton(int buttonId, final Class<?> activityClass) {
        View btn = findViewById(buttonId);
        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, activityClass));
                }
            });
        }
    }
}
