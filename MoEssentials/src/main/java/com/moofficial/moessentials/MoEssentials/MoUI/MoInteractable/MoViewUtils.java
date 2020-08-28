package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;


import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;

import java.util.Arrays;
import java.util.List;

public class MoViewUtils {

    /**
     * applies the visibility and animation to each
     * view
     * @param views
     * @param visibility
     */
    public static void apply(View parent,View[] views, int visibility,Transition transition){
        apply(parent,Arrays.asList(views),visibility,transition);
    }

    /**
     * applies the visibility to all of the views
     * and performs a delayed transition with changing bound
     * attribute
     * @param parent
     * @param views
     * @param visibility
     */
    public static void apply(View parent,List<View> views, int visibility,Transition transition){
        if(views==null)
            return;
        if(transition!=null && parent!=null){
            TransitionManager.beginDelayedTransition((ViewGroup) parent,transition);
        }
        for(View v: views){
            v.setVisibility(visibility);
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

    /**
     * applies the color to the view
     * based on what type of view v is,
     * we use different methods
     * @param v view to apply the color to
     * @param color background color to apply to v
     */
    public static void applyColor(View v, int color) {
        if(v instanceof CardView){
            ((CardView) v).setCardBackgroundColor(color);
        }else{
            v.setBackgroundColor(color);
        }
    }


}
