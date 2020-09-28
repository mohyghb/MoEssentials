package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.LinearLayoutCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoLinearLayoutUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoSwitchers.MoSwitchViews;

import java.util.Arrays;
import java.util.List;

import static com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoLinearLayoutUtils.addToLinearLayout;

public class MoWrapperLinearLayout extends MoWrapper<LinearLayout> {




    public MoWrapperLinearLayout(LinearLayout l){
        super(l);
    }





    public MoWrapperLinearLayout addView(View v){
        return addView(v,null);
    }


    /**
     * sets the orientation of the
     * linear layout
     * @param o orientation
     * @return this for nested calling
     */
    public MoWrapperLinearLayout setOrientation(@LinearLayoutCompat.OrientationMode int o) {
        wrappedElement.setOrientation(o);
        return this;
    }

    public MoWrapperLinearLayout setWeightSum(float s) {
        wrappedElement.setWeightSum(s);
        return this;
    }


    /**
     * adds all the views to the linear layout
     * and puts null as their layout param
     * @param views views to be added
     */
    public MoWrapperLinearLayout addViews(View ... views){
        return addViews(Arrays.asList(views));
    }

    /**
     * adds all the views to the linear layout
     * and puts null as their layout param
     * @param views views to be added
     */
    public MoWrapperLinearLayout addViews(List<View> views){
        return addViews(null,views);
    }

    /**
     * adds all the views to the linear layout
     * and puts p as their layout param
     * @param lp layout param
     * @param views views to be added
     */
    public MoWrapperLinearLayout addViews(LinearLayout.LayoutParams lp,View ... views){
        return this.addViews(lp, Arrays.asList(views));
    }

    /**
     * adds all the views to the linear layout
     * and puts p as their layout param
     * @param lp layout param
     * @param views views to be added
     */
    public MoWrapperLinearLayout addViews(LinearLayout.LayoutParams lp, List<View> views){
        for(View v:views) {
            addView(v,lp);
        }
        return this;
    }

    public MoWrapperLinearLayout addView(View v,LinearLayout.LayoutParams lp){
        MoLinearLayoutUtils.addToLinearLayout(wrappedElement,v,lp);
        return this;
    }

    public LinearLayout getLinearLayout() {
        return wrappedElement;
    }

    public MoWrapperLinearLayout setLinearLayout(LinearLayout linearLayout) {
        this.wrappedElement = linearLayout;
        return this;
    }

    /**
     * this is a term we use to show only
     * one bar inside the linear layout at a time
     * adds multiple toolbars to the main toolbar
     * and only turns the active one on
     * and the rest are GONE
     * @param active
     * @param views
     */
    public void setupMultipleBars(View active,View ... views){
        new MoSwitchViews().addViews(views).setActiveView(active).build(this::addView);
    }

    @Override
    public LinearLayout getView() {
        return wrappedElement;
    }
}
