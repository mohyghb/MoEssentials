package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoDelete.MoDeletableInterface;

import com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface.MoSelectableItem;

import java.util.List;

public interface MoOnDeleteSelected<T extends MoSelectableItem> {

    void delete(List<T> selected);

}
