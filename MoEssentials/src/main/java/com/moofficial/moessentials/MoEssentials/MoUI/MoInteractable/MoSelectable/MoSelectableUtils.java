package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import android.content.Context;
import android.view.View;

import androidx.annotation.ColorRes;
import androidx.core.graphics.ColorUtils;
import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoViewUtils;
import com.moofficial.moessentials.R;

import java.util.ArrayList;
import java.util.List;

public class MoSelectableUtils {


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

//    /**
//     * if the apply range change is true, we call
//     * the adapter notifyItemRangeChanged
//     * otherwise we call notifyItemChanged for every index
//     * inside the indexes list
//     * @param wrapper used to notify
//     * @param indexes indexes to be notified
//     * @param applyRangeChange whether we apply a range change or not
//     */
//    public static void notifyItemChanged(MoSelectableListWrapper<? extends MoSelectableItem> wrapper,
//                                         List<Integer> indexes,boolean applyRangeChange){
//        if(indexes == null || indexes.isEmpty()){
//            return;
//        }
//
//        if(applyRangeChange){
//           // wrapper.notifyItemRangeChanged(indexes.get(0),indexes.size());
//        }else{
//            for(int i:indexes){
//                wrapper.notifyItemChanged(i);
//            }
//        }
//    }
//
//    /**
//     * overloaded method from the above function
//     * @param wrapper
//     * @param indexes
//     */
//    public static void notifyItemChanged(MoSelectableListWrapper<? extends MoSelectableItem> wrapper,
//                                         List<Integer> indexes) {
//           notifyItemChanged(wrapper,indexes,false);
//    }

    /**
     * sets the background of v
     * to 100 alpha of color accent if it is selected
     * or to transparent if it is not selected
     * @param c context
     * @param v cover view to show the selected background
     * @param selectableItem selectable item
     */
    public static void applySelectedColor(Context c, View v, MoSelectableItem selectableItem){
        applySelectedColor(c,v,selectableItem,R.color.colorAccent,100,R.color.transparent,0);
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
        applySelectedColor(c,v,selectableItem,R.color.colorPrimary,100,R.color.transparent,0);
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
        applySelectedColor(c,v,selectableItem,R.color.colorPrimaryDark,100,R.color.transparent,0);
    }


    /**
     * @param c context of app
     * @param v view to apply the color to
     * @param item selectable item
     * @param s selected color's id
     * @param a selected color's alpha
     * @param ns not selected color id
     * @param na not selected color's alpha
     * applies the selected color to a view
     * indicating that the view is selected
     * to be deleted or applies non-selected color
     * to that view if the selectable item is not
     * selected
     */
    public static void applySelectedColor(Context c, View v, MoSelectableItem item,
                                          @ColorRes int s, int a, @ColorRes int ns, int na){
        applySelectedColor(v,item,c.getColor(s),a,c.getColor(ns),na);
    }

    /**
     * @param v view to apply the color to
     * @param item selectable item
     * @param s selected color's id
     * @param a selected color's alpha
     * @param ns not selected color id
     * @param na not selected color's alpha
     * applies the selected color to a view
     * indicating that the view is selected
     * to be deleted or applies non-selected color
     * to that view if the selectable item is not
     * selected
     */
    public static void applySelectedColor(View v, MoSelectableItem item,
                                          int s, int a, int ns, int na){
        if(item.isSelected()) {
            MoViewUtils.applyColor(v,ColorUtils.setAlphaComponent(s,a));
        }else{
            MoViewUtils.applyColor(v,ColorUtils.setAlphaComponent(ns,na));
        }
    }









}
