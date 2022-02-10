package com.example.caleb.dndcharactersheet;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains a class, the information for that class, race, ability scores,
 * skills, class abilities, level, and proficiency for a character. Uses function
 * generate that takes a level to fill the data in the character.
 */
class Character implements CharacterData {
    private CharacterClass characterClass;
    private CharacterInformation characterInformation;
    private CharacterRace characterRace;
    private AbilityScores abilityScores;
    private SavingThrows savingThrows;
    private Skills skills;
    private List<String> classAbilities;
    private int level;
    private int proficiency;
    private int maxHealth;
    List<Spell> spells;

    String printableSpells() {
        String list = new String();
//        Iterator iterator = spells.listIterator();
//        while (iterator.hasNext()) {
//
//            Spell spell = (Spell)iterator.next();
//            list += spell.getName() + ", ";
//        }
        for(Spell spell : spells) {
            list += spell.getName() + ", ";
        }

//        for(int i = 0; i < spells.size(); i++) {
//            list = spells.get(i).getName();
//        }
        return list;
    }

    Character(CharacterClass characterClass, CharacterInformation characterInformation, CharacterRace characterRace) {
        this.characterClass = characterClass;
        this.characterInformation = characterInformation;
        this.characterRace = characterRace;
        abilityScores = new AbilityScores();
        savingThrows = new SavingThrows();
        classAbilities = new ArrayList<>();
        spells = new ArrayList<>();
        skills = new Skills();
        level = 0;
        proficiency = 0;
        maxHealth = 0;
    }

    /**
     * generates the character by calling generateAbilityScores for the class,
     * then adding the ability changes that come from the race. It then chooses
     * skills for the character, and calculates the proficiency. It then takes the level
     * parameter that is passed in, and calls the levelUp function however many times it needs to
     * to reach the level passed in
     * @param toLevel - what level you want to level the character to.
     */
    void generate(int toLevel) {
        abilityScores = characterClass.generateAbilityScores();
        abilityScores.add(characterRace.getAbilityChanges());
        savingThrows = new SavingThrows(abilityScores);
        savingThrows.addGoodSaves(characterInformation.getSavingThrows());
        List<String> chosenSkills = characterInformation.chooseSkills();
        proficiency = (((level - 1) / 4)) + 2;
        maxHealth = calculateHealth(characterInformation.getHitDieSize(), toLevel);
        for (int i = 1; i <= toLevel; i++) {
            characterClass.levelUp(this);
            characterClass.chooseSpells(
                    characterInformation.getSpellsKnownPerLevel().get(i -1),
                    characterInformation.getHighestSpellKnown().get(i - 1),
                    spells);
            characterClass.chooseSpells(
                    characterInformation.getCantripsPerLevel().get(i - 1),
                    0,
                    spells);
        }
        savingThrows.applyProficiency(proficiency);
        for (String skill : chosenSkills) {
            if (!skills.map.containsKey(skill))
                Log.e("Skills", skill + " is not a valid skill string");
            skills.map.put(skill, true);
        }

    }
    void addRacialExceptions(){
        switch(characterRace.printableName()){
            case "Hill Dwarf":
                List<String> armorProf = characterInformation.getArmorProf();
                List<String> wepProf = characterInformation.getWeaponProf();
                if(!wepProf.contains("battleaxe"))
                    wepProf.add("battleaxe");
                if(!wepProf.contains("handaxe"))
                    wepProf.add("handaxe");
                if(!wepProf.contains("throwing hammer"))
                    wepProf.add("throwing hammer");
                if(!wepProf.contains("warhammer"))
                    wepProf.add("warhammer");
                break;
            case "Mountain Dwarf":
                break;
            case "High Elf":
                break;
            case "Wood Elf":
                break;
            case "Dark Elf":
                break;
            case "Lightfoot":
                break;
            case "Stout":
                break;
            case "Human":
                break;
            case "Dragonborn":
                break;
            case "Forest Gnome":
                break;
            case "Rock Gnome":
                break;
            case "Half-Elf":
                break;
            case "Half-Orc":
                break;
            case "Tiefling":
                break;
        }

    }

    int calculateHealth(int dieSize, int level) {
        if (level == 1)
            return dieSize + AbilityScores.getModifier(abilityScores.getConstitution());
        return (int)(Math.random() * dieSize + 1) + AbilityScores.getModifier(abilityScores.getConstitution()) + calculateHealth(dieSize, level - 1);
    }

    String print() {
        String printable = "*****" + "\n" +
            "Class: " + characterClass.printableName() +  "\n" +
            "Level: " + level + "   Hit Die Size: " + characterInformation.getHitDieSize() + "\n" +
            "Proficiency: " + proficiency + "\n" +
            "Race: " + characterRace.printableName() + "\n" +
            "Size: " + characterRace.getSize() + "   Speed: " + characterRace.getSpeed() + "\n" +
            "Racial Abilities: " + Arrays.toString(characterRace.getRacialAbilities().toArray()) + "\n" +
            "Languages: " + Arrays.toString(characterRace.getLanguages().toArray()) + "\n" +
            "Ability Scores: " + abilityScores.printable() + "\n" +
            "Ability Modifiers: " + abilityScores.modifiersPrintable() + "\n" +
            "Class Abilities: " + Arrays.toString(classAbilities.toArray()) + "\n" +
            "Skills: " + Arrays.toString(skills.skillsToList().toArray()) + "\n" +
            "Saving Throws: " + Arrays.toString(characterInformation.getSavingThrows().toArray()) + "\n" +
            "*****";
        //System.out.println(printable);
        return printable;//.replace("\n", "");
    }

    @Override
    public Skills getSkills() {
        return skills;
    }

    @Override
    public void setSkills(Skills skills) {
        this.skills = skills;
    }

    @Override
    public List<String> getClassAbilities() {
        return classAbilities;
    }
    @Override
    public void setClassAbilities(List<String> abilities) {
        classAbilities = abilities;
    }

    @Override
    public AbilityScores getAbilityScores() {
        return abilityScores;
    }
    @Override
    public void setAbilityScores(AbilityScores scores) {
        abilityScores = scores;
    }

    @Override
    public int getLevel() {
        return level;
    }
    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    public int getProficiency() { return proficiency; }
    public int getMaxHealth() { return maxHealth; }

    public CharacterRace getCharacterRace() { // created so I could test in Unit testing
        return characterRace;
    }
    public CharacterClass getCharacterClass() { return characterClass; }
    public CharacterInformation getCharacterInformation() { return characterInformation; }
    public SavingThrows getSavingThrows() { return savingThrows; }
}
