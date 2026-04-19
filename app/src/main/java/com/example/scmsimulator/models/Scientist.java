package com.example.scmsimulator.models;

public class Scientist extends CrewMember {
    public Scientist(String name) {
        super(name, "Scientist", 8, 1, 17);
    }

    @Override
    public String performSpecialAbility() {
        return getName() + " analyzes the threat for critical weaknesses!";
    }
}
