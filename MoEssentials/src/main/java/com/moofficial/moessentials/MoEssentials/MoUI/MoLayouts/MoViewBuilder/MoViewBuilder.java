package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public abstract class MoViewBuilder extends MoContext {


    protected View.OnClickListener clickListener;
    protected View.OnLongClickListener longClickListener;
    protected MoPaddingBuilder contentPadding;
    protected MoMarginBuilder marginBuilder;
    protected int visibility = View.VISIBLE;
    protected int minHeight,minWidth;


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

    public int getMinHeight() {
        return minHeight;
    }

    public MoViewBuilder setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public MoViewBuilder setMinWidth(int minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public MoViewBuilder setVisibility(int visibility) {
        this.visibility = visibility;
        return this;
    }

    public <T extends View> void build(T ... vs){
        for(T v: vs){
            setIfNotNull(longClickListener,()->v.setOnLongClickListener(longClickListener));
            setIfNotNull(clickListener,()->v.setOnClickListener(clickListener));
            setIfNotNull(contentPadding,()->  contentPadding.apply(v));
            setIfNotNull(marginBuilder,()-> marginBuilder.apply(v));
            v.setMinimumWidth(minWidth);
            v.setMinimumHeight(minHeight);
            buildItem(v);
        }
    }

    protected abstract <T extends View> void buildItem(T v);

    /**
     * if the object is not null, we run the runnable
     * @param o
     * @param r
     */
    public void setIfNotNull(Object o,Runnable r){
        if(o!=null){
            r.run();
        }
    }

}
