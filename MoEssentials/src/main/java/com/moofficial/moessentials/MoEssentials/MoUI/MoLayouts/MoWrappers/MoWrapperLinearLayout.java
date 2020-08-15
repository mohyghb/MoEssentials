package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;

import static com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoLinearLayoutUtils.addToLinearLayout;

public class MoWrapperLinearLayout extends MoWrapper<LinearLayout> {




    public MoWrapperLinearLayout(Context c, LinearLayout l){
        super(c,l);
    }



    public View addView(int rid){
        return addView(MoInflaterView.inflate(rid,this.context));
    }

    public View addView(View v){
        return addView(v,null);
    }

    public void addViews(View ... views){
        addViews(null,views);
    }

    public void addViews(LinearLayout.LayoutParams lp,View ... views){
        for(View v:views){
            addView(v,lp);
        }
    }

    public View addView(View v,LinearLayout.LayoutParams lp){
        addToLinearLayout(wrappedElement,v,lp);
        return v;
    }

    public LinearLayout getLinearLayout() {
        return wrappedElement;
    }

    public MoWrapperLinearLayout setLinearLayout(LinearLayout linearLayout) {
        this.wrappedElement = linearLayout;
        return this;
    }

    public Context getContext() {
        return context;
    }

    public MoWrapperLinearLayout setContext(Context context) {
        this.context = context;
        return this;
    }

    @Override
    public LinearLayout getView() {
        return wrappedElement;
    }
}
