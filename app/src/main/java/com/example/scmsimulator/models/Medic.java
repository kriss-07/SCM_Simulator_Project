package com.example.scmsimulator.models;

public class Medic extends CrewMember {
    public Medic(String name) {
        super(name, "Medic", 7, 2, 18);
    }

    @Override
    public String performSpecialAbility() {
        return getName() + " prepares medical supplies to heal the team.";
    }
}
