package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders;

import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public class MoGLMBuilder extends MoContext {


    private int spanCount;

    public MoGLMBuilder(Context c) {
        super(c);
    }


    public MoGLMBuilder setSpanCount(int spanCount) {
        this.spanCount = spanCount;
        return this;
    }

    public GridLayoutManager build() {
        GridLayoutManager g = new GridLayoutManager(context,spanCount);
        return g;
    }


}
