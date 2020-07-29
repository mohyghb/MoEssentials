package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoFindBar extends MoConstraint {

    private ImageButton leftButton, middleButton, rightButton;
    private EditText editText;


    public MoFindBar(Context context) {
        super(context);
    }

    public MoFindBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoFindBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // edit text id
    public int EDId(){
        return editText.getId();
    }

    // left button id
    public int LId(){
        return leftButton.getId();
    }

    // right button id
    public int RId(){
        return rightButton.getId();
    }

    // middle button id
    public int MId(){
        return middleButton.getId();
    }


    public ImageButton getLeftButton() {
        return leftButton;
    }

    public MoFindBar setLeftButton(ImageButton leftButton) {
        this.leftButton = leftButton;
        return this;
    }

    public ImageButton getMiddleButton() {
        return middleButton;
    }

    public MoFindBar setMiddleButton(ImageButton middleButton) {
        this.middleButton = middleButton;
        return this;
    }

    public ImageButton getRightButton() {
        return rightButton;
    }

    public MoFindBar setRightButton(ImageButton rightButton) {
        this.rightButton = rightButton;
        return this;
    }

    public EditText getEditText() {
        return editText;
    }

    public MoFindBar setEditText(EditText editText) {
        this.editText = editText;
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_find_bar;
    }

    @Override
    public void initViews() {
        editText = findViewById(R.id.find_edit_text);
        leftButton = findViewById(R.id.close_find_bar);
        middleButton = findViewById(R.id.up_find_bar_button);
        rightButton = findViewById(R.id.down_find_bar_button);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }


}
