package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.R;

public class MoBasicActivity extends MoActivity {


    private TextView title,subtitle;
    private LinearLayout linearNested,linearBottom;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private CoordinatorLayout coordinatorLayout;
    private ConstraintLayout rootView;



    @Override
    protected int getLayoutResId() {
        return R.layout.activity_mo_basic;
    }

    @Override
    protected void init() {
        title = findViewById(R.id.mo_lib_title);
        subtitle = findViewById(R.id.mo_lib_subtitle);
        linearNested = findViewById(R.id.basic_activity_linear_nested_layout);
        linearBottom = findViewById(R.id.basic_activity_linear_bottom_layout);
        appBarLayout = findViewById(R.id.basic_activity_appbar);
        toolbar = findViewById(R.id.basic_activity_toolbar);
        coordinatorLayout = findViewById(R.id.basic_activity_coordinator_layout);
        collapsingToolbarLayout = findViewById(R.id.basic_activity_collapsing_toolbar);
        rootView = findViewById(R.id.basic_activity_root);
    }


    @Override
    protected View getRootView() {
        return rootView;
    }


    public void addToolbar(int rId){
        addToolbar(MoInflaterView.inflate(rId,this));
    }

    public void addToolbar(View v){
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.addView(v,layoutParams);
    }



}