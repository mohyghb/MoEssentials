package com.moofficial.moessentials.MoEssentials.MoContext;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class MoContext {

    protected Context context;

    public MoContext(Context c){
        this.context = c;
    }


    protected String getString(int id){
        return context.getString(id);
    }

    protected Drawable getDrawable(int id){
        return context.getDrawable(id);
    }

    protected int getColor(int id){
        return context.getColor(id);
    }

    protected Resources getResources(){
        return context.getResources();
    }

    protected float getDimension(int id){
        return context.getResources().getDimension(id);
    }


}
