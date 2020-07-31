package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoSearchBar extends MoConstraint {

    private EditText editText;
    private ImageButton leftButton, rightButton;
    private CardView materialCardView;

    public MoSearchBar(Context context) {super(context);}

    public MoSearchBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoSearchBar(Context context, AttributeSet attrs, int defStyleAttr) {
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
        return materialCardView.getId();
    }

    public EditText getEditText() {
        return editText;
    }

    public MoSearchBar setEditText(EditText editText) {
        this.editText = editText;
        return this;
    }

    public ImageButton getLeftButton() {
        return leftButton;
    }

    public MoSearchBar setLeftButton(ImageButton leftButton) {
        this.leftButton = leftButton;
        return this;
    }

    public ImageButton getRightButton() {
        return rightButton;
    }

    public MoSearchBar setRightButton(ImageButton rightButton) {
        this.rightButton = rightButton;
        return this;
    }

    public CardView getMaterialCardView() {
        return materialCardView;
    }

    public MoSearchBar setMaterialCardView(CardView materialCardView) {
        this.materialCardView = materialCardView;
        return this;
    }



    public MoSearchBar setSearchHint(String s){
        this.editText.setHint(s);
        return this;
    }

    public MoSearchBar setSearchHint(int s){
        this.editText.setHint(s);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_search_bar;
    }

    @Override
    public void initViews() {
        editText = findViewById(R.id.search_edit_text);
        leftButton = findViewById(R.id.close_search_bar);
        rightButton = findViewById(R.id.clear_search_bar);
        materialCardView = findViewById(R.id.search_card_view);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }


}
