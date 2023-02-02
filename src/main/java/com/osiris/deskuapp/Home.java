package com.osiris.deskuapp;

import com.osiris.desku.App;
import com.osiris.desku.Route;
import com.osiris.desku.ui.Component;
import com.osiris.desku.ui.Layout;
import com.osiris.desku.ui.Text;

public class Home extends Route {
    public Home() {
        super("/");
    }

    @Override
    public Component<?> loadContent() {
        Layout ly = new Layout();
        ly.sizeFull().childCenter();
        ly.add(new Text(App.name).sizeXL().selfCenter());
        ly.add(new Text("Example app demonstrating Deskus' features.").selfCenter());
        return ly;
    }
}
