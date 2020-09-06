package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import android.content.res.Configuration;

import androidx.annotation.NonNull;

// this is an original activity where
// when you set different things,
// they get automatically adjusted for the
// screen size
public abstract class MoSmartActivity extends MoBasicActivity {


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        onAppbarLayoutHeightChanged(activitySettings.getAppbarRatio());
    }

    @Override
    protected void initViews() {
        super.initViews();
        onAppbarLayoutHeightChanged(activitySettings.getAppbarRatio());
    }

    @Override
    public void setTitle(String t) {
        super.setTitle(t);
        activitySettings.getTitleSettings().adjustFontSize(l.title);
    }

    @Override
    public void setSubTitle(String t) {
        super.setSubTitle(t);
        activitySettings.getSubTitleSettings().adjustFontSize(l.subtitle);
    }



}
