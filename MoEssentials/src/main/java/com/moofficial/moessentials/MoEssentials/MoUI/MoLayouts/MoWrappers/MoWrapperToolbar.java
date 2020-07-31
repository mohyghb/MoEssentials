package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.widget.Toolbar;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;

public class MoWrapperToolbar extends MoWrapper {

    private Toolbar toolbar;
    private MoWrapperLinearLayout linearLayout;

    public MoWrapperToolbar(Context c, Toolbar t,LinearLayout linearLayout) {
        super(c);
        this.toolbar = t;
        this.linearLayout = new MoWrapperLinearLayout(this.context,linearLayout);
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public MoWrapperToolbar setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
        return this;
    }

    public MoWrapperLinearLayout getLinearLayout() {
        return linearLayout;
    }

    public MoWrapperToolbar setLinearLayout(MoWrapperLinearLayout linearLayout) {
        this.linearLayout = linearLayout;
        return this;
    }

    public MoWrapperToolbar setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = new MoWrapperLinearLayout(this.context,linearLayout);
        return this;
    }

    public View addToolbar(int rId){
        return addToolbar( MoInflaterView.inflate(rId,context));
    }

    public View addToolbar(View v){
        linearLayout.addView(v);
        return v;
    }

    @Override
    public View getView() {
        return toolbar;
    }
}
