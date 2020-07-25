package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoViewBuilder;

public abstract class MoAppbarLayout extends AppBarLayout implements MoViewInterface{

    protected TypedArray typedArray;

    public MoAppbarLayout(Context context) {
        super(context);
        init(null);
    }

    public MoAppbarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MoAppbarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    public MoAppbarLayout customize(MoViewBuilder builder, View viewToCustomize){
        builder.build(viewToCustomize);
        return this;
    }

    public MoAppbarLayout customize(MoViewBuilder builder, int id){
        builder.build(findViewById(id));
        return this;
    }


    /**
     * inflates the view of this class and does other appropriate things
     */
    protected void init(AttributeSet attrs){
        inflate(getContext(),getLayoutId(),this);
        if(attrs!=null){
            //get the attributes specified in attrs.xml using the name we included
            getContext().getTheme().obtainStyledAttributes(attrs,
                    getAttrs(), 0, 0);
        }
        initViews();
    }
}
