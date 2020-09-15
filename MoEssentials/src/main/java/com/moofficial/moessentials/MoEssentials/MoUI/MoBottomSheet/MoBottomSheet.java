package com.moofficial.moessentials.MoEssentials.MoUI.MoBottomSheet;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBottomSheetLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// a builder class for bottom sheet dialog
public class MoBottomSheet extends MoContext {

    private MoBottomSheetLayout layout;
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
    private int peekHeight;
    @BottomSheetBehavior.State private int state = BottomSheetBehavior.STATE_COLLAPSED;
    private List<BottomSheetBehavior.BottomSheetCallback> callbacks = new ArrayList<>();

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
     * adds the callback to the
     * list of call backs
     * @param c callback to be added to the list
     * @return this for nested calling
     */
    public MoBottomSheet addBottomSheetCallback(BottomSheetBehavior.BottomSheetCallback c) {
        callbacks.add(c);
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

    public BottomSheetDialog build() {
        BottomSheetDialog b = new BottomSheetDialog(this.context);
        b.setContentView(layout);
        b.setCancelable(cancelable);
        b.setDismissWithAnimation(dismissWithAnimation);
        b.setCanceledOnTouchOutside(canceledOnTouchOutside);
        applyDim(b);
        BottomSheetBehavior<FrameLayout> behavior = b.getBehavior();
        behavior.setSkipCollapsed(skipCollapsed);
        behavior.setDraggable(draggable);
        behavior.setFitToContents(fitToContents);
        behavior.setState(state);
        behavior.setPeekHeight(peekHeight,animatePeekHeight);
        behavior.setGestureInsetBottomIgnored(gestureInsetBottomIgnored);
        behavior.setHideable(hideable);
        addAllCallBacks(behavior);
        return b;
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

}
