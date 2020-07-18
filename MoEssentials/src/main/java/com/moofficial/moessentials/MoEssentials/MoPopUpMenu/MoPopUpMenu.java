package com.moofficial.moessentials.MoEssentials.MoPopUpMenu;

import android.content.Context;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MoPopUpMenu {

    private Context context;
    private List<Pair<String, MenuItem.OnMenuItemClickListener>> menuItems = new ArrayList<>();

    public MoPopUpMenu(Context c){
        this.context = c;
    }

    @SafeVarargs
    public final MoPopUpMenu setEntries(Pair<String, MenuItem.OnMenuItemClickListener>... pair){
        this.menuItems = Arrays.asList(pair);
        return this;
    }

    public void addEntry(Pair<String, MenuItem.OnMenuItemClickListener> enrty){
        this.menuItems.add(enrty);
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
