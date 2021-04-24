package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerAdapters;

import android.app.Activity;
import android.content.Context;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;

import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoEmptyRecyclerView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoMarginBuilder;

import java.util.List;

public abstract class MoRecyclerAdapter<T extends RecyclerView.ViewHolder,I> extends RecyclerView.Adapter<T> {

    protected List<I> dataSet;
    protected Context context;
    private MoEmptyRecyclerView emptyViewListener = new MoEmptyRecyclerView();

    public MoRecyclerAdapter(Context c,List<I> dataSet) {
        this.context = c;
        this.dataSet = dataSet;
    }

    // this is to know which recycler view this adapter belongs to
    public MoRecyclerAdapter<T, I> setRecyclerView(RecyclerView recyclerView) {
        this.emptyViewListener.setRecyclerView(recyclerView);
        return this;
    }

    // this is the view that is shown when the adapter is empty
    public MoRecyclerAdapter<T, I> setEmptyView(View emptyView) {
        this.emptyViewListener.setEmptyView(emptyView);
        return this;
    }

    /**
     * this callback is called when you call notify empty view
     * @param callback what to do and the state of empty view when calling notifyEmptyView
     * @return this for nested calling
     */
    public MoRecyclerAdapter<T, I> setEmptyViewCallback(ValueCallback<Boolean> callback) {
        this.emptyViewListener.setShowEmptyCallback(callback);
        return this;
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
        return position;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * match parent width with
     * wrap content height
     */
    public RecyclerView.LayoutParams getMatchWrapParams() {
        return getMatchWrapParams(new MoMarginBuilder(context));
    }

    /**
     * match parent width with
     * wrap content height
     */
    public RecyclerView.LayoutParams getMatchWrapParams(MoMarginBuilder marginBuilder) {
        return getRecyclerParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, marginBuilder);
    }

    public  RecyclerView.LayoutParams getWrapWrapParam() {
        return getRecyclerParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT, new MoMarginBuilder(context));
    }

    /**
     * @param height of the recycler view item
     * @param width of the recycler view item
     * @return the layout params for the recycler view item
     */
    public RecyclerView.LayoutParams getRecyclerParams(int width, int height, MoMarginBuilder mb) {
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(width,height);
        lp.setMargins(mb.getLeft(),mb.getTop(), mb.getRight(),mb.getBottom());
        return lp;
    }

    /**
     * match parent width
     * with the specified height
     * @param height of the recycler view item
     * @return the layout params for the recycler view item
     */
    public RecyclerView.LayoutParams getRecyclerParams(int height){
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,height);
    }

    /**
     * notifies the recycler adapter that an
     * item has been added to the last position
     * of the recycler adapter
     */
    public void notifyItemInsertedAtEnd() {
        notifyItemInserted(getItemCount()-1);
    }




    /**
     * updates the adapter to the new data that
     * is passed in
     * @param a activity to update the ui for
     * @param newData for the adapter
     * @param viewGroup if it's passed, we animate the update,
     *                  if null, we don't animate
     */
    public void update(Activity a, List<I> newData, ViewGroup viewGroup) {
        setDataSet(newData);
        a.runOnUiThread(()-> {
            if (viewGroup != null) {
                TransitionManager.beginDelayedTransition(viewGroup);
            }
            notifyDataSetChanged();
            this.emptyViewListener.notify(newData.size());
        });
    }

    /**
     * updates the adapter to the new data that
     * is passed in
     * @param a activity to update the ui for
     * @param newData for the adapter
     */
    public void update(Activity a, List<I> newData) {
        update(a,newData,null);
    }

    /**
     * this should be called whenever you change something in the data set, so we know whether
     * we need to show empty state or not, this is not required with the update methods above
     * @return this for nested calling
     */
    public MoRecyclerAdapter<T,I> notifyEmptyState() {
        this.emptyViewListener.notify(this.dataSet.size());
        return this;
    }

}
