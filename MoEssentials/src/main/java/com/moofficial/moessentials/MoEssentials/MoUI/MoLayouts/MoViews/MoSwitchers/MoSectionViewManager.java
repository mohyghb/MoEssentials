package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoSwitchers;

import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;

import androidx.core.util.Pair;

import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoViewUtils;

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
        MoViewUtils.apply(root,viewsInSection,View.GONE,transitionOut);
        mapOfView.put(key,viewsInSection);
        return this;
    }

    public MoSectionViewManager setActiveSection(int key){
        if(activeSection!=null){
            MoViewUtils.apply(root,activeSection.second,View.GONE,transitionOut);
        }
        this.activeSection = new Pair<>(key,mapOfView.get(key));
        MoViewUtils.apply(root,activeSection.second,View.VISIBLE,transitionIn);
        return this;
    }





}
