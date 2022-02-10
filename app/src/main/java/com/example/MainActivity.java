package com.example.caleb.dndcharactersheet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;

import org.apache.pdfbox.util.PDFBoxResourceLoader;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private PDFGenerator pdfGenerator;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadData.context = this;
        progressDialog = new ProgressDialog(this, R.style.AppCompatAlertDialogStyle);
        PDFBoxResourceLoader.init(getApplicationContext());
    }

    public void onClickGeneratePDF(View v) {
        if (PDFGeneration.generatingPDF == false)
            PDFGeneration.generatingPDF = true;
        else
            return;

        pdfGenerator = new PDFGenerator(this);
        PDFGeneration.mainActivity = this;

        progressDialog.setCancelable(false);
        progressDialog.getWindow().setLayout(750, 500);
        progressDialog.setTitle("Generating character");
        progressDialog.setMessage("This may take a few minutes.");
        progressDialog.show();

        final Spinner spinClass = (Spinner) findViewById(R.id.spinClasses);
        String classChoice = spinClass.getSelectedItem().toString();
        Log.d("input", classChoice);

        final Spinner spinRace = (Spinner) findViewById(R.id.spinRace);
        String raceChoice = spinRace.getSelectedItem().toString();
        Log.d("input", raceChoice);

        final Spinner spinLevel = (Spinner) findViewById(R.id.spinLevel);
        int levelChoice = Integer.valueOf(spinLevel.getSelectedItem().toString());
        Character character = new Character(
                new DnDClass(classChoice),
                new ClassInformation(classChoice),
                new Race(raceChoice)
        );
        character.generate(levelChoice);
        System.out.println(character.print());
        pdfGenerator.generatePdf(character);
    }

    public void generationFinished() {
        File characterSheet = pdfGenerator.saveAndCloseFile(this);
        Intent intent = Emailer.getIntent(characterSheet);

        runOnUiThread(new Runnable() {
            public void run() {
                progressDialog.setCancelable(true);
                progressDialog.dismiss();
            }
        });
        startActivity(Intent.createChooser(intent, "Send Character Sheet..."));
        PDFGeneration.reset();
    }
}
