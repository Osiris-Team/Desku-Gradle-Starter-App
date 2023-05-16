package com.author.core;

import com.osiris.desku.App;
import com.osiris.desku.MRoute;
import com.osiris.desku.ui.display.Text;
import com.osiris.desku.ui.layout.Layout;

public class Main {
    public static void main(String[] args) {
        // App.init(...) is done in each platform-specific repo, before calling this main method,
        // with the platform-specific implementations of UI and UIManager.

        MRoute home = new MRoute("/", () -> {
           return new Layout().add(new Text("Hello World!"));
        });

        try {
            App.uis.create(home);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
