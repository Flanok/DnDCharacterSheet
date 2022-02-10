package com.example.caleb.dndcharactersheet;

import java.util.Arrays;
import java.util.List;

/**
 * This class has an array of integers for the ability scores.
 * It generates them randomly and fills the array.
 * Abilities are strength, dexterity, constitution, intelligence,
 * wisdom, charisma.
 */
class AbilityScores {
    private int[] abilityScores;

    /**
     * generates an empty array of integers 6 long, all filled with 0
     */
    AbilityScores() {
        abilityScores = new int[]{0, 0, 0, 0, 0, 0};
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
    AbilityScores(int strength, int dexterity, int constitution,
                  int intelligence, int wisdom, int charisma) {
        abilityScores = new int[]{strength, dexterity, constitution,
                                    intelligence, wisdom, charisma};
    }

    /**
     * takes a list of integers that are ability scores we want to add to our current
     * list. Makes sure that the size is 6, then loops through and adds each number to
     * our current ability scores.
     * @param scores - a list of integers size 6
     */
    void add(List<Integer> scores){
        assert scores.size() == 6;
        for (int i = 0; i < 6; i++) {
            abilityScores[i] += scores.get(i);
        }
    }

    public int getStrength() {
        return abilityScores[0];
    }
    public void setStrength(int strength) {
        abilityScores[0] = strength;
    }

    public int getDexterity() {
        return abilityScores[1];
    }
    public void setDexterity(int dexterity) {
        abilityScores[1] = dexterity;
    }

    public int getConstitution() {
        return abilityScores[2];
    }
    public void setConstitution(int constitution) {
        abilityScores[2] = constitution;
    }

    public int getIntelligence() {
        return abilityScores[3];
    }
    public void setIntelligence(int intelligence) {
        abilityScores[3] = intelligence;
    }

    public int getWisdom() {
        return abilityScores[4];
    }
    public void setWisdom(int wisdom) {
        abilityScores[4] = wisdom;
    }

    public int getCharisma() {
        return abilityScores[5];
    }
    public void setCharisma(int charisma) {
        abilityScores[5] = charisma;
    }

    public String printable() {
        return Arrays.toString(abilityScores);
    }

    /**
     * gets us the modifiers for each ability score. It does this by subtracting 10
     * from the total, then dividing by 2. This will give us an array of 6 long integers
     * corresponding to the ability scores.
     * @return - it will return a string with the modifiers in it
     */
    public String modifiersPrintable() {
        int[] mods = new int[6];
        for (int i = 0; i < 6; i++) {
            mods[i] = getModifier(abilityScores[i]);
        }
        return Arrays.toString(mods);
    }

    static public int getModifier(int score) {
        return (int)(Math.floor((float)(score - 10) / 2));
    }
}
