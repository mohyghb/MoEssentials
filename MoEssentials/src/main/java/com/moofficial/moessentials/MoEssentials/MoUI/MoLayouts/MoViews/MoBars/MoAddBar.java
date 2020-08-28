package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.card.MaterialCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoCardWrapper;
import com.moofficial.moessentials.R;

public class MoAddBar extends MoConstraint {

    private EditText editText;
    private ImageButton leftButton, rightButton;
    private MoCardView cardView;


    public MoAddBar(Context context) {
        super(context);
    }

    public MoAddBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoAddBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // edit text id
    public int ETId(){
        return editText.getId();
    }

    // left button id
    public int LBId(){
        return leftButton.getId();
    }

    // right button id
    public int RBId(){
        return rightButton.getId();
    }

    // card view id
    public int CVId(){
        return cardView.getId();
    }


    public EditText getEditText() {
        return editText;
    }

    public MoAddBar setEditText(EditText editText) {
        this.editText = editText;
        return this;
    }

    public ImageButton getLeftButton() {
        return leftButton;
    }

    public MoAddBar setLeftButton(ImageButton leftButton) {
        this.leftButton = leftButton;
        return this;
    }

    public ImageButton getRightButton() {
        return rightButton;
    }

    public MoAddBar setRightButton(ImageButton rightButton) {
        this.rightButton = rightButton;
        return this;
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public MoAddBar setCardView(MoCardView cardView) {
        this.cardView = cardView;
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_add_bar;
    }

    @Override
    public void initViews() {
        editText = findViewById(R.id.add_bar_edit_text);
        rightButton = findViewById(R.id.add_add_bar);
        leftButton = findViewById(R.id.close_add_bar);
        cardView = findViewById(R.id.add_card_view);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
