package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoDelete.MoOnDeleteFinished;

public class MoActivityDimensions {

    public static final float MO_GOLDEN_RATIO = 2.25f;
    // universal dimension
    public static final MoActivityDimensions UD = new MoActivityDimensions();


    // this is basically saying that if the pixel height
    // of a screen is 800, then the appbar of it should be sized
    // (int) 800/2.25 = 356
    private float appbarRatio = MO_GOLDEN_RATIO;


    public float getAppbarRatio() {
        return appbarRatio;
    }

    public MoActivityDimensions setAppbarRatio(float appbarRatio) {
        this.appbarRatio = appbarRatio;
        return this;
    }
}
