package com.moofficial.moessentials.MoEssentials.MoUI.MoPopUpMenu;

import android.content.Context;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MoPopUpMenu extends MoContext {


    private List<Pair<String, MenuItem.OnMenuItemClickListener>> menuItems = new ArrayList<>();

    public MoPopUpMenu(Context c){
        super(c);
    }

    @SafeVarargs
    public final MoPopUpMenu setEntries(Pair<String, MenuItem.OnMenuItemClickListener>... pair){
        this.menuItems.addAll(Arrays.asList(pair));
        return this;
    }

    public MoPopUpMenu addEntry(Pair<String, MenuItem.OnMenuItemClickListener> enrty){
        this.menuItems.add(enrty);
        return this;
    }


    public MoPopUpMenu show(View anchor) {
        if(menuItems==null || menuItems.isEmpty()){
            // we don't show anything if menu items are empty
            return this;
        }
        PopupMenu popup = new PopupMenu(context, anchor);
        Menu menu = popup.getMenu();
        for(Pair<String, MenuItem.OnMenuItemClickListener> item: menuItems){
            MenuItem i = menu.add(item.first);
            i.setOnMenuItemClickListener(item.second);
        }
        popup.show();
        return this;
    }

}
