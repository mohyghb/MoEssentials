package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.R;

public class MoCardRecyclerView extends MoConstraint {

    private RecyclerView recyclerView;
    private MaterialCardView cardView;

    public MoCardRecyclerView(Context context) {
        super(context);
    }

    public MoCardRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoCardRecyclerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int RVId(){
        return recyclerView.getId();
    }

    public int CId(){
        return cardView.getId();
    }


    @Override
    public int getLayoutId() {
        return R.layout.mo_card_recyclerview;
    }

    @Override
    public void initViews() {
        recyclerView = findViewById(R.id.mo_card_recyclerview_recycler);
        cardView = findViewById(R.id.mo_card_recyclerview_card);
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
