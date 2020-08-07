package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable;

import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoUI.MoAnimation.MoAnimation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MoListViewSync {

    public static final int NO_ACTION = -1;

    private List<MoListViews> views;
    // shared views that are turned on or off by all of the MoListViews
    private List<View> sharedElements = new ArrayList<>();
    private Stack<MoListViews> inActions = new Stack<>();
    // the item on top of the stack is the one active
    private Stack<MoListViews> onHolds = new Stack<>();
    private MoOnEmptyOnHoldsListener onEmptyOnHoldsListener = ()->{};
    private boolean putOnHold = false;


    public MoListViewSync(MoListViews ... v){
        this.views = Arrays.asList(v);
        MoViewUtils.sync(this,this.views);
    }

    public MoOnEmptyOnHoldsListener getOnEmptyOnHoldsListener() {
        return onEmptyOnHoldsListener;
    }

    public MoListViewSync setOnEmptyOnHoldsListener(MoOnEmptyOnHoldsListener onEmptyOnHoldsListener) {
        this.onEmptyOnHoldsListener = onEmptyOnHoldsListener;
        return this;
    }

    public List<View> getSharedElements() {
        return sharedElements;
    }

    public MoListViewSync setSharedElements(List<View> sharedElements) {
        this.sharedElements = sharedElements;
        return this;
    }

    public MoListViewSync setSharedElements(View ... v){
        sharedElements.addAll(Arrays.asList(v));
        return this;
    }

    public List<MoListViews> getViews() {
        return views;
    }

    public MoListViewSync setViews(List<MoListViews> views) {
        this.views = views;
        return this;
    }

    public Stack<MoListViews> getInActions() {
        return inActions;
    }

    public MoListViewSync setInActions(Stack<MoListViews> inActions) {
        this.inActions = inActions;
        return this;
    }

    public Stack<MoListViews> getOnHolds() {
        return onHolds;
    }

    public MoListViewSync setOnHolds(Stack<MoListViews> onHolds) {
        this.onHolds = onHolds;
        return this;
    }

    public boolean isPutOnHold() {
        return putOnHold;
    }

    public MoListViewSync setPutOnHold(boolean putOnHold) {
        this.putOnHold = putOnHold;
        return this;
    }

    /**
     * returns true if it has a
     * list view in action
     * @return
     */
    public boolean hasAction(){
        if(this.putOnHold){
            return !this.onHolds.isEmpty();
        }
        return !inActions.isEmpty();
    }

    /**
     * removes the top in action one
     * and makes it so that it doesn't have
     * action anymore
     */
    public void removeAction(){
        if(hasAction()){
            if(putOnHold){
                onHolds.pop().removeAction();
                releaseNextOnHold();
                showSharedElementsIf(onHolds.isEmpty());
            }else{
                inActions.pop().removeAction();
                showSharedElementsIf(inActions.isEmpty());
            }
        }
    }

    /**
     * releases the next on hold item
     * or calls empty on hold if there is no
     * more of them
     */
    public void releaseNextOnHold() {
        if (!onHolds.isEmpty()) {
            // we have an on hold item
            onHolds.peek().releaseOnHold();
        }else{
            // then we do not have anymore on holds
            onEmptyOnHoldsListener.onEmptyOnHolds();
        }
    }

    /**
     * when they are going to activate v
     * @param v
     */
    public void goingToActivate(MoListViews v){
        if(putOnHold){
            // put all the items inside the on hold stack on hold
            MoViewUtils.goOnHold(onHolds);
            hideSharedElementsIf(onHolds.isEmpty());
            onHolds.push(v);
        }else{
            // call remove action on all the items inside
            MoViewUtils.closeActions(this.inActions);
            hideSharedElementsIf(inActions.isEmpty());
            inActions.clear();
            inActions.push(v);
        }
    }

    public void goingToDeactivate(MoListViews v){
        if(this.putOnHold){
            // release the next one

        }
    }


    private void hideSharedElementsIf(boolean condition){
        if(condition){
            MoViewUtils.apply(null,this.sharedElements,View.GONE,MoAnimation.FADE_OUT);
        }
    }

    private void showSharedElementsIf(boolean condition){
        if(condition){
            MoViewUtils.apply(null,this.sharedElements,View.VISIBLE,MoAnimation.FADE_IN);
        }
    }

    /**
     * runs the runnable if no more on holds exist
     * @param r
     */
    public void runIfEmptyOnHolds(Runnable r){
        if(onHolds.isEmpty()){
            r.run();
        }
    }

    /**
     * runs the runnable if no more in actions exist
     * @param r
     */
    public void runIfEmptyActions(Runnable r){
        if(inActions.isEmpty()){
            r.run();
        }
    }


}
