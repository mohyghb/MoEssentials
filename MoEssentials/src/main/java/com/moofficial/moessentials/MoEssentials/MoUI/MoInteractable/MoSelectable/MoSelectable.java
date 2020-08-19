package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoListViews;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoOnCanceledListener;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoOnEmptySelectionListener;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoOnSelectFinishedListener;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoOnSelectListener;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableList;


// T is the dynamic type that we are dealing with
public class MoSelectable<T extends MoSelectableItem> extends MoListViews {

    private MoSelectableListWrapper<T> wrapper;
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
    private MoOnEmptySelectionListener onEmptySelectionListener = ()->{};
    private boolean updateTitleAfter = true;
    private boolean allItemsAreSelectable = true;
    private String savedTitle = "";


    public MoSelectable(Context c, ViewGroup parent, MoSelectableList<T> selectableList) {
        super(c,parent);
        this.wrapper = new MoSelectableListWrapper<>(selectableList).sync(this);
    }

    public MoOnEmptySelectionListener getOnEmptySelectionListener() {
        return onEmptySelectionListener;
    }

    public MoSelectable<T> setOnEmptySelectionListener(MoOnEmptySelectionListener onEmptySelectionListener) {
        this.onEmptySelectionListener = onEmptySelectionListener;
        return this;
    }

    public MoSelectableListWrapper<T> getWrapper() {
        return wrapper;
    }

    public MoSelectable<T> setWrapper(MoSelectableListWrapper<T> wrapper) {
        this.wrapper = wrapper;
        return this;
    }

    public CheckBox getSelectAllCheckBox() {
        return selectAllCheckBox;
    }

    public MoSelectable<T> setSelectAllCheckBox(CheckBox selectAllCheckBox) {
        this.selectAllCheckBox = selectAllCheckBox;
        this.selectAllCheckBox.setOnCheckedChangeListener((compoundButton, b) -> {
            if(!compoundButton.isPressed()){
                // return if the actual button was not pressed
                // we might have changed the checked state
                // based on what we saw fit at that time
                return;
            }
            if(b){
                selectAll(true);
            }else{
                deselectAll(true);
            }
        });
        return this;
    }

    public TextView getCounterTextView() {
        return counterTextView;
    }



    public String getCounterMessage() {
        return counterMessage;
    }

    public MoSelectable<T> setCounterMessage(String counterMessage) {
        this.counterMessage = counterMessage;
        return this;
    }


    public MoOnSelectListener<T> getOnSelectListener() {
        return onSelectListener;
    }

    public MoSelectable<T> setOnSelectListener(MoOnSelectListener<T> onSelectListener) {
        this.onSelectListener = onSelectListener;
        return this;
    }

    public MoOnCanceledListener getCanceledListener() {
        return canceledListener;
    }

    public MoSelectable<T> setCanceledListener(MoOnCanceledListener canceledListener) {
        this.canceledListener = canceledListener;
        return this;
    }

    public MoOnSelectFinishedListener<T> getSelectFinishedListener() {
        return selectFinishedListener;
    }

    public MoSelectable<T> setSelectFinishedListener(MoOnSelectFinishedListener<T> selectFinishedListener) {
        this.selectFinishedListener = selectFinishedListener;
        return this;
    }

    public ImageButton getConfirmImageButton() {
        return confirmImageButton;
    }

    public MoSelectable<T> setConfirmImageButton(ImageButton confirmImageButton) {
        this.confirmImageButton = confirmImageButton;
        this.confirmImageButton.setOnClickListener(view -> onConfirm());
        return this;
    }

    public MoSelectable<T> setConfirmImageButton(int confirmImageButton) {
        return setConfirmImageButton(parentView.findViewById(confirmImageButton));
    }

    @Override
    public MoSelectable<T> setCancelButton(int cancelButton) {
        super.setCancelButton(cancelButton);
        return this;
    }

    @Override
    public MoSelectable<T> setConfirmButton(int confirmButton) {
        super.setConfirmButton(confirmButton);
        return this;
    }

    public MoSelectable<T> setOnCanceledListener(MoOnCanceledListener canceledListener) {
        this.canceledListener = canceledListener;
        return this;
    }

    public MoSelectable<T> setOnSelectFinishedListener(MoOnSelectFinishedListener<T> selectFinishedListener) {
        this.selectFinishedListener = selectFinishedListener;
        return this;
    }

