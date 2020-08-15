package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.R;

public class MoWrapperFloatingActionButton extends MoWrapper<FloatingActionButton> {



    public MoWrapperFloatingActionButton(Context c, FloatingActionButton f) {
        super(c,f);
    }

    public MoWrapperFloatingActionButton setOnClickListener(View.OnClickListener listenerFAB){
        wrappedElement.setOnClickListener(listenerFAB);
        return this;
    }

    public MoWrapperFloatingActionButton setIcon(int iconDrawable){
        wrappedElement.setImageResource(iconDrawable);
        return this;
    }

    public MoWrapperFloatingActionButton setRippleColor(int rippleColorId){
        wrappedElement.setRippleColor(getColor(rippleColorId));
        return this;
    }

    public MoWrapperFloatingActionButton setBackgroundColor(int res){
        wrappedElement.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(context, res)));
        return this;
    }

    public MoWrapperFloatingActionButton hide(){
        wrappedElement.setVisibility(View.GONE);
        return this;
    }
    public MoWrapperFloatingActionButton show() {
        wrappedElement.setVisibility(View.VISIBLE);
        return this;
    }

    @Override
    public FloatingActionButton getView() {
        return wrappedElement;
    }
}
