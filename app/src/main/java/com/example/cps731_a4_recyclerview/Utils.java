package com.example.cps731_a4_recyclerview;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Static class holding any utilities methods that can reusable across the app
 */
public class Utils {

    public static String loadJSONFromAsset(Context c, String filename) {
        String json = null;
        try {
            InputStream is = c.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
