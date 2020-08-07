package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable;

import android.view.View;


import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;

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
    public static void closeActions(Iterable<MoListViews> views){
        if(views == null)
            return;
        for(MoListViews moListViews: views){
            if(moListViews.hasAction()){
                moListViews.removeAction();
            }
        }
    }


    /**
     * makes all the list views
     * go on hold
     * @param views
     */
    public static void goOnHold(Iterable<MoListViews> views){
        if(views == null)
            return;
        for(MoListViews moListViews: views){
            moListViews.goOnHold();
        }
    }



    /**
     * makes all the list views
     * go on hold
     * @param views
     */
    public static void releaseOnHold(Iterable<MoListViews> views){
        if(views == null)
            return;
        for(MoListViews moListViews: views){
            moListViews.releaseOnHold();
        }
    }


    /**
     * sets a mutual connection between all of the
     * list views and the list sync
     * @param listSync
     * @param listViews
     */
    public static void sync(MoListViewSync listSync, List<MoListViews> listViews){
        for(MoListViews item: listViews){
            item.setListViewSync(listSync);
        }
    }


//    public static int firstAction(MoListViews[] views){
//        for(int i = 0;i < views.length; i++ ){
//            if(views[i].hasAction()){
//                return i;
//            }
//        }
//        return MoListViewSync.NO_ACTION;
//    }



//    public static void sync(MoListViews ... views){
//        for(int i = 0;i < views.length; i++){
//            MoListViews v = views[i];
//            for(int j = 0; j < views.length; j++){
//                if(i!=j){
//                    // then we should sync these views together
//                    v.addSyncAction(views[j]);
//                }
//            }
//        }
//    }
//
//    /**
//     * syncs the view with other v
//     * @param view
//     * @param v
//     */
//    public static void sync(MoListViews view, MoListViews ... v){
//        view.setSyncActions(v);
//    }


}
