package com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MoInflaterView {


    public static View inflate(int layout, Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return inflater.inflate(layout,null);
    }

    public static View inflate(int layout, ViewGroup viewGroup, Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        return inflater.inflate(layout, viewGroup, false);
    }
}
