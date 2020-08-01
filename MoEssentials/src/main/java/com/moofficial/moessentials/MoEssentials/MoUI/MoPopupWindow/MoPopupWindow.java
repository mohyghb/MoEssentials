package com.moofficial.moessentials.MoEssentials.MoUI.MoPopupWindow;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.R;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoPopupWindow extends MoContext {

    private ArrayList<View> allViews = new ArrayList<>();
    private PopupWindow popupWindow;
    private Dialog dialog;
    private View rootView;
    private LinearLayout rootLinearLayout;
    private int maxHeight;
    private int maxWidth;
    private int minHeight;
    private int minWidth;
    private int width = ViewGroup.LayoutParams.WRAP_CONTENT;
    private int height = ViewGroup.LayoutParams.WRAP_CONTENT;
    private boolean overlapAnchor = false;
    private boolean focusable = true;
    private boolean outsideTouchable = true;
    private float elevation = 3f;


    public MoPopupWindow(Context c){
        super(c);
        MoPopupWindowUtils.init(c);
        initDimensions();

    }

    public void initDimensions() {
        maxHeight = MoPopupWindowUtils.MAX_HEIGHT;
        maxWidth = MoPopupWindowUtils.MAX_WIDTH;
        // since the height shouldn't be that big
        minHeight = MoPopupWindowUtils.MIN_HEIGHT;
        minWidth = MoPopupWindowUtils.MIN_WIDTH;
    }

    public ArrayList<View> getAllViews() {
        return allViews;
    }

    public MoPopupWindow setAllViews(ArrayList<View> allViews) {
        this.allViews = allViews;
        return this;
    }

    public PopupWindow getPopupWindow() {
        return popupWindow;
    }

    public MoPopupWindow setPopupWindow(PopupWindow popupWindow) {
        this.popupWindow = popupWindow;
        return this;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public MoPopupWindow setDialog(Dialog dialog) {
        this.dialog = dialog;
        return this;
    }

    public View getRootView() {
        return rootView;
    }

    public MoPopupWindow setRootView(View rootView) {
        this.rootView = rootView;
        return this;
    }

    public LinearLayout getRootLinearLayout() {
        return rootLinearLayout;
    }

    public MoPopupWindow setRootLinearLayout(LinearLayout rootLinearLayout) {
        this.rootLinearLayout = rootLinearLayout;
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
        popupWindow = new PopupWindow(rootView, width, height);
        popupWindow.setClippingEnabled(true);
        popupWindow.setOutsideTouchable(this.outsideTouchable);
        popupWindow.setFocusable(this.focusable);
        popupWindow.setElevation(this.elevation);
        popupWindow.setOverlapAnchor(this.overlapAnchor);
        calculateHeightWidth();
    }


    private void initLayouts() {
        rootView = MoInflaterView.inflate(R.layout.mo_pop_up_window_layout,this.context);
        this.rootLinearLayout = rootView.findViewById(R.id.root_linear_layout);
        addViewsToLayout(this.rootLinearLayout,this.allViews);
    }

    private void calculateHeightWidth() {
        rootLinearLayout.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        calculateHeight();
        calculateWidth();
    }

    // calculates the height of the pop up window
    private void calculateHeight() {
        if(height!=ViewGroup.LayoutParams.MATCH_PARENT){
            popupWindow.setHeight(getAppropriateHeight());
        }
    }

    // calculates the width of the pop up window
    private void calculateWidth() {
        if(width!=ViewGroup.LayoutParams.MATCH_PARENT) {
            popupWindow.setWidth(getAppropriateWidth());
        }
    }

    private int getAppropriateHeight(){
        return Math.max(Math.min(rootLinearLayout.getMeasuredHeight(), maxHeight),minHeight);
    }

    private int getAppropriateWidth(){
        return Math.max(Math.min(rootLinearLayout.getMeasuredWidth(),maxWidth),minWidth);
    }

    /**
     * adds all the views to the layout
     * @param layout
     * @param views
     */
    private void addViewsToLayout(LinearLayout layout, List<View> views){
        layout.removeAllViews();
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        for(View v: views){
            v.setLayoutParams(lp);
            layout.addView(v);
        }
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
    public void show(View anchor){
        popupWindow.showAsDropDown(anchor);
    }

    public boolean isShowing(){
        return this.popupWindow.isShowing();
    }


    public void dismiss(){
        this.popupWindow.dismiss();
    }



}
