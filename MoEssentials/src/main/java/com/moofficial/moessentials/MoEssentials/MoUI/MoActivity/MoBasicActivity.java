package com.moofficial.moessentials.MoEssentials.MoUI.MoActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoLinearLayoutUtils;
import com.moofficial.moessentials.R;

import java.util.HashMap;

import static com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoLinearLayoutUtils.addToLinearLayout;

public abstract class MoBasicActivity extends MoActivity {


    protected TextView title,subtitle;
    protected LinearLayout linearNested,linearBottom,linearTop;
    protected AppBarLayout appBarLayout;
    protected Toolbar toolbar;
    protected CollapsingToolbarLayout collapsingToolbarLayout;
    protected CoordinatorLayout coordinatorLayout;
    protected ConstraintLayout rootView;
    protected CardView cardView;
    protected HashMap<Integer,Integer> idMap = new HashMap<>();


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_mo_basic;
    }

    @Override
    protected void onCreate() {
        title = findViewById(R.id.mo_lib_title);
        subtitle = findViewById(R.id.mo_lib_subtitle);
        linearNested = findViewById(R.id.basic_activity_linear_nested_layout);
        linearBottom = findViewById(R.id.basic_activity_linear_bottom_layout);
        linearTop = findViewById(R.id.basic_activity_linear_top_layout);
        appBarLayout = findViewById(R.id.basic_activity_appbar);
        toolbar = findViewById(R.id.basic_activity_toolbar);
        coordinatorLayout = findViewById(R.id.basic_activity_coordinator_layout);
        collapsingToolbarLayout = findViewById(R.id.basic_activity_collapsing_toolbar);
        rootView = findViewById(R.id.basic_activity_root);
        cardView = findViewById(R.id.basic_activity_card_view);
    }


    @Override
    protected View getRootView() {
        return rootView;
    }


    // card view
    public void setRadius(float r){
        cardView.setRadius(r);
    }

    public void makeActivityRound(){
        cardView.setRadius((float)getResources().getDimension(R.dimen.mo_style_card_corner));
    }

    public void makeActivityRectangular(){
        cardView.setRadius(0f);
    }


//    // TODO does not work
//    public void setBackgroundColor(int colorId){
//
//        cardView.setBackgroundColor(getColor(colorId));
//        cardView.setCardBackgroundColor(getColor(colorId));
//    }


    protected void addId(View v,int baseId){
        idMap.put(baseId,v.getId());
    }


    // add toolbar view

    public void addToolbar(int rId){
        View v = MoInflaterView.inflate(rId,this);
        addToolbar(v);
        addId(v,rId);
    }

    public void addToolbar(View v){
        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        toolbar.addView(v,layoutParams);
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


    // add to nested linear layout

    public void addToNestedLinearLayout(int rid){
        View v = MoInflaterView.inflate(rid,this);
        addToNestedLinearLayout(v);
        addId(v,rid);
    }

    public void addToNestedLinearLayout(View v){
        addToNestedLinearLayout(v,null);
    }

    public void addToNestedLinearLayout(View v,LinearLayout.LayoutParams lp){
        addToLinearLayout(linearNested,v,lp);
    }


    // add to bottom linear layout

    public void addToBottomLinearLayout(int rid){
        View v = MoInflaterView.inflate(rid,this);
        addToBottomLinearLayout(v);
        addId(v,rid);
    }

    public void addToBottomLinearLayout(View v){
        addToBottomLinearLayout(v,null);
    }

    public void addToBottomLinearLayout(View v,LinearLayout.LayoutParams lp){
        addToLinearLayout(linearBottom,v,lp);
    }




    @SuppressWarnings("ConstantConditions")
    public int getId(int id){
        return idMap.get(id);
    }





}