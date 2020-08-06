package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

// this is an original activity where
// when you set different things,
// they get automatically adjusted for the
// screen size
public abstract class MoSmartActivity extends MoOriginalActivity {

    @Override
    protected void onCreate() {
        super.onCreate();
        onAppbarLayoutHeightChanged();
        makeTitleFadingEdge();
    }

    @Override
    public void setTitle(String t) {
        super.setTitle(t);
        activitySettings.getTitleSettings().adjust(title);
    }

    @Override
    public void setSubTitle(String t) {
        super.setSubTitle(t);
        activitySettings.getSubTitleSettings().adjust(subtitle);
    }



}