package com.example.caleb.dndcharactersheet;

import java.util.ArrayList;
import java.util.List;

/**
 * This has a list of the class abilities, which it pulls from the name of the class we give it
 * It also has functions to generate ability scores, to level up, and to choose class abilities
 * from the list we get from our data
 */
class DnDClass implements CharacterClass {
    private List<ClassAbility> classAbilities;
    private List<Spell> classSpells;
    private String name;

    DnDClass(String className) {
        classAbilities = new ArrayList<>();
        classSpells = new ArrayList<>();
        name = className;
        LoadData.ClassAbilities(classAbilities, printableName());
        LoadData.ClassSpells(classSpells, printableName());
    }

    /**
     * generates random ability scores between 9 and 18
     * @return - filled out ability scores
     */
    @Override
    public AbilityScores generateAbilityScores() {
        return new AbilityScores(
        (int)(Math.random() * 10 + 8), // STR
        (int)(Math.random() * 10 + 8), // DEX
        (int)(Math.random() * 10 + 8), // CON
        (int)(Math.random() * 10 + 8), // INT
        (int)(Math.random() * 10 + 8), // WIS
        (int)(Math.random() * 10 + 8));// CHA
    }

    /**
     * this will level our character up, adding everything in the next level to the character.
     * This includes adding everything for level 1
     * @param data - the data we need to pull the info from
     */
    @Override
    public void levelUp(CharacterData data) {
        data.setLevel(data.getLevel() + 1);

        List<String> currentAbilities = data.getClassAbilities();
        currentAbilities.addAll(chooseClassAbilities(data.getLevel()));
        data.setClassAbilities(currentAbilities);

        // TODO: Add stuff for feats, spells, etc...
    }

    @Override
    public String printableName() { return name; }

    /**
     * adds the class abilities for the level we chose to the abilities string, and returns it
     * @param level - what level we want to grab class abilities for
     * @return a list of string that has the class abilities for the level we chose
     */
    private List<String> chooseClassAbilities(int level) {
        ArrayList<String> abilities = new ArrayList<>();
        for (ClassAbility ability : classAbilities) {
            if (ability.level == level) {
                abilities.add(ability.name);
            }
        }
        return abilities;
    }

    @Override
    public void chooseSpells(int numSpells, int maxSpellLevel, List<Spell> chosenSpells) {
        if (numSpells == 0)
            return;

        List<Spell> spells = new ArrayList();
        for (Spell spell : classSpells) {
            if (maxSpellLevel == 0) {
                if (spell.level == maxSpellLevel)
                    spells.add(spell);
            } else {
                if (spell.level <= maxSpellLevel && spell.level != 0)
                    spells.add(spell);
            }
        }

        int choice;
        for (int i = 0; i < numSpells; i++) {
            do {
                choice = (int)(Math.random() * spells.size());
            } while (chosenSpells.contains(spells.get(choice)));
            chosenSpells.add(spells.get(choice));
        }
    }
}
