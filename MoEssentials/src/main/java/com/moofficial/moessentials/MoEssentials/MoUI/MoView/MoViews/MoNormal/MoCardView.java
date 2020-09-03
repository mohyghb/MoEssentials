package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.card.MaterialCardView;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.R;

// a material card view class with more methods to make
// everything more easy and seamless
public class MoCardView extends MaterialCardView {

    private MoContext context;

    public MoCardView(Context context) {
        super(context);
        this.context =  new MoContext(context);
    }

    public MoCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context =  new MoContext(context);
    }

    public MoCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context =  new MoContext(context);
    }


    public MoCardView setBackground(int res){
        setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(context.getContext(), res)));
        return this;
    }

    public MoCardView makeTransparent(){
        return setBackground(R.color.transparent);
    }

    public MoCardView makeCardRound(){
        setRadius(context.getDimension(R.dimen.mo_style_card_corner));
        return this;
    }

    public MoCardView makeCardRecRound(){
        setRadius(context.getDimension(R.dimen.mo_style_card_corner_small));
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


}
