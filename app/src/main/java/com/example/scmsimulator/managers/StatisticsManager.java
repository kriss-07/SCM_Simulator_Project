package com.example.scmsimulator.managers;

public class StatisticsManager {
    private static StatisticsManager instance;
    private int totalMissions;
    private int totalWins;
    private int totalTrainingSessions;

    private StatisticsManager() {
        totalMissions = 0;
        totalWins = 0;
        totalTrainingSessions = 0;
    }

    public static StatisticsManager getInstance() {
        if (instance == null) {
            instance = new StatisticsManager();
        }
        return instance;
    }

    public void recordMission(boolean win) {
        totalMissions++;
        if (win) {
            totalWins++;
        }
    }

    public void recordTraining() {
        totalTrainingSessions++;
    }

    public int getTotalMissions() { return totalMissions; }
    public int getTotalWins() { return totalWins; }
    public int getTotalTrainingSessions() { return totalTrainingSessions; }
}
