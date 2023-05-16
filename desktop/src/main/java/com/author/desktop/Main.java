package com.author.desktop;

import com.osiris.desku.App;
import com.osiris.desku.DesktopUI;
import com.osiris.desku.UI;

import java.io.IOException;

public class Main {
    public static final Home home = new Home();

    public static void main(String[] args) throws IOException {
        App.name = "Desku-App";
        try {
            DesktopUI ui = (DesktopUI) App.uis.create(home);
            ui.openDevTools();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
