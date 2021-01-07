package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoActivity.MoBasicActivity;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoCardBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoAppbar.MoAppbarUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroupUtils.MoViewGroupUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewGroups.MoConstraint;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoNormal.MoCardView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoSwitchers.MoSwitchViews;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperFloatingActionButton;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperLinearLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperToolbar;
import com.moofficial.moessentials.R;

// holds all the views inside my basic layout
// so this layout can be used for both activity and fragment
@SuppressWarnings("UnusedReturnValue")
public class MoBasicLayout extends MoConstraint {

    public TextView title;
    public TextView subtitle;
    public MoWrapperLinearLayout linearNested;
    public MoWrapperLinearLayout linearBottom;
    public AppBarLayout appBarLayout;
    public MoWrapperToolbar toolbar;
    public CollapsingToolbarLayout collapsingToolbarLayout;
    public CoordinatorLayout coordinatorLayout;
    public ConstraintLayout rootView;
    public MoWrapperFloatingActionButton floatingActionButton;
    public NestedScrollView nestedScrollView;

    public MoBasicLayout(Context context) {
        super(context);
    }

    public MoBasicLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MoBasicLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public int getLayoutId() {
        return R.layout.mo_basic_layout;
    }

    @Override
    public void initViews() {
        title = findViewById(R.id.mo_lib_title);
        subtitle = findViewById(R.id.mo_lib_subtitle);
        linearNested = new MoWrapperLinearLayout(findViewById(R.id.basic_activity_linear_nested_layout));
        linearBottom = new MoWrapperLinearLayout( findViewById(R.id.basic_activity_linear_bottom_layout));
        appBarLayout = findViewById(R.id.basic_activity_appbar);
        toolbar = new MoWrapperToolbar( findViewById(R.id.basic_activity_toolbar)
                , findViewById(R.id.basic_activity_toolbar_linear_layout));
        coordinatorLayout = findViewById(R.id.basic_activity_coordinator_layout);
        collapsingToolbarLayout = findViewById(R.id.basic_activity_collapsing_toolbar);
        rootView = findViewById(R.id.basic_activity_root);
        nestedScrollView = findViewById(R.id.basic_activity_nested_scroll_view);
        floatingActionButton = new MoWrapperFloatingActionButton(findViewById(R.id.basic_activity_floating_action_button));
        floatingActionButton.hide();
    }

    @Override
    public int[] getAttrs() {
        return new int[0];
    }

    // mo helper methods


    public ViewGroup getRootGroupView() {
        return rootView;
    }

    public View getRootView() {
        return rootView;
    }


    public MoBasicLayout makeNestedScrollTransparent(){
        nestedScrollView.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.transparent));
        return this;
    }

    public MoBasicLayout showNestedScrollBackground(){
        nestedScrollView.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.mo_rounded_background));
        return this;
    }



    // set title text
    public MoBasicLayout setTitle(int rid){
        setTitle(getContext().getString(rid));
        return this;
    }

    public MoBasicLayout setTitle(String t){
        title.setText(t);
        return this;
    }

    public MoBasicLayout setTitleSize(float size){
        this.title.setTextSize(size);
        return this;
    }

    public MoBasicLayout makeTitleFadingEdge(){
        this.title.setSingleLine(true);
        this.title.setFadingEdgeLength(MoDynamicUnit.convertDpToPixels(getContext(),80f));
        this.title.setHorizontalFadingEdgeEnabled(true);
        return this;
    }

    public MoBasicLayout setTitleSingleLine(boolean b){
        this.title.setSingleLine(b);
        return this;
    }




    // set subtitle text

    public MoBasicLayout setSubTitle(int rid){
        setSubTitle(getContext().getString(rid));
        return this;
    }

    public MoBasicLayout setSubTitle(String t){
        subtitle.setText(t);
        return this;
    }

    public MoBasicLayout setSubTitleSize(float size){
        this.subtitle.setTextSize(size);
        return this;
    }

    public MoBasicLayout setSubTitleSingleLine(boolean b){
        this.subtitle.setSingleLine(b);
        return this;
    }


    /**
     * syncs the title between app bar layout
     * and the text views that are passed
     * @param tv
     */
    public MoBasicLayout syncTitle(TextView ... tv){
        MoAppbarUtils.sync(appBarLayout,
                collapsingToolbarLayout,
                title,
                tv);
        return this;
    }

    /**
     * removes the toolbar from activity
     */
    public MoBasicLayout noToolbarNeeded(){
        MoAppbarUtils.noToolbar(this.collapsingToolbarLayout);
        return this;
    }




    /**
     * snaps the app bar
     */
    public MoBasicLayout snapAppbar(){
        MoAppbarUtils.snapWithToolbar(collapsingToolbarLayout);
        return this;
    }


    /**
     * adds multiple toolbars to the main toolbar
     * and only turns the active one on
     * and the rest are GONE
     * @param active
     * @param views
     */
    public MoBasicLayout setupMultipleToolbars(View active,View ... views){
        new MoSwitchViews().addViews(views).setActiveView(active).build(v -> toolbar.addToolbar(v));
        return this;
    }

    /**
     * removes all the elements that are used
     * inside the nested scroll view including
     * the nested scroll view
     * @return this (builder)
     */
    public MoBasicLayout removeNestedScrollView() {
        coordinatorLayout.removeView(nestedScrollView);
        nestedScrollView = null;
        linearNested = null;
        return this;
    }

    /**
     * changes the app bar layout by considering
     * the heights of other view groups as well
     * now has the ability to
     * change the app bar layout as we continue to add
     * or remove things from toolbar
     * @param considerTheseHeights
     */
    public MoBasicLayout onAppbarLayoutHeightChanged(float ratio,ViewGroup... considerTheseHeights){
        float heightDp = (float) getContext().getResources().getDisplayMetrics().heightPixels /
                ratio;
        CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams)appBarLayout.getLayoutParams();
        lp.height = (int)heightDp + MoViewGroupUtils.getMeasuredHeight(considerTheseHeights);
        appBarLayout.setLayoutParams(lp);
        return this;
    }


    public ViewGroup getGroupRootView() {
        return this.rootView;
    }



}