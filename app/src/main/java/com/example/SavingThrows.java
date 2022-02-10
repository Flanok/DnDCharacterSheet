package com.example.caleb.dndcharactersheet;

/**
 * Created by caleb on 3/21/17.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class has an array of integers for the ability scores.
 * It generates them randomly and fills the array.
 * Abilities are strength, dexterity, constitution, intelligence,
 * wisdom, charisma.
 */
class SavingThrows {
    private int[] savingThrows;
    private List<String> goodSaves;

    /**
     * generates an empty array of integers 6 long, all filled with 0
     */
    SavingThrows() {
        savingThrows = new int[]{0, 0, 0, 0, 0, 0};
        goodSaves = new ArrayList<>();
    }

    /**
     * takes in parameters for each ability score, and sets them accordingly
     * @param strength - sets the index 0 int
     * @param dexterity - sets the index 1 int
     * @param constitution - sets index 2
     * @param intelligence - sets index 3
     * @param wisdom - sets index 4
     * @param charisma - sets index 5
     */
    SavingThrows(int strength, int dexterity, int constitution,
                  int intelligence, int wisdom, int charisma) {
        savingThrows = new int[]{strength, dexterity, constitution,
                intelligence, wisdom, charisma};
        goodSaves = new ArrayList<>();
    }

    SavingThrows(AbilityScores abilityScores) {
        savingThrows = new int[] {
                AbilityScores.getModifier(abilityScores.getStrength()),
                AbilityScores.getModifier(abilityScores.getDexterity()),
                AbilityScores.getModifier(abilityScores.getConstitution()),
                AbilityScores.getModifier(abilityScores.getIntelligence()),
                AbilityScores.getModifier(abilityScores.getWisdom()),
                AbilityScores.getModifier(abilityScores.getCharisma())
        };
        goodSaves = new ArrayList<>();
    }

    void addGoodSaves(List<String> saves) {
        goodSaves.addAll(saves);
//        for (String save : saves) {
//            switch (save) {
//                case "Strength":
//                    if (!goodSaves.contains("Strength")) {
//                        savingThrows[0]
//                    }
//            }
//        }
    }

    void applyProficiency(int proficiency) {
        if (goodSaves.contains("Strength"))
            savingThrows[0] += proficiency;
        if (goodSaves.contains("Dexterity"))
            savingThrows[1] += proficiency;
        if (goodSaves.contains("Constitution"))
            savingThrows[2] += proficiency;
        if (goodSaves.contains("Intelligence"))
            savingThrows[3] += proficiency;
        if (goodSaves.contains("Wisdom"))
            savingThrows[4] += proficiency;
        if (goodSaves.contains("Charisma"))
            savingThrows[5] += proficiency;
    }
    public boolean[] getGoodSaves() {
        return new boolean[] {
                goodSaves.contains("Strength"),
                goodSaves.contains("Dexterity"),
                goodSaves.contains("Constitution"),
                goodSaves.contains("Intelligence"),
                goodSaves.contains("Wisdom"),
                goodSaves.contains("Charisma")
        };
    }

    public int getStrength() {
        return savingThrows[0];
    }
    public void setStrength(int strength) {
        savingThrows[0] = strength;
    }

    public int getDexterity() {
        return savingThrows[1];
    }
    public void setDexterity(int dexterity) {
        savingThrows[1] = dexterity;
    }

    public int getConstitution() {
        return savingThrows[2];
    }
    public void setConstitution(int constitution) {
        savingThrows[2] = constitution;
    }

    public int getIntelligence() {
        return savingThrows[3];
    }
    public void setIntelligence(int intelligence) {
        savingThrows[3] = intelligence;
    }

    public int getWisdom() {
        return savingThrows[4];
    }
    public void setWisdom(int wisdom) {
        savingThrows[4] = wisdom;
    }

    public int getCharisma() {
        return savingThrows[5];
    }
    public void setCharisma(int charisma) {
        savingThrows[5] = charisma;
    }

    public String printable() {
        return Arrays.toString(savingThrows);
    }
}
