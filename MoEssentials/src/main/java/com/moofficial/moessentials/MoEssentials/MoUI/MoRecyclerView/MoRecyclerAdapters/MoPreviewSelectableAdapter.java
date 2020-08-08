package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerAdapters;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// an adapter that has both selected items
// and it is preview-able
public abstract class MoPreviewSelectableAdapter<T extends RecyclerView.ViewHolder,I> extends MoPreviewAdapter<T,I> {

    protected List<I> selectedItems = new ArrayList<>();

    public MoPreviewSelectableAdapter(List<I> dataSet) {
        super(dataSet);
    }

    public List<I> getSelectedItems() {
        return selectedItems;
    }

    public MoPreviewSelectableAdapter<T, I> setSelectedItems(List<I> selectedItems) {
        this.selectedItems = selectedItems;
        return this;
    }
}
