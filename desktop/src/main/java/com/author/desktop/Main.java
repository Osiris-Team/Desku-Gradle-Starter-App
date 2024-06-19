package com.author.desktop;

import com.osiris.desku.App;
import com.osiris.desku.ui.DesktopUIManager;

public class Main {

    public static void main(String[] args) {
        try {
            App.LoggerParams loggerParams = new App.LoggerParams();
            App.init(new DesktopUIManager(), loggerParams);
            com.author.core.Main.main(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
