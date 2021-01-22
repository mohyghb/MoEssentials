package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoPaddingBuilder;

public class MoCoordinatorUtils {

    /**
     *
     * @return scrolling coordinator layout params
     * with match parent width and height
     * and layout behavior of app bar layout scrolling
     * view behavior
     */
    public static CoordinatorLayout.LayoutParams getScrollingParams(MoPaddingBuilder p) {
        return getScrollingParams(p,
                CoordinatorLayout.LayoutParams.MATCH_PARENT,
                CoordinatorLayout.LayoutParams.MATCH_PARENT);
    }


    /**
     *
     * @return scrolling coordinator layout params
     * with match parent width and height
     * and layout behavior of app bar layout scrolling
     * view behavior
     */
    public static CoordinatorLayout.LayoutParams getScrollingParams(Context c){
        return getScrollingParams(new MoPaddingBuilder(c));
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
    public static CoordinatorLayout.LayoutParams getScrollingParams(MoPaddingBuilder p, int width,int height){
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(width,height);
        lp.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        lp.setMargins(p.getLeft(), p.getTop(),p.getRight(),p.getBottom());
        return lp;
    }


    public static CoordinatorLayout.LayoutParams getMatchMatch(MoPaddingBuilder p) {
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        lp.gravity = Gravity.CENTER;
        lp.setMargins(p.getLeft(), p.getTop(),p.getRight(),p.getBottom());
        return lp;
    }

    public static CoordinatorLayout.LayoutParams getMatchMatch(Context context) {
        return getMatchMatch(new MoPaddingBuilder(context));
    }

}
