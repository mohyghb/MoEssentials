package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public abstract class MoActivity extends AppCompatActivity {


    protected Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.savedInstanceState = savedInstanceState;
        setContentView(getLayoutResId());
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

}
