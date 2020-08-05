package com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoDelete;


import com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoSelectable.MoListSelectable;
import com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoSelectable.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoSelectable.MoSelectableList;

public interface MoListDeletable<T extends MoSelectableItem> extends MoSelectableList<T> {

    // we don't need to set list selectable inside a mo list delete
    // so we define it as a default function
    @Override
    default void setListSelectable(MoListSelectable<T> s){}

    /**
     * when we want to set a mo delete for that adapter
     * @param d
     */
    void setMoDelete(MoListDelete<T> d);




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
