package com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoSelectable;

public class MoSelectableUtils {

    /**
     * selects all the items of the iterable
     * @param items iterable of selectable items
     */
    public static void selectAllItems(Iterable<? extends MoSelectableItem> items){
        turnAllItems(true,items);
    }

    /**
     * selects all the items
     * @param items
     * @param selectable
     */
    public static void selectAllItems(Iterable<? extends MoSelectableItem> items,MoListSelectable selectable){
        selectable.setSelectedSize(turnAllItems(true,items));
    }

    /**
     * deselects all the items of the iterable
     * @param items iterable of selectable items
     */
    public static void deselectAllItems(Iterable<? extends MoSelectableItem> items){
        turnAllItems(false,items);
    }

    /**
     * sets the selected size to 0 as well
     * @param items
     * @param selectable
     */
    public static void deselectAllItems(Iterable<? extends MoSelectableItem> items,MoListSelectable selectable){
        deselectAllItems(items);
        selectable.setSelectedSize(0);
    }

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
