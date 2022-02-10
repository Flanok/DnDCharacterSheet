package com.example.caleb.dndcharactersheet;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * This will hold the information for each class that we need for the character sheet, such as
 * hit die size, number of skills the character can learn, saving throws, skills they can choose from,
 * and their weapon and armor proficiency. This class has the function for the character to choose
 * the skills, which are picked at random from the skills they can use.
 */
class ClassInformation implements CharacterInformation {
    private int hitDieSize;
    private int numSkills;
    private List<String> savingThrows;
    private List<String> skills;
    private List<String> armorProf;
    private List<String> weaponProf;
    private List<Integer> cantripsPerLevel;
    @SerializedName("spellsPerLevel")
    private List<Integer> spellsKnownPerLevel;
    private List<Integer> highestSpellKnown;

    ClassInformation(String className){
        this.hitDieSize = 0;
        this.numSkills = 0;
        this.savingThrows = new ArrayList<>();
        this.skills = new ArrayList<>();

        LoadData.classInformation(this, className);
    }

    ClassInformation(){
        this.hitDieSize = 0;
        this.numSkills = 0;
        this.savingThrows = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    @Override
    public List<Integer> getHighestSpellKnown() {
        return highestSpellKnown;
    }

    @Override
    public void setHighestSpellKnown(List<Integer> highestSpellKnown) {
        this.highestSpellKnown = highestSpellKnown;
    }

    @Override
    public List<String> getWeaponProf() { return weaponProf; }

    @Override
    public void setWeaponProf(List<String> weaponProf) { this.weaponProf = weaponProf; }

    @Override
    public List<String> getArmorProf() { return armorProf; }

    @Override
    public  void setArmorProf(List<String> armorProf) { this.armorProf = armorProf; }

    @Override
    public int getHitDieSize() {
        return hitDieSize;
    }

    @Override
    public void setHitDieSize(int hitDieSize) {
        this.hitDieSize = hitDieSize;
    }

    @Override
    public int getNumSkills() {
        return numSkills;
    }

    @Override
    public void setNumSkills(int numSkills) {
        this.numSkills = numSkills;
    }

    @Override
    public List<String> getSavingThrows() {
        return savingThrows;
    }

    @Override
    public void setSavingThrows(List<String> savingThrows) { this.savingThrows = savingThrows; }

    @Override
    public List<String> getSkills() {
        return skills;
    }

    @Override
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public List<Integer> getSpellsKnownPerLevel() {
        return spellsKnownPerLevel;
    }

    @Override
    public void setSpellsKnownPerLevel(List<Integer> spellsKnownPerLevel) {
        this.spellsKnownPerLevel = spellsKnownPerLevel;
    }

    @Override
    public List<Integer> getCantripsPerLevel() {
        return cantripsPerLevel;
    }

    @Override
    public void setCantripsPerLevel(List<Integer> cantripsPerLevel) {
        this.cantripsPerLevel = cantripsPerLevel;
    }

    /**
     * chooses skills for the character. If the number of skills they are aloud is the same as the
     * skills they can choose from, it assigns that and exits. If it doesn't, it cycles through
     * the number they are aloud to choose, and makes a random number, picks that skill from the list,
     * and adds that number to a list so we don't choose it again.
     * @return - a list of skills that our character has
     */
    @Override
    public List<String> chooseSkills() {
        // Early exit for simple case
        if (skills.size() == numSkills) {
            return skills;
        }
        // Otherwise we gotta go through this mess
        List<String> skills = new ArrayList<>();
        List<Integer> choices = new ArrayList<>();
        int choice;
        for (int i = 0; i < numSkills; i++) {
            do {
                choice = (int)(Math.random() * this.skills.size());
            } while (choices.contains(choice));
            choices.add(choice);
            skills.add(this.skills.get(choice));
        }
        return skills;
    }


}
