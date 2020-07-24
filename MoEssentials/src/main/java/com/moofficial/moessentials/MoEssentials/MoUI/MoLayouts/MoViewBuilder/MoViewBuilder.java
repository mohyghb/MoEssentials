package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public abstract class MoViewBuilder extends MoContext {


    protected View.OnClickListener clickListener = view -> {};
    protected View.OnLongClickListener longClickListener = view -> {return false;};
    protected MoPaddingBuilder contentPadding = new MoPaddingBuilder(0);
    protected int visibility = View.VISIBLE;


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

    public MoPaddingBuilder getContentPadding() {
        return contentPadding;
    }

    public MoViewBuilder setContentPadding(MoPaddingBuilder contentPadding) {
        this.contentPadding = contentPadding;
        return this;
    }

    public int getVisibility() {
        return visibility;
    }

    public MoViewBuilder setVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public <T extends View> void build(T v){
        v.setOnLongClickListener(longClickListener);
        v.setOnClickListener(clickListener);
        contentPadding.apply(v);
        buildItem(v);
    }

    protected abstract <T extends View> void buildItem(T v);
}
