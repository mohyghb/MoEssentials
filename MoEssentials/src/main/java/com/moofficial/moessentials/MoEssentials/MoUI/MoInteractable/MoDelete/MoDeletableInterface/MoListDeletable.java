package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete.MoDeletableInterface;


import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete.MoDeletable;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectable;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableList;

public interface MoListDeletable<T extends MoSelectableItem> extends MoSelectableList<T> {

    // we don't need to set list selectable inside a mo list delete
    // so we define it as a default function
    @Override
    default void setListSelectable(MoSelectable<T> s){}

    /**
     * when we want to set a mo delete for that adapter
     * @param d
     */
    void setMoDelete(MoDeletable<T> d);



    /**
     * traverses through the list
     * and deletes the selected elements appropriately
     */
    void deleteSelected();

    /**
     *
     * @returns the size of list
     */
    int size();

}
