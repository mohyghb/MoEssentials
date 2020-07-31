package com.moofficial.moessentials.MoEssentials.MoUI.MoViews;

import android.view.View;
import android.view.ViewGroup;


import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;
import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoTransitionsUtils;

import java.util.Arrays;
import java.util.List;

public class MoViewUtils {

    /**
     * applies the visibility and animation to each
     * view
     * @param views
     * @param visibility
     * @param animation
     */
    public static void apply(View parent,View[] views, int visibility, int animation){
        apply(parent,Arrays.asList(views),visibility,animation);
    }

    public static void apply(View parent,List<View> views, int visibility, int animation){
        if(views==null)
            return;

        for(View v: views){
            //MoTransitionsUtils.fade((ViewGroup)parent,v,visibility);
            MoAnimation.animateNoTag(v,visibility,animation);
        }
    }

    /**
     * closes the views that are performing an action
     * @param views
     */
    public static void closeActions(MoListViews[] views){
        if(views == null)
            return;
        for(MoListViews moListViews: views){
            if(moListViews.hasAction()){
                moListViews.removeAction();
            }
        }
    }

    public static void closeActions(List<MoListViews> views){
        if(views == null)
            return;
        for(MoListViews moListViews: views){
            if(moListViews.hasAction()){
                moListViews.removeAction();
            }
        }
    }

    public static int firstAction(MoListViews[] views){
        for(int i = 0;i < views.length; i++ ){
            if(views[i].hasAction()){
                return i;
            }
        }
        return MoListViewSync.NO_ACTION;
    }



    public static void sync(MoListViews ... views){
        for(int i = 0;i < views.length; i++){
            MoListViews v = views[i];
            for(int j = 0; j < views.length; j++){
                if(i!=j){
                    // then we should sync these views together
                    v.addSyncAction(views[j]);
                }
            }
        }
    }

    /**
     * syncs the view with other v
     * @param view
     * @param v
     */
    public static void sync(MoListViews view, MoListViews ... v){
        view.setSyncActions(v);
    }


}
