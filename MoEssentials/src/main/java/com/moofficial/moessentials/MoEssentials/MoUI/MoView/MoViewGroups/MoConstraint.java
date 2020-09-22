package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoViewBuilder;

public abstract class MoConstraint extends ConstraintLayout implements MoViewInterface {

    protected TypedArray typedArray;

    public MoConstraint(Context context) {
        super(context);
        //this.context = context;
        init(null);
    }

    public MoConstraint(Context context, AttributeSet attrs) {
        super(context, attrs);
       // this.context = context;
        init(attrs);
    }

    public MoConstraint(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       // this.context = context;
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

    public MoConstraint invisible() {
        setVisibility(View.INVISIBLE);
        return this;
    }

    public MoConstraint visible() {
        setVisibility(View.VISIBLE);
        return this;
    }

    public  MoConstraint gone() {
        setVisibility(View.GONE);
        return this;
    }

    public String getString(int id) {
        return getContext().getString(id);
    }

    public Drawable getDrawable(int id) {
        return ContextCompat.getDrawable(getContext(),id);
    }

    public int getColor(int id) {
        return ContextCompat.getColor(getContext(),id);
    }

    public Resources getResources(){
        return getContext().getResources();
    }

    public float getDimension(int id){
        return getContext().getResources().getDimension(id);
    }


    /**
     *
     * @return height of the screen in current mode
     *         in pixels
     */
    public int getHeightPixels(){
        return getResources().getDisplayMetrics().heightPixels;
    }

    /**
     *
     * @return width of the screen in current mode
     *         in pixels
     */
    public int getWidthPixels(){
        return getResources().getDisplayMetrics().widthPixels;
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
