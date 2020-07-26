package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.R;

public class MoFloatingActionButton extends MoWrapper {

    private FloatingActionButton fab;


    public MoFloatingActionButton(Context c,FloatingActionButton f) {
        super(c);
        this.fab = f;
    }

    public void setOnClickListener(View.OnClickListener listenerFAB){
        fab.setOnClickListener(listenerFAB);
    }

    public void setIcon(int iconDrawable){
        fab.setImageResource(iconDrawable);
    }

    public void setRippleColor(int rippleColorId){
        fab.setRippleColor(getColor(rippleColorId));
    }

    public void setBackgroundColor(int res){
        fab.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(context, res)));
    }

    @Override
    public View getView() {
        return fab;
    }
}
