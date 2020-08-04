package com.moofficial.moessentials.MoEssentials.MoUI.MoViews;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MoListViewSync {

    public static final int NO_ACTION = -1;

    private List<MoListViews> views;
    private Stack<MoListViews> inActions = new Stack<>();
    // the item on top of the stack is the one active
    private Stack<MoListViews> onHolds = new Stack<>();
    private boolean putOnHold = false;


    public MoListViewSync(MoListViews ... v){
        this.views = Arrays.asList(v);
        MoViewUtils.sync(this,this.views);
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
            goingToDeactivate();
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
            onHolds.push(v);
        }else{
            // call remove action on all the items inside
            MoViewUtils.closeActions(this.inActions);
            inActions.push(v);
        }
    }

    /**
     * going to pop the top of on holds
     * and release on hold on the next item
     */
    public void goingToDeactivate(){
        if(putOnHold){
            onHolds.pop().removeAction();
            if(!onHolds.isEmpty()){
                onHolds.peek().releaseOnHold();
            }
        }else{
            inActions.pop().removeAction();
        }
    }


}
