package com.example.caleb.dndcharactersheet;

import java.util.List;

/**
 * Each race will have a printable name, get/set size, get/set Ability changes, get/set Speed,
 * get/set racial abilities, get/set languages
 */
interface CharacterRace {
    String printableName();

    String getSize();
    void setSize(String raceSize);

    List<Integer> getAbilityChanges();
    void setAbilityChanges(List<Integer> abilityChanges);

    int getSpeed();
    void setSpeed(int speed);

    List<String> getRacialAbilities();
    void setRacialAbilities(List<String> racialAbilities);

    List<String> getLanguages();
    void setLanguages(List<String> languages);
}
