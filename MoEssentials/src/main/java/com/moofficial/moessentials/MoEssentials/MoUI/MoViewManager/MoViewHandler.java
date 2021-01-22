package com.moofficial.moessentials.MoEssentials.MoUI.MoViewManager;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoListViewUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoViewHandler {

    private List<View> unNormal = new ArrayList<>();
    private List<View> normal = new ArrayList<>();
    private ViewGroup parent;
    private Transition transitionIn = new ChangeBounds();
    private Transition transitionOut = new ChangeBounds();
    private boolean isNormal = true;

    public MoViewHandler(@NonNull ViewGroup g) {
        this.parent = g;
    }

    public MoViewHandler setTransitionIn(Transition transitionIn) {
        this.transitionIn = transitionIn;
        return this;
    }

    public MoViewHandler setTransitionOut(Transition transitionOut) {
        this.transitionOut = transitionOut;
        return this;
    }

    public MoViewHandler addNormalView(View ... views) {
        normal.addAll(Arrays.asList(views));
        return this;
    }

    public MoViewHandler addUnNormalView(View ... views) {
        unNormal.addAll(Arrays.asList(views));
        return this;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public MoViewHandler turnNormal() {
        this.isNormal = true;
        MoListViewUtils.apply(parent, this.normal, View.VISIBLE,transitionIn);
        MoListViewUtils.apply(parent, this.unNormal, View.GONE,transitionOut);
        return this;
    }

    public MoViewHandler turnUnNormal() {
        this.isNormal = false;
        MoListViewUtils.apply(parent, this.unNormal, View.VISIBLE,transitionIn);
        MoListViewUtils.apply(parent, this.normal, View.GONE,transitionOut);
        return this;
    }



}
