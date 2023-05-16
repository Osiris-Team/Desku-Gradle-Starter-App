package com.osiris.jsqlgen.android;

import android.app.Activity;
import android.os.Bundle;

import com.osiris.desku.App;
import com.osiris.jsqlgen.Main;

/** Launches the Android application. */
public class AndroidLauncher extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidUIManager.mainActivity = this;
        App.init(new AndroidUIManager());
        Main.main(new String[]{});
    }
}
