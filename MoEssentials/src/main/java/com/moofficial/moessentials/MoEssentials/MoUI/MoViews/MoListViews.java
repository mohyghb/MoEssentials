package com.moofficial.moessentials.MoEssentials.MoUI.MoViews;

import android.content.Context;
import android.view.View;
import android.widget.Button;


import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MoListViews extends MoContext {



    protected View parentView;
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
    private int visible = View.VISIBLE;
    private int invisible = View.GONE;
    private int visibleAnimation = MoAnimation.FADE_IN;
    private int goneAnimation = MoAnimation.FADE_OUT;
    protected boolean isInActionMode = false;
    protected boolean isOnHold = false;




    public MoListViews(Context context, View parentView){
        super(context);
        this.parentView = parentView;
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


    public MoListViews setVisibleAnimation(int a){
        this.visibleAnimation = a;
        return this;
    }

    public MoListViews setGoneAnimation(int a){
        this.goneAnimation = a;
        return this;
    }




    public MoListViews setCancelButton(int cancelButton){
        this.cancelButton = parentView.findViewById(cancelButton);
        this.cancelButton.setOnClickListener(view -> onCancel());
        return this;
    }

    public MoListViews setConfirmButton(int deleteButton){
        this.confirmButton = parentView.findViewById(deleteButton);
        this.confirmButton.setOnClickListener(view -> this.onConfirm());
        return this;
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

    public MoListViews setParentView(View parentView) {
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

    public int getVisibleAnimation() {
        return visibleAnimation;
    }

    public int getGoneAnimation() {
        return goneAnimation;
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
        return this;
    }

    public MoListViews setConfirmButton(Button confirmButton) {
        this.confirmButton = confirmButton;
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
        MoViewUtils.apply(this.parentView,unNormalViews,visible,visibleAnimation);
        MoViewUtils.apply(this.parentView,normalViews,invisible,goneAnimation);
    }

    public void goingToActivateIfNotNull() {
        if(listViewSync!=null){
            listViewSync.goingToActivate(this);
        }
    }

    public void deactivateSpecialMode(){
        if(!isOnHold){
            isInActionMode = false;
        }
        MoViewUtils.apply(this.parentView,unNormalViews,invisible,goneAnimation);
        MoViewUtils.apply(this.parentView,normalViews,visible,visibleAnimation);
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



}
