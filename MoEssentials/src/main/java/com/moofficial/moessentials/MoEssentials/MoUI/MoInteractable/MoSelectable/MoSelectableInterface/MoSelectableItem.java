package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface;

public interface MoSelectableItem {

    /**
     * this function triggers when the
     * user tries to select a selectable item
     * @return the select state after the change
     */
    boolean onSelect();

    /**
     * setting the selected of selectable item
     * @param s select state
     */
    void setSelected(boolean s);

    /**
     *
     * @return true if the item is selected
     */
    boolean isSelected();

    /**
     * not all the items inside a list
     * are selectable, on default we assume that
     * they are selectable, but the developer
     * can change it based on their need
     * @return true if the item is selectable
     */
    default boolean isSelectable(){
        return true;
    }


}
