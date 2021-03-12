package com.moofficial.moessentials.MoEssentials.MoUI.MoBottomSheet;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

// a builder class for bottom sheet dialog
public class MoBottomSheet extends MoContext {

    private BottomSheetDialog bottomSheet;
    private MoBottomSheetLayout layout;
    private View contentView;
    // duration that the bottom sheet should be shown
    // before dismissing on its own
    private long duration = 0;
    private boolean cancelable = true;
    private boolean canceledOnTouchOutside = true;
    private boolean dismissWithAnimation = true;
    private boolean draggable = true;
    private boolean fitToContents = true;
    private boolean skipCollapsed;
    private boolean animatePeekHeight = true;
    private boolean gestureInsetBottomIgnored;
    private boolean hideable = true;
    private boolean dimBehind = true;
    private boolean round = true;
    private int peekHeight;
    @BottomSheetBehavior.State private int state = BottomSheetBehavior.STATE_COLLAPSED;
    private List<BottomSheetBehavior.BottomSheetCallback> callbacks = new ArrayList<>();
    private Runnable onDismissedListener = () -> {};

    public MoBottomSheet(Context c) {
        super(c);
        layout = new MoBottomSheetLayout(c);
    }

    /**
     * adds the view to the linear
     * layout inside the nested scroll view
     * @param v view to be added
     * @return this for nested calling
     */
    public MoBottomSheet add(View v) {
        layout.wrapperLinear.addView(v);
        return this;
    }

    /**
     * adds the view to the linear
     * layout inside the nested scroll view
     * @param v view to be added
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet add(View v, LinearLayout.LayoutParams p) {
        layout.wrapperLinear.addView(v,p);
        return this;
    }

    /**
     * adds the view to the linear
     * layout inside the nested scroll view
     * @param v views to be added with the param
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet add(LinearLayout.LayoutParams p,View ... v) {
        return this.add(p, Arrays.asList(v));
    }

    /**
     * adds the view to the linear
     * layout inside the nested scroll view
     * @param v views to be added with the param
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet add(LinearLayout.LayoutParams p,List<View> v) {
        layout.wrapperLinear.addViews(p,v);
        return this;
    }


    /**
     * adds the view to the linear
     * title layout at top of the
     * bottom sheet (non scrollable)
     * @param v view to be added
     * @return this for nested calling
     */
    public MoBottomSheet addTitle(View v) {
        layout.wrapperTitle.addView(v);
        return this;
    }

    /**
     * adds the view to the linear
     * title layout at top of the
     * bottom sheet (non scrollable)
     * @param v view to be added
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet addTitle(View v, LinearLayout.LayoutParams p) {
        layout.wrapperTitle.addView(v,p);
        return this;
    }

    /**
     * adds the view to the linear
     * title layout at top of the
     * bottom sheet (non scrollable)
     * @param v views to be added with the param
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet addTitle(LinearLayout.LayoutParams p,View ... v) {
        layout.wrapperTitle.addViews(p,v);
        return this;
    }

    /**
     * adds the view to the linear
     * layout inside the nested scroll view
     * @param v views to be added with the param
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet addTitle(LinearLayout.LayoutParams p,List<View> v) {
        layout.wrapperTitle.addViews(p,v);
        return this;
    }



    /**
     * adds the view to the linear
     * bottom bar layout at bottom of the
     * bottom sheet (non scrollable)
     * @param v view to be added
     * @return this for nested calling
     */
    public MoBottomSheet addBottomBar(View v) {
        layout.wrapperBottomBar.addView(v);
        return this;
    }

    /**
     * adds the view to the linear
     * bottom bar layout at bottom of the
     * bottom sheet (non scrollable)
     * @param v view to be added
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet addBottomBar(View v, LinearLayout.LayoutParams p) {
        layout.wrapperBottomBar.addView(v,p);
        return this;
    }

    /**
     * adds the view to the linear
     * bottom bar layout at bottom of the
     * bottom sheet (non scrollable)
     * @param v view to be added
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet addBottomBar(LinearLayout.LayoutParams p,View ... v) {
        layout.wrapperBottomBar.addViews(p,v);
        return this;
    }

    /**
     * adds the view to the linear
     * bottom bar layout at bottom of the
     * bottom sheet (non scrollable)
     * @param v view to be added
     * @param p params of the view inside linear layout
     * @return this for nested calling
     */
    public MoBottomSheet addBottomBar(LinearLayout.LayoutParams p,List<View> v) {
        layout.wrapperBottomBar.addViews(p,v);
        return this;
    }


