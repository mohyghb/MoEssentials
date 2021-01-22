package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerAdapters;

import android.app.Activity;
import android.content.Context;
import android.transition.TransitionManager;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class MoRecyclerAdapter<T extends RecyclerView.ViewHolder,I> extends RecyclerView.Adapter<T> {

    protected List<I> dataSet;
    protected Context context;

    public MoRecyclerAdapter(Context c,List<I> dataSet) {
        this.context = c;
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
    public RecyclerView.LayoutParams getMatchWrapParams(){
        return getRecyclerParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public  RecyclerView.LayoutParams getWrapWrapParam() {
        return getRecyclerParams(RecyclerView.LayoutParams.WRAP_CONTENT,RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    /**
     * @param height of the recycler view item
     * @param width of the recycler view item
     * @return the layout params for the recycler view item
     */
    public RecyclerView.LayoutParams getRecyclerParams(int width,int height){
        return new RecyclerView.LayoutParams(width,height);
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


}
