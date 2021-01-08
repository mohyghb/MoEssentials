package com.moofficial.moessentials.MoEssentials.MoUI.MoDrawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;

import androidx.annotation.ColorRes;

import com.moofficial.moessentials.R;

public class MoDrawableUtils {

    public static Drawable outlineCircle(Context c){
        return new MoDrawableBuilder(c)
                .strokeWidth(2)
                .strokeColor(R.color.colorPrimary)
                .withColor(R.color.transparent)
                .oval()
                .build();
    }

    public static Drawable filledCircle(Context c) {
        return new MoDrawableBuilder(c).oval().build();
    }

    public static Drawable filledCircle(Context c, @ColorRes int color) {
        return new MoDrawableBuilder(c).withColor(color).oval().build();
    }

    public static Drawable filledRec(Context c) {
        return new MoDrawableBuilder(c).rectangle().recRadius().build();
    }

    public static Drawable filledRec(Context c, @ColorRes int color) {
        return new MoDrawableBuilder(c).rectangle().recRadius().withColor(color).build();
    }

    public static Drawable filledRoundRec(Context c) {
        return new MoDrawableBuilder(c).rectangle().roundRecRadius().build();
    }

    public static Drawable filledRoundRec(Context c, @ColorRes int color) {
        return new MoDrawableBuilder(c).rectangle().roundRecRadius().withColor(color).build();
    }
}
