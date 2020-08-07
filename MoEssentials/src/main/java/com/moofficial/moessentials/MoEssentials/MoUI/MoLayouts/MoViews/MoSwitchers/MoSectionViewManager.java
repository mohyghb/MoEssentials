package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoSwitchers;

import android.view.View;

import androidx.core.util.Pair;

import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoViewUtils;

import java.util.HashMap;

public class MoSectionViewManager {

    private View root;
    private int visibleAnimation = MoAnimation.FADE_IN;
    private int invisibleAnimation = MoAnimation.FADE_OUT;
    private HashMap<Integer, View[]> mapOfView = new HashMap<>();
    private Pair<Integer,View[]> activeSection;

    public MoSectionViewManager(View root){
        this.root = root;
    }

    public MoSectionViewManager addSection(Integer key,View ... viewsInSection){
        MoViewUtils.apply(root,viewsInSection,View.GONE,invisibleAnimation);
        mapOfView.put(key,viewsInSection);
        return this;
    }

    public MoSectionViewManager setActiveSection(int key){
        if(activeSection!=null){
            MoViewUtils.apply(root,activeSection.second,View.GONE,invisibleAnimation);
        }
        this.activeSection = new Pair<>(key,mapOfView.get(key));
        MoViewUtils.apply(root,activeSection.second,View.VISIBLE,visibleAnimation);
        return this;
    }





}
