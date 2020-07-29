package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoWrappers;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;

import static com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViewGroupUtils.MoLinearLayoutUtils.addToLinearLayout;

public class MoWrapperLinearLayout extends MoWrapper {

    private LinearLayout linearLayout;


    public MoWrapperLinearLayout(Context c, LinearLayout l){
        super(c);
        this.linearLayout = l;
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
        addToLinearLayout(linearLayout,v,lp);
        return v;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public MoWrapperLinearLayout setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
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
    public View getView() {
        return linearLayout;
    }
}
