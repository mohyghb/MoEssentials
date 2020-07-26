package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoViewBuilder;
import com.moofficial.moessentials.R;

public abstract class MoConstraint extends ConstraintLayout implements MoViewInterface {

    protected TypedArray typedArray;

    public MoConstraint(Context context) {
        super(context);
        init(null);
    }

    public MoConstraint(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public MoConstraint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }


    public MoConstraint customize(MoViewBuilder builder, View viewToCustomize){
        builder.build(viewToCustomize);
        return this;
    }

    public MoConstraint customize(MoViewBuilder builder, int id){
        builder.build(findViewById(id));
        return this;
    }

    public MoConstraint goInvisible(){
        setVisibility(View.INVISIBLE);
        return this;
    }

    public MoConstraint goVisible(){
        setVisibility(View.VISIBLE);
        return this;
    }

    public  MoConstraint goGone(){
        setVisibility(View.GONE);
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
