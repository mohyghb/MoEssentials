package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable;

import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.annotation.NonNull;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MoListViews extends MoContext {



    protected ViewGroup parentView;
    // this mo list view action is
    // synced with others
    // so we don't show multiple
    // views that are in common
    private MoListViewSync listViewSync;
    // un-normal views that are only shown when the
    // a mode is on
    private List<View> unNormalViews = new ArrayList<>();
    // normal views that are shown to the user when
    // it is not in delete mode
    private List<View> normalViews = new ArrayList<>();
    // canceling the delete mode
    protected Button cancelButton;
    // performing the actual delete
    protected Button confirmButton;
    protected boolean showOneActionAtTime = true;
    private Transition transitionIn = new ChangeBounds();
    private Transition transitionOut = new ChangeBounds();
    private int visible = View.VISIBLE;
    private int invisible = View.GONE;
    protected boolean isInActionMode = false;
    protected boolean isOnHold = false;




    public MoListViews(Context context, @NonNull ViewGroup parentView){
        super(context);
        this.parentView = parentView;
    }

    public Transition getTransitionIn() {
        return transitionIn;
    }

    public MoListViews setTransitionIn(Transition transitionIn) {
        this.transitionIn = transitionIn;
        return this;
    }

    public Transition getTransitionOut() {
        return transitionOut;
    }

    public MoListViews setTransitionOut(Transition transitionOut) {
        this.transitionOut = transitionOut;
        return this;
    }

    public MoListViewSync getListViewSync() {
        return listViewSync;
    }

    public MoListViews setListViewSync(MoListViewSync listViewSync) {
        this.listViewSync = listViewSync;
        return this;
    }

    public MoListViews setOnHold(boolean onHold) {
        isOnHold = onHold;
        return this;
    }

    public MoListViews addUnNormalViews(int ... views){
        for (int value : views) {
            View view = this.parentView.findViewById(value);
            unNormalViews.add(view);
        }
        return this;
    }

    public MoListViews addUnNormalViews(View ... views){
        unNormalViews.addAll(Arrays.asList(views));
        return this;
    }

    public MoListViews addNormalViews(int ... views){
        for (int value : views) {
            View view = this.parentView.findViewById(value);
            normalViews.add(view);
        }
        return this;
    }

    public MoListViews addNormalViews(View ... views){
        normalViews.addAll(Arrays.asList(views));
        return this;
    }





    public MoListViews setCancelButton(int cancelButton){
        return setCancelButton(parentView.findViewById(cancelButton));
    }

    public MoListViews setConfirmButton(int deleteButton){
        return setConfirmButton(parentView.findViewById(deleteButton));
    }



    public Context getContext() {
        return context;
    }

    public MoListViews setContext(Context context) {
        this.context = context;
        return this;
    }

    public View getParentView() {
        return parentView;
    }

    public MoListViews setParentView(ViewGroup parentView) {
        this.parentView = parentView;
        return this;
    }



    public List<View> getUnNormalViews() {
        return unNormalViews;
    }

    public int getVisible() {
        return visible;
    }

    public int getInvisible() {
        return invisible;
    }


    public MoListViews setUnNormalViews(List<View> unNormalViews) {
        this.unNormalViews = unNormalViews;
        return this;
    }

    public List<View> getNormalViews() {
        return normalViews;
    }

    public MoListViews setNormalViews(List<View> normalViews) {
        this.normalViews = normalViews;
        return this;
    }

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public boolean isShowOneActionAtTime() {
        return showOneActionAtTime;
    }

    public MoListViews setCancelButton(Button cancelButton) {
        this.cancelButton = cancelButton;
        this.cancelButton.setOnClickListener(view -> onCancel());
        return this;
    }

    public MoListViews setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
        this.confirmButton.setOnClickListener(view -> this.onConfirm());
        return this;
    }

    public MoListViews setShowOneActionAtTime(boolean showOneActionAtTime) {
        this.showOneActionAtTime = showOneActionAtTime;
        return this;
    }

    public MoListViews setVisible(int visible) {
        this.visible = visible;
        return this;
    }

    public MoListViews setInvisible(int invisible) {
        this.invisible = invisible;
        return this;
    }

    public MoListViews setInActionMode(boolean inActionMode) {
        isInActionMode = inActionMode;
        return this;
    }

    public void activateSpecialMode(){
        // sync with others
        if(!isInActionMode){
            goingToActivateIfNotNull();
            isInActionMode = true;
        }
        MoViewUtils.apply(this.parentView,unNormalViews,visible,transitionIn);
        MoViewUtils.apply(this.parentView,normalViews,invisible,transitionOut);
        onActivateSpecialMode();
    }

    public void goingToActivateIfNotNull() {
        if(listViewSync!=null && !isInActionMode){
            listViewSync.goingToActivate(this);
        }
    }

    public void deactivateSpecialMode(){
        if(!isOnHold){
            goingToDeactivateIfNotNull();
            isInActionMode = false;
        }
        MoViewUtils.apply(this.parentView,unNormalViews,invisible,transitionOut);
        MoViewUtils.apply(this.parentView,normalViews,visible,transitionIn);
    }

    /**
     * it calls going to deactivate to the list view
     * sync in case the deactivation was called inside the
     * on cancel method
     */
    public void goingToDeactivateIfNotNull() {
        if(listViewSync!=null && isInActionMode){
            listViewSync.goingToDeactivate(this);
        }
    }


    public boolean isInActionMode() {
        return isInActionMode;
    }

    // returns true if this is in delete mode
    // used for when user presses back button
    // so we need to cancel this before leaving the activity
    public boolean hasAction(){
        return this.isInActionMode;
    }

    public boolean isOnHold(){
        return this.isOnHold;
    }

    /**
     * calls on cancel and sets in action
     * mode to false
     */
    public void removeAction(){
        this.isInActionMode = false;
        this.onCancel();

    }

    /**
     * makes the operation to be on hold
     * and be activated later on
     */
    public void goOnHold(){
        if(!isOnHold){
            this.isOnHold = true;
            this.deactivateSpecialMode();
        }
    }

    /**
     * makes it so that this view
     * is not on hold anymore
     */
    public void releaseOnHold(){
        if(isOnHold){
            this.isOnHold = false;
            this.activateSpecialMode();
        }
    }





    /**
     * when user is not trying to do this anymore
     */
    public abstract void onCancel();

    /**
     * when user gave us permission do
     * an operation that required one
     */
    public abstract void onConfirm();


    /**
     * this is triggered when the user
     * activates this special mode
     */
    public abstract void onActivateSpecialMode();



}
