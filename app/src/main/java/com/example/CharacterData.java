package com.example.caleb.dndcharactersheet;

import java.util.List;

/**
 * this is an interface for the character data. It will have get/set skills, get/set class abilities,
 * get/set Ability scores, and get/set level
 */
interface CharacterData {

    Skills getSkills();
    void setSkills(Skills skills);

    List<String> getClassAbilities();
    void setClassAbilities(List<String> abilities);

    AbilityScores getAbilityScores();
    void setAbilityScores(AbilityScores scores);

    int getLevel();
    void setLevel(int level);
}
