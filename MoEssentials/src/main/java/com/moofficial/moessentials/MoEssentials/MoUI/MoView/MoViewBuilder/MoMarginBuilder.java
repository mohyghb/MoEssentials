package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
// todo the linear and card params do not work as dp since
//  we also need the view to get the context from
public class MoMarginBuilder extends MoPaddingBuilder{


    public MoMarginBuilder(Context c) {
        super(c);
    }

    public MoMarginBuilder(Context c, int p) {
        super(c,p);
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
    public static LinearLayout.LayoutParams getLinearParams(Context c, int l, int t, int r, int b){
        return getLinearParams(
                new MoMarginBuilder(c).setTop(t)
                                     .setLeft(l)
                                     .setRight(r)
                                     .setBottom(b)
                                     .asDp());
    }

    /**
     * all of them the same value
     * @param m
     * @return
     */
    public static LinearLayout.LayoutParams getLinearParams(Context c, int m){
        return getLinearParams(c,m,m,m,m);
    }


    /**
     * returns a linear layout params based on the builder
     * that is passed as the param
     * @param builder
     * @return
     */
    public static CardView.LayoutParams getCardLayoutParams(MoPaddingBuilder builder){
        CardView.LayoutParams lp = new CardView.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(builder.left,builder.top,builder.right,builder.bottom);
        return lp;
    }

    /**
     *
     * @param left
     * @param top
     * @param right
     * @param bottom
     * @return
     */
    public static CardView.LayoutParams getCardLayoutParams(Context c, int left,int top,int right,int bottom){
        return getCardLayoutParams(new MoMarginBuilder(c).setLeft(left).setTop(top)
                .setRight(right).setBottom(bottom).asDp());
    }

    /**
     *
     * @param m
     * @return
     */
    public static CardView.LayoutParams getCardLayoutParams(Context c, int m){
        return getCardLayoutParams(c,m,m,m,m);
    }




}
