package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.util.AttributeSet;

import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerView;
import com.moofficial.moessentials.R;

public class MoCardRecyclerView extends MoConstraint {

    private MoRecyclerView recyclerView;
    private MoCardView cardView;

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


    public MoRecyclerView getRecyclerView() {
        return recyclerView;
    }

    public MoCardRecyclerView setRecyclerView(MoRecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        return this;
    }

    public MoCardView getCardView() {
        return cardView;
    }

    public MoCardRecyclerView setCardView(MoCardView cardView) {
        this.cardView = cardView;
        return this;
    }

    public MoCardRecyclerView makeCardRound(){
        cardView.makeCardRound();
        return this;
    }

    public MoCardRecyclerView makeCardRectangular(){
        cardView.makeCardRectangular();
        return this;
    }

    public MoCardRecyclerView setRadius(float r){
        cardView.setRadius(r);
        return this;
    }

    @Override
    public int getLayoutId() {
        return R.layout.mo_card_recyclerview;
    }

    @Override
    public void initViews() {
        recyclerView = findViewById(R.id.mo_card_recyclerview_recycler);
        cardView = findViewById(R.id.mo_card_recyclerview_card);
        makeCardRound();
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }
}