    public MoSelectable<T> setSelectAllCheckBox(int selectAll){
        return setSelectAllCheckBox(parentView.findViewById(selectAll));
    }

    public MoSelectable<T> setCounterView(int ctv){
        return setCounterView(parentView.findViewById(ctv));
    }

    public MoSelectable<T> setCounterView(TextView ctv){
        return setCounterView(ctv,null);
    }

    // set counter of items
    public MoSelectable<T> setCounterView(int ctv, String message){
        return setCounterView(parentView.findViewById(ctv),message);
    }

    public MoSelectable<T> setCounterView(TextView ctv, String message){
        this.counterTextView = ctv;
        if(message!=null){
            this.counterMessage = message;
        }
        this.savedTitle = this.counterTextView.getText().toString();
        return this;
    }

    @Override
    public MoSelectable<T> addUnNormalViews(int... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoSelectable<T> addUnNormalViews(View... views) {
        super.addUnNormalViews(views);
        return this;
    }

    @Override
    public MoSelectable<T> addNormalViews(int... views) {
        super.addNormalViews(views);
        return this;
    }

    @Override
    public MoSelectable<T> addNormalViews(View... views) {
        super.addNormalViews(views);
        return this;
    }

    public MoSelectable<T> setUpdateTitleAfter(boolean updateTitleAfter) {
        this.updateTitleAfter = updateTitleAfter;
        return this;
    }

    @Override
    public MoSelectable<T> setShowOneActionAtTime(boolean showOneActionAtTime) {
        super.setShowOneActionAtTime(showOneActionAtTime);
        return this;
    }

    public boolean isAllItemsAreSelectable() {
        return allItemsAreSelectable;
    }

    public MoSelectable<T> setAllItemsAreSelectable(boolean allItemsAreSelectable) {
        this.allItemsAreSelectable = allItemsAreSelectable;
        wrapper.setAllItemsAreSelectable(allItemsAreSelectable);
        return this;
    }

    public boolean isUpdateTitleAfter() {
        return updateTitleAfter;
    }

    public MoSelectable<T> updateTitle(boolean updateTitleAfter) {
        this.updateTitleAfter = updateTitleAfter;
        return this;
    }

    public String getSavedTitle() {
        return savedTitle;
    }

    public MoSelectable<T> setSavedTitle(String savedTitle) {
        this.savedTitle = savedTitle;
        return this;
    }

    public void update() {
        updateActions();
        updateCounter();
        updateCheckButton();
        notifyEmptySelectListener();
    }

    /**
     * when user is not trying to do this anymore
     */
    @Override
    public void onCancel() {
        deselectAll(false);
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
        this.selectFinishedListener.onSelectFinished(wrapper.getSelectedItems());
    }

    @Override
    public void onActivateSpecialMode() {
        wrapper.init();
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

    protected void updateCheckButton(){
        if(selectAllCheckBox!=null){
            if(selectedSize == wrapper.dataSetSize()){
                selectAllCheckBox.setChecked(true);
            }else{
                selectAllCheckBox.setChecked(false);
            }
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
    public void setSelectedSize(int s,boolean update){
        this.selectedSize = s;
        if(update){
            update();
        }
    }

    public void notifyEmptySelectListener() {
        if(this.isEmpty()){
            onEmptySelectionListener.onSelectionEmpty();
        }
    }


    //
    /**
     *  notifies that the the selected size has been changed
     *  b is whether the newly touched element was selected
     *  or deselcted
     *  increments the selected size if b is true (which means
     *  the element was selected)
     *  or decrements it if it is false
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
    public void onSelect(T si,int position){
        addOrRemoveItem(si);
        notifySizeChange(si.isSelected());
        wrapper.notifyItemChanged(position);
        onSelectListener.onSelect(si);
    }

    /**
     * adds it if si is selected
     * after we call si.onSelect
     * or removes it if it is not
     * selected anymore
     * @param si
     */
    public void addOrRemoveItem(T si) {
        if(si.onSelect()){
            // if it is selected, add it to the selected list
            wrapper.add(si);
        }else{
            // else remove it from the list
            wrapper.remove(si);
        }
    }


    /**
     * selects all the items inside a list
     */
    public void selectAll(boolean update){
        wrapper.selectAll(update);
    }

    /**
     * deselects all items inside a list
     */
    public void deselectAll(boolean update){
        wrapper.deselectAll(update);
    }


    /**
     *
     * @return true if the selected size is 0
     */
    public boolean isEmpty(){
        return selectedSize == 0;
    }

}
