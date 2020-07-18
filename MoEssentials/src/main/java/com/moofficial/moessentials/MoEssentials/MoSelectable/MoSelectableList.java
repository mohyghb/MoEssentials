package com.moofficial.moessentials.MoEssentials.MoSelectable;

import java.util.List;

public interface MoSelectableList {

//    /**
//     * an array list to store the selected items in
//     */
//    List<MoSelectableItem> selectedItems = new ArrayList<>();


    /**
     * if we want all the elements to be selected
     */
    void selectAllElements();

    /**
     * if we want to deselect all the elements
     */
    void deselectAllElements();


    /**
     * when the user clicks on an element to
     * be selected
     */
    void onSelect(int position);


    /**
     *
     * @return the list of the selected items
     */
    List<? extends MoSelectableItem> getSelectedItems();



}
