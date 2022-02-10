package com.example.caleb.dndcharactersheet;

import java.util.List;

/**
 * each class that implements will have get/set hit die, get/set number of skills, get/set saving
 * throws, get/set skills, get/set armor proficiency, get/set weapon proficiency, and choose skills
 */
interface CharacterInformation {
    int getHitDieSize();
    void setHitDieSize(int hitDieSize);

    int getNumSkills();
    void setNumSkills(int numSkills);

    List<String> getSavingThrows();
    void setSavingThrows(List<String> savingThrows);

    List<String> getSkills();
    void setSkills(List<String> skills);

    List<String> getArmorProf();
    void setArmorProf(List<String> armorProf);

    List<String> getWeaponProf();
    void setWeaponProf(List<String> weaponProf);

    List<Integer> getCantripsPerLevel();
    void setCantripsPerLevel(List<Integer> cantripsPerLevel);

    List<Integer> getSpellsKnownPerLevel();
    void setSpellsKnownPerLevel(List<Integer> spellsPerLevel);

    List<Integer> getHighestSpellKnown();

    void setHighestSpellKnown(List<Integer> highestSpellKnown);


    List<String> chooseSkills();
}
