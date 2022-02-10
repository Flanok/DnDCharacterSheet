package com.example.caleb.dndcharactersheet;

import com.google.gson.annotations.SerializedName;

/**
 * Created by caleb on 3/21/17.
 */

public class Spell {
    @SerializedName("Name")
    public String name;
    @SerializedName("Level")
    public int level;
    @SerializedName("Ritual")
    public boolean ritual;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isRitual() {
        return ritual;
    }

    public void setRitual(boolean ritual) {
        this.ritual = ritual;
    }
}
