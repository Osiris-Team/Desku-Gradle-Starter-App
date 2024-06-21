package com.author.core;

import com.author.core.about.About;
import com.author.core.home_full.HomeFull;
import com.author.core.home_minimal.HomeMinimal;
import com.osiris.desku.App;

public class Main {
    // Register routes
    public static About about = new About();
    public static HomeFull homeFull = new HomeFull();
    public static HomeMinimal homeMinimal = new HomeMinimal();

    public static void main(String[] args) {
        // App.init(...) is done in each platform-specific repo, before calling this main method,
        // with the platform-specific implementations of UI and UIManager.

        try {
            //App.uis.create(homeFull);
            App.uis.create(homeMinimal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
