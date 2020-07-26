package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public abstract class MoWrapper extends MoContext {


    public MoWrapper(Context c) {
        super(c);
    }

    public abstract View getView();

}
