package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoButton;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoNormal.MoCardRecyclerView;
import com.moofficial.moessentials.R;

@Deprecated
// should use MoCardView from now on
public class MoCardWrapper extends MoWrapper<CardView>{



    public MoCardWrapper(CardView c) {
        super(c.getContext(),c);
    }

    public CardView getCardView() {
        return wrappedElement;
    }

    public MoCardWrapper setCardView(CardView cardView) {
        this.wrappedElement = cardView;
        return this;
    }

    public MoCardWrapper setBackground(int res){
        wrappedElement.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(context, res)));
        return this;
    }

    public MoCardWrapper makeTransparent(){
        return setBackground(R.color.transparent);
    }

    public MoCardWrapper makeCardRound(){
        wrappedElement.setRadius(getDimension(R.dimen.mo_style_card_corner));
        return this;
    }

    public MoCardWrapper makeCardRecRound(){
        wrappedElement.setRadius(getDimension(R.dimen.mo_style_card_corner_small));
        return this;
    }

    public MoCardWrapper makeCardRectangular(){
        wrappedElement.setRadius(0f);
        return this;
    }

    public MoCardWrapper setRadius(float r){
        wrappedElement.setRadius(r);
        return this;
    }

    public MoCardWrapper show(){
        wrappedElement.setVisibility(View.VISIBLE);
        return this;
    }

    public MoCardWrapper hide(){
        wrappedElement.setVisibility(View.GONE);
        return this;
    }

    public MoCardWrapper setOnCardClickListener(View.OnClickListener l){
        wrappedElement.setOnClickListener(l);
        return this;
    }

    public MoCardWrapper setOnCardLongClickListener(View.OnLongClickListener l){
        wrappedElement.setOnLongClickListener(l);
        return this;
    }

    public MoCardWrapper setElevation(float e){
        this.wrappedElement.setCardElevation(e);
        return this;
    }




    @Override
    public CardView getView() {
        return wrappedElement;
    }






}
