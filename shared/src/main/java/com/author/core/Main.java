package com.author.shared;

import com.author.shared.about.About;
import com.author.shared.home_full.HomeFull;
import com.author.shared.home_minimal.HomeMinimal;
import com.osiris.desku.App;

public class Main {
    // Register routes
    public static About about = new About();
    public static HomeFull homeFull = new HomeFull();
    public static HomeMinimal homeMinimal = new HomeMinimal();

    public static void main(String[] args) {
        App.name = "My-Example-Desku-App";
        App.init();

        try {
            //App.uis.create(homeFull);
            App.uis.create(homeMinimal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
