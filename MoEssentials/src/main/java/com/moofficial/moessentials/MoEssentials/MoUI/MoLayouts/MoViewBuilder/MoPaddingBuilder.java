package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder;

import android.content.Context;
import android.view.View;

public class MoPaddingBuilder{

    int top,left,bottom,right;

    public MoPaddingBuilder(int p){
        top = p;
        left = p;
        bottom = p;
        right = p;
    }

    public int getTop() {
        return top;
    }

    public MoPaddingBuilder setTop(int top) {
        this.top = top;
        return this;
    }

    public int getLeft() {
        return left;
    }

    public MoPaddingBuilder setLeft(int left) {
        this.left = left;
        return this;
    }

    public int getBottom() {
        return bottom;
    }

    public MoPaddingBuilder setBottom(int bottom) {
        this.bottom = bottom;
        return this;
    }

    public int getRight() {
        return right;
    }

    public MoPaddingBuilder setRight(int right) {
        this.right = right;
        return this;
    }

    /**
     * applies the padding to the view
     * @param v
     */
    public void apply(View v){
        v.setPadding(left,top,right,bottom);
    }

}
