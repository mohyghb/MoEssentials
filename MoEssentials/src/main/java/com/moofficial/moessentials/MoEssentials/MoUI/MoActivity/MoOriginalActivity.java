package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoActivitySettings.MoActivitySettings;

// round transparent background for cards
// enabled animations
// provides the universal activity dimension as well
// sets the app bar height to height of screen / activitySettings.appbarRatio
public abstract class MoOriginalActivity extends MoBasicActivity {

    @Override
    protected void initLayout() {
        super.initLayout();
        makeActivityRound();
        makeCardViewsTransparent();
    }

    @Override
    protected MoActivitySettings getActivitySettings() {
        return MoActivitySettings.UD;
    }
}
