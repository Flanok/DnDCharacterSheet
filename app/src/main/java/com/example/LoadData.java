package com.example.caleb.dndcharactersheet;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;


/**
 * Loads all the data from the JSON strings
 */

class LoadData {
    static Context context;
    static void RaceData(CharacterRace race, String raceName) {
        Type collectionType = new TypeToken<Collection<Race>>() {}.getType();
        Gson gson = new Gson();
        Collection<Race> enums = gson.fromJson(context.getResources().getString(R.string.races), collectionType);
        Race[] races = enums.toArray(new Race[enums.size()]);

        switch (raceName) {
            case "Hill Dwarf":
                race.setAbilityChanges(races[0].getAbilityChanges());
                race.setSize(races[0].getSize());
                race.setSpeed(races[0].getSpeed());
                race.setRacialAbilities(races[0].getRacialAbilities());
                race.setLanguages(races[0].getLanguages());
                break;
            case "Mountain Dwarf":
                race.setAbilityChanges(races[1].getAbilityChanges());
                race.setSize(races[1].getSize());
                race.setSpeed(races[1].getSpeed());
                race.setRacialAbilities(races[1].getRacialAbilities());
                race.setLanguages(races[1].getLanguages());
                break;
            case "High Elf":
                race.setAbilityChanges(races[2].getAbilityChanges());
                race.setSize(races[2].getSize());
                race.setSpeed(races[2].getSpeed());
                race.setRacialAbilities(races[2].getRacialAbilities());
                race.setLanguages(races[2].getLanguages());
                break;
            case "Wood Elf":
                race.setAbilityChanges(races[3].getAbilityChanges());
                race.setSize(races[3].getSize());
                race.setSpeed(races[3].getSpeed());
                race.setRacialAbilities(races[3].getRacialAbilities());
                race.setLanguages(races[3].getLanguages());
                break;
            case "Dark Elf":
                race.setAbilityChanges(races[4].getAbilityChanges());
                race.setSize(races[4].getSize());
                race.setSpeed(races[4].getSpeed());
                race.setRacialAbilities(races[4].getRacialAbilities());
                race.setLanguages(races[4].getLanguages());
                break;
            case "Lightfoot":
                race.setAbilityChanges(races[5].getAbilityChanges());
                race.setSize(races[5].getSize());
                race.setSpeed(races[5].getSpeed());
                race.setRacialAbilities(races[5].getRacialAbilities());
                race.setLanguages(races[5].getLanguages());
                break;
            case "Stout":
                race.setAbilityChanges(races[6].getAbilityChanges());
                race.setSize(races[6].getSize());
                race.setSpeed(races[6].getSpeed());
                race.setRacialAbilities(races[6].getRacialAbilities());
                race.setLanguages(races[6].getLanguages());
                break;
            case "Human":
                race.setAbilityChanges(races[7].getAbilityChanges());
                race.setSize(races[7].getSize());
                race.setSpeed(races[7].getSpeed());
                race.setRacialAbilities(races[7].getRacialAbilities());
                race.setLanguages(races[7].getLanguages());
                break;
            case "Dragonborn":
                race.setAbilityChanges(races[8].getAbilityChanges());
                race.setSize(races[8].getSize());
                race.setSpeed(races[8].getSpeed());
                race.setRacialAbilities(races[8].getRacialAbilities());
                race.setLanguages(races[8].getLanguages());
                break;
            case "Forest Gnome":
                race.setAbilityChanges(races[9].getAbilityChanges());
                race.setSize(races[9].getSize());
                race.setSpeed(races[9].getSpeed());
                race.setRacialAbilities(races[9].getRacialAbilities());
                race.setLanguages(races[9].getLanguages());
                break;
            case "Rock Gnome":
                race.setAbilityChanges(races[10].getAbilityChanges());
                race.setSize(races[10].getSize());
                race.setSpeed(races[10].getSpeed());
                race.setRacialAbilities(races[10].getRacialAbilities());
                race.setLanguages(races[10].getLanguages());
                break;
            case "Half-Elf":
                race.setAbilityChanges(races[11].getAbilityChanges());
                race.setSize(races[11].getSize());
                race.setSpeed(races[11].getSpeed());
                race.setRacialAbilities(races[11].getRacialAbilities());
                race.setLanguages(races[11].getLanguages());
                break;
            case "Half-Orc":
                race.setAbilityChanges(races[12].getAbilityChanges());
                race.setSize(races[12].getSize());
                race.setSpeed(races[12].getSpeed());
                race.setRacialAbilities(races[12].getRacialAbilities());
                race.setLanguages(races[12].getLanguages());
                break;
            case "Tiefling":
                race.setAbilityChanges(races[13].getAbilityChanges());
                race.setSize(races[13].getSize());
                race.setSpeed(races[13].getSpeed());
                race.setRacialAbilities(races[13].getRacialAbilities());
                race.setLanguages(races[13].getLanguages());
                break;
        }
    }

