package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoCardBuilder;
import com.moofficial.moessentials.R;

// round transparent background for cards
// enabled animations
public abstract class MoOriginalActivity extends MoBasicActivity {

    @Override
    protected void onCreate() {
        super.onCreate();
        makeActivityRound();
        makeCardViewsTransparent();
        enableAnimations();
    }



}
