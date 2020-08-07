package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;

public class MoSelectableUtils {


//    /**
//     * selects all the items
//     * @param items
//     * @param selectable
//     */
//    public static <T extends MoSelectableItem> void selectAllItems(Collection<T> items, MoSelectable<T> selectable){
//        selectable.setSelectedSize(turnAllItems(true,items));
//        List<T> list = selectable.getSelectableList().getSelectedItems();
//        // clearing all the selected items from before
//        list.clear();
//        // and adding all the items to selected
//        list.addAll(items);
//    }
//
//
//    /**
//     * sets the selected size to 0 as well
//     * @param selectable
//     */
//    public static <T extends MoSelectableItem> void deselectAllItems(MoSelectable<T> selectable){
//        List<T> list = selectable.getSelectableList().getSelectedItems();
//        turnAllItems(false,list);
//        list.clear();
//        selectable.setSelectedSize(0);
//    }

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









}
