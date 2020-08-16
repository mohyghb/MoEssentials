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


}