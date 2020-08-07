package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableList;

import java.util.List;

public class MoSelectableListWrapper<T extends MoSelectableItem> {

    private MoSelectableList<T> list;
    private MoSelectable<T> selectable;

    public MoSelectableListWrapper(MoSelectableList<T> l){
        this.list = l;
    }

    public void sync(MoSelectable<T> s){
        this.selectable = s;
        this.list.setListSelectable(s);
    }

    public void selectAll(boolean update){
        MoSelectableUtils.turnAllItems(true,list.getDataSet());
        this.list.getSelectedItems().clear();
        this.list.getSelectedItems().addAll(list.getDataSet());
        this.selectable.setSelectedSize(this.list.getDataSet().size(),update);
        list.notifyDataSetChanged();
    }

    public void deselectAll(boolean update){
        MoSelectableUtils.turnAllItems(false,this.list.getSelectedItems());
        this.list.getSelectedItems().clear();
        this.selectable.setSelectedSize(0,update);
        list.notifyDataSetChanged();
    }


    public void add(T item){
        list.getSelectedItems().add(item);
    }

    public void remove(T item){
        list.getSelectedItems().remove(item);
    }

    public int dataSetSize(){
        return list.getDataSet().size();
    }

    public int selectedSize(){
        return list.getSelectedItems().size();
    }

    public List<T> getSelectedItems(){
        return this.list.getSelectedItems();
    }

}
