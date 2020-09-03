package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts;

import android.content.Context;
import android.util.AttributeSet;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;

public abstract class MoEmptyLayout extends MoConstraint {

    public MoEmptyLayout(Context context) {
        super(context);
    }

    public MoEmptyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoEmptyLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
