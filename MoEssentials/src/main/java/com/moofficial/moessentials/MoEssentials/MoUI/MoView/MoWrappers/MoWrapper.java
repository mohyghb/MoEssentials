package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public abstract class MoWrapper<T extends View>  {

    T wrappedElement;

    public MoWrapper(T t) {
        wrappedElement = t;
    }

    public Context getContext(){
        return wrappedElement.getContext();
    }

    public int getId(){
        return getView().getId();
    }

    public abstract T getView();

}
