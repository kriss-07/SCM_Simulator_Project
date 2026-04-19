package com.example.scmsimulator.managers;

import com.example.scmsimulator.models.CrewMember;
import com.example.scmsimulator.models.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.scmsimulator.models.Soldier;
import com.example.scmsimulator.models.Pilot;
import com.example.scmsimulator.models.Medic;

public class Storage {
    private static Storage instance;
    private HashMap<String, CrewMember> crewDatabase;

    private Storage() {
        crewDatabase = new HashMap<>();
        
        // Add some starting crew for convenience
        CrewMember p = new Pilot("Nova");
        CrewMember s = new Soldier("Kael");
        CrewMember m = new Medic("Dr. Mercer");
        
        crewDatabase.put(p.getId(), p);
        crewDatabase.put(s.getId(), s);
        crewDatabase.put(m.getId(), m);
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addCrewMember(CrewMember cm) {
        crewDatabase.put(cm.getId(), cm);
    }

    public CrewMember getCrewMember(String id) {
        return crewDatabase.get(id);
    }

    public List<CrewMember> getAllCrew() {
        return new ArrayList<>(crewDatabase.values());
    }

    public List<CrewMember> getCrewByLocation(Location location) {
        List<CrewMember> filtered = new ArrayList<>();
        for (CrewMember cm : crewDatabase.values()) {
            if (cm.getCurrentLocation() == location) {
                filtered.add(cm);
            }
        }
        return filtered;
    }
}
