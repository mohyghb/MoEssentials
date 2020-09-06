package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders.MoGLMBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders.MoLLMBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoBuilders.MoSGLMBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewInterfaces.MoOnConfigurationChanged;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewInterfaces.MoOnSizeChanged;

import java.util.Objects;

// expands the abilities of the original recycler view
// to unlock new experiences
public class MoRecyclerView extends RecyclerView {



    public static final int NO_MAX_VALUE = -3;
    private static final int SWIPE_MIN_DISTANCE = 5;
    private static final int SWIPE_THRESHOLD_VELOCITY = 300;

    /**
     * showing different layout managers
     * based on the type that the developer
     * chooses
     * LinearLayoutManager,GridLayoutManager,StaggeredLayoutManager
     */
    @IntDef({LINEAR_LAYOUT_MANAGER,GRID_LAYOUT_MANAGER,STAGGERED_GRID_LAYOUT_MANAGER})
    public @interface LayoutManagerType {}

    public static final int LINEAR_LAYOUT_MANAGER = 0;
    public static final int GRID_LAYOUT_MANAGER = 1;
    public static final int STAGGERED_GRID_LAYOUT_MANAGER = 2;

    public static final int VERTICAL = LinearLayoutManager.VERTICAL;
    public static final int HORIZONTAL = LinearLayoutManager.HORIZONTAL;

    public static final int SCROLL_UP = -1;
    public static final int SCROLL_DOWN = 1;
    public static final int SCROLL_ANY_DIRECTION = 0;

    public static final int DEFAULT_GRID_COUNT = 2;
    public static final boolean DEFAULT_REVERSE_LAYOUT = false;
    public static final boolean DEFAULT_HAS_FIXED_SIZE = false;
    public static final boolean DEFAULT_STACK_FROM_END = false;





    private int maxHeight = NO_MAX_VALUE;
    private int maxWidth = NO_MAX_VALUE;
    @Orientation private int orientation = RecyclerView.VERTICAL;
    private int spanCount = DEFAULT_GRID_COUNT;
    private boolean reverseLayout = DEFAULT_REVERSE_LAYOUT;
    private boolean stackFromEnd = DEFAULT_STACK_FROM_END;
    @LayoutManagerType private int layoutManagerType = LINEAR_LAYOUT_MANAGER;
    @NonNull private MoOnConfigurationChanged onConfigurationChanged = newConfig -> {};
    @NonNull private MoOnSizeChanged onSizeChanged = (w, h, oldw, oldh) -> {};
    private GestureDetector gestureDetector;
    private int activeFeature = 0;

    public MoRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MoRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public MoRecyclerView setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public MoRecyclerView setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public int getOrientation() {
        return orientation;
    }

    public MoRecyclerView setOrientation(int orientation) {
        this.orientation = orientation;
        return this;
    }

    public int getSpanCount() {
        return spanCount;
    }

    public MoRecyclerView setSpanCount(int spanCount) {
        this.spanCount = spanCount;
        return this;
    }

    public boolean isReverseLayout() {
        return reverseLayout;
    }

    public MoRecyclerView setReverseLayout(boolean reverseLayout) {
        this.reverseLayout = reverseLayout;
        return this;
    }


    public int getLayoutManagerType() {
        return layoutManagerType;
    }

    public MoRecyclerView setLayoutManagerType(int layoutManagerType) {
        this.layoutManagerType = layoutManagerType;
        return this;
    }

    public boolean isStackFromEnd() {
        return stackFromEnd;
    }

    public MoRecyclerView setStackFromEnd(boolean stackFromEnd) {
        this.stackFromEnd = stackFromEnd;
        return this;
    }

    public MoRecyclerView setOnConfigurationChanged(@NonNull MoOnConfigurationChanged onConfigurationChanged) {
        this.onConfigurationChanged = onConfigurationChanged;
        return this;
    }

