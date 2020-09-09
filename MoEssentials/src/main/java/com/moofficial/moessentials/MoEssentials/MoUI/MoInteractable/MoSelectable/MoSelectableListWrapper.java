package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MoSelectableListWrapper<T extends MoSelectableItem> {

    private interface MoOnAction<T extends MoSelectableItem> {
            void perform(MoSelectableList<T> l);
    }

    private MoSelectableList<T> [] list;
    private MoSelectable<T> selectable;
    private boolean allItemsAreSelectable = true;
    private int countSelectableItems = 0;

    @SafeVarargs
    public MoSelectableListWrapper(MoSelectableList<T> ... l){
        this.list = l;
    }


    private void performForAll(MoOnAction<T> action) {
        for(MoSelectableList<T> l:list){
            action.perform(l);
        }
    }

    public MoSelectableListWrapper<T> sync(MoSelectable<T> s){
        this.selectable = s;
        performForAll(l -> l.setListSelectable(selectable));
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
        performForAll(l -> {
            List<T> affectedItems = MoSelectableUtils.turnAllItems(true,l.getDataSet());
            l.getSelectedItems().clear();
            l.getSelectedItems().addAll(affectedItems);
        });
        this.selectable.setSelectedSize(dataSetSize(),update);
        notifyDataSetChanged();
    }

    public void deselectAll(boolean update) {
        performForAll(l -> {
            MoSelectableUtils.turnAllItems(false,l.getSelectedItems());
            l.getSelectedItems().clear();
        });
        this.selectable.setSelectedSize(0,update);
        notifyDataSetChanged();
    }


    public void add(MoSelectableList<T> list,T item) {
        list.getSelectedItems().add(item);
    }

    public void remove(MoSelectableList<T> list,T item) {
        list.getSelectedItems().remove(item);
    }


    public List<T> getSelectedItems(){
        List<T> items = new ArrayList<>();
        performForAll(l -> items.addAll(l.getSelectedItems()));
        return items;
    }

    /**
     * returns the data set size if all the items are selectable
     * or measures the selectable items inside the list
     * @return
     */
    public int dataSetSize(){
        return allItemsAreSelectable?allDataSetSize():countSelectableItems;
    }

    public int allDataSetSize() {
        AtomicInteger size = new AtomicInteger();
        performForAll(l -> size.addAndGet(l.getDataSet().size()));
        return size.get();
    }

    public int selectedSize() {
        AtomicInteger size = new AtomicInteger();
        performForAll(l -> size.addAndGet(l.getSelectedItems().size()));
        return size.get();
    }


    public void notifyItemChanged(MoSelectableList<T> list,int position,Object payload) {
        list.notifyItemChanged(position,payload);
//        performForAll(l->l.notifyItemChanged(position,payload));
    }

    public void notifyDataSetChanged() {
        performForAll(MoSelectableList::notifyDataSetChanged);
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
        performForAll(l -> {
            for(T t: l.getDataSet()) {
                if(t.isSelectable()){
                    countSelectableItems++;
                }
            }
        });

    }


}
