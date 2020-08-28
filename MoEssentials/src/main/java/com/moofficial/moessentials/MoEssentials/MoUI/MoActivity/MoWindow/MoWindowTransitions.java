package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoWindow;

import android.app.Activity;
import android.transition.Transition;
import android.view.Window;

public class MoWindowTransitions {

    /**
     * applies transition t to the window of
     * activity a
     * @param t transition to apply to
     * @param a activity to apply the transitions to
     */
    public static void apply(Transition t, Activity a){
        apply(t,a,false);
    }

    /**
     * applies transition t to the window of
     * activity a
     * @param t transition to apply to
     * @param a activity to apply the transitions to
     * @param overlap whether the transitions can overlap or not
     */
    public static void apply(Transition t, Activity a,boolean overlap){
        Window w = a.getWindow();
        w.setEnterTransition(t);
        w.setExitTransition(t);
        w.setAllowEnterTransitionOverlap(overlap);
        w.setAllowReturnTransitionOverlap(overlap);
    }

}
