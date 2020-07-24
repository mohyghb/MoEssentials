package com.moofficial.moessentials.MoEssentials.MoLayouts;

import android.content.Context;
import android.util.AttributeSet;

import com.moofficial.moessentials.MoEssentials.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoFindBar extends MoConstraint {


    public MoFindBar(Context context) {
        super(context);
    }

    public MoFindBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoFindBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mo_find_bar;
    }


}
