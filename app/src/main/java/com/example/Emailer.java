package com.example.caleb.dndcharactersheet;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.io.File;

/**
 * opens up the email for the user
 */

public class Emailer {
    static public Intent getIntent(File file) {
        // Email document
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {""});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Random Character Sheet");
        intent.putExtra(Intent.EXTRA_TEXT, "A randomly generated character sheet that I created with this new app.");

        if (!file.exists()) {
            Log.e("Emailer", "Attachment Does Not Exist");
            return null;
        } else if (!file.canRead()) {
            Log.e("Emailer", "Attachment cannot be read");
            return null;
        }

        Uri uri = Uri.fromFile(file);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        return intent;
    }
}
