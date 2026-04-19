package com.example.scmsimulator.models;

import java.util.Random;

public class Threat {
    private String name;
    private int difficultyLevel;
    private int health;
    private int maxHealth;
    private int attack;
    private int defense;
    private String flavorText;

    private static final String[] ALIEN_NAMES = {"Alien Swarm", "Mechanoid Invader", "Space Pirate Ship"};
    private static final String[] HAZARD_NAMES = {"Asteroid Storm", "Solar Flare", "Ion Storm"};
    private static final String[] SYSTEM_NAMES = {"Broken Heating System", "Reactor Core Meltdown", "Hull Breach"};

    public Threat(int progressLevel) {
        this.difficultyLevel = progressLevel;
        Random rand = new Random();
        
        int type = rand.nextInt(3);
        
        this.health = 40 + (difficultyLevel * 15) + rand.nextInt(20);
        this.attack = 8 + (difficultyLevel * 4) + rand.nextInt(10);
        this.defense = 2 + (difficultyLevel * 2) + rand.nextInt(5);

        if (type == 0) { // Combat Scenario
            this.name = ALIEN_NAMES[rand.nextInt(ALIEN_NAMES.length)];
            this.attack += 5; // Hits harder
            this.flavorText = "Prepare for combat! Enemies are highly aggressive.";
        } else if (type == 1) { // Environmental Hazard
            this.name = HAZARD_NAMES[rand.nextInt(HAZARD_NAMES.length)];
            this.health += 50; // Takes longer to endure
            this.defense += 5; // Harder to deal 'damage' to
            this.flavorText = "A severe environmental hazard blocks your path. You must survive it.";
        } else { // Ship Malfunction
            this.name = SYSTEM_NAMES[rand.nextInt(SYSTEM_NAMES.length)];
            this.attack += 2;
            this.health += 20;
            this.flavorText = "Critical system failure detected! Engineers and prompt action needed.";
        }
        
        this.maxHealth = this.health;
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(1, damage - defense);
        this.health = Math.max(0, this.health - actualDamage);
    }

    public boolean isDefeated() { return health <= 0; }
    public String getName() { return name; }
    public String getFlavorText() { return flavorText; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttack() { return attack; }
}
