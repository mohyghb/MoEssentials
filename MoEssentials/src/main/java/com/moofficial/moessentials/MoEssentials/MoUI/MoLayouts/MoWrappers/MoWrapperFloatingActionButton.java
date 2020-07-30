package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.R;

public class MoWrapperFloatingActionButton extends MoWrapper {

    private FloatingActionButton fab;


    public MoWrapperFloatingActionButton(Context c, FloatingActionButton f) {
        super(c);
        this.fab = f;
    }

    public MoWrapperFloatingActionButton setOnClickListener(View.OnClickListener listenerFAB){
        fab.setOnClickListener(listenerFAB);
        return this;
    }

    public MoWrapperFloatingActionButton setIcon(int iconDrawable){
        fab.setImageResource(iconDrawable);
        return this;
    }

    public MoWrapperFloatingActionButton setRippleColor(int rippleColorId){
        fab.setRippleColor(getColor(rippleColorId));
        return this;
    }

    public MoWrapperFloatingActionButton setBackgroundColor(int res){
        fab.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(context, res)));
        return this;
    }

    public MoWrapperFloatingActionButton hide(){
        fab.setVisibility(View.GONE);
        return this;
    }
    public MoWrapperFloatingActionButton show() {
        fab.setVisibility(View.VISIBLE);
        return this;
    }

    @Override
    public View getView() {
        return fab;
    }
}