    static void ClassSpells(List<Spell> spellsList, String className){
        Type collectionType = new TypeToken<Collection<Spell>>() {}.getType();
        Gson gson = new Gson();
        Collection<Spell> enums;
        Spell[] spells = new Spell[]{};
        switch (className){
            case "Bard":
                Log.d("bard spells", context.getResources().getString(R.string.bard_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.bard_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
            case "Cleric":
                Log.d("cleric spells", context.getResources().getString(R.string.cleric_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.cleric_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
            case "Druid":
                Log.d("druid spells", context.getResources().getString(R.string.druid_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.druid_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
            case "Paladin":
                Log.d("paladin spells", context.getResources().getString(R.string.paladin_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.paladin_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
            case "Ranger":
                Log.d("ranger spells", context.getResources().getString(R.string.ranger_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.ranger_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
            case "Sorcerer":
                Log.d("sorcerer spells", context.getResources().getString(R.string.sorcerer_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.sorcerer_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
            case "Warlock":
                Log.d("warlock spells", context.getResources().getString(R.string.warlock_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.warlock_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
            case "Wizard":
                Log.d("wizard spells", context.getResources().getString(R.string.wizard_spells));
                enums = gson.fromJson(context.getResources().getString(R.string.wizard_spells), collectionType);
                spells = enums.toArray(new Spell[enums.size()]);
                break;
        }
        for(Spell spell: spells) {
            spellsList.add(spell);
        }
    }

    /**
     * grabs all the class abilities for the class name we pass in
     * @param classAbilityList - to be filled with the abilities for that class
     * @param className - what class we need the abilities for
     */
    static void ClassAbilities(List<ClassAbility> classAbilityList, String className) {
        Type collectionType = new TypeToken<Collection<ClassAbility>>() {}.getType();
        Gson gson = new Gson();
        Collection<ClassAbility> enums;
        ClassAbility[] classAbilities = new ClassAbility[]{};
        switch (className) {
            case "Barbarian":
                Log.d("barbarian abilities", context.getResources().getString(R.string.barbarian_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.barbarian_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Bard":
                Log.d("bard abilities", context.getResources().getString(R.string.bard_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.bard_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Cleric":
                Log.d("cleric abilities", context.getResources().getString(R.string.cleric_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.cleric_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Druid":
                Log.d("Druid abilities", context.getResources().getString(R.string.druid_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.druid_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Fighter":
                Log.d("fighter abilities", context.getResources().getString(R.string.fighter_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.fighter_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Monk":
                Log.d("monk abilities", context.getResources().getString(R.string.monk_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.monk_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Paladin":
                Log.d("paladin abilities", context.getResources().getString(R.string.paladin_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.paladin_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Ranger":
                Log.d("ranger abilities", context.getResources().getString(R.string.ranger_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.ranger_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Rogue":
                Log.d("rouge abilities", context.getResources().getString(R.string.rogue_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.rogue_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Sorcerer":
                Log.d("sorcerer abilities", context.getResources().getString(R.string.sorcerer_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.sorcerer_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Warlock":
                Log.d("warlock abilities", context.getResources().getString(R.string.warlock_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.warlock_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
            case "Wizard":
                Log.d("Wizard abilities", context.getResources().getString(R.string.wizard_abilities));
                enums = gson.fromJson(context.getResources().getString(R.string.wizard_abilities), collectionType);
                classAbilities = enums.toArray(new ClassAbility[enums.size()]);
                break;
        }
        for(ClassAbility ability: classAbilities) {
            classAbilityList.add(ability);
        }
    }

    /**
     * Pulls all the extra information for the class we need, such as hit die, saving throws, etc.
     * @param information - the information we need to get for the class we pass in
     * @param className - the class we need the info for
     */
    static void classInformation(CharacterInformation information, String className){
        Gson gson = new Gson();
        ClassInformation classInformation = new ClassInformation();
        switch (className) {
            case "Barbarian":
                Log.d("Barbarian info", context.getResources().getString(R.string.barbarian_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.barbarian_other), ClassInformation.class);
                break;
            case "Bard":
                Log.d("Bard info", context.getResources().getString(R.string.bard_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.bard_other), ClassInformation.class);
                break;
            case "Cleric":
                Log.d("Cleric info", context.getResources().getString(R.string.cleric_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.bard_other), ClassInformation.class);
                break;
            case "Druid":
                Log.d("Druid info", context.getResources().getString(R.string.druid_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.druid_other), ClassInformation.class);
                break;
            case "Fighter":
                Log.d("Fighter info", context.getResources().getString(R.string.fighter_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.fighter_other), ClassInformation.class);
                break;
            case "Monk":
                Log.d("Monk info", context.getResources().getString(R.string.monk_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.monk_other), ClassInformation.class);
                break;
            case "Paladin":
                Log.d("Paladin info", context.getResources().getString(R.string.paladin_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.paladin_other), ClassInformation.class);
                break;
            case "Ranger":
                Log.d("Ranger info", context.getResources().getString(R.string.ranger_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.ranger_other), ClassInformation.class);
                break;
            case "Rogue":
                Log.d("Rogue info", context.getResources().getString(R.string.rouge_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.rouge_other), ClassInformation.class);
                break;
            case "Sorcerer":
                Log.d("Sorcerer info", context.getResources().getString(R.string.sorcerer_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.sorcerer_other), ClassInformation.class);
                break;
            case "Warlock":
                Log.d("Warlock info", context.getResources().getString(R.string.warlock_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.warlock_other), ClassInformation.class);
                break;
            case "Wizard":
                Log.d("Wizard info", context.getResources().getString(R.string.wizard_other));
                classInformation = gson.fromJson(context.getResources().getString(R.string.wizard_other), ClassInformation.class);
                break;
        }
        information.setNumSkills(classInformation.getNumSkills());
        information.setHitDieSize(classInformation.getHitDieSize());
        information.setSavingThrows(classInformation.getSavingThrows());
        information.setSkills(classInformation.getSkills());
        information.setArmorProf(classInformation.getArmorProf());
        information.setWeaponProf(classInformation.getWeaponProf());
        information.setCantripsPerLevel(classInformation.getCantripsPerLevel());
        information.setSpellsKnownPerLevel(classInformation.getSpellsKnownPerLevel());
        information.setHighestSpellKnown(classInformation.getHighestSpellKnown());
    }
}
