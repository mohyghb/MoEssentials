package com.moofficial.moessentials.MoEssentials.MoLayouts.MoBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoInputBar extends MoConstraint {


    private EditText editText;
    private CardView cardView;


    public MoInputBar(Context context) {
        super(context);
    }

    public MoInputBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoInputBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int EDId(){
        return editText.getId();
    }

    public int CVId(){
        return cardView.getId();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.mo_input_bar;
    }

    @Override
    protected void initViews() {
        editText = findViewById(R.id.input_bar_edit_text);
        cardView = findViewById(R.id.input_bar_card_view);
    }
}
