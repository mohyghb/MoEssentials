package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoListViewUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViews.MoViewUtils;
import com.moofficial.moessentials.R;

import java.util.ArrayList;
import java.util.List;


public class MoSelectableUtils {

    public static final float ALPHA_SELECTED = 0.45f;

    /**
     * changes the selected state to the boolean given
     * @param b make all of them selected or not
     * @param items to have their selected field changed
     * @return a list of affected items
     */
    public static <T extends MoSelectableItem> List<T> turnAllItems(boolean b, Iterable<T> items){
        List<T> list = new ArrayList<>();
        for(T s : items){
            if(s.isSelectable()){
                s.setSelected(b);
                list.add(s);
            }
        }
        return list;
    }




    /**
     * sets the background of v
     * to 100 alpha of color accent if it is selected
     * or to transparent if it is not selected
     * @param c context
     * @param v cover view to show the selected background
     * @param selectableItem selectable item
     */
    public static void applySelectedColor(Context c, View v, MoSelectableItem selectableItem){
        applySelectedColor(c,v,selectableItem,R.color.colorAccent,ALPHA_SELECTED);
    }

    /**
     * sets the background of v
     * to 100 alpha of color primary if it is selected
     * or to transparent if it is not selected
     * @param c context
     * @param v cover view to show the selected background
     * @param selectableItem selectable item
     */
    public static void applySelectedColorUsePrimary(Context c, View v, MoSelectableItem selectableItem){
        applySelectedColor(c,v,selectableItem,R.color.colorPrimary,ALPHA_SELECTED);
    }


    /**
     * sets the background of v
     * to 100 alpha of color primary dark if it is selected
     * or to transparent if it is not selected
     * @param c context
     * @param v cover view to show the selected background
     * @param selectableItem selectable item
     */
    public static void applySelectedColorUseDarkPrimary(Context c, View v, MoSelectableItem selectableItem){
        applySelectedColor(c,v,selectableItem,R.color.colorPrimaryDark,ALPHA_SELECTED);
    }


    /**
     * @param c context of app
     * @param v view to apply the color to
     * @param item selectable item
     * @param s selected color's id
     * @param a selected color's alpha
     * applies the selected color to a view
     * indicating that the view is selected
     * to be deleted or applies non-selected color
     * to that view if the selectable item is not
     * selected
     */
    public static void applySelectedColor(Context c, View v, MoSelectableItem item,
                                          @ColorRes int s, float a){
        applySelectedColor(v, item, ContextCompat.getColor(c,s), a);
    }

    /**
     * @param v view to apply the color to
     * @param item selectable item
     * @param s selected color's id
     * @param a selected color's alpha
     * applies the selected color to a view
     * indicating that the view is selected
     * to be deleted or applies non-selected color
     * to that view if the selectable item is not
     * selected
     */
    public static void applySelectedColor(View v, MoSelectableItem item,
                                          @ColorInt int s, float a){
        if(item.isSelected()) {
            // remove any (same) overlay
            MoViewUtils.colorOverlay(v, s, a);
        } else {
            MoViewUtils.clearOverlay(v);
        }
    }









}
