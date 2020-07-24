package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder;

import android.content.Context;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.R;

public class MoCardBuilder extends MoViewBuilder {

    float cornerRadius,elevation;

    int backgroundColorId = R.color.transparent;

    public MoCardBuilder(Context c) {
        super(c);
    }

    public float getCornerRadius() {
        return cornerRadius;
    }

    public MoCardBuilder setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    public float getElevation() {
        return elevation;
    }

    public MoCardBuilder setElevation(float elevation) {
        this.elevation = elevation;
        return this;
    }

    public int getBackgroundColorId() {
        return backgroundColorId;
    }

    public MoCardBuilder setBackgroundColorId(int backgroundColorId) {
        this.backgroundColorId = backgroundColorId;
        return this;
    }


    @Override
    public MoCardBuilder setClickListener(View.OnClickListener clickListener) {
        super.setClickListener(clickListener);
        return this;
    }


    @Override
    public MoCardBuilder setLongClickListener(View.OnLongClickListener longClickListener) {
        super.setLongClickListener(longClickListener);
        return this;
    }

    @Override
    public MoCardBuilder setVisibility(int visibility) {
        super.setVisibility(visibility);
        return this;
    }


    @Override
    public MoCardBuilder setContentPadding(MoPaddingBuilder contentPadding) {
        this.contentPadding = contentPadding;
        return this;
    }

    @Override
    protected <T extends View> void buildItem(T v) {
        CardView cardView = (CardView)v;
        cardView.setCardBackgroundColor(cardView.getContext().getColor(backgroundColorId));
        cardView.setElevation(elevation);
        cardView.setRadius(cornerRadius);
        contentPadding.apply(cardView);
    }

}
