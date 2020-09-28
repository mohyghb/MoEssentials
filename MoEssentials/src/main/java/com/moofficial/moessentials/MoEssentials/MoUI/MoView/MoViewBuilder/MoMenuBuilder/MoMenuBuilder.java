package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoMenuBuilder;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.util.Pair;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoPaddingBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoTextViewBuilder;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoViewUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoWrappers.MoWrapperLinearLayout;
import com.moofficial.moessentials.R;

import java.util.ArrayList;
import java.util.List;

// a class to make multiple views and
// put them inside a list of views
public class MoMenuBuilder extends MoContext {

    private List<Pair<View,View.OnClickListener>> pairs = new ArrayList<>();
    private List<View> views = new ArrayList<>();
    // this is ran on every click listener (for every menu item)
    private View.OnClickListener runOnAllClicks = (v)->{};
    private MoPaddingBuilder paddingBuilder;
    private MoPaddingBuilder textPadding, iconPadding;

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
        // make the view ripple on click
        MoViewUtils.rippleOnClick(context,v);
        pairs.add(new Pair<>(v, l));
        views.add(v);
        return this;
    }

    /**
     * this is all the final work that needs
     * to be done and finally add the view to the
     * list
     * @return this for nested calling
     */
    private MoMenuBuilder setup(List<View> views, View.OnClickListener l) {
        for (View v: views) {
            setup(v,l);
        }
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
    public MoMenuBuilder text(String text, View.OnClickListener l) {
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
    public MoMenuBuilder text(@StringRes int id, View.OnClickListener l) {
        return this.text(getString(id),l);
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
    public MoMenuBuilder text(String text, Drawable left, View.OnClickListener l) {
        TextView tv = new TextView(context);
        new MoTextViewBuilder(context)
                .setText(text)
                .setLeftIcon(left)
                .build(tv);
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
    public MoMenuBuilder text(@StringRes int text, Drawable left, View.OnClickListener l) {
        return text(getString(text),left,l);
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
    public MoMenuBuilder text(@StringRes int text, @DrawableRes int left, View.OnClickListener l) {
        return text(getString(text),getDrawable(left),l);
    }


    /**
     * creates an icon button and
     * adds it to the list
     * @param drawable for icon button
     * @param clickListener of icon button
     * @return this for nested calling
     */
    public MoMenuBuilder icon(@DrawableRes int drawable, View.OnClickListener clickListener) {
        return icon(getDrawable(drawable),clickListener);
    }


    /**
     * creates an icon button and
     * adds it to the list
     * @param drawable for icon button
     * @param clickListener of icon button
     * @return this for nested calling
     */
    public MoMenuBuilder icon(Drawable drawable, View.OnClickListener clickListener) {
        ImageButton imageButton = new ImageButton(context);
        imageButton.setImageDrawable(drawable);
        imageButton.setCropToPadding(true);

        return setup(imageButton,clickListener);
    }


    /**
     * creates a row and lets the developer
     * to populate the row
     * adjusts the items inside the row to fill the
     * entier layout
     * @param rowBuilder populate the horizontal linear layout
     * @return this for nested calling
     */
    public MoMenuBuilder rowFill(MoMenuRowBuilder rowBuilder) {
        MoMenuBuilder builder = new MoMenuBuilder(this.context);
        // calling the code on developer side to build the row
        rowBuilder.buildRow(builder);
        List<View> toAdd = builder.asList();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        params.weight = 1f;
        params.gravity = Gravity.CENTER;
        LinearLayout horizontalGroup = new MoWrapperLinearLayout(new LinearLayout(context))
                .setOrientation(LinearLayoutCompat.HORIZONTAL)
                .setWeightSum(toAdd.size())
                .addViews(params,toAdd)
                .getLinearLayout();
        // add the horizontal bar once
        this.views.add(horizontalGroup);
        // add all the pairs since build also matters
        this.pairs.addAll(builder.asPairs());
        return this;
    }


    /**
     * runs this runnable
     * whenever an item from the list
     * view is clicked
     * @param runOnAllClicks the global click listener to run on every view click
     * @return this for nested calling
     */
    public MoMenuBuilder allWith(View.OnClickListener runOnAllClicks) {
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
     * padding in dp for all TEXT views the
     * views inside the list
     * @param padding of every item in the list
     * @return this for nested calling
     */
    public MoMenuBuilder textsWith(int padding) {
        textPadding = new MoPaddingBuilder(padding).convertValuesToDp();
        return this;
    }

    /**
     * padding in dp for every TEXT
     * view inside the list
     * @param left padding
     * @param top padding
     * @param right padding
     * @param bottom padding
     * @return this for nested calling
     */
    public MoMenuBuilder textsWith(int left,int top,int right, int bottom) {
        this.textPadding = new MoPaddingBuilder(left, top, right, bottom).convertValuesToDp();
        return this;
    }


    /**
     * padding in dp for all ICON views the
     * views inside the list
     * @param padding of every item in the list
     * @return this for nested calling
     */
    public MoMenuBuilder iconsWith(int padding) {
        iconPadding = new MoPaddingBuilder(padding).convertValuesToDp();
        return this;
    }

    /**
     * padding in dp for every ICON
     * view inside the list
     * @param left padding
     * @param top padding
     * @param right padding
     * @param bottom padding
     * @return this for nested calling
     */
    public MoMenuBuilder iconsWith(int left,int top,int right, int bottom) {
        this.iconPadding = new MoPaddingBuilder(left, top, right, bottom).convertValuesToDp();
        return this;
    }



    /**
     * adds the padding to every view
     * @return this for nested calling
     */
    public MoMenuBuilder build() {
        for (Pair<View, View.OnClickListener> p : pairs) {
            applyPadding(p.first);
            addOnClickListener(p);
        }
        return this;
    }

    /**
     * adds on click listener to the pair
     * of view and view on click listener
     * on click listener of the view will be equal
     * to = p.second + runOnAllClicks
     * @param p pair to add on click listener for
     */
    private void addOnClickListener(Pair<View, View.OnClickListener> p) {
        if (p.first != null) {
            // on click listener
            p.first.setOnClickListener(v -> {
                //call the specific view listener
                if (p.second != null) {
                    p.second.onClick(v);
                }
                // also call the all click listener
                runOnAllClicks.onClick(v);
            });
        }
    }

    /**
     * applies padding for all the
     * views if padding is not null
     */
    private void applyPadding(View v) {
        if(v != null) {
            MoPaddingBuilder.applyToExisting(paddingBuilder,v,true);
            MoPaddingBuilder.applyToExisting(textPadding,v,v instanceof TextView);
            MoPaddingBuilder.applyToExisting(iconPadding,v,v instanceof ImageButton);
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

    /**
     * @return pairs of this class
     */
    private List<Pair<View,View.OnClickListener>> asPairs() {
        return pairs;
    }

}
