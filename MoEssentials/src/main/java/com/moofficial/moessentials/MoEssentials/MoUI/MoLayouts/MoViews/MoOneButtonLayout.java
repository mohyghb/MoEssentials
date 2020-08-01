package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoOneButtonLayout extends MoConstraint {

    MoCardWrapper cardView;
    Button button;


    public MoOneButtonLayout(Context context) {
        super(context);
    }

    public MoOneButtonLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoOneButtonLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MoOneButtonLayout setOnButtonClickListener(View.OnClickListener l){
        button.setOnClickListener(l);
        return this;
    }

    public MoOneButtonLayout setButtonText(String t){
        button.setText(t);
        return this;
    }

    public MoCardWrapper getCardView() {
        return cardView;
    }

    public MoOneButtonLayout setCardView(MoCardWrapper cardView) {
        this.cardView = cardView;
        return this;
    }

    public Button getButton() {
        return button;
    }

    public MoOneButtonLayout setButton(Button button) {
        this.button = button;
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_one_button_layout;
    }

    @Override
    public void initViews() {
        cardView = new MoCardWrapper(findViewById(R.id.one_button_card_view));
        button = findViewById(R.id.one_button_button);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
