package com.moofficial.moessentials.MoEssentials.MoLayouts.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.card.MaterialCardView;
import com.moofficial.moessentials.MoEssentials.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoAddBar extends MoConstraint {

    private EditText editText;
    private ImageButton left,right;
    private MaterialCardView materialCardView;


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
    protected int getLayoutId() {
        return R.layout.mo_add_bar;
    }

    @Override
    protected void initViews() {
        editText = findViewById(R.id.add_bar_edit_text);
        right = findViewById(R.id.add_add_bar);
        left = findViewById(R.id.close_add_bar);
        materialCardView = findViewById(R.id.add_card_view);
    }
}
