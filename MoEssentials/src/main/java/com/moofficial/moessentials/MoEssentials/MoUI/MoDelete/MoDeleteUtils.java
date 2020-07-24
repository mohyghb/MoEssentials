package com.moofficial.moessentials.MoEssentials.MoUI.MoDelete;

import android.content.Context;
import android.view.View;

import com.moofficial.moessentials.MoEssentials.MoRunnable.MoRunnableUtils;
import com.moofficial.moessentials.MoEssentials.MoUI.MoSelectable.MoSelectableItem;
import com.moofficial.moessentials.R;

public class MoDeleteUtils {

    /**
     *
     * @param c
     * @param v
     * @param selectableItem
     */
    public static void applyDeleteColor(Context c, View v, MoSelectableItem selectableItem){
        applyDeleteColor(c,v,selectableItem,R.color.delete_item_low_transparency_color,R.color.transparent);
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
    public static void applyDeleteColor(Context c,View v, MoSelectableItem selectableItem,int selectedColorId,int notSelectedColorId){
        if(selectableItem.isSelected()){
            v.setBackgroundColor(c.getColor(selectedColorId));
        }else{
            v.setBackgroundColor(c.getColor(notSelectedColorId));
        }
    }


    /**
     * sets a long click listener for the longPressView
     * and activates the list delete if it has not been activated already
     * and selects the current element at which it was long pressed at
     * otherwise it performs the [elseOption]
     * @param longPressView view that is going to activate the delete mode
     * @param deleteManager delete manager of that list
     * @param listDeletable list itself
     * @param position of the item in the array
     * @param elseOption other option if we do not activate the delete mode
     */
    public static void longPressDeleteActivation(View longPressView,MoListDelete deleteManager,
                                                 MoListDeletable listDeletable,int position,Runnable elseOption){
        longPressView.setOnLongClickListener(view -> {
            if(!deleteManager.isInActionMode()){
                deleteManager.setDeleteMode(true);
                listDeletable.onSelect(position);
            }else{
                MoRunnableUtils.runIfNotNull(elseOption);
            }
            return false;
        });
    }


}
