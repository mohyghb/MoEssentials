package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerAdapters.MoRecyclerAdapter;

public class MoEmptyRecyclerView {

    private RecyclerView recyclerView;
    private View emptyView;

    public MoEmptyRecyclerView setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        return this;
    }

    public MoEmptyRecyclerView setEmptyView(View emptyView) {
        this.emptyView = emptyView;
        return this;
    }

    /**
     * size of the adapter given and the respective view is displayed
     * @param size
     */
    public void notify(int size) {
        if (this.emptyView != null && this.recyclerView != null) {
            boolean showEmpty = size == 0;
            this.emptyView.setVisibility(showEmpty ? View.VISIBLE : View.GONE);
            this.recyclerView.setVisibility(showEmpty ? View.GONE : View.VISIBLE);
        }
    }
}
