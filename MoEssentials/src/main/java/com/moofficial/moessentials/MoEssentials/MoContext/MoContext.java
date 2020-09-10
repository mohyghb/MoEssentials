package com.moofficial.moessentials.MoEssentials.MoContext;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import androidx.core.content.ContextCompat;

// this class used as a helper class
// in case you want to extend this class,
// you will automatically gain access to most features of the
// context and it makes everything easier for you
public class MoContext {

    protected Context context;

    public MoContext(Context c){
        this.context = c;
    }

    public void update(Context c){
        this.context = c;
    }

    public String getString(int id) {
        return context.getString(id);
    }

    public Drawable getDrawable(int id) {
        return ContextCompat.getDrawable(context,id);
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

    /**
     *
     * @return height of the screen in current mode
     *         in pixels
     */
    public int getHeightPixels(){
        return getResources().getDisplayMetrics().heightPixels;
    }

    /**
     *
     * @return width of the screen in current mode
     *         in pixels
     */
    public int getWidthPixels(){
        return getResources().getDisplayMetrics().widthPixels;
    }

    public void startActivity(Intent i){
        context.startActivity(i);
    }

}
