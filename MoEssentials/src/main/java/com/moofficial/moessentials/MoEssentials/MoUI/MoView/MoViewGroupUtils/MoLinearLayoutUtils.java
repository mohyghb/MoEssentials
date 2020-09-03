package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MoLinearLayoutUtils {


    public static void addToLinearLayout(LinearLayout linearLayout, View v){
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(v,lp);
    }


    public static void addToLinearLayout(LinearLayout linearLayout, View v,LinearLayout.LayoutParams lp){
        if(lp!=null){
            linearLayout.addView(v,lp);
        }else {
            linearLayout.addView(v);
        }
    }

    /**
     * enables changing animation
     * @param l
     */
    public static void enableChangingAnimation(LinearLayout l){
        LayoutTransition layoutTransition = l.getLayoutTransition();
        if(layoutTransition!=null){
            layoutTransition.enableTransitionType(LayoutTransition.CHANGING);
        }
    }

}
