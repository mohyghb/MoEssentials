package com.moofficial.moessentials.MoEssentials.MoUI.MoInteractable.MoSelectable.MoSelectableInterface;

import java.util.List;

public interface MoOnSelectFinishedListener<T extends MoSelectableItem> {


    void onSelectFinished(List<T> pickedItems);

}
