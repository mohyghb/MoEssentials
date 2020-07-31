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

    /**
     * returns a linear layout params based on the builder
     * that is passed as the param
     * @param builder
     * @return
     */
    public static LinearLayout.LayoutParams getLinearParams(MoPaddingBuilder builder){
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        lp.setMargins(builder.left,builder.top,builder.right,builder.bottom);
        return lp;
    }


    /**
     *
     * @param l left margin
     * @param t top margin
     * @param r right margin
     * @param b bottom margin
     * @return
     */
    public static LinearLayout.LayoutParams getLinearParams(int l,int t,int r,int b){
        return MoMarginBuilder.getLinearParams(
                new MoMarginBuilder().setTop(t)
                                     .setLeft(l)
                                     .setRight(r)
                                     .setBottom(b)
                                     .convertValuesToDp());
    }

    /**
     * all of them the same value
     * @param m
     * @return
     */
    public static LinearLayout.LayoutParams getLinearParams(int m){
        return getLinearParams(m,m,m,m);
    }


}
