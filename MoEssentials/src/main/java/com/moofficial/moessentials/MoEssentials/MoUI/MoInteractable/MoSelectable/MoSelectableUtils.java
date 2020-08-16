package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.R;

public class MoSelectableUtils {


    /**
     * changes the selected state to the boolean given
     * @param b
     * @param items
     * @return number of items inside items
     */
    public static int turnAllItems(boolean b,Iterable<? extends MoSelectableItem> items){
        int i = 0;
        for(MoSelectableItem s : items){
            s.setSelected(b);
            i++;
        }
        return i;
    }

    /**
     *
     * @param c
     * @param v
     * @param selectableItem
     */
    public static void applySelectedColor(Context c, View v, MoSelectableItem selectableItem){
        applySelectedColor(c,v,selectableItem, R.color.colorAccent,R.color.transparent);
    }

    /**
     * applies the selected color to a view
     * indicating that the view is selected
     * to be deleted or applies non-selected color
     * to that view if the selectable item is not
     * selected
     * @param c
     * @param v
     * @param selectableItem
     * @param selectedColorId
     * @param notSelectedColorId
     */
    public static void applySelectedColor(Context c,View v, MoSelectableItem selectableItem,int selectedColorId,int notSelectedColorId){
        if(selectableItem.isSelected()){
            v.setBackgroundColor(c.getColor(selectedColorId));
        }else{
            v.setBackgroundColor(c.getColor(notSelectedColorId));
        }
    }









}
