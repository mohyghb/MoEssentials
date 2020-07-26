package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoAppbar;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moofficial.moessentials.R;

import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS;
import static com.google.android.material.appbar.AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL;

public class MoAppbarUtils {


    /**
     * transitions between the title inside the collapsing toolbar
     * and the title of the small toolbar
     * @param parent view which contains all of the items
     * @param appbarLayoutId id of the app bar
     * @param collapsingToolbarId id of the collapsing toolbar
     * @param bt id of the big title inside collapsing toolbar
     * @param st id of the small title inside the toolbar
     */
    public static void sync(View parent, int appbarLayoutId,int collapsingToolbarId,int bt,int st){
        AppBarLayout appBarLayout = parent.findViewById(appbarLayoutId);
        CollapsingToolbarLayout collapsingToolbar = parent.findViewById(collapsingToolbarId);
        TextView smallTitle = parent.findViewById(st);
        TextView bigTitle = parent.findViewById(bt);
        appBarLayout.addOnOffsetChangedListener((appBarLayout1, verticalOffset) -> {
            int col = collapsingToolbar.getScrimVisibleHeightTrigger();
            int h = collapsingToolbar.getHeight();
            float f = (float)(col-verticalOffset)/h;
            float actualF = verticalOffset==0?0f:Math.abs(verticalOffset)>col?1f:f;
            smallTitle.setAlpha(actualF);
            bigTitle.setAlpha(1f-actualF);
        });
    }


    /**
     * disables the app bar from being scrolled
     * @param toolbar
     */
    public static void disableToolBarScrolling(CollapsingToolbarLayout toolbar) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
    }

    /**
     * enables the scrolling
     * @param toolbar
     */
    public static void enableToolBarScrolling(CollapsingToolbarLayout toolbar) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
    }


    /**
     * enables the scrolling
     * @param toolbar
     */
    public static void setFlags(CollapsingToolbarLayout toolbar,int flags) {
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(flags);
    }


}
