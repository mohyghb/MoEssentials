package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoActivitySettings.MoActivitySettings;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoBasicLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoCardBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoAppbar.MoAppbarUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoViewGroupUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoSwitchers.MoSwitchViews;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperFloatingActionButton;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperLinearLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperToolbar;
import com.moofficial.moessentials.R;


// basic activity with title,subtitle, 3 linear layouts
public abstract class MoBasicActivity extends MoActivity {


    protected MoBasicLayout l;

    @Override
    protected void setTheContentView() {
        l = new MoBasicLayout(this);
        setContentView(l);
    }

    @Override
    protected void initViews() {
        // this is already done inside the basic layout
        // ignore
    }


    @Override
    protected View getRootView() {
        return l.rootView;
    }

    @Override
    protected MoActivitySettings getActivitySettings() {
        return MoActivitySettings.UD;
    }



    public void makeNestedScrollTransparent(){
       l.makeNestedScrollTransparent();
    }

    public void showNestedScrollBackground(){
        l.showNestedScrollBackground();
    }



    // set title text

    public void setTitle(int rid){
        l.setTitle(getString(rid));
    }

    public void setTitle(String t){
        l.setTitle(t);
    }

    public void setTitleSize(float size){
        l.setTitleSize(size);
    }



    // set subtitle text

    public void setSubTitle(int rid) {
        l.setSubTitle(getString(rid));
    }

    public void setSubTitle(String t){
        l.setSubTitle(t);
    }



    /**
     * syncs the title between app bar layout
     * and the text views that are passed
     * @param tv
     */
    public void syncTitle(TextView ... tv){
        l.syncTitle(tv);
    }

    /**
     * removes the toolbar from activity
     */
    public void noToolbarNeeded() {
        l.noToolbarNeeded();
    }



    /**
     * snaps the app bar
     */
    public void snapAppbar(){
        l.snapAppbar();
    }


    /**
     * adds multiple toolbars to the main toolbar
     * and only turns the active one on
     * and the rest are GONE
     * @param active
     * @param views
     */
    public void setupMultipleToolbars(View active,View ... views) {
        l.setupMultipleToolbars(active,views);
    }


    /**
     * changes the app bar layout by considering
     * the heights of other view groups as well
     * now has the ability to
     * change the app bar layout as we continue to add
     * or remove things from toolbar
     * @param considerTheseHeights
     */
    public void onAppbarLayoutHeightChanged(float r,ViewGroup... considerTheseHeights){
        l.onAppbarLayoutHeightChanged(r,considerTheseHeights);
    }



}