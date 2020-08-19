package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoActivitySettings.MoActivitySettings;

public abstract class MoActivity extends AppCompatActivity {


    protected Bundle savedInstanceState;
    protected MoActivitySettings activitySettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(getLayoutResId());

        // set activity settings
        activitySettings = getActivitySettings();
        // call the on create inside the activity
        onCreate();
        // init other things that you want
        init();
    }

    /**
     *
     * this is used to set the content
     * view inside the onCreate method
     * @return the resource id of the layout
     */
    protected abstract int getLayoutResId();

    /**
     * init the class variables and fields
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
     * this is called when the activity was successfully created and ready to go
     */
    protected abstract void onCreate();


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







}
