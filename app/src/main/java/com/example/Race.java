package com.example.caleb.dndcharactersheet;

import java.util.ArrayList;
import java.util.List;

/**
 * Has everything a race needs, name, speed, size, racial abilities, languages they can speak, and
 * what abilities might change because you are different than other races...
 */

class Race implements CharacterRace {

    private List<Integer> abilityChanges;
    private String size;
    private int speed;
    private List<String> racialAbilities;
    private List<String> languages;
    private String name;


    Race(String raceName) {
        abilityChanges = new ArrayList<>();
        racialAbilities = new ArrayList<>();
        languages = new ArrayList<>();
        size = "";
        speed = 0;
        name = raceName;
        LoadData.RaceData(this, raceName);
    }

    @Override
    public String printableName() { return name; }

    @Override
    public String getSize() { return size; }
    @Override
    public void setSize(String size) { this.size = size; }

    @Override
    public List<Integer> getAbilityChanges() { return abilityChanges; }
    @Override
    public void setAbilityChanges(List<Integer> abilityChanges) { this.abilityChanges = abilityChanges; }

    @Override
    public int getSpeed() { return speed; }
    @Override
    public void setSpeed(int speed) { this.speed = speed; }

    @Override
    public List<String> getRacialAbilities() { return racialAbilities; }
    @Override
    public void setRacialAbilities(List<String> racialAbilities) { this.racialAbilities = racialAbilities; }

    @Override
    public List<String> getLanguages() { return languages; }
    @Override
    public void setLanguages(List<String> languages) { this.languages = languages; }
}
