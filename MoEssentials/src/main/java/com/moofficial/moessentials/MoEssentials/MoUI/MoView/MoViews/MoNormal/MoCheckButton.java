package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.StringRes;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoCheckButton extends MoConstraint {

    private MoCardView cardView;
    private TextView text;
    private SwitchMaterial switchMaterial;

    public MoCheckButton(Context context) {
        super(context);
    }

    public MoCheckButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoCheckButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public TextView getText() {
        return text;
    }

    public SwitchMaterial getSwitchMaterial() {
        return switchMaterial;
    }

    public MoCheckButton setText(String text) {
        this.text.setText(text);
        return this;
    }

    public MoCheckButton setText(@StringRes int text) {
        this.text.setText(text);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_check_button;
    }

    @Override
    public void initViews() {
        this.text = findViewById(R.id.mo_check_button_text);
        this.switchMaterial = findViewById(R.id.mo_check_button_check);
        this.cardView = findViewById(R.id.mo_check_button_card_view);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
