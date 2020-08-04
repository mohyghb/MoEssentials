package com.moofficial.moessentials.MoEssentials.MoUI.MoViews.MoSelectable;

import java.util.List;

public interface MoOnSelectFinishedListener<T extends MoSelectableItem> {


    void onSelectFinished(List<T> pickedItems);

}
