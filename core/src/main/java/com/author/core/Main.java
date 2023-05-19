package com.author.core;

import com.author.core.home.Home;
import com.osiris.desku.App;

public class Main {
    public static Home home = new Home();
    public static void main(String[] args) {
        // App.init(...) is done in each platform-specific repo, before calling this main method,
        // with the platform-specific implementations of UI and UIManager.

        try {
            App.uis.create(home);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
