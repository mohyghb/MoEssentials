package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoViewGroupUtils;

// an original activity but now has the ability to
// change the app bar layout as we continue to add
// or remove things from toolbar
public abstract class MoSmartActivity extends MoOriginalActivity {

    private final float MO_GOLDEN_RATIO = 2.25f;


    @Override
    protected void onCreate() {
        super.onCreate();
        onAppbarLayoutHeightChanged();
    }

    /**
     * changes the app bar layout by considering
     * the heights of other view groups as well
     * @param considerTheseHeights
     */
    public void onAppbarLayoutHeightChanged(ViewGroup ... considerTheseHeights){
        float heightDp = (float) getResources().getDisplayMetrics().heightPixels / MO_GOLDEN_RATIO;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams)appBarLayout.getLayoutParams();
        lp.height = (int)heightDp + MoViewGroupUtils.getMeasuredHeight(considerTheseHeights);
        appBarLayout.setLayoutParams(lp);
    }



}
