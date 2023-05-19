package com.author.desktop;

import com.osiris.desku.App;
import com.osiris.desku.DesktopUI;
import com.osiris.desku.DesktopUIManager;
import com.osiris.desku.UI;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            App.init(new DesktopUIManager(false));
            com.author.core.Main.main(args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
