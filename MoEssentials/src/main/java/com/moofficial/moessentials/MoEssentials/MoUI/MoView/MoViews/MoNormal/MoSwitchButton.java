package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoSwitchButton extends MoConstraint {

    private MoCardView cardView;
    private TextView text;
    private SwitchMaterial switchMaterial;
    private ConstraintLayout layout;
    private View.OnClickListener clickListener = (v) -> {};

    public MoSwitchButton(Context context) {
        super(context);
    }

    public MoSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoSwitchButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ConstraintLayout getLayout() {
        return layout;
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

    public MoSwitchButton setText(String text) {
        this.text.setText(text);
        return this;
    }

    public MoSwitchButton setText(@StringRes int text) {
        this.text.setText(text);
        return this;
    }

    public MoSwitchButton setOnSwitchChanged(@NonNull View.OnClickListener l) {
        this.clickListener = (v)-> {
            switchMaterial.setChecked(!switchMaterial.isChecked());
            l.onClick(v);
        };
        return this;
    }


    public boolean isChecked() {
        return this.switchMaterial.isChecked();
    }

    public void setChecked(boolean b) {
        this.switchMaterial.setChecked(b);
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_switch_button;
    }

    @Override
    public void initViews() {
        this.text = findViewById(R.id.mo_check_button_text);
        this.switchMaterial = findViewById(R.id.mo_check_button_check);
        this.cardView = findViewById(R.id.mo_check_button_card_view);
        this.layout = findViewById(R.id.mo_switch_button_layout);
//        this.switchMaterial.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (!buttonView.isPressed()) {
//                return;
//            }
//            clickListener.onClick(buttonView);
//            switchMaterial.setChecked(isChecked);
//        });
        this.switchMaterial.setClickable(false);
        this.cardView.setOnClickListener((v)-> clickListener.onClick(v));
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
