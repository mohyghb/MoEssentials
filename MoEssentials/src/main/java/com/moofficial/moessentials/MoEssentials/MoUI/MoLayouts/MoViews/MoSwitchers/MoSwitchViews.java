package com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoSwitchers;

import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoUI.MoLayouts.MoViews.MoOnAddToLayoutListener;

import java.util.ArrayList;
import java.util.Arrays;

// you can have many views and only one is active,
// which means one's visibility is set to visible and the rest
// are set to gone
public class MoSwitchViews {


    private View activeView;
    private ArrayList<View> views = new ArrayList<>();

    /**
     * all the views that this class is switching
     * between them
     * @param vs
     * @return
     */
    public MoSwitchViews addViews(View ... vs){
        views.addAll(Arrays.asList(vs));
        return this;
    }

    public View getActiveView() {
        return activeView;
    }

    public MoSwitchViews setActiveView(View activeView) {
        this.activeView = activeView;
        return this;
    }

    public ArrayList<View> getViews() {
        return views;
    }

    public MoSwitchViews setViews(ArrayList<View> views) {
        this.views = views;
        return this;
    }

    private void activate(View v){
        if(activeView!=null){
            activeView.setVisibility(View.GONE);
        }
        activeView = v;
        activeView.setVisibility(View.VISIBLE);
    }



    // initially setting all the view's visibility
    // to gone
    public MoSwitchViews build(MoOnAddToLayoutListener l){
        turnAllOff();
        activate(activeView);
        addViewsToLayout(l);
        return this;
    }

    private void addViewsToLayout(MoOnAddToLayoutListener l) {
        if(l==null)
            return;
        for(View v: views){
            l.addToLayout(v);
        }
    }

    private void turnAllOff() {
        for(View v:views){
            v.setVisibility(View.GONE);
        }
    }

}
