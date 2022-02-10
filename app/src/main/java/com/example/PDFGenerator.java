package com.example.caleb.dndcharactersheet;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDCheckbox;
import org.apache.pdfbox.pdmodel.interactive.form.PDFieldTreeNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static android.R.attr.name;

/**
 * makes pdf stuff.... caleb you should fix this, I am not entirely sure what is going on here, looks
 * like a lot of stuff....
 */

public class PDFGenerator {
    private PDDocument document;
    private PDAcroForm acroForm;

    public PDFGenerator(Context context) {
        try {
            // Load the document
            InputStream file = context.getResources().openRawResource(R.raw.char_sheet);
            document = PDDocument.load(file);

            // Get the AcroForm
            PDDocumentCatalog docCatalog = document.getDocumentCatalog();
            acroForm = docCatalog.getAcroForm();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public File saveAndCloseFile(Context context) {
        File newFile = new File(context.getExternalFilesDir(null), "filled_pdf.pdf");

        try {
            // Save document
            document.save(newFile);
            Log.d(null, newFile.getAbsolutePath());

            // Close the document
            document.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return newFile;
    }

    public void generatePdf(Character character) {
        new SetTextFields().execute(
                new TextField(acroForm, "ClassLevel", character.getCharacterClass().printableName() + " " + character.getLevel()),
                new TextField(acroForm, "Race ", character.getCharacterRace().printableName()),

                new TextField(acroForm, "STR", Integer.toString(character.getAbilityScores().getStrength())),
                new TextField(acroForm, "STRmod", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getStrength()))),
                new TextField(acroForm, "DEX", Integer.toString(character.getAbilityScores().getDexterity())),
                new TextField(acroForm, "DEXmod ", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getDexterity()))),
                new TextField(acroForm, "CON", Integer.toString(character.getAbilityScores().getConstitution())),
                new TextField(acroForm, "CONmod", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getConstitution()))),
                new TextField(acroForm, "INT", Integer.toString(character.getAbilityScores().getIntelligence())),
                new TextField(acroForm, "INTmod", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getIntelligence()))),
                new TextField(acroForm, "WIS", Integer.toString(character.getAbilityScores().getWisdom())),
                new TextField(acroForm, "WISmod", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getWisdom()))),
                new TextField(acroForm, "CHA", Integer.toString(character.getAbilityScores().getCharisma())),
                new TextField(acroForm, "CHamod", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getCharisma()))),

                new TextField(acroForm, "ST Strength", Integer.toString(character.getSavingThrows().getStrength())),
                new TextField(acroForm, "ST Dexterity", Integer.toString(character.getSavingThrows().getDexterity())),
                new TextField(acroForm, "ST Constitution", Integer.toString(character.getSavingThrows().getConstitution())),
                new TextField(acroForm, "ST Intelligence", Integer.toString(character.getSavingThrows().getIntelligence())),
                new TextField(acroForm, "ST Wisdom", Integer.toString(character.getSavingThrows().getWisdom())),
                new TextField(acroForm, "ST Charisma", Integer.toString(character.getSavingThrows().getCharisma())),

                new TextField(acroForm, "Acrobatics", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getDexterity()))),
                new TextField(acroForm, "Animal", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getWisdom()))),
                new TextField(acroForm, "Arcana", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getIntelligence()))),
                new TextField(acroForm, "Athletics", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getStrength()))),
                new TextField(acroForm, "Deception ", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getCharisma()))),
                new TextField(acroForm, "History ", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getIntelligence()))),
                new TextField(acroForm, "Insight", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getWisdom()))),
                new TextField(acroForm, "Intimidation", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getCharisma()))),
                new TextField(acroForm, "Investigation ", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getIntelligence()))),
                new TextField(acroForm, "Medicine", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getWisdom()))),
                new TextField(acroForm, "Nature", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getIntelligence()))),
                new TextField(acroForm, "Perception ", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getWisdom()))),
                new TextField(acroForm, "Performance", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getCharisma()))),
                new TextField(acroForm, "Persuasion", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getCharisma()))),
                new TextField(acroForm, "Religion", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getIntelligence()))),
                new TextField(acroForm, "SleightofHand", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getDexterity()))),
                new TextField(acroForm, "Stealth ", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getDexterity()))),
                new TextField(acroForm, "Survival", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getWisdom()))),

                new TextField(acroForm, "ProfBonus", Integer.toString(character.getProficiency())),
                new TextField(acroForm, "Initiative", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getDexterity()))),
                new TextField(acroForm, "Speed", Integer.toString(character.getCharacterRace().getSpeed())),
                new TextField(acroForm, "Passive", Integer.toString(AbilityScores.getModifier(character.getAbilityScores().getWisdom()) + 10)),
                new TextField(acroForm, "HPMax", Integer.toString(character.getMaxHealth())),
                new TextField(acroForm, "HDTotal", Integer.toString(character.getLevel())),
                new TextField(acroForm, "HD", Integer.toString(character.getLevel()) + "d" + Integer.toString(character.getCharacterInformation().getHitDieSize())),
                new TextField(acroForm, "AttacksSpellcasting", "                                                         " + character.printableSpells()),
                new TextField(acroForm, "Features and Traits", "                                                         Class Abilities - " + Arrays.toString(character.getClassAbilities().toArray()) + "                                                         Racial Abilities - " + Arrays.toString(character.getCharacterRace().getRacialAbilities().toArray())),
                new TextField(acroForm, "ProficienciesLang", "                                                         " + Arrays.toString(character.getCharacterRace().getLanguages().toArray()))
        );

        new SetCheckBoxes().execute(
                new CheckBox(acroForm, "Check Box 11", character.getSavingThrows().getGoodSaves()[0]),      /*STR*/
                new CheckBox(acroForm, "Check Box 18", character.getSavingThrows().getGoodSaves()[1]),      /*DEX*/
                new CheckBox(acroForm, "Check Box 19", character.getSavingThrows().getGoodSaves()[2]),      /*CON*/
                new CheckBox(acroForm, "Check Box 20", character.getSavingThrows().getGoodSaves()[3]),      /*INT*/
                new CheckBox(acroForm, "Check Box 21", character.getSavingThrows().getGoodSaves()[4]),      /*WIS*/
                new CheckBox(acroForm, "Check Box 22", character.getSavingThrows().getGoodSaves()[5]),      /*CHA*/

                new CheckBox(acroForm, "Check Box 23", character.getSkills().map.get("Acrobatics")),        /*Acrobatics*/
                new CheckBox(acroForm, "Check Box 24", character.getSkills().map.get("Animal Handling")),   /*Animal Handling*/
                new CheckBox(acroForm, "Check Box 25", character.getSkills().map.get("Arcana")),            /*Arcana*/
                new CheckBox(acroForm, "Check Box 26", character.getSkills().map.get("Athletics")),         /*Athletics*/
                new CheckBox(acroForm, "Check Box 27", character.getSkills().map.get("Deception")),         /*Deception*/
                new CheckBox(acroForm, "Check Box 28", character.getSkills().map.get("History")),           /*History*/
                new CheckBox(acroForm, "Check Box 29", character.getSkills().map.get("Insight")),           /*Insight*/
                new CheckBox(acroForm, "Check Box 30", character.getSkills().map.get("Intimidation")),      /*Intimidation*/
                new CheckBox(acroForm, "Check Box 31", character.getSkills().map.get("Investigation")),     /*Investigation*/
                new CheckBox(acroForm, "Check Box 32", character.getSkills().map.get("Medicine")),          /*Medicine*/
                new CheckBox(acroForm, "Check Box 33", character.getSkills().map.get("Nature")),            /*Nature*/
                new CheckBox(acroForm, "Check Box 34", character.getSkills().map.get("Perception")),        /*Perception*/
                new CheckBox(acroForm, "Check Box 35", character.getSkills().map.get("Performance")),       /*Performance*/
                new CheckBox(acroForm, "Check Box 36", character.getSkills().map.get("Persuasion")),        /*Persuasion*/
                new CheckBox(acroForm, "Check Box 37", character.getSkills().map.get("Religion")),          /*Religion*/
                new CheckBox(acroForm, "Check Box 38", character.getSkills().map.get("Sleight of Hand")),    /*Sleight of Hand*/
                new CheckBox(acroForm, "Check Box 39", character.getSkills().map.get("Stealth")),           /*Stealth*/
                new CheckBox(acroForm, "Check Box 40", character.getSkills().map.get("Survival"))           /*Survival*/
        );
    }

    private class FormField{
        PDAcroForm acroForm;
        String name;

        public FormField(PDAcroForm acroForm, String name) {
            this.acroForm = acroForm;
            this.name = name;
        }
    }

    private class TextField extends FormField {
        String text;

        TextField(PDAcroForm acroForm, String textFieldName, String text) {
            super(acroForm, textFieldName);
            this.text = text;
        }
    }

    private class CheckBox extends FormField {
        boolean isChecked;

        CheckBox(PDAcroForm acroForm, String checkBoxFieldName, boolean isChecked) {
            super(acroForm, checkBoxFieldName);
            this.isChecked = isChecked;
        }
    }

    private class SetTextFields extends AsyncTask<TextField, Void, Void> {

        @Override
        protected void onPostExecute(Void v) {
            PDFGeneration.finished();
        }

        protected Void doInBackground(final TextField... params) {
            synchronized (PDFGeneration.lock) {
                for (TextField textField : params) {
                    try {
                        PDFieldTreeNode treeNode = textField.acroForm.getField(textField.name);
                        if (treeNode != null) {
                            treeNode.setValue(textField.text);
                        } else {
                            Log.e("PDFGeneration", "No text field found with name:" + textField.name);
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
            return null;
        }
    }

    private class SetCheckBoxes extends AsyncTask<CheckBox, Void, Void> {

        @Override
        protected void onPostExecute(Void v) {
            PDFGeneration.finished();
        }

        protected Void doInBackground(final CheckBox... params) {
            synchronized (PDFGeneration.lock) {
                for (CheckBox checkBox : params) {
                    try {
                        PDFieldTreeNode treeNode = checkBox.acroForm.getField(checkBox.name);
                        if (treeNode != null && treeNode instanceof PDCheckbox) {
                            if (checkBox.isChecked)
                                ((PDCheckbox) treeNode).check();
                            else
                                ((PDCheckbox) treeNode).unCheck();
                        } else {
                            Log.e(null, "No checkbox field found with name:" + name);
                        }
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
            return null;
        }
    }
}
