package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import android.view.View;
import android.widget.TextView;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewBuilder.MoCardBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoAppbar.MoAppbarUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoWrapperFloatingActionButton;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoWrapperLinearLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers.MoWrapperToolbar;
import com.moofficial.moessentials.R;


// basic activity with title,subtitle, 3 linear layouts
public abstract class MoBasicActivity extends MoActivity {


    protected TextView title,subtitle;
    protected MoWrapperLinearLayout linearNested,linearBottom,linearTop;
    protected AppBarLayout appBarLayout;
    protected MoWrapperToolbar toolbar;
    protected CollapsingToolbarLayout collapsingToolbarLayout;
    protected CoordinatorLayout coordinatorLayout;
    protected ConstraintLayout rootView;
    protected CardView cardView,innerCardView;
    protected MoWrapperFloatingActionButton floatingActionButton;
    protected NestedScrollView nestedScrollView;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_mo_basic;
    }

    @Override
    protected void onCreate() {
        title = findViewById(R.id.mo_lib_title);
        subtitle = findViewById(R.id.mo_lib_subtitle);
        linearNested = new MoWrapperLinearLayout(this,findViewById(R.id.basic_activity_linear_nested_layout));
        linearBottom = new MoWrapperLinearLayout(this,findViewById(R.id.basic_activity_linear_bottom_layout));
        linearTop = new MoWrapperLinearLayout(this,findViewById(R.id.basic_activity_linear_top_layout));
        appBarLayout = findViewById(R.id.basic_activity_appbar);
        toolbar = new MoWrapperToolbar(this,findViewById(R.id.basic_activity_toolbar));
        coordinatorLayout = findViewById(R.id.basic_activity_coordinator_layout);
        collapsingToolbarLayout = findViewById(R.id.basic_activity_collapsing_toolbar);
        rootView = findViewById(R.id.basic_activity_root);
        cardView = findViewById(R.id.basic_activity_card_view);
        innerCardView = findViewById(R.id.basic_activity_inner_card_view);
        nestedScrollView = findViewById(R.id.basic_activity_nested_scroll_view);
        floatingActionButton = new MoWrapperFloatingActionButton(this,
                findViewById(R.id.basic_activity_floating_action_button));
        floatingActionButton.hide();
    }


    @Override
    protected View getRootView() {
        return rootView;
    }


    // card view
    public void setRadius(float r){
        cardView.setRadius(r);
        innerCardView.setRadius(r);
    }

    public void makeActivityRound(){
        cardView.setRadius((float)getResources().getDimension(R.dimen.mo_style_card_corner));
        innerCardView.setRadius((float)getResources().getDimension(R.dimen.mo_style_card_corner));
    }

    public void makeActivityRectangular(){
        cardView.setRadius(0f);
        innerCardView.setRadius(0f);
    }

    public void customizeCards(MoCardBuilder c){
        customizeOuterCard(c);
        customizeInnerCard(c);
    }

    public void customizeInnerCard(MoCardBuilder c){
        c.build(innerCardView);
    }

    public void customizeOuterCard(MoCardBuilder c){
        c.build(cardView);
    }




    // set title text

    public void setTitle(int rid){
        this.title.setText(getString(rid));
    }

    public void setTitle(String t){
        this.title.setText(t);
    }

    // set subtitle text

    public void setSubTitle(int rid){
        setSubTitle(getString(rid));
    }

    public void setSubTitle(String t){
        this.subtitle.setText(t);
    }



    public void syncTitle(TextView ... tv){
        MoAppbarUtils.sync(appBarLayout,
                collapsingToolbarLayout,
                title,
                tv);
    }






}