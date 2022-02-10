package com.example.caleb.dndcharactersheet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caleb on 3/21/17.
 */

public class Skills {

    Map<String, Boolean> map;

    Skills() {
        map = new HashMap<>(18);
        map.put("Acrobatics", false);
        map.put("Animal Handling", false);
        map.put("Arcana", false);
        map.put("Athletics", false);
        map.put("Deception", false);
        map.put("History", false);
        map.put("Insight", false);
        map.put("Intimidation", false);
        map.put("Investigation", false);
        map.put("Medicine", false);
        map.put("Nature", false);
        map.put("Perception", false);
        map.put("Performance", false);
        map.put("Persuasion", false);
        map.put("Religion", false);
        map.put("Sleight of Hand", false);
        map.put("Stealth", false);
        map.put("Survival", false);
    }

    ArrayList<String> skillsToList() {
        ArrayList<String> chosenSkills = new ArrayList<>();
        for(Map.Entry<String, Boolean> entry : map.entrySet()) {
            if (entry.getKey() != null)
                if (entry.getValue() == true)
                    chosenSkills.add(entry.getKey());
        }
        return chosenSkills;
    }
}
