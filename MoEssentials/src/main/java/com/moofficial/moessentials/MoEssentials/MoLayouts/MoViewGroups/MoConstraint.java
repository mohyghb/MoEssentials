package com.moofficial.moessentials.MoEssentials.MoLayouts.MoViewGroups;

import android.content.Context;
import android.util.AttributeSet;

import androidx.constraintlayout.widget.ConstraintLayout;

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

    /**
     * inflates the view of this class and does other appropriate things
     */
    protected void init(){
        inflate(getContext(),getLayoutId(),this);
    }

    protected abstract int getLayoutId();

}
