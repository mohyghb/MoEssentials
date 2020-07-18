package com.moofficial.moessentials.MoEssentials.MoSearchable;


import com.moofficial.moessentials.MoEssentials.MoState.MoStateChange;

import java.util.List;

// a dynamic interface to make a list searchable
public interface MoSearchableList extends MoStateChange {

//    /**
//     *
//     * @param criteria can be a string, date, or any object
//     * manipulates a list of iterable of searchable item that are
//     * shown to user as suggestions when trying to search something
//     */
//    void search(Object ... criteria);
//
//    /**
//     * when the user is not trying to search anymore
//     * we set back everything to normal
//     */
//    void cancelSearch();

    /**
     *
     * @return the list of searchable items
     */
    List<? extends MoSearchableItem> getSearchableItems();

}
