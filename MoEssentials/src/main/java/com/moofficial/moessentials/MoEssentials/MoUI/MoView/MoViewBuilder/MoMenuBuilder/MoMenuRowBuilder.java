package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewBuilder.MoMenuBuilder;

import android.view.View;

import java.util.List;

public interface MoMenuRowBuilder {

    /**
     * build the row that you want with the
     * menu builder and then return those views as
     * a list to make them horizontal inside the main
     * menu
     * (populate the builder with list of
     * views that will be places inside a row)
     * @param builder to build views inside a row
     */
    void buildRow(MoMenuBuilder builder);

}
