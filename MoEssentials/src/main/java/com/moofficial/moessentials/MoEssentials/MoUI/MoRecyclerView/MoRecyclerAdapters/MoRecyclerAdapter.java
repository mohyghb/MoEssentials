package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerAdapters;

import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class MoRecyclerAdapter<T extends RecyclerView.ViewHolder,I> extends RecyclerView.Adapter<T> {

    protected List<I> dataSet;

    public MoRecyclerAdapter(List<I> dataSet){
        this.dataSet = dataSet;
    }

    public List<I> getDataSet() {
        return dataSet;
    }

    public MoRecyclerAdapter<T, I> setDataSet(List<I> dataSet) {
        this.dataSet = dataSet;
        return this;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public RecyclerView.LayoutParams getMatchWrapParams(){
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

}