    public MoRecyclerView setOnSizeChanged(@NonNull MoOnSizeChanged onSizeChanged) {
        this.onSizeChanged = onSizeChanged;
        return this;
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        if(hasMax(maxHeight)){
            heightSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);
        }
        if(hasMax(maxWidth)){
            widthSpec = MeasureSpec.makeMeasureSpec(maxWidth, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthSpec, heightSpec);
    }

    /**
     * returns true if the value passed
     * has a maximum inside our class
     * @param val dimension to be considered to have max value
     * @return true if there is a max value for that respective dimension
     */
    private boolean hasMax(int val) {
        return val != NO_MAX_VALUE;
    }


    /**
     * init the layout manager based
     * on the specifications that were
     * either provided or set by default
     * @return this
     */
    public MoRecyclerView show() {
        initLayoutManager();
        return this;
    }

    /**
     * sets the layout manager
     * based on the specifications that are provided
     * and the type of layout manager
     */
    @SuppressLint("SwitchIntDef")
    private void initLayoutManager() {
        LayoutManager layoutManager;
        switch (this.layoutManagerType) {
            case STAGGERED_GRID_LAYOUT_MANAGER:
                layoutManager = new MoSGLMBuilder(getContext())
                        .setOrientation(orientation)
                        .setSpanCount(spanCount)
                        .build();
                break;
            case GRID_LAYOUT_MANAGER:
                layoutManager = new MoGLMBuilder(getContext())
                        .setSpanCount(spanCount)
                        .build();
                break;
            default:
                layoutManager = new MoLLMBuilder(getContext())
                        .setOrientation(orientation)
                        .setReverseLayout(reverseLayout)
                        .setStackFromEnd(stackFromEnd)
                        .build();
                break;
        }
        setLayoutManager(layoutManager);
    }

    /**
     * changes the type of layout manager
     * and init the layout manager
     * and sets it to the parent recycler view
     * @param type type of layout manager
     */
    public void switchLayoutManager(@LayoutManagerType int type){
        setLayoutManagerType(type);
        initLayoutManager();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onSizeChanged.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        onConfigurationChanged.onConfigurationChanged(newConfig);
    }

    //    public Bundle saveState(String key,Bundle inState){
//        Parcelable p = getLayoutManager().onSaveInstanceState();
//        inState.putParcelable(key,p);
//        return inState;
//    }
//
//    public void loadState(String key,Bundle inState){
//        if(getLayoutManager()==null){
//            initLayoutManager();
//        }
//        getLayoutManager().onRestoreInstanceState(inState.getParcelable(key));
//
//    }


    /**
     * makes the recycler view so that
     * it snaps to the nearest item linearly when possible
     * @return this
     */
    public MoRecyclerView enableLinearSnap() {
        new LinearSnapHelper().attachToRecyclerView(this);
        return this;
    }

    /**
     * makes the recycler view so that
     * it snaps to the nearest item like a pager
     * when possible
     * @return this
     */
    public MoRecyclerView enablePagerSnap() {
        new PagerSnapHelper().attachToRecyclerView(this);
        return this;
    }

    /**
     * casts linear layout manager
     * to the layout manager and returns it
     * @return linear layout manager if exist or throw
     * runtime exception
     */
    public LinearLayoutManager getLinearLayoutManager() {
        return (LinearLayoutManager)getLayoutManager();
    }

    /**
     * this only works with all the
     * layout managers that are a subclass of
     * LinearLayoutManager
     * @return position of the first completely visible item
     */
    public int findFirstCompletelyVisibleItemPosition() {
        return getLinearLayoutManager().findFirstCompletelyVisibleItemPosition();
    }

    /**
     * this only works with all the
     * layout managers that are a subclass of
     * LinearLayoutManager
     * @return position of the first visible item
     */
    public int findFirstVisibleItemPosition() {
        return getLinearLayoutManager().findFirstVisibleItemPosition();
    }

    /**
     * this only works with all the
     * layout managers that are a subclass of
     * LinearLayoutManager
     * @return findLastCompletelyVisibleItemPosition
     */
    public int findLastCompletelyVisibleItemPosition() {
        return getLinearLayoutManager().findLastCompletelyVisibleItemPosition();
    }

