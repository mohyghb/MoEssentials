package com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoSelectable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoListViews;


// T is the dynamic type that we are dealing with
public class MoListSelectable<T extends MoSelectableItem> extends MoListViews {

    private MoSelectableList<T> selectableList;
    // select all button
    protected CheckBox selectAllCheckBox;

    // shows the total items selected
    protected int selectedSize;
    protected TextView counterTextView;
    protected String counterMessage = " Selected";
    private ImageButton confirmImageButton;
    private MoOnCanceledListener canceledListener = () -> {};
    private MoOnSelectFinishedListener<T> selectFinishedListener = pickedItems -> {};
    private MoOnSelectListener<T> onSelectListener = selectableItem -> {};
    private boolean updateTitleAfter = true;
    private String savedTitle = "";


    public MoListSelectable(Context c, View parent, MoSelectableList<T> selectableList) {
        super(c,parent);
        this.selectableList = selectableList;
        this.selectableList.setListSelectable(this);
    }

    public MoSelectableList<T> getSelectableList() {
        return selectableList;
    }

    public MoListSelectable<T> setSelectableList(MoSelectableList<T> selectableList) {
        this.selectableList = selectableList;
        return this;
    }

    public CheckBox getSelectAllCheckBox() {
        return selectAllCheckBox;
    }

    public MoListSelectable<T> setSelectAllCheckBox(CheckBox selectAllCheckBox) {
        this.selectAllCheckBox = selectAllCheckBox;
        return this;
    }

    public TextView getCounterTextView() {
        return counterTextView;
    }

    public MoListSelectable<T> setCounterTextView(TextView counterTextView) {
        this.counterTextView = counterTextView;
        return this;
    }

    public String getCounterMessage() {
        return counterMessage;
    }

    public MoListSelectable<T> setCounterMessage(String counterMessage) {
        this.counterMessage = counterMessage;
        return this;
    }



    public MoOnCanceledListener getCanceledListener() {
        return canceledListener;
    }

    public MoListSelectable<T> setCanceledListener(MoOnCanceledListener canceledListener) {
        this.canceledListener = canceledListener;
        return this;
    }

    public MoOnSelectFinishedListener<T> getSelectFinishedListener() {
        return selectFinishedListener;
    }

    public MoListSelectable<T> setSelectFinishedListener(MoOnSelectFinishedListener<T> selectFinishedListener) {
        this.selectFinishedListener = selectFinishedListener;
        return this;
    }

    public ImageButton getConfirmImageButton() {
        return confirmImageButton;
    }

    public MoListSelectable<T>  setConfirmImageButton(ImageButton confirmImageButton) {
        this.confirmImageButton = confirmImageButton;
        this.confirmImageButton.setOnClickListener(view -> onConfirm());
        return this;
    }

    public MoListSelectable<T>  setConfirmImageButton(int confirmImageButton) {
        return setConfirmImageButton(parentView.findViewById(confirmImageButton));
    }

    @Override
    public MoListSelectable<T>  setCancelButton(int cancelButton) {
        super.setCancelButton(cancelButton);
        return this;
    }

    @Override
    public MoListSelectable<T>  setConfirmButton(int confirmButton) {
        super.setConfirmButton(confirmButton);
        return this;
    }

    public MoListSelectable<T>  setOnCanceledListener(MoOnCanceledListener canceledListener) {
        this.canceledListener = canceledListener;
        return this;
    }

    public MoListSelectable<T>  setOnSelectFinishedListener(MoOnSelectFinishedListener<T> selectFinishedListener) {
        this.selectFinishedListener = selectFinishedListener;
        return this;
    }

    public MoListSelectable<T>  setSelectAllCheckBox(int selectAll){
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

    public MoListSelectable<T>  setCounterView(int ctv){
        return setCounterView(parentView.findViewById(ctv));
    }

    public MoListSelectable<T>  setCounterView(TextView ctv){
        return setCounterView(ctv,null);
    }

    // set counter of items
    public MoListSelectable<T>  setCounterView(int ctv, String message){
        return setCounterView(parentView.findViewById(ctv),message);
    }

    public MoListSelectable<T>  setCounterView(TextView ctv, String message){
        this.counterTextView = ctv;
        if(message!=null){
            this.counterMessage = message;
        }
        this.savedTitle = this.counterTextView.getText().toString();
        return this;
    }

    @Override
    public MoListSelectable<T>  addUnNormalViews(int... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoListSelectable<T>  addUnNormalViews(View... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoListSelectable<T>  addNormalViews(int... views) {
        super.addNormalViews(views);
        return this;
    }

    @Override
    public MoListSelectable<T>  addNormalViews(View... views) {
        super.addNormalViews(views);
        return this;
    }

    public MoListSelectable<T>  setUpdateTitleAfter(boolean updateTitleAfter) {
        this.updateTitleAfter = updateTitleAfter;
        return this;
    }

    @Override
    public MoListSelectable<T>  setShowOneActionAtTime(boolean showOneActionAtTime) {
        super.setShowOneActionAtTime(showOneActionAtTime);
        return this;
    }

    public boolean isUpdateTitleAfter() {
        return updateTitleAfter;
    }

    public MoListSelectable<T> updateTitle(boolean updateTitleAfter) {
        this.updateTitleAfter = updateTitleAfter;
        return this;
    }

    public String getSavedTitle() {
        return savedTitle;
    }

    public MoListSelectable<T>  setSavedTitle(String savedTitle) {
        this.savedTitle = savedTitle;
        return this;
    }

    public void update() {
        updateActions();
        updateCounter();
    }

    /**
     * when user is not trying to do this anymore
     */
    @Override
    public void onCancel() {
        selectableList.deselectAllElements();
        selectableList.notifySituationChanged();
        deactivateSpecialMode();
        updateTitle(updateTitleAfter && counterTextView!=null, savedTitle);
        this.canceledListener.onCanceled();
    }

    public void updateTitle(boolean condition, String savedTitle) {
        if (condition) {
            counterTextView.setText(savedTitle);
        }
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
        if(showOneActionAtTime && this.confirmButton!=null && this.cancelButton!=null){
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
        updateTitle(this.counterTextView!=null, this.selectedSize + this.counterMessage);
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
     * when the user calls on select (selects an item to deselect or select)
     * @param si
     */
    public void onSelect(T si){
        if(si.onSelect()){
            // if it is selected, add it to the selected list
            selectableList.getSelectedItems().add(si);
        }else{
            // else remove it from the list
            selectableList.getSelectedItems().remove(si);
        }
        notifySizeChange(si.isSelected());
        onSelectListener.onSelect(si);
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
