package com.example.caleb.dndcharactersheet;

import com.google.gson.annotations.SerializedName;

/**
 * this will find the class ability in the JSON and make sure it has a name, and level
 */
public class ClassAbility {
    @SerializedName("Level")
    int level;
    @SerializedName("Name")
    String name;

    public ClassAbility(int level, String name) {
        this.level = level;
        this.name = name;
    }
}
