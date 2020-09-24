package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoMenuBuilder;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoPaddingBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoTextViewBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoViewBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoViewUtils;

import java.util.ArrayList;
import java.util.List;

// a class to make multiple views and
// put them inside a list of views
public class MoMenuBuilder extends MoContext {

    private List<View> views = new ArrayList<>();
    // this is ran on every click listener (for every menu item)
    private Runnable runOnAllClicks = ()->{};
    private MoPaddingBuilder paddingBuilder;

    public MoMenuBuilder(Context c) {
        super(c);
    }

    /**
     * this is all the final work that needs
     * to be done and finally add the view to the
     * list
     * @return this for nested calling
     */
    private MoMenuBuilder setup(View v, View.OnClickListener l) {
        v.setOnClickListener(v1 -> {
            // call the specific view listener
            l.onClick(v1);
            // also call the all click listener
            runOnAllClicks.run();
        });
        // make the view ripple on click
        MoViewUtils.rippleOnClick(context,v);
        // add to list
        views.add(v);
        return this;
    }

    /**
     * builds a text view with
     * the text that is passed as the primary
     * text and click listener
     * @param text of menu item
     * @param l click listener for menu item
     * @return this for nested calling
     */
    public MoMenuBuilder with(String text, View.OnClickListener l) {
        TextView tv = new TextView(context);
        new MoTextViewBuilder(context).setText(text).build(tv);
        return setup(tv,l);
    }

    /**
     * builds a text view with
     * the text that is passed as the primary
     * text and click listener
     * @param id of text
     * @param l click listener for menu item
     * @return this for nested calling
     */
    public MoMenuBuilder with(@StringRes int id, View.OnClickListener l) {
        return this.with(getString(id),l);
    }


    /**
     * builds a text view with
     * the text that is passed as the primary
     * text and click listener
     * @param text of menu item
     * @param l click listener for menu item
     * @param left puts this drawable to the left of the text
     * @return this for nested calling
     */
    public MoMenuBuilder with(String text, Drawable left, View.OnClickListener l) {
        TextView tv = new TextView(context);
        new MoTextViewBuilder(context)
                .setText(text)
                .setLeftIcon(left)
                .build(tv);
        // construction
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setCompoundDrawablePadding(24);
        return setup(tv,l);
    }

    /**
     * builds a text view with
     * the text that is passed as the primary
     * text and click listener
     * @param text id of the text of menu item
     * @param l click listener for menu item
     * @param left puts this drawable to the left of the text
     * @return this for nested calling
     */
    public MoMenuBuilder with(@StringRes int text, Drawable left, View.OnClickListener l) {
        return with(getString(text),left,l);
    }




    /**
     * builds a text view with
     * the text that is passed as the primary
     * text and click listener
     * @param text id of the text of menu item
     * @param l click listener for menu item
     * @param left puts this drawable to the left of the text
     * @return this for nested calling
     */
    public MoMenuBuilder with(@StringRes int text, @DrawableRes int left, View.OnClickListener l) {
        return with(getString(text),getDrawable(left),l);
    }

    /**
     * runs this runnable
     * whenever an item from the list
     * view is clicked
     * @param runOnAllClicks the runnable to run on every view click
     * @return this for nested calling
     */
    public MoMenuBuilder allWith(Runnable runOnAllClicks) {
        this.runOnAllClicks = runOnAllClicks;
        return this;
    }

    /**
     * padding in dp for all the
     * views inside the list
     * @param padding of every item in the list
     * @return this for nested calling
     */
    public MoMenuBuilder allWith(int padding) {
        paddingBuilder = new MoPaddingBuilder(padding).convertValuesToDp();
        return this;
    }

    /**
     * padding in dp for every
     * view inside the list
     * @param left padding
     * @param top padding
     * @param right padding
     * @param bottom padding
     * @return this for nested calling
     */
    public MoMenuBuilder allWith(int left,int top,int right, int bottom) {
        this.paddingBuilder = new MoPaddingBuilder(left, top, right, bottom).convertValuesToDp();
        return this;
    }


    /**
     * adds the padding to every view
     * @return this for nested calling
     */
    public MoMenuBuilder build() {
        applyPadding();
        return this;
    }

    /**
     * applies padding for all the
     * views if padding is not null
     */
    private void applyPadding() {
        if(paddingBuilder != null) {
            for (View v: views) {
                paddingBuilder.apply(v);
            }
        }
    }

    /**
     * returns this list of views
     * as array
     * @return views that have been added
     */
    public View[] asArray() {
        View[] array = new View[views.size()];
        views.toArray(array);
        return array;
    }

    /**
     *
     * @return list of views that have been built
     */
    public List<View> asList() {
        return views;
    }

}
