package com.moofficial.moessentials.MoEssentials.MoUI.MoViews;

import android.view.View;


import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;

import java.util.List;

public class MoViewUtils {

    /**
     * applies the visibility and animation to each
     * view
     * @param views
     * @param visibility
     * @param animation
     */
    static void apply(View[] views, int visibility, int animation){
        if(views==null)
            return;

        for(View v: views){
            MoAnimation.animateNoTag(v,visibility,animation);
        }
    }

    /**
     * closes the views that are performing an action
     * @param views
     */
    static void closeActions(MoListViews[] views){
        if(views == null)
            return;
        for(MoListViews moListViews: views){
            if(moListViews.hasAction()){
                moListViews.removeAction();
            }
        }
    }

    static void closeActions(List<MoListViews> views){
        if(views == null)
            return;
        for(MoListViews moListViews: views){
            if(moListViews.hasAction()){
                moListViews.removeAction();
            }
        }
    }

    static int firstAction(MoListViews[] views){
        for(int i = 0;i < views.length; i++ ){
            if(views[i].hasAction()){
                return i;
            }
        }
        return MoListViewSync.NO_ACTION;
    }



    static void sync(MoListViews ... views){
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
