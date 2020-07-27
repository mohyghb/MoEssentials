package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.view.View;

import androidx.cardview.widget.CardView;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public class MoCardView extends MoWrapper {

    private CardView cardView;

    public MoCardView(Context c) {
        super(c);
    }



    @Override
    public View getView() {
        return cardView;
    }
}
