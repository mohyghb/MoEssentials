package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.appbar.AppBarLayout;

public class MoCoordinatorUtils {

    /**
     *
     * @return scrolling coordinator layout params
     * with match parent width and height
     * and layout behavior of app bar layout scrolling
     * view behavior
     */
    public static CoordinatorLayout.LayoutParams getScrollingParams(){
        return getScrollingParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,CoordinatorLayout.LayoutParams.MATCH_PARENT);
    }

    /**
     *
     * @param width of view inside coordinator layout
     * @param height of view inside coordinator layout
     * @return scrolling coordinator layout params
     * with match parent width and height
     * and layout behavior of app bar layout scrolling
     * view behavior
     */
    public static CoordinatorLayout.LayoutParams getScrollingParams(int width,int height){
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(width,height);
        lp.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        return lp;
    }

}
