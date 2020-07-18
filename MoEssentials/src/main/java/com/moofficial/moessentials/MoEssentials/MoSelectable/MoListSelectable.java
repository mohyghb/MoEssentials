package com.moofficial.moessentials.MoEssentials.MoSelectable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoViews.MoListViews;


public class MoListSelectable extends MoListViews {

    private MoSelectableList selectableList;
    // select all button
    protected CheckBox selectAllCheckBox;

    // shows the total items selected
    protected int selectedSize;
    protected TextView counterTextView;
    protected String counterMessage;
    protected boolean loadTitleAfter;
    private MoOnCanceledListener canceledListener = () -> {};
    private MoOnSelectFinishedListener selectFinishedListener = pickedItems -> {};


    public MoListSelectable(Context c, View parent, MoSelectableList selectableList) {
        super(c,parent);
        this.selectableList = selectableList;
    }

    public MoSelectableList getSelectableList() {
        return selectableList;
    }

    public MoListSelectable setSelectableList(MoSelectableList selectableList) {
        this.selectableList = selectableList;
        return this;
    }

    public CheckBox getSelectAllCheckBox() {
        return selectAllCheckBox;
    }

    public MoListSelectable setSelectAllCheckBox(CheckBox selectAllCheckBox) {
        this.selectAllCheckBox = selectAllCheckBox;
        return this;
    }

    public TextView getCounterTextView() {
        return counterTextView;
    }

    public MoListSelectable setCounterTextView(TextView counterTextView) {
        this.counterTextView = counterTextView;
        return this;
    }

    public String getCounterMessage() {
        return counterMessage;
    }

    public MoListSelectable setCounterMessage(String counterMessage) {
        this.counterMessage = counterMessage;
        return this;
    }

    public boolean isLoadTitleAfter() {
        return loadTitleAfter;
    }

    public MoListSelectable setLoadTitleAfter(boolean loadTitleAfter) {
        this.loadTitleAfter = loadTitleAfter;
        return this;
    }

    public MoOnCanceledListener getCanceledListener() {
        return canceledListener;
    }

    public MoListSelectable setCanceledListener(MoOnCanceledListener canceledListener) {
        this.canceledListener = canceledListener;
        return this;
    }

    public MoOnSelectFinishedListener getSelectFinishedListener() {
        return selectFinishedListener;
    }

    public MoListSelectable setSelectFinishedListener(MoOnSelectFinishedListener selectFinishedListener) {
        this.selectFinishedListener = selectFinishedListener;
        return this;
    }

    @Override
    public MoListSelectable setCancelButton(int cancelButton) {
        super.setCancelButton(cancelButton);
        return this;
    }

    @Override
    public MoListSelectable setConfirmButton(int confirmButton) {
        super.setConfirmButton(confirmButton);
        return this;
    }

    public MoListSelectable setOnCanceledListener(MoOnCanceledListener canceledListener) {
        this.canceledListener = canceledListener;
        return this;
    }

    public MoListSelectable setOnSelectFinishedListener(MoOnSelectFinishedListener selectFinishedListener) {
        this.selectFinishedListener = selectFinishedListener;
        return this;
    }

    public MoListSelectable setSelectAllCheckBox(int selectAll){
        this.selectAllCheckBox = parentView.findViewById(selectAll);
        this.selectAllCheckBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if(!compoundButton.isPressed()){
                // return if the actual button was not pressed
                // we might have changed the checked state
                // based on what we saw fit at that time
                return;
            }
            if(b){
                selectAll();
            }else{
                deselectAll();
            }
        });
        return this;
    }

    // set counter of items
    public MoListSelectable setCounterView(int ctv, String message){
        this.counterTextView = parentView.findViewById(ctv);
        this.counterMessage = message;
        return this;
    }

    @Override
    public MoListSelectable setUnNormalViews(int... views) {
        super.setUnNormalViews(views);
        return this;
    }

    @Override
    public MoListSelectable setNormalViews(int... views) {
        super.setNormalViews(views);
        return this;
    }

    @Override
    public MoListSelectable setShowOneActionAtTime(boolean showOneActionAtTime) {
        super.setShowOneActionAtTime(showOneActionAtTime);
        return this;
    }

    public void update() {
        updateActions();
    }

    /**
     * when user is not trying to do this anymore
     */
    @Override
    public void onCancel() {
        this.canceledListener.onCanceled();
    }

    /**
     * when user gave us permission do
     * an operation that required one
     */
    @Override
    public void onConfirm() {
        this.selectFinishedListener.onSelectFinished(selectableList.getSelectedItems());
    }


    /**
      * updates the action buttons of the bottom bar
      */
    protected void updateActions(){
        if(showOneActionAtTime){
            if(this.selectedSize > 0){
                // then delete should be shown
                this.confirmButton.setVisibility(View.VISIBLE);
                this.cancelButton.setVisibility(View.GONE);
            }else{
                // then show cancel
                this.confirmButton.setVisibility(View.GONE);
                this.cancelButton.setVisibility(View.VISIBLE);
            }
        }
    }

    /**
     * updates the counter message
     * to the size of actually selected elements
     */
    @SuppressLint("SetTextI18n")
    protected void updateCounter(){
        if(this.counterTextView!=null){
            this.counterTextView.setText(this.selectedSize + this.counterMessage);
        }
    }



    // returns if there is no selected item
    // inside the selected list
    public boolean emptySelected(){
        return this.selectedSize == 0;
    }

    // return the selected size
    public int getSelectedSize() {
        return selectedSize;
    }

    // sets the selected size
    public void setSelectedSize(int s){
        this.selectedSize = s;
        update();
    }


    // notifies that the the selected size has been changed
    // b is whether the newly touched element was selected
    // or deselcted
    /**
     * increments the selected size if b is true (which means
     *  the element was selected)
     * or decrements it if it is false
     * @param b
     */
    public void notifySizeChange(boolean b){
        if(b){
            this.selectedSize++;
        }else{
            this.selectedSize--;
        }
        update();
    }


    /**
     * selects all the items inside a list
     */
    public void selectAll(){
        this.selectableList.selectAllElements();
    }

    /**
     * deselects all items inside a list
     */
    public void deselectAll(){
        this.selectableList.deselectAllElements();
    }



}
