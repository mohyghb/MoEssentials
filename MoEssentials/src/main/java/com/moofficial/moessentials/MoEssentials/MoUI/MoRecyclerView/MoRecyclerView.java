package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;


public class MoRecyclerView extends MoContext {


    public static final int VERTICAL = LinearLayoutManager.VERTICAL;
    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

    public static final int SCROLL_UP = -1;
    public static final int SCROLL_DOWN = 1;
    public static final int SCROLL_ANY_DIRECTION = 0;

    public static final int DEFAULT_GRID_COUNT = 2;
    public static final boolean DEFAULT_REVERSE_LAYOUT = false;



    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private int orientation = LinearLayoutManager.VERTICAL;
    private int gridCount = DEFAULT_GRID_COUNT;
    private boolean reverseLayout = DEFAULT_REVERSE_LAYOUT;
    private RecyclerView.LayoutManager layoutManager;
    private View.OnLayoutChangeListener onLayoutChangeListener;
    private boolean built = false;


    @SuppressWarnings("rawtypes")
    public MoRecyclerView(Context c,View view, int recyclerViewResources, RecyclerView.Adapter adapter){
        this(c,view.findViewById(recyclerViewResources),adapter);
    }


    @SuppressWarnings("rawtypes")
    public MoRecyclerView(Context c,RecyclerView r, RecyclerView.Adapter adapter){
        super(c);
        this.recyclerView = r;
        this.mAdapter = adapter;
    }

    @SuppressLint("WrongConstant")
    public MoRecyclerView build(){
        this.layoutManager= new LinearLayoutManager(context,orientation, reverseLayout);
        this.built = true;
        return this;
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

    public MoRecyclerView setReverseLayout(boolean b){
        this.reverseLayout = b;
        if(this.layoutManager!=null){
            ((LinearLayoutManager) this.layoutManager).setReverseLayout(this.reverseLayout);
        }
        return this;
    }


    public MoRecyclerView setOnLayoutChangeListener(View.OnLayoutChangeListener l){
        this.onLayoutChangeListener = l;
        return this;
    }



    /**
     * shows the recycler view by setting the layout manager and
     * adapter and makes sure that this view is visible
     * it also builds the recycler view if it is not built
     */
    public MoRecyclerView show() {
        buildIfNotBuilt();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        if(this.onLayoutChangeListener!=null)
            recyclerView.addOnLayoutChangeListener(this.onLayoutChangeListener);
        applyVisibilityVisible();
        return this;
    }

    /**
     * builds the class if it is not built already
     */
    private void buildIfNotBuilt() {
        if(!built){
            build();
        }
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
            layoutManager = new GridLayoutManager(context, gridCount);
        }else{
            // we want list view
            layoutManager = new LinearLayoutManager(context,orientation, reverseLayout);
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
