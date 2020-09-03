package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils;

import android.view.ViewGroup;

public class MoViewGroupUtils {

    /**
     * returns the total height of the view groups
     * @param viewGroups
     * @return
     */
    public static int getMeasuredHeight(ViewGroup... viewGroups){
        int total = 0;
        for(ViewGroup v: viewGroups){
            v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            total += v.getMeasuredHeight();
        }
        return total;
    }
}
