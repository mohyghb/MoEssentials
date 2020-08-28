package com.moofficial.moessentials.MoEssentials.MoContext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class MoContext {

    protected Context context;

    public MoContext(Context c){
        this.context = c;
    }


    public String getString(int id){
        return context.getString(id);
    }

    public Drawable getDrawable(int id){
        return context.getDrawable(id);
    }

    public int getColor(int id){
        return context.getColor(id);
    }

    public Resources getResources(){
        return context.getResources();
    }

    public float getDimension(int id){
        return context.getResources().getDimension(id);
    }


    public Context getContext(){
        return this.context;
    }

}
