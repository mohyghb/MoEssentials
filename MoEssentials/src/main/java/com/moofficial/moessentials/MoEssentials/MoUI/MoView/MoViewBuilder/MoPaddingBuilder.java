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
    public MoPaddingBuilder apply(View v) {
        if(v == null)
            return this;
        v.setPadding(left,top,right,bottom);
        return this;
    }

    /**
     * adds the padding to the current
     * padding of the view instead of resetting
     * it to the values of this class
     * @param v view to add padding to
     * @return this for nested calling
     */
    public MoPaddingBuilder applyToExisting(View v) {
        if(v == null)
            return this;
        v.setPadding(left + v.getPaddingLeft(),
                top + v.getPaddingTop(),
                right + v.getPaddingRight(),
                bottom + v.getPaddingBottom());
        return this;
    }


    /**
     * applies the padding to the view
     * if the condition is true and padding builder
     * is not null
     * @param p padding builder
     * @param v view
     * @param condition if true we apply padding to the view
     */
    public static void applyToExisting(MoPaddingBuilder p, View v, boolean condition) {
        if (p!=null && condition) {
            p.applyToExisting(v);
        }
    }

}
