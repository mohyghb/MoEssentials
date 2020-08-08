package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoButton;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoCardRecyclerView;
import com.moofficial.moessentials.R;

public class MoCardWrapper extends MoWrapper{

    private CardView cardView;

    public MoCardWrapper(CardView c) {
        super(c.getContext());
        cardView = c;
    }

    public CardView getCardView() {
        return cardView;
    }

    public MoCardWrapper setCardView(CardView cardView) {
        this.cardView = cardView;
        return this;
    }

    public MoCardWrapper setBackground(int res){
        cardView.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(context, res)));
        return this;
    }

    public MoCardWrapper makeTransparent(){
        return setBackground(R.color.transparent);
    }

    public MoCardWrapper makeCardRound(){
        cardView.setRadius(getDimension(R.dimen.mo_style_card_corner));
        return this;
    }

    public MoCardWrapper makeCardRecRound(){
        cardView.setRadius(getDimension(R.dimen.mo_style_card_corner_small));
        return this;
    }

    public MoCardWrapper makeCardRectangular(){
        cardView.setRadius(0f);
        return this;
    }

    public MoCardWrapper setRadius(float r){
        cardView.setRadius(r);
        return this;
    }

    public MoCardWrapper show(){
        cardView.setVisibility(View.VISIBLE);
        return this;
    }

    public MoCardWrapper hide(){
        cardView.setVisibility(View.GONE);
        return this;
    }

    public MoCardWrapper setOnCardClickListener(View.OnClickListener l){
        cardView.setOnClickListener(l);
        return this;
    }

    public MoCardWrapper setOnCardLongClickListener(View.OnLongClickListener l){
        cardView.setOnLongClickListener(l);
        return this;
    }

    public MoCardWrapper setElevation(float e){
        this.cardView.setCardElevation(e);
        return this;
    }




    @Override
    public View getView() {
        return cardView;
    }






}
