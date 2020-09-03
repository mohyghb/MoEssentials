package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoLinearLayoutUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoSwitchers.MoSwitchViews;

import static com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoLinearLayoutUtils.addToLinearLayout;

public class MoWrapperLinearLayout extends MoWrapper<LinearLayout> {




    public MoWrapperLinearLayout(LinearLayout l){
        super(l);
    }





    public View addView(View v){
        return addView(v,null);
    }

    public void addViews(View ... views){
        addViews(null,views);
    }

    public void addViews(LinearLayout.LayoutParams lp,View ... views){
        for(View v:views){
            addView(v,lp);
        }
    }

    public View addView(View v,LinearLayout.LayoutParams lp){
        MoLinearLayoutUtils.addToLinearLayout(wrappedElement,v,lp);
        return v;
    }

    public LinearLayout getLinearLayout() {
        return wrappedElement;
    }

    public MoWrapperLinearLayout setLinearLayout(LinearLayout linearLayout) {
        this.wrappedElement = linearLayout;
        return this;
    }

    /**
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
