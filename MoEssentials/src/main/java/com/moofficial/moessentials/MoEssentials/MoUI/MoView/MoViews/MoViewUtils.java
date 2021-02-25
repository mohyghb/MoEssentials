package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.view.ViewOverlay;

import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;

public class MoViewUtils {

    public static final float MO_DIM_VALUE = 0.6f;

    /**
     * creates a dim/blur effect on the view
     * group that is passed in based on our standards
     * @param parent view to be dimmed
     */
    public static void dim(@NonNull View parent){
        dim(parent,MO_DIM_VALUE);
    }

    /**
     * creates a dim/blur effect on the view
     * group that is passed in based on the dim amount
     * @param parent view to be dimmed
     * @param dimAmount amount of dim ranges between 0 and 1
     */
    public static void dim(@NonNull View parent, float dimAmount){
        colorOverlay(parent,Color.BLACK,dimAmount);
    }

    /**
     * clears all the overlay on this view
     * @param view view group to remove the
     *               dim from
     */
    public static void clearDim(@NonNull View view) {
        clearOverlay(view);
    }


    /**
     *
     * @param parent to add the overlay to
     * @param c color value used to create color overlay
     * @param alpha float value between 0 and 1. 1 being completely
     *             visible and 0 being completely transparent
     */
    public static void colorOverlay(@NonNull View parent, @ColorInt int c, float alpha) {
        Drawable dim = getOverlayDrawable(parent, c, alpha);
        ViewOverlay overlay = parent.getOverlay();
        overlay.add(dim);
    }

    /**
     * creates an overlay drawable
     * @param parent to obtain width and height
     * @param c color value
     * @param alpha of the color value
     * @return drawable for showing an overlay with color
     */
    private static Drawable getOverlayDrawable(@NonNull View parent, @ColorInt int c, float alpha) {
        Drawable dim = new ColorDrawable(c);
        dim.setBounds(0, 0, parent.getWidth(), parent.getHeight());
        dim.setAlpha((int) (255 * alpha));
        return dim;
    }

    /**
     * clears the specific color overlay for the
     * given view
     * @param v view to clear the overlay for
     */
    public static void clearOverlay(View v) {
        v.getOverlay().clear();
    }

    /**
     * makes the view to ripple when clicked
     * @param v view to apply ripple effect
     */
    public static void rippleOnClick(Context context,View v){
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        v.setBackgroundResource(outValue.resourceId);
        v.setClickable(true);
    }

    /**
     * makes the view to ripple when clicked
     * @param v view to apply ripple effect
     */
    public static void borderlessRippleOnClick(Context context,View v){
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.selectableItemBackgroundBorderless,
                outValue, true);
        v.setBackgroundResource(outValue.resourceId);
        v.setClickable(true);
    }

    /**
     * sets the size of the view
     * @param v view to be resized
     * @param width new width of the view
     * @param height new height of the view
     */
    public static void setSize(View v, @DimenRes int width, @DimenRes int height) {
        ViewGroup.LayoutParams params = v.getLayoutParams();
        params.width = (int) v.getContext().getResources().getDimension(width);
        params.height = (int) v.getContext().getResources().getDimension(height);
    }

    /**
     * recursively sets enabled for all the children of view group
     * @param enable whether the view is enable or disbaled
     * @param v view group to apply enable to
     */
    public static void setEnabled(boolean enable, ViewGroup v) {
        for (int i = 0; i < v.getChildCount(); i++) {
            View child = v.getChildAt(i);
            child.setEnabled(enable);
            if (child instanceof ViewGroup) {
                setEnabled(enable, (ViewGroup) child);
            }
        }
    }

}
