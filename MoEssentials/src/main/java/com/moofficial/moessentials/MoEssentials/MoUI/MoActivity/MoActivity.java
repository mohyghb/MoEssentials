package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoActivitySettings.MoActivitySettings;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDialog.MoProgressDialog.MoProgressDialog;

public abstract class MoActivity extends AppCompatActivity {



    protected MoActivitySettings activitySettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the content view of the activity
        setTheContentView();
        // set activity settings
        activitySettings = getActivitySettings();
        // call the on create inside the activity
        initViews();
        // init other things that you want
        init();
    }


    /**
     * init the class variables and fields
     * this is called from the on create of the activity
     * method
     * you should be creating anything you want here
     */
    protected abstract void init();

    /**
     *
     * @return the root view of the current activity
     */
    protected abstract View getRootView();

    /**
     *
     * @return the group root view of this activity
     */
    protected ViewGroup getGroupRootView(){
        return (ViewGroup) getRootView();
    }

    /**
     * this is called when the activity should init its
     * views, anything like findViewById should go inside
     * here
     */
    protected abstract void initViews();


    /**
     * set the layout that you will be using inside this activity
     * just call setContentView and pass in the
     * layout id or view that you want to use
     */
    protected abstract void setTheContentView();

    /**
     * returns a MoActivity dimensions which is
     * used to init certain parts of the app using the
     * dimension that is provided
     */
    protected abstract MoActivitySettings getActivitySettings();



    /**
     *
     * @return height of the screen in current mode
     *         in pixels
     */
    public int getHeightPixels(){
        return getResources().getDisplayMetrics().heightPixels;
    }

    /**
     *
     * @return width of the screen in current mode
     *         in pixels
     */
    public int getWidthPixels(){
        return getResources().getDisplayMetrics().widthPixels;
    }




    public Activity getActivity() {
        return this;
    }

    public Context getContext() {
        return this;
    }


}
