package com.moofficial.moessentials.MoEssentials.MoViews;

import android.content.Context;
import android.view.View;
import android.widget.Button;


import com.moofficial.moessentials.MoEssentials.MoAnimation.MoAnimation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MoListViews {


    protected Context context;

    protected View parentView;

    // this mo list view action is
    // synced with others
    // so we don't show multiple
    // views that are in common
    private List<MoListViews> syncActions = new ArrayList<>();
    // un-normal views that are only shown when the
    // a mode is on
    private View[] unNormalViews;
    // normal views that are shown to the user when
    // it is not in delete mode
    private View[] normalViews;
    // canceling the delete mode
    protected Button cancelButton;
    // performing the actual delete
    protected Button confirmButton;
    protected boolean showOneActionAtTime = true;
    private int visible = View.VISIBLE;
    private int invisible = View.INVISIBLE;
    private int visibleAnimation = MoAnimation.FADE_IN;
    private int goneAnimation = MoAnimation.FADE_OUT;
    protected boolean isInActionMode = false;




    public MoListViews(Context context, View parentView){
        this.context = context;
        this.parentView = parentView;
    }


    public MoListViews setUnNormalViews(int ... views){
        this.unNormalViews = new View[views.length];
        for(int i = 0;i < views.length; i++){
            View view = this.parentView.findViewById(views[i]);
            this.unNormalViews[i] = view;
        }
        return this;
    }

    public MoListViews setNormalViews(int ... views){
        this.normalViews = new View[views.length];
        for(int i = 0;i < views.length; i++){
            View view = this.parentView.findViewById(views[i]);
            this.normalViews[i] = view;
        }
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


    public MoListViews setSyncActions(MoListViews ... syncActions) {
        this.syncActions = Arrays.asList(syncActions);
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


    public MoListViews setSyncActions(List<MoListViews> syncActions) {
        this.syncActions = syncActions;
        return this;
    }

    public MoListViews setUnNormalViews(View[] unNormalViews) {
        this.unNormalViews = unNormalViews;
        return this;
    }

    public MoListViews setNormalViews(View[] normalViews) {
        this.normalViews = normalViews;
        return this;
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
        MoViewUtils.closeActions(this.syncActions);
        isInActionMode = true;
        MoViewUtils.apply(unNormalViews,visible,visibleAnimation);
        MoViewUtils.apply(normalViews,invisible,goneAnimation);
    }

    public void deactivateSpecialMode(){
        isInActionMode = false;
        MoViewUtils.apply(unNormalViews,invisible,goneAnimation);
        MoViewUtils.apply(normalViews,visible,visibleAnimation);
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


    public void removeAction(){
        this.onCancel();
        this.isInActionMode = false;
    }


    public void addSyncAction(MoListViews s){
        this.syncActions.add(s);
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
