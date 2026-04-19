package com.example.scmsimulator.models;

import java.io.Serializable;
import java.util.UUID;

public abstract class CrewMember implements Serializable {
    private String id;
    private String name;
    private String role;
    private int health;
    private int energy;
    private int experience;
    private int level;
    private Location currentLocation;
    
    // Combat stats
    private int skill;
    private int resilience;
    private int maxEnergy;
    
    // Combat state
    private boolean defending;

    public CrewMember(String name, String role, int baseSkill, int baseResilience, int maxEnergy) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.role = role;
        this.health = 100;
        this.maxEnergy = maxEnergy;
        this.energy = maxEnergy;
        this.experience = 0;
        this.level = 1;
        this.currentLocation = Location.QUARTERS;
        
        this.skill = baseSkill;
        this.resilience = baseResilience;
        this.defending = false;
    }

    public void train() {
        if (energy >= 20) {
            energy -= 20;
            experience += 50;
            if (experience >= level * 100) {
                levelUp();
            }
        }
    }

    private void levelUp() {
        level++;
        health = 100; // Restore health on level up
        skill += 2;
        resilience += 1;
        maxEnergy += 2;
        experience = 0;
    }

    public void rest() {
        this.energy = maxEnergy;
        // Optionally rest gives some health, handled in MedBase now
    }

    public void takeDamage(int damage) {
        int actualDamage = Math.max(1, damage - resilience);
        if (defending) {
            actualDamage /= 2; // Defending halves incoming damage
        }
        this.health = Math.max(0, this.health - actualDamage);
        
        if (this.health == 0) {
            this.currentLocation = Location.MED_BASE;
        }
    }
    
    // Polymorphic method
    public abstract String performSpecialAbility();

    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public int getHealth() { return health; }
    public int getEnergy() { return energy; }
    public int getMaxEnergy() { return maxEnergy; }
    public int getLevel() { return level; }
    public Location getCurrentLocation() { return currentLocation; }
    public int getSkill() { return skill; }
    public int getResilience() { return resilience; }
    public boolean isDefending() { return defending; }
    
    // Setters / Modifiers
    public void setCurrentLocation(Location currentLocation) { this.currentLocation = currentLocation; }
    public void setDefending(boolean defending) { this.defending = defending; }
    
    public void useEnergy(int amount) {
        this.energy = Math.max(0, this.energy - amount);
    }
    
    public void heal(int amount) {
        this.health = Math.min(100, this.health + amount);
        if (this.health > 0 && this.currentLocation == Location.MED_BASE) {
            // They can still be in med base until fully healed, but alive
        }
    }
    
    // MedBase full recovery
    public void fullRecovery() {
        this.health = 100;
        this.energy = maxEnergy;
        this.currentLocation = Location.QUARTERS;
    }
}
