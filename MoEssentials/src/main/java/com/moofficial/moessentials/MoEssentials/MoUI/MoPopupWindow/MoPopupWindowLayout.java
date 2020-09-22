package com.moofficial.moessentials.MoEssentials.MoUI.MoPopupWindow;

import android.content.Context;
import android.util.AttributeSet;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperLinearLayout;
import com.moofficial.moessentials.R;

public class MoPopupWindowLayout extends MoConstraint {

    private MoCardView cardView;
    private MoWrapperLinearLayout wrapperLinearLayout;

    public MoPopupWindowLayout(Context context) {
        super(context);
    }

    public MoPopupWindowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoPopupWindowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public MoWrapperLinearLayout getWrapperLinearLayout() {
        return wrapperLinearLayout;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_pop_up_window;
    }


    @Override
    public void initViews() {
        this.cardView = findViewById(R.id.mo_pop_up_window_card);
        this.wrapperLinearLayout = new MoWrapperLinearLayout(findViewById(R.id.mo_pop_up_window_linear));
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
