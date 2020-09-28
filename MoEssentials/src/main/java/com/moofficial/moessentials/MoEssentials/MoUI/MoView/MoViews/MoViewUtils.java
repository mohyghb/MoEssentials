package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class MoViewUtils {

    public static final float MO_DIM_VALUE = 0.6f;

    /**
     * creates a dim/blur effect on the view
     * group that is passed in based on our standards
     * @param parent view group to be dimmed
     */
    public static void dim(@NonNull ViewGroup parent){
        dim(parent,MO_DIM_VALUE);
    }

    /**
     * creates a dim/blur effect on the view
     * group that is passed in based on the dim amount
     * @param parent view group to be dimmed
     * @param dimAmount amount of dim ranges between 0 and 1
     */
    public static void dim(@NonNull ViewGroup parent, float dimAmount){
        Drawable dim = new ColorDrawable(Color.BLACK);
        dim.setBounds(0, 0, parent.getWidth(), parent.getHeight());
        dim.setAlpha((int) (255 * dimAmount));
        ViewGroupOverlay overlay = parent.getOverlay();
        overlay.add(dim);
    }

    /**
     *
     * @param parent view group to remove the
     *               dim from
     */
    public static void clearDim(@NonNull ViewGroup parent) {
        ViewGroupOverlay overlay = parent.getOverlay();
        overlay.clear();
    }


    /**
     * makes the view to ripple when clicked
     * @param v view to apply ripple effect
     */
    public static void rippleOnClick(Context context,View v){
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        //v.setForeground(ContextCompat.getDrawable(context,outValue.resourceId));
        v.setBackgroundResource(outValue.resourceId);
        v.setClickable(true);
    }

}
