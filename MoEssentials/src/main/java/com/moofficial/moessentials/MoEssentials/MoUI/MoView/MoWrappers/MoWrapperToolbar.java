package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoSwitchers.MoSwitchViews;

public class MoWrapperToolbar extends MoWrapper<Toolbar> {

    private MoWrapperLinearLayout linearLayout;

    public MoWrapperToolbar(Toolbar t,LinearLayout linearLayout) {
        super(t);
        this.linearLayout = new MoWrapperLinearLayout(linearLayout);
    }



    public MoWrapperLinearLayout getLinearLayout() {
        return linearLayout;
    }

    public MoWrapperToolbar setLinearLayout(MoWrapperLinearLayout linearLayout) {
        this.linearLayout = linearLayout;
        return this;
    }

    public View addToolbar(View v){
        linearLayout.addView(v);
        return v;
    }


    /**
     * adds multiple toolbars to the main toolbar
     * and only turns the active one on
     * and the rest are GONE
     * @param active
     * @param views
     */
    public void setupMultipleToolbars(View active,View ... views){
        linearLayout.setupMultipleBars(active,views);
    }

    @Override
    public Toolbar getView() {
        return wrappedElement;
    }
}
