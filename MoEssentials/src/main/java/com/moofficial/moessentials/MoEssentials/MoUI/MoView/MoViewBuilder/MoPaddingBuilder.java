package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder;

import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;

public class MoPaddingBuilder{

    int top,left,bottom,right;


    public MoPaddingBuilder(){}

    public MoPaddingBuilder(int p){
        top = p;
        left = p;
        bottom = p;
        right = p;
    }

    public MoPaddingBuilder(int left,int top,int right,int bottom) {
        setLeft(left).setTop(top).setRight(right).setBottom(bottom);
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


    public MoPaddingBuilder convertValuesToDp(){
        this.right = MoDynamicUnit.convertDpToPixels(this.right);
        this.top = MoDynamicUnit.convertDpToPixels(this.top);
        this.bottom = MoDynamicUnit.convertDpToPixels(this.bottom);
        this.left = MoDynamicUnit.convertDpToPixels(this.left);
        return this;
    }

    /**
     * applies the padding to the view
     * @param v
     */
    public MoPaddingBuilder apply(View v){
        v.setPadding(left,top,right,bottom);
        return this;
    }

}
