package com.example.scmsimulator.models;

public class Pilot extends CrewMember {
    public Pilot(String name) {
        super(name, "Pilot", 5, 4, 20);
    }

    @Override
    public String performSpecialAbility() {
        return getName() + " performs an evasive maneuver, dodging some attacks!";
    }
}
