package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoSwitchers;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;

import androidx.core.util.Pair;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoListViewUtils;

import java.util.HashMap;

public class MoSectionViewManager {

    private View root;
    private HashMap<Integer, View[]> mapOfView = new HashMap<>();
    private Pair<Integer,View[]> activeSection;
    private Transition transitionIn = new ChangeBounds();
    private Transition transitionOut = new ChangeBounds();

    public MoSectionViewManager(View root){
        this.root = root;
    }

    public MoSectionViewManager addSection(Integer key,View ... viewsInSection){
        MoListViewUtils.apply(root,viewsInSection,View.GONE,transitionOut);
        mapOfView.put(key,viewsInSection);
        return this;
    }

    public MoSectionViewManager setActiveSection(int key){
        if(activeSection!=null){
            MoListViewUtils.apply(root,activeSection.second,View.GONE,transitionOut);
        }
        this.activeSection = new Pair<>(key,mapOfView.get(key));
        MoListViewUtils.apply(root,activeSection.second,View.VISIBLE,transitionIn);
        return this;
    }

    public HashMap<Integer, View[]> getMapOfView() {
        return mapOfView;
    }

    public MoSectionViewManager setMapOfView(HashMap<Integer, View[]> mapOfView) {
        this.mapOfView = mapOfView;
        return this;
    }

    public Pair<Integer, View[]> getActiveSection() {
        return activeSection;
    }

    public MoSectionViewManager setActiveSection(Pair<Integer, View[]> activeSection) {
        this.activeSection = activeSection;
        return this;
    }

    public Transition getTransitionIn() {
        return transitionIn;
    }

    public MoSectionViewManager setTransitionIn(Transition transitionIn) {
        this.transitionIn = transitionIn;
        return this;
    }

    public Transition getTransitionOut() {
        return transitionOut;
    }

    public MoSectionViewManager setTransitionOut(Transition transitionOut) {
        this.transitionOut = transitionOut;
        return this;
    }
}
