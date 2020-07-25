package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoFindBar extends MoConstraint {

    private ImageButton left,middle,right;
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
        return left.getId();
    }

    // right button id
    public int RId(){
        return right.getId();
    }

    // middle button id
    public int MId(){
        return middle.getId();
    }


    @Override
    public int getLayoutId() {
        return R.layout.mo_find_bar;
    }

    @Override
    public void initViews() {
        editText = findViewById(R.id.find_edit_text);
        left = findViewById(R.id.close_find_bar);
        middle = findViewById(R.id.up_find_bar_button);
        right = findViewById(R.id.down_find_bar_button);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }


}
