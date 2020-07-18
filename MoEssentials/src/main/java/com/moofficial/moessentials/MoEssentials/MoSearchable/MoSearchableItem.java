package com.moofficial.moessentials.MoEssentials.MoSearchable;

public interface MoSearchableItem {

    /**
     * @param criteria is by which we determine whether
     *      this class should be considered as a
     *      search suggestion
     *      any type of criteria can be passed this
     *      way and we can just cast it to the desired
     *      object or class as needed
     * @param criteria
     * @return the searchable state
     */
    boolean updateSearchable(Object... criteria);

    /**
     *
     *
     * @return true if the item is considered to be
     * a good search for showing up
     */
    boolean isSearchable();

    /**
     *
     */
    void setSearchable(boolean s);



}
