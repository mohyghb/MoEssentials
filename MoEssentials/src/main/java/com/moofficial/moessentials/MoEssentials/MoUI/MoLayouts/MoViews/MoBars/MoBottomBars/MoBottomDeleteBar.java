package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoBars.MoBottomBars;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoBottomDeleteBar extends MoConstraint {

    private CardView cardView;
    private LinearLayout linearLayout;
    private Button cancel,delete;

    public MoBottomDeleteBar(Context context) {
        super(context);
    }

    public MoBottomDeleteBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoBottomDeleteBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int CBId(){
        return cancel.getId();
    }

    public int DBId(){
        return delete.getId();
    }

    public int LLId(){
        return linearLayout.getId();
    }

    public int CVId(){
        return cardView.getId();
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_bottom_delete_bar;
    }

    @Override
    public void initViews() {
        cancel = findViewById(R.id.bottom_delete_bar_cancel);
        delete = findViewById(R.id.bottom_delete_bar_delete);
        linearLayout = findViewById(R.id.bottom_delete_bar_linear_layout);
        cardView = findViewById(R.id.bottom_delete_bar_card_view);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
