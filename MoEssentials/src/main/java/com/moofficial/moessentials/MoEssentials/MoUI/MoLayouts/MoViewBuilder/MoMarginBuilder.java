package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

public class MoMarginBuilder extends MoPaddingBuilder{


    public MoMarginBuilder() {
        super();
    }

    public MoMarginBuilder(int p) {
        super(p);
    }

    @Override
    public int getTop() {
        return super.getTop();
    }

    @Override
    public MoMarginBuilder setTop(int top) {
        super.setTop(top);
        return this;
    }

    @Override
    public int getLeft() {
        return super.getLeft();
    }

    @Override
    public MoMarginBuilder setLeft(int left) {
        super.setLeft(left);
        return this;
    }

    @Override
    public int getBottom() {
        return super.getBottom();
    }

    @Override
    public MoMarginBuilder setBottom(int bottom) {
        super.setBottom(bottom);
        return this;
    }

    @Override
    public int getRight() {
        return super.getRight();
    }

    @Override
    public MoMarginBuilder setRight(int right) {
        super.setRight(right);
        return this;
    }

    @Override
    public MoMarginBuilder apply(View v) {
        v.setLayoutParams(getRespectiveParam((ViewGroup) v.getParent()));
        return this;
    }

    public ViewGroup.LayoutParams getRespectiveParam(ViewGroup v){
        if(v instanceof LinearLayout){
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(left,top,right,bottom);
            return lp;
        }else if(v instanceof ConstraintLayout){
            ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(left,top,right,bottom);
            return lp;
        }else if(v instanceof CoordinatorLayout) {
            CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT,
                    CoordinatorLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(left, top, right, bottom);
            return lp;
        }
        return null;
    }

}
