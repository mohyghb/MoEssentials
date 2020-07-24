package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoViewBuilder;

public abstract class MoConstraint extends ConstraintLayout {
    public MoConstraint(Context context) {
        super(context);
        init();
    }

    public MoConstraint(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MoConstraint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    public MoConstraint customize(MoViewBuilder builder, View viewToCustomize){
        builder.build(viewToCustomize);
        return this;
    }

    public MoConstraint customize(MoViewBuilder builder, int id){
        builder.build(findViewById(id));
        return this;
    }


    /**
     * inflates the view of this class and does other appropriate things
     */
    protected void init(){
        inflate(getContext(),getLayoutId(),this);
        initViews();
    }

    protected abstract int getLayoutId();
    protected abstract void initViews();




}
