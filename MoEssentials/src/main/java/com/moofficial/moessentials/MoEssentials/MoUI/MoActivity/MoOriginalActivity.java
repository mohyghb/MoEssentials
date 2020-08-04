package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoCardBuilder;
import com.moofficial.moessentials.R;

// round transparent background for cards
// enabled animations
// provides the universal activity dimension as well
// so you don't need to provid it that
public abstract class MoOriginalActivity extends MoBasicActivity {

    @Override
    protected void onCreate() {
        super.onCreate();
        makeActivityRound();
        makeCardViewsTransparent();
        enableAnimations();
    }

    @Override
    protected MoActivityDimensions getActivityDimensions() {
        return MoActivityDimensions.UD;
    }
}
