package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoWindow;

import android.app.Activity;
import android.view.WindowManager;

public class MoSoftInputBuilder {

    private int mode;
    private Activity activity;

    public MoSoftInputBuilder(Activity a){
        this.activity = a;
    }


    public MoSoftInputBuilder adjustResizeSoftInput(){
        mode = mode | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
        return this;
    }

    public MoSoftInputBuilder adjustPanSoftInput(){
        mode = mode | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
        return this;
    }

    public MoSoftInputBuilder softInputAlwaysVisible(){
        mode = mode | WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE;
        return this;
    }

    public MoSoftInputBuilder softInputAlwaysHidden(){
        mode = mode | WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN;
        return this;
    }

    public MoSoftInputBuilder build(){
        this.activity.getWindow().setSoftInputMode(mode);
        return this;
    }



//    /**
//     * sets the activity soft input mode
//     * to s
//     * @param a
//     * @param s
//     */
//    public void setSoftInput(Activity a,int s){
//        a.getWindow().setSoftInputMode(s);
//    }

}
