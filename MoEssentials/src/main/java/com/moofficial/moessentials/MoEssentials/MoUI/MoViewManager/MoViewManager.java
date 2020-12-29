package com.moofficial.moessentials.MoEssentials.MoUI.MoViewManager;

import android.view.View;

public class MoViewManager {

    private int[] visible;



    public MoViewManager saveVisibility(View ... views) {
        visible = new int[views.length];
        for (int i = 0; i < views.length; i++) {
            visible[i] = views[i].getVisibility() ;
        }
        return this;
    }

    public MoViewManager deployVisibility( View ... views) {
        if (visible == null  || visible.length != views.length) {
            return this;
        }
        for (int i = 0; i < visible.length; i++) {
            views[i].setVisibility(visible[i]);
        }
        return this;
    }

}
