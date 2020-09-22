package com.moofficial.moessentials.MoEssentials.MoUI.MoPopupWindow;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.transition.Slide;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import android.transition.Transition;

import androidx.annotation.RequiresApi;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.R;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

public class MoPopupWindow extends MoContext {

    private ArrayList<View> allViews = new ArrayList<>();
    private PopupWindow popupWindow;
    private MoPopupWindowLayout windowLayout;
    // max up time for the pop up window, if its zero the duration is infinite
    private long duration = 0;
    private int maxHeight;
    private int maxWidth;
    private int minHeight;
    private int minWidth;
    private int width;
    private int height;
    private boolean overlapAnchor = false;
    private boolean focusable = true;
    private boolean outsideTouchable = true;
    private boolean clippingEnabled = true;
    private Transition enterTransition, exitTransition;
    private float elevation = 3f;


    public MoPopupWindow(Context c){
        super(c);
        MoPopupWindowUtils.init(c);
        initDimensions();
        initTransitions();
    }

    public void initDimensions() {
        maxHeight = MoPopupWindowUtils.MAX_HEIGHT;
        maxWidth = MoPopupWindowUtils.MAX_WIDTH;
        minHeight = 0;
        minWidth = MoPopupWindowUtils.MIN_WIDTH;
    }


    public void initTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.enterTransition = new Slide();
            this.exitTransition = new Slide();
        }
    }

    public ArrayList<View> getAllViews() {
        return allViews;
    }

    public MoPopupWindow setAllViews(ArrayList<View> allViews) {
        this.allViews = allViews;
        return this;
    }




    public Context getContext() {
        return context;
    }

    public MoPopupWindow setContext(Context context) {
        this.context = context;
        return this;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public MoPopupWindow setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        return this;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public MoPopupWindow setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public MoPopupWindow setMinHeight(int minHeight) {
        this.minHeight = minHeight;
        return this;
    }

    public int getMinWidth() {
        return minWidth;
    }

    public MoPopupWindow setMinWidth(int minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public int getWidth() {
        return width;
    }

    public MoPopupWindow setWidth(int width) {
        this.width = width;
        return this;
    }

    public int getHeight() {
        return height;
    }

    public MoPopupWindow setHeight(int height) {
        this.height = height;
        return this;
    }

    public boolean isOverlapAnchor() {
        return overlapAnchor;
    }

    public MoPopupWindow setOverlapAnchor(boolean overlapAnchor) {
        this.overlapAnchor = overlapAnchor;
        return this;
    }

    public boolean isFocusable() {
        return focusable;
    }

    public MoPopupWindow setFocusable(boolean focusable) {
        this.focusable = focusable;
        return this;
    }

    public boolean isOutsideTouchable() {
        return outsideTouchable;
    }

    public MoPopupWindow setOutsideTouchable(boolean outsideTouchable) {
        this.outsideTouchable = outsideTouchable;
        return this;
    }

    public float getElevation() {
        return elevation;
    }

    public MoPopupWindow setElevation(float elevation) {
        this.elevation = elevation;
        return this;
    }

    /**
     * sets the duration of up time of this
     * pop up menu. after this amount of time in
     * milliseconds, the pop up window is dismissed
     * @param duration of up time
     * @return this for nested calling
     */
    public MoPopupWindow setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    public MoPopupWindow setClippingEnabled(boolean clippingEnabled) {
        this.clippingEnabled = clippingEnabled;
        return this;
    }

    public MoPopupWindow setViews(View ... views){
        return this.setViews(Arrays.asList(views));
    }

    public MoPopupWindow setViews(List<View> views){
        allViews.addAll(views);
        return this;
    }



    public MoPopupWindow groupViewsHorizontally(View ... views){
        return groupViewsHorizontally(Arrays.asList(views));
    }

    public MoPopupWindow groupViewsHorizontally(List<View> views){
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        for(View v:views){
            linearLayout.addView(v);
        }
        allViews.add(linearLayout);
        return this;
    }


    private void addAll(ArrayList<View> v,View ... views){
        v.addAll(Arrays.asList(views));
    }


    private void initPopupWindow() {
        initLayouts();
        calculateHeightWidth();
        popupWindow = new PopupWindow(windowLayout, width, height);
        popupWindow.setClippingEnabled(this.clippingEnabled);
        popupWindow.setOutsideTouchable(this.outsideTouchable);
        popupWindow.setFocusable(this.focusable);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            popupWindow.setIsLaidOutInScreen(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            popupWindow.setAttachedInDecor(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            popupWindow.setElevation(this.elevation);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            popupWindow.setOverlapAnchor(this.overlapAnchor);
            popupWindow.setEnterTransition(enterTransition);
            popupWindow.setExitTransition(exitTransition);
        }
    }


    private void initLayouts() {
        this.windowLayout = new MoPopupWindowLayout(this.context);
        View[] views = new View[this.allViews.size()];
        this.allViews.toArray(views);
        this.windowLayout.getWrapperLinearLayout().addViews(
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT), views);
    }

    private void calculateHeightWidth() {
        windowLayout.measure(View.MeasureSpec.makeMeasureSpec(maxWidth, View.MeasureSpec.AT_MOST),
                View.MeasureSpec.makeMeasureSpec(maxHeight, View.MeasureSpec.AT_MOST));
        calculateHeight();
        calculateWidth();
    }

    // calculates the height of the pop up window
    private void calculateHeight() {
        if(height == 0) {
            height = getAppropriateHeight();
        }
    }

    // calculates the width of the pop up window
    private void calculateWidth() {
        if (width == 0) {
            width = getAppropriateWidth();
        }
    }

    private int getAppropriateHeight() {
        return Math.max(Math.min(windowLayout.getMeasuredHeight(),maxHeight),minHeight);
    }

    private int getAppropriateWidth(){
        return Math.max(Math.min(windowLayout.getMeasuredWidth(),maxWidth),minWidth);
    }



    /**
     * builds the pop up window
     * but does not show it
     * @return
     */
    public MoPopupWindow build(){
        this.initPopupWindow();
        return this;
    }

    /**
     * shows the pop up window as a drop down
     * to the anchor specified
     * @param anchor
     */
    public void show(View anchor) {
        setupTimer();
        popupWindow.showAsDropDown(anchor);
    }

    /**
     * shows the pop up window
     * above the anchor window
     * @param anchor to attach the window to
     */
    public void showAboveAnchor(View anchor) {
        setupTimer();
        popupWindow.showAsDropDown(anchor,0,-windowLayout.getHeight());
    }


    /**
     * shows the pop up window on the parent view
     * based on the x, y, and gravity that is provided
     * @param parent
     * @param x
     * @param y
     * @param gravity
     */
    public void showOn(View parent, int x,int y,int gravity) {
        setupTimer();
        popupWindow.showAtLocation(parent,gravity,x,y);
    }

    /**
     * if the duration is positive
     * and bigger than 0, then for that
     * amount in milliseconds, we wait to show
     * this window to user and after that we close the window
     */
    private void setupTimer() {
        if (duration > 0) {
            Handler h = new Handler();
            h.postDelayed(() -> {
                if (popupWindow != null && isShowing()) {
                    dismiss();
                }
            },duration);
        }
    }

    public boolean isShowing(){
        return this.popupWindow.isShowing();
    }


    public void dismiss(){
        this.popupWindow.dismiss();
    }






}
