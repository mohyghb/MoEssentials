package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MoRecyclerView {


    public static final int VERTICAL = LinearLayoutManager.VERTICAL;
    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

    public static final int SCROLL_UP = -1;
    public static final int SCROLL_DOWN = 1;
    public static final int SCROLL_ANY_DIRECTION = 0;

    public static final int DEFAULT_GRID_COUNT = 2;
    public static final boolean DEFAULT_REVERSE_LAYOUT = false;



    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private Activity activity;
    private int recyclerViewResources;
    private int orientation = LinearLayoutManager.VERTICAL;
    private int gridCount = DEFAULT_GRID_COUNT;
    private boolean reverseLayout = DEFAULT_REVERSE_LAYOUT;
    private RecyclerView.LayoutManager layoutManager;
    private View.OnLayoutChangeListener onLayoutChangeListener;


    @SuppressWarnings("rawtypes")
    @SuppressLint("WrongConstant")
    public MoRecyclerView(Activity a, int recyclerViewResources, RecyclerView.Adapter adapter){
        this.activity = a;
        this.recyclerViewResources = recyclerViewResources;
        this.mAdapter = adapter;
        this.recyclerView = activity.findViewById(recyclerViewResources);
        layoutManager= new LinearLayoutManager(activity,orientation, false);
    }

    @SuppressWarnings("rawtypes")
    public MoRecyclerView(RecyclerView r, RecyclerView.Adapter adapter){
        this.recyclerView = r;
        this.mAdapter = adapter;
    }

    @SuppressWarnings("rawtypes")
    public MoRecyclerView(Activity a, RecyclerView rv, RecyclerView.Adapter adapter){
        this.activity = a;
        this.mAdapter = adapter;
        this.recyclerView = rv;
    }


    public MoRecyclerView setOrientation(int or){
        this.orientation = or;
        return this;
    }

    public MoRecyclerView setLayoutManager(RecyclerView.LayoutManager layoutManager){
        this.layoutManager = layoutManager;
        return this;
    }

    public MoRecyclerView setGridCount(int gc){
        this.gridCount = gc;
        return this;
    }

    public void setReverseLayout(boolean b){
        this.reverseLayout = b;
        ((LinearLayoutManager) this.layoutManager).setReverseLayout(this.reverseLayout);
    }


    public MoRecyclerView setOnLayoutChangeListener(View.OnLayoutChangeListener l){
        this.onLayoutChangeListener = l;
        return this;
    }


    /**
     * shows the recycler view by setting the layout manager and
     * adapter and makes sure that this view is visible
     */
    public void show() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        if(this.onLayoutChangeListener!=null)
            recyclerView.addOnLayoutChangeListener(this.onLayoutChangeListener);
        applyVisibilityVisible();
    }

    /**
     * scroll to the position if position is less than
     * the size of the array adapter data set
     * @param position
     */
    public void scrollTo(int position){
        if(position < mAdapter.getItemCount()) {
            recyclerView.scrollToPosition(position);
        }
    }


    // we only smooth scroll if the position is less than the size of
    // the array adapter
    public void smoothScrollTo(int position){
        if(position < mAdapter.getItemCount()){
            Handler handler = new Handler();
            handler.postDelayed(() -> recyclerView.smoothScrollToPosition(position),100);
        }
    }

    /**
     *
     */
    public void scrollToLastItem(){
        recyclerView.scrollToPosition(mAdapter.getItemCount() - 1);
    }

    /**
     * only notifies item added at last
     * position if the length is higher than 0
     */
    public void notifyItemAddedLastPosition(){
        if(mAdapter.getItemCount()>0){
            mAdapter.notifyItemInserted(bottomPosition());
        }
    }


    public RecyclerView getRecyclerView(){
        return this.recyclerView;
    }

    public int bottomPosition(){
        return mAdapter.getItemCount()-1;
    }




    public void notifyDataSetChanged() {
        mAdapter.notifyDataSetChanged();
    }

    public void notifyLastItemChanged(){
        if(mAdapter.getItemCount()>0)
            mAdapter.notifyItemChanged(bottomPosition());
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        this.mAdapter = adapter;
    }



    @SuppressLint("WrongConstant")
    public void switchViewMode(boolean showInGrid, RecyclerView.Adapter adapter){
        if(showInGrid){
            // we want grid view
            layoutManager = new GridLayoutManager(activity, gridCount);
        }else{
            // we want list view
            layoutManager = new LinearLayoutManager(activity,orientation, reverseLayout);
        }
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = adapter;
        recyclerView.setAdapter(mAdapter);
    }



    /**
     * notifies that an item was added
     */
    public void notifyLastItemInserted(){
        if(mAdapter.getItemCount()>0){
            mAdapter.notifyItemInserted(bottomPosition());
        }
    }


    /**
     * makes the recycler view gone
     */
    public void applyVisibilityGone(){
        changeVisibility(View.GONE);
    }

    /**
     * makes the recycler view visible
     */
    public void applyVisibilityVisible(){
        changeVisibility(View.VISIBLE);
    }

    /**
     * applies visibility v to the recycler view
     * @param v
     */
    private void changeVisibility(int v){
        this.recyclerView.setVisibility(v);
    }


    /**
     *
     * @param direction * -1 = up
     *                     0 = up or down
     *                     1 = down
     * @return true if the recycler view can scroll in [direction]
     */
    public boolean canScrollVertically(int direction){
        return this.recyclerView.canScrollVertically(direction);
    }



}
