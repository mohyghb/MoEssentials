package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.card.MaterialCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoSearchBar extends MoConstraint {

    private EditText editText;
    private ImageButton left,right;
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
        return left.getId();
    }

    // right button id
    public int RBId(){
        return right.getId();
    }

    // card view id
    public int CVId(){
        return materialCardView.getId();
    }


    @Override
    public int getLayoutId() {
        return R.layout.mo_search_bar;
    }

    @Override
    public void initViews() {
        editText = findViewById(R.id.search_edit_text);
        left = findViewById(R.id.close_search_bar);
        right = findViewById(R.id.clear_search_bar);
        materialCardView = findViewById(R.id.search_card_view);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }


}
