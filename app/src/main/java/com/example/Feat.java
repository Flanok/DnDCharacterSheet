package com.example.caleb.dndcharactersheet;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Zach Hulse on 3/21/2017.
 */

public class Feat {
    @SerializedName("Name")
    private String name;
    @SerializedName("Prerequisits")
    private List<Integer> abillityPrerequisits;
    @SerializedName("Pre-req")
    private String prerequisit;
}
