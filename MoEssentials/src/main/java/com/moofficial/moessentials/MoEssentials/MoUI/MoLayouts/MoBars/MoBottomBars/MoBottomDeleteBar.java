package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBars.MoBottomBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoBottomDeleteBar extends MoConstraint {

    private LinearLayout linearLayout;
    private Button cancel,delete;

    public MoBottomDeleteBar(Context context) {
        super(context);
    }

    public MoBottomDeleteBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoBottomDeleteBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int CId(){
        return cancel.getId();
    }

    public int DId(){
        return delete.getId();
    }

    public int LId(){
        return linearLayout.getId();
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_bottom_delete_bar;
    }

    @Override
    public void initViews() {
        cancel = findViewById(R.id.bottom_delete_bar_cancel);
        delete = findViewById(R.id.bottom_delete_bar_delete);
        linearLayout = findViewById(R.id.bottom_delete_bar_linear_layout);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
