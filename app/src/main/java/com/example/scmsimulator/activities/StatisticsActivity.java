package com.example.scmsimulator.activities;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.scmsimulator.managers.StatisticsManager;
import com.example.scmsimulator.managers.Storage;
import com.example.scmsimulator.R;

public class StatisticsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView textRoster = findViewById(R.id.text_roster_size);
        TextView textMissions = findViewById(R.id.text_total_missions);
        TextView textWins = findViewById(R.id.text_total_wins);
        TextView textTraining = findViewById(R.id.text_total_training);

        StatisticsManager stats = StatisticsManager.getInstance();
        Storage storage = Storage.getInstance();

        int totalRecruits = storage.getAllCrew().size();

        textRoster.setText("Crew Roster Size: " + totalRecruits);
        textMissions.setText("Total Missions: " + stats.getTotalMissions());
        textWins.setText("Total Wins: " + stats.getTotalWins());
        textTraining.setText("Training Sessions: " + stats.getTotalTrainingSessions());
    }
}