    /**
     * this only works with all the
     * layout managers that are a subclass of
     * LinearLayoutManager
     * @return findLastVisibleItemPosition
     */
    public int findLastVisibleItemPosition() {
        return getLinearLayoutManager().findLastVisibleItemPosition();
    }

    /**
     *
     * @return true if the recycler view is
     * on the last completely visible item
     */
    public boolean isOnLastCompletelyVisibleItem() {
        return findLastCompletelyVisibleItemPosition() == Objects.requireNonNull(getAdapter()).getItemCount() - 1;
    }

    /**
     *
     * @return true if the recycler view is
     * on the last visible item (notice that
     * the last item does not have to be completely visible)
     */
    public boolean isOnLastVisibleItem() {
        return findLastVisibleItemPosition() == Objects.requireNonNull(getAdapter()).getItemCount() - 1;
    }


    /**
     *
     * @return true if the recycler view is
     * on the first completely visible item
     */
    public boolean isOnFirstCompletelyVisibleItem() {
        return findFirstCompletelyVisibleItemPosition() == Objects.requireNonNull(getAdapter()).getItemCount() - 1;
    }


    /**
     *
     * @return true if the recycler view is
     * on the first visible item (notice that
     * the first item does not have to be completely visible)
     */
    public boolean isOnFirstVisibleItem() {
        return findLastVisibleItemPosition() == Objects.requireNonNull(getAdapter()).getItemCount() - 1;
    }



    @SuppressWarnings("rawtypes")
    public static class Builder extends MoContext {

        private RecyclerView.Adapter adapter;
        @Orientation
        private int orientation = RecyclerView.VERTICAL;
        private int gridCount = DEFAULT_GRID_COUNT;
        private boolean reverseLayout = DEFAULT_REVERSE_LAYOUT;
        private boolean hasFixedSize = DEFAULT_HAS_FIXED_SIZE;
        private RecyclerView.LayoutManager layoutManager;
        private View.OnLayoutChangeListener onLayoutChangeListener;
        private int maxHeight = NO_MAX_VALUE,maxWidth = NO_MAX_VALUE;
        private int layoutManagerType = LINEAR_LAYOUT_MANAGER;

        public Builder(Context c){
            super(c);
        }

        public Builder setAdapter(Adapter mAdapter) {
            this.adapter = mAdapter;
            return this;
        }

        public Builder setOrientation(@Orientation int orientation) {
            this.orientation = orientation;
            return this;
        }

        public Builder setGridCount(int gridCount) {
            this.gridCount = gridCount;
            return this;
        }

        public Builder setReverseLayout(boolean reverseLayout) {
            this.reverseLayout = reverseLayout;
            return this;
        }

        public Builder setHasFixedSize(boolean hasFixedSize) {
            this.hasFixedSize = hasFixedSize;
            return this;
        }

        public Builder setLayoutManager(LayoutManager layoutManager) {
            this.layoutManager = layoutManager;
            return this;
        }

        public Builder setOnLayoutChangeListener(OnLayoutChangeListener onLayoutChangeListener) {
            this.onLayoutChangeListener = onLayoutChangeListener;
            return this;
        }

        public Builder setMaxHeight(int maxHeight) {
            this.maxHeight = maxHeight;
            return this;
        }

        public Builder setMaxWidth(int maxWidth) {
            this.maxWidth = maxWidth;
            return this;
        }

        public MoRecyclerView build(){
            MoRecyclerView r = new MoRecyclerView(this.context);
            r.setAdapter(adapter);
           // r.setLayoutManager();
            return r;
        }

        /**
         * applies all the fields inside here to
         * the mo recycler view that is passed to us
         * @param r recycler view to apply the fields to
         * @return mo recycler view with the changes applied
         */
        public MoRecyclerView apply(MoRecyclerView r){
            r.setAdapter(this.adapter);
            return r;
        }

    }

}
