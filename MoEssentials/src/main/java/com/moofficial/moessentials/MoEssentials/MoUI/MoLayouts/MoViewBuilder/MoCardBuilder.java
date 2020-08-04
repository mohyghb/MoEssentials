package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.R;

public class MoCardBuilder extends MoViewBuilder {

    Float cornerRadius,elevation;

    Integer backgroundColorId;

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

    public MoCardBuilder makeRound() {
        this.cornerRadius = context.getResources().getDimension(R.dimen.mo_style_card_corner);
        return this;
    }

    public MoCardBuilder makeRectangular() {
        this.cornerRadius = 0f;
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
    public MoCardBuilder setMinHeight(int minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    @Override
    public MoCardBuilder setMinWidth(int minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    @Override
    protected <T extends View> void buildItem(T v) {
        CardView cardView = (CardView)v;
        setIfNotNull(this.backgroundColorId, () -> cardView.setBackgroundTintList(ColorStateList.valueOf(
                ContextCompat.getColor(context, backgroundColorId))));
        setIfNotNull(elevation,()->cardView.setElevation(elevation));
        setIfNotNull(cornerRadius,()->cardView.setRadius(cornerRadius));
    }

}
