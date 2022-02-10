package com.example.caleb.dndcharactersheet;

/**
 * generates the pdf?
 */

public class PDFGeneration {
    static int numParts = 2;
    static private int finishedParts = 0;
    static MainActivity mainActivity;
    static boolean generatingPDF;
    static final Object lock = new Object();

    static void finished() {
        finishedParts++;
        if (numParts == finishedParts) {
            mainActivity.generationFinished();
        }
    }

    static void reset() {
        finishedParts = 0;
        generatingPDF = false;
    }
}
