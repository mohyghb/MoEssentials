package com.moofficial.moessentials.MoEssentials.MoColor;

import android.content.Context;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import com.moofficial.moessentials.R;

public class MoColor {

    public static int[] colors = new int[]{
            R.color.mo_red,
            R.color.mo_pink,
            R.color.mo_purple,
            R.color.mo_deep_purple,
            R.color.mo_indigo,
            R.color.mo_blue,
            R.color.mo_light_blue,
            R.color.mo_cyan,
            R.color.mo_teal,
            R.color.mo_green,
            R.color.mo_light_green,
            R.color.mo_lime,
            R.color.mo_yellow,
            R.color.mo_amber,
            R.color.mo_orange,
            R.color.mo_deep_orange,
    };

    public static int NULL_COLOR = R.color.colorPrimary;


    /**
     * returns a color for any object
     * based on using their string value
     * @param o object
     * @return color resource
     */
    public static @ColorRes int color(Object o) {
        if (o == null) {
            return NULL_COLOR;
        }
        return color(o.toString());
    }

    /**
     * generates a color based on the
     * first character of the text
     * @param text to generate a color for
     * @return color resource value
     */
    public static @ColorRes int color(String text) {
        if (text == null || text.isEmpty()) {
            return NULL_COLOR;
        }
        return color((int) text.charAt(0));
    }

    /**
     * returns a random color resource
     * based on the value of int that is passed in
     * @param value to find a color for
     * @return color resource
     */
    public static @ColorRes int color(int value) {
        return colors[value % colors.length];
    }


    public static @ColorInt int colorInt(Context c, String string) {
        return ContextCompat.getColor(c, color(string));
    }

}
