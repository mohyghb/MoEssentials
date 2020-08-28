package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

// staggered grid layout manager
public class MoSGLMBuilder extends MoContext {

    private int spanCount;
    @RecyclerView.Orientation private int orientation;
    private int gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS;

    public MoSGLMBuilder(Context c) {
        super(c);
    }

    public MoSGLMBuilder setSpanCount(int spanCount) {
        this.spanCount = spanCount;
        return this;
    }

    public MoSGLMBuilder setOrientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public MoSGLMBuilder setGapStrategy(int gapStrategy) {
        this.gapStrategy = gapStrategy;
        return this;
    }

    public StaggeredGridLayoutManager build(){
        StaggeredGridLayoutManager s = new StaggeredGridLayoutManager(spanCount,orientation);
        s.setGapStrategy(gapStrategy);
        return s;
    }

}
