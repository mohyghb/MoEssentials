package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MoWrapperFloatingActionButton extends MoWrapper<FloatingActionButton> {



    public MoWrapperFloatingActionButton(FloatingActionButton f) {
        super(f);
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
        wrappedElement.setRippleColor(getContext().getColor(rippleColorId));
        return this;
    }

    public MoWrapperFloatingActionButton setBackgroundColor(int res){
        wrappedElement.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(getContext(), res)));
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
