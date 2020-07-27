package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoAppbarLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoAppBar extends MoAppbarLayout {

    private final int MO_TOOL_BAR = 0;


    Toolbar toolbar;
    View toolbarChild;

    public MoAppBar(Context context) {
        super(context);
    }

    public MoAppBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoAppBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_app_bar;
    }

    @Override
    public void initViews() {
//        try{
//            int childId = typedArray.getInteger(R.styleable.MoAppBar_toolbar,-1);
            this.toolbarChild = MoInflaterView.inflate(R.layout.mo_tool_bar,getContext());
        //}catch (Exception ignore){}
        toolbar = findViewById(R.id.mo_appbar_toolbar);
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.addView(toolbarChild,layoutParams);
    }

    @Override
    public int[] getAttrs() {
        return R.styleable.MoAppBar;
    }
}
