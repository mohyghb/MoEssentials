package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;


// we remove the nested scroll view for this activity
// and set the respective layouts to null
// this was developed for putting a web view
// inside a coordinator layout
public abstract class MoSmartCoordinatorActivity extends MoSmartActivity {

    @Override
    protected void onCreate() {
        super.onCreate();
        coordinatorLayout.removeView(nestedScrollView);
        nestedScrollView = null;
        linearNested = null;
        innerCardView = null;
    }

}
