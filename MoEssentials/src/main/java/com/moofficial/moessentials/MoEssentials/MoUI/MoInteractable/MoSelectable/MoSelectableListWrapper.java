package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableList;

import java.util.List;

public class MoSelectableListWrapper<T extends MoSelectableItem> {

    private MoSelectableList<T> list;
    private MoSelectable<T> selectable;
    private boolean allItemsAreSelectable = true;
    private int countSelectableItems = 0;

    public MoSelectableListWrapper(MoSelectableList<T> l){
        this.list = l;
    }

    public MoSelectableListWrapper<T> sync(MoSelectable<T> s){
        this.selectable = s;
        this.list.setListSelectable(s);
        return this;
    }

    /**
     * init the class
     */
    public void init(){
        if(!this.allItemsAreSelectable){
            measureSelectableItemsInList();
        }
    }

    public boolean isAllItemsAreSelectable() {
        return allItemsAreSelectable;
    }

    public MoSelectableListWrapper<T> setAllItemsAreSelectable(boolean allItemsAreSelectable) {
        this.allItemsAreSelectable = allItemsAreSelectable;
        return this;
    }

    public void selectAll(boolean update){
        // because all the items might not be affect, so we need
        // to keep track of which items are selectable, and only
        // add those to the selected list
        List<T> affectedItems = MoSelectableUtils.turnAllItems(true,list.getDataSet());
        this.list.getSelectedItems().clear();
        this.list.getSelectedItems().addAll(affectedItems);
        this.selectable.setSelectedSize(dataSetSize(),update);
        notifyDataSetChanged();
    }

    public void deselectAll(boolean update){
        MoSelectableUtils.turnAllItems(false,this.list.getSelectedItems());
        this.list.getSelectedItems().clear();
        this.selectable.setSelectedSize(0,update);
        notifyDataSetChanged();
    }


    public void add(T item){
        list.getSelectedItems().add(item);
    }

    public void remove(T item){
        list.getSelectedItems().remove(item);
    }

    /**
     * returns the data set size if all the items are selectable
     * or measures the selectable items inside the list
     * @return
     */
    public int dataSetSize(){
        return allItemsAreSelectable?list.getDataSet().size():countSelectableItems;
    }

    public int selectedSize(){
        return list.getSelectedItems().size();
    }

    public List<T> getSelectedItems(){
        return this.list.getSelectedItems();
    }

    public void notifyItemChanged(int position,Object payload){
        list.notifyItemChanged(position,payload);
    }

    public void notifyDataSetChanged(){
        list.notifyDataSetChanged();
    }



    /**
     * goes through the list of selectable items
     * and only gets the size of selectable items inside there
     * not all the items may be selectable
     * @return the number of selectable items inside the
     *         whole data set
     */
    public void measureSelectableItemsInList(){
        this.countSelectableItems = 0;
        for(T t: list.getDataSet()){
            if(t.isSelectable()){
                countSelectableItems++;
            }
        }
    }

}
