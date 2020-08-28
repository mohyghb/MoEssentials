package com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation;

import android.transition.Fade;
import android.view.View;
import android.view.ViewGroup;

import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;

import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoTransitions.MoCircularTransition;
import com.moofficial.moessentials.R;

// makes it easier to use the transition classes
// in androidx
public class MoTransitionsUtils {

    private static final int FADE_DURATION = 600;
    private static final int SLIDE_DURATION = 500;
    private static final int CIRCULAR_REVEAL_DURATION = 500;


    /**
     *
     * @param transition
     * @param duration
     * @param parent
     * @param view
     * @param visibility
     */
    public static void applyTransition(Transition transition,int duration,ViewGroup parent,
                                       View view, int visibility) {
        transition.setDuration(duration);
        transition.addTarget(view);
        TransitionManager.beginDelayedTransition(parent, transition);
        view.setVisibility(visibility);
    }

    /**
     *
     * @param parent
     * @param view
     * @param visibility
     */
    public static void fade(ViewGroup parent, View view, int visibility){
        applyTransition(new Fade(),FADE_DURATION,parent, view, visibility);
    }

    /**
     *
     * @param parent
     * @param view
     * @param visibility
     */
    public static void slide(ViewGroup parent, View view, int visibility){
        applyTransition(new Slide(),SLIDE_DURATION,parent,view,visibility);
    }

    /**
     *
     * @param parent
     * @param view
     * @param visibility
     */
    public static void circularReveal(ViewGroup parent, View view, int visibility){
        applyTransition(new MoCircularTransition(),CIRCULAR_REVEAL_DURATION,
                parent,view,visibility);
    }



}
