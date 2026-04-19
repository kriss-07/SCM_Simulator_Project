package com.example.scmsimulator.models;

public class Engineer extends CrewMember {
    public Engineer(String name) {
        super(name, "Engineer", 6, 3, 19);
    }

    @Override
    public String performSpecialAbility() {
        return getName() + " deploys a temporary shield module.";
    }
}
