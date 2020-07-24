package com.moofficial.moessentials.MoEssentials.MoUI.MoViews;

public class MoListViewSync {

    public static final int NO_ACTION = -1;

    private MoListViews[] views;
    private int indexOfAction;

    public MoListViewSync(MoListViews ... v){
        this.views = v;
        MoViewUtils.sync(this.views);
    }


    public boolean hasAction(){
        this.indexOfAction = MoViewUtils.firstAction(this.views);
        return this.indexOfAction != NO_ACTION;
    }

    public void removeAction(){
        if(this.indexOfAction != NO_ACTION){
            views[this.indexOfAction].removeAction();
            this.indexOfAction = MoViewUtils.firstAction(this.views);
        }
    }

}
