package com.osiris.deskuapp;

import com.osiris.desku.App;
import com.osiris.desku.swing.NativeWindow;

import java.io.IOException;

public class Main {
    public static final Home home = new Home();

    public static void main(String[] args) throws IOException {
        App.name = "Desku-App";
        new NativeWindow(home).openDevTools();
    }
}
