package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

public class MoImageButtonBuilder extends MoViewBuilder{

    int icon;

    public MoImageButtonBuilder(Context c) {
        super(c);
    }


    public int getIcon() {
        return icon;
    }

    public MoImageButtonBuilder setIcon(int icon) {
        this.icon = icon;
        return this;
    }


    @Override
    public View.OnClickListener getClickListener() {
        return super.getClickListener();
    }

    @Override
    public MoImageButtonBuilder setClickListener(View.OnClickListener clickListener) {
        super.setClickListener(clickListener);
        return this;
    }

    @Override
    public View.OnLongClickListener getLongClickListener() {
        return super.getLongClickListener();
    }

    @Override
    public MoImageButtonBuilder setLongClickListener(View.OnLongClickListener longClickListener) {
        super.setLongClickListener(longClickListener);
        return this;
    }

    @Override
    public MoImageButtonBuilder setContentPadding(MoPaddingBuilder contentPadding) {
        this.contentPadding = contentPadding;
        return this;
    }

    @Override
    public MoImageButtonBuilder setMinHeight(int minHeight) {
        super.setMinHeight(minHeight);
        return this;
    }

    @Override
    public MoImageButtonBuilder setMinWidth(int minWidth) {
        super.setMinWidth(minWidth);
        return this;
    }

    @Override
    public MoImageButtonBuilder setVisibility(int visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    protected <T extends View> void buildItem(T v) {
        ImageButton ib = (ImageButton)v;
        setIfNotNull(ib,()->ib.setImageResource(icon));
    }

}
