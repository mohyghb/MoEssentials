package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public abstract class MoWrapper<T extends View> extends MoContext {

    T wrappedElement;

    public MoWrapper(Context c, T t) {
        super(c);
        wrappedElement = t;
    }

    public int getId(){
        return getView().getId();
    }

    public abstract T getView();

}
