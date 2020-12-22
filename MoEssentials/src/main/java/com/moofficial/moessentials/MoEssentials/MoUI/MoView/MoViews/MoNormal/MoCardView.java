package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;
import com.moofficial.moessentials.R;

// a material card view class with more methods to make
// everything more easy and seamless
public class MoCardView extends MaterialCardView {



    public MoCardView(Context context) {
        super(context);

    }

    public MoCardView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MoCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }


    /**
     * sets p for padding in all
     * directions
     * @param p padding in pixels
     * @return this for nested calling
     */
    public MoCardView setContentPadding(int p) {
        setContentPadding(p,p,p,p);
        return this;
    }


    /**
     * sets p for padding in all
     * directions
     * @param dp padding in dp
     * @return this for nested calling
     */
    public MoCardView setContentPadding(float dp) {
        return this.setContentPadding(MoDynamicUnit.convertDpToPixels(dp));
    }

    /**
     * makes the background color of the card
     * view to be transparent
     * @return this for nested calling
     */
    public MoCardView makeTransparent() {
        setCardBackgroundColor(ContextCompat.getColor(getContext(),R.color.transparent));
        return this;
    }

    public MoCardView setColor(@ColorRes int color) {
        this.setCardBackgroundColor(ContextCompat.getColor(getContext(), color));
        return this;
    }

    public MoCardView makeCardRound(){
        setRadius(getContext().getResources().getDimension(R.dimen.mo_style_card_corner));
        return this;
    }

    public MoCardView makeCardRecRound(){
        setRadius(getContext().getResources().getDimension(R.dimen.mo_style_card_corner_small));
        return this;
    }

    public MoCardView makeCardRectangular(){
        setRadius(0f);
        return this;
    }


    public MoCardView show(){
        setVisibility(View.VISIBLE);
        return this;
    }

    public MoCardView hide(){
        setVisibility(View.GONE);
        return this;
    }

    public MoCardView removeElevation() {
        setCardElevation(0f);
        return this;
    }


}
