package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoActivitySettings;

import android.util.DisplayMetrics;

public class MoActivitySettings {

    public static final float MO_GOLDEN_RATIO = 2.4f;
    // universal dimension
    public static final MoActivitySettings UD = new MoActivitySettings();




    // this is basically saying that if the pixel height
    // of a screen is 800, then the appbar of it should be sized
    // (int) 800/2.25 = 356
    private float appbarRatio = MO_GOLDEN_RATIO;

    // every 8 char, we reduce the base font size by 5, and the char limit is 16
    private MoTextSettings titleSettings = new MoTextSettings(20,50,5,8,25);
    // every 25 chars, we reduce the base font by 4. and char limit is 50
    private MoTextSettings subTitleSettings = new MoTextSettings(50,18,4,25,8);


    public float getAppbarRatio() {
        return appbarRatio;
    }

    public MoActivitySettings setAppbarRatio(float appbarRatio) {
        this.appbarRatio = appbarRatio;
        return this;
    }

    public MoTextSettings getTitleSettings() {
        return titleSettings;
    }

    public MoActivitySettings setTitleSettings(MoTextSettings titleSettings) {
        this.titleSettings = titleSettings;
        return this;
    }

    public MoTextSettings getSubTitleSettings() {
        return subTitleSettings;
    }

    public MoActivitySettings setSubTitleSettings(MoTextSettings subTitleSettings) {
        this.subTitleSettings = subTitleSettings;
        return this;
    }

}
