package com.example.caleb.dndcharactersheet;

import java.util.List;

/**
 * each class will be able to generate ability scores, and be able
 * to level up by taking an int to level, and a CharacterData data.
 * Each class will also have a printableName.
 */
interface CharacterClass {
    AbilityScores generateAbilityScores();
    void levelUp(CharacterData data);
    String printableName();
    void chooseSpells(int numSpells, int level, List<Spell> spells);
}
