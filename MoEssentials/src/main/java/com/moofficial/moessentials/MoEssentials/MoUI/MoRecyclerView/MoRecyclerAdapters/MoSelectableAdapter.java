package com.moofficial.moessentials.MoEssentials.MoUI.MoRecyclerView.MoRecyclerAdapters;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectable;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableList;

import java.util.ArrayList;
import java.util.List;

// an adapter that handles the selectable property
// form interactables
public abstract class MoSelectableAdapter<T extends RecyclerView.ViewHolder,I extends MoSelectableItem>
        extends MoRecyclerAdapter<T, I>
        implements MoSelectableList<I> {

    protected List<I> selectedItems = new ArrayList<>();
    protected MoSelectable<I> selectable;

    public MoSelectableAdapter(Context c,List<I> dataSet) {
        super(c,dataSet);
    }

    public List<I> getSelectedItems() {
        return selectedItems;
    }

    public MoSelectableAdapter<T, I> setSelectedItems(List<I> selectedItems) {
        this.selectedItems = selectedItems;
        return this;
    }


    @Override
    public void setListSelectable(MoSelectable<I> moSelectable) {
        this.selectable = moSelectable;
    }

    @Override
    public void onSelect(int i) {
        selectable.onSelect(this,dataSet.get(i),i);
    }

    /**
     *
     * @return true if the user is currently
     *         selecting the items of this adapter
     */
    public boolean isSelecting() {
        return this.selectable.isInActionMode();
    }

    /**
     *
     * @return true if the user is not currently selecting the items
     * (we have not activated the select mode)
     */
    public boolean isNotSelecting(){
        return !this.isSelecting();
    }

    /**
     * makes the user to be able to select the list items inside
     * this adapter
     */
    public void startSelecting(int startPosition) {
        this.selectable.activateSpecialMode();
        this.onSelect(startPosition);
    }

    /**
     *
     * @return true if the user has not selected any item
     */
    public boolean selectionIsEmpty(){
        return selectedItems.isEmpty();
    }

    /**
     * clears all the selected
     * items
     */
    public void clearSelection() {
        for(I i: selectedItems) {
            i.setSelected(false);
        }
        selectedItems.clear();
    }

    /**
     *
     * @return numbers of selected items
     */
    public int selectedSize() {
        return selectedItems.size();
    }

    /**
     * if the user has only selected one item,
     * then return true else false
     * @return true if the size of the selected
     * list is equal to one
     */
    public boolean onlyOneIsSelected() {
        return selectedSize() == 1;
    }

}
