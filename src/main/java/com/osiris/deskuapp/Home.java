package com.osiris.deskuapp;

import com.osiris.desku.App;
import com.osiris.desku.Route;
import com.osiris.desku.ui.Component;
import com.osiris.desku.ui.Layout;

public class Home extends Route {
    public Home() {
        super("/");
    }

    @Override
    public Component<?> loadContent() {
        Layout ly = new Layout();
        ly.sizeFull().childCenter();
        ly.textXL(App.name);
        ly.textM("Example app demonstrating Deskus' features.");
        return ly;
    }
}
