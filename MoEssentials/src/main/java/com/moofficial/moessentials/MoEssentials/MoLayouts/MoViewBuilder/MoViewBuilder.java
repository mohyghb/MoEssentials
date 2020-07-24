package com.moofficial.moessentials.MoEssentials.MoLayouts.MoViewBuilder;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public abstract class MoViewBuilder extends MoContext {


    protected View.OnClickListener clickListener = view -> {};
    protected View.OnLongClickListener longClickListener = view -> {return false;};

    public MoViewBuilder(Context c) {
        super(c);
    }


    public View.OnClickListener getClickListener() {
        return clickListener;
    }

    public MoViewBuilder setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
        return this;
    }

    public View.OnLongClickListener getLongClickListener() {
        return longClickListener;
    }

    public MoViewBuilder setLongClickListener(View.OnLongClickListener longClickListener) {
        this.longClickListener = longClickListener;
        return this;
    }

    public <T extends View> void build(T v){
        v.setOnLongClickListener(longClickListener);
        v.setOnClickListener(clickListener);
        buildItem(v);
    }

    protected abstract <T extends View> void buildItem(T v);
}