    /**
     * adds the callback to the
     * list of call backs
     * @param c callback to be added to the list
     * @return this for nested calling
     */
    public MoBottomSheet addBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback c) {
        callbacks.add(c);
        return this;
    }

    /**
     * called when the bottom sheet is dismissed
     * @param onDismissedListener
     * @return
     */
    public MoBottomSheet setOnDismissedListener(Runnable onDismissedListener) {
        this.onDismissedListener = onDismissedListener;
        return this;
    }

    public MoBottomSheet setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public MoBottomSheet setCanceledOnTouchOutside(boolean canceledOnTouchOutside) {
        this.canceledOnTouchOutside = canceledOnTouchOutside;
        return this;
    }

    public MoBottomSheet setDismissWithAnimation(boolean dismissWithAnimation) {
        this.dismissWithAnimation = dismissWithAnimation;
        return this;
    }

    public MoBottomSheet setDraggable(boolean draggable) {
        this.draggable = draggable;
        return this;
    }

    public MoBottomSheet setFitToContents(boolean fitToContents) {
        this.fitToContents = fitToContents;
        return this;
    }

    public MoBottomSheet setSkipCollapsed(boolean skipCollapsed) {
        this.skipCollapsed = skipCollapsed;
        return this;
    }

    public MoBottomSheet setAnimatePeekHeight(boolean animatePeekHeight) {
        this.animatePeekHeight = animatePeekHeight;
        return this;
    }

    public MoBottomSheet setGestureInsetBottomIgnored(boolean gestureInsetBottomIgnored) {
        this.gestureInsetBottomIgnored = gestureInsetBottomIgnored;
        return this;
    }

    public MoBottomSheet setHideable(boolean hideable) {
        this.hideable = hideable;
        return this;
    }

    public MoBottomSheet setPeekHeight(int peekHeight) {
        this.peekHeight = peekHeight;
        return this;
    }

    public MoBottomSheet setCallbacks(List<BottomSheetBehavior.BottomSheetCallback> callbacks) {
        this.callbacks = callbacks;
        return this;
    }

    public MoBottomSheet setState(@BottomSheetBehavior.State int state) {
        this.state = state;
        return this;
    }

    public MoBottomSheet setDimBehind(boolean dimBehind) {
        this.dimBehind = dimBehind;
        return this;
    }

    /**
     * makes the state expanded
     * @return this for nested calling
     */
    public MoBottomSheet expanded() {
        return setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    /**
     * makes the state half-expanded
     * @return this for nested calling
     */
    public MoBottomSheet halfExpanded() {
        return setState(BottomSheetBehavior.STATE_HALF_EXPANDED);
    }

    /**
     * duration of the bottom sheet
     * after duration (in milliseconds)
     * the bottom sheet is dismissed automatically
     * @param duration in milliseconds
     * @return this for nested calling
     */
    public MoBottomSheet setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * if the style used in making the bottom
     * sheet should be round
     */
    public MoBottomSheet setRound(boolean round) {
        this.round = round;
        return this;
    }

    /**
     * if this is set, contentView is used instead of layout for the bottom sheet
     * @param contentView
     * @return
     */
    public MoBottomSheet setContentView(View contentView) {
        this.contentView = contentView;
        return this;
    }

    /**
     * builds the class based on the
     * specs that are passed in
     * @return this for nested calling
     */
    public MoBottomSheet build() {
        initBottomSheetDialog();
        bottomSheet.setContentView(contentView == null ? layout : contentView);
        bottomSheet.setCancelable(cancelable);
        bottomSheet.setDismissWithAnimation(dismissWithAnimation);
        bottomSheet.setCanceledOnTouchOutside(canceledOnTouchOutside);
        applyDim(bottomSheet);
        BottomSheetBehavior<FrameLayout> behavior = bottomSheet.getBehavior();
        behavior.setSkipCollapsed(skipCollapsed);
        behavior.setDraggable(draggable);
        behavior.setFitToContents(fitToContents);
        behavior.setState(state);
        behavior.setPeekHeight(peekHeight,animatePeekHeight);
        behavior.setGestureInsetBottomIgnored(gestureInsetBottomIgnored);
        behavior.setHideable(hideable);
        addAllCallBacks(behavior);
        addUniversalCallback(behavior);
        addDuration();
        return this;
    }

    /**
     * if duration is not 0,
     * we dismiss the bottom sheet after
     * the specified duration in milliseconds
     */
    private void addDuration() {
        if (duration!=0) {
            Handler h = new Handler();
            h.postDelayed(this::dismiss,duration);
        }
    }

    /**
     * if it is round
     * we init the bottom sheet dialog to use
     * the round style background for bottom
     * sheet. else we init it the normal
     * way.
     */
    private void initBottomSheetDialog() {
        if (round) {
            this.bottomSheet = new BottomSheetDialog(this.context, R.style.mo_round_bottom_sheet_dialog);
        } else {
            this.bottomSheet = new BottomSheetDialog(this.context);
        }
    }

    /**
     * can create null pointer exception
     * if build is not called before this
     * @return this for nested calling
     */
    public MoBottomSheet show() {
        this.bottomSheet.show();
        return this;
    }

    /**
     * dismisses the bottom sheet
     * this also calls the on dismiss listener
     * @return this for nested calling
     */
    public MoBottomSheet dismiss() {
        dismissWithoutListener();
        this.onDismissedListener.run();
        return this;
    }

    /**
     * dismiss the bottom sheet without activating
     * the on dismiss listener
     * @return this for nested calling
     */
    public MoBottomSheet dismissWithoutListener() {
        this.bottomSheet.dismiss();
        return this;
    }




    /**
     * remove the dim from bottom sheet
     * if dim behind is false
     * @param b bottom sheet dialog to remove the dim from
     */
    private void applyDim(BottomSheetDialog b) {
        if(!dimBehind) {
            Objects.requireNonNull(b.getWindow()).clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        }
    }

    private void addAllCallBacks(BottomSheetBehavior<FrameLayout> behavior) {
        for(BottomSheetBehavior.BottomSheetCallback c: callbacks){
            behavior.addBottomSheetCallback(c);
        }
    }

    /**
     * this is needed to handle all the problems that
     * bottom sheet has,
     * - for example when the bottom sheet is hidden, the
     * bottom sheet is not dismissed, so our solution fix
     * that problem automatically
     * - another problem is when the state is expanded or half-expanded,
     * and fit content is set to true, we wouldn't get round behaviours (
     * this was fixed by overriding the theme inside styles )
     * @param behavior
     */
    private void addUniversalCallback(BottomSheetBehavior<FrameLayout> behavior) {
        behavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == BottomSheetBehavior.STATE_HIDDEN || newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    // if the state of the bottom sheet is hidden,
                    // then dismiss the bottom sheet
                    dismiss();
                    // removing the callback to avoid memory leaks
                    behavior.removeBottomSheetCallback(this);
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }






}
