package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
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
