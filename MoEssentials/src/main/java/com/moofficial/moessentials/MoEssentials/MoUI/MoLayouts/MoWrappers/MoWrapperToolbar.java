package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;

public class MoWrapperToolbar extends MoWrapper {

    private Toolbar toolbar;

    public MoWrapperToolbar(Context c, Toolbar t) {
        super(c);
        this.toolbar = t;
    }


    public View addToolbar(int rId){
        return addToolbar( MoInflaterView.inflate(rId,context));
    }

    public View addToolbar(View v){
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.addView(v,layoutParams);
        return v;
    }

    @Override
    public View getView() {
        return toolbar;
    }
}
