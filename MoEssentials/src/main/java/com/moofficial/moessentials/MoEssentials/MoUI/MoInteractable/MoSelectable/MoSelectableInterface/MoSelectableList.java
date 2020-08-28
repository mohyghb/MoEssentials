package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectable;

import java.util.List;

public interface MoSelectableList<T extends MoSelectableItem> {

//    /**
//     * an array list to store the selected items in
//     */
//    List<MoSelectableItem> selectedItems = new ArrayList<>();


    /**
     * setting up a mutual relationship
     * @param s
     */
    void setListSelectable(MoSelectable<T> s);


    /**
     * when the user clicks on an element to
     * be selected
     */
    void onSelect(int position);


    /**
     * notifies the data set changed
     * either used when we are transitioning to
     * delete mode or out of it
     */
    void notifyDataSetChanged();

    /**
     * notifies the item at position
     * that something has changed
     * so we need to render it again
     * @param position position of the item that has changed (either
     *                 selected or unselected)
     * @param payload to tell the adapter that we are only updating one
     *                part of the view holder, no need to update the whole
     *                thing again
     */
    void notifyItemChanged(int position,Object payload);

    /**
     *
     * @return the list of the selected items
     */
    List<T> getSelectedItems();


    /**
     *
     * @return the data set that we are dealing with
     */
    List<T> getDataSet();



}
