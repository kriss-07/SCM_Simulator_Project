package com.example.scmsimulator.models;

public class Soldier extends CrewMember {
    public Soldier(String name) {
        super(name, "Soldier", 9, 0, 16);
    }

    @Override
    public String performSpecialAbility() {
        return getName() + " executes a tactical assault for maximum damage!";
    }
}
