package com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoTransitions;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import android.transition.TransitionValues;
import android.transition.Visibility;

// a circular transition that can be used to
// transition views as well as activities
public class MoCircularTransition extends Visibility {

    // this is used to track the touch position of the
    // transition, if we turn on this feature, the
    // transition happens at the point that we are touching the views
    private float x,y;

    public void onTouch(MotionEvent e){
        this.x = e.getX();
    }

    @Override
    public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        int startRadius = 0;
        int endRadius = (int) Math.hypot(view.getWidth(), view.getHeight());
        Animator reveal = ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2,
                view.getHeight() / 2, startRadius, endRadius);
        //make view invisible until animation actually starts
        view.setAlpha(0);
        reveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                view.setAlpha(1);
            }
        });
        return reveal;
    }

    @Override
    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        int endRadius = 0;
        int startRadius = (int) Math.hypot(view.getWidth(), view.getHeight());
        return ViewAnimationUtils.createCircularReveal(view, view.getWidth() / 2,
                view.getHeight() / 2, startRadius, endRadius);
    }
}
