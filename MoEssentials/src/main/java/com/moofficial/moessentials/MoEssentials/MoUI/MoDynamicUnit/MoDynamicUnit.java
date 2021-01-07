package com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class MoDynamicUnit {
    /**
     * Converts DP into pixels.
     *
     * @param dp The value in DP to be converted into pixels.
     *
     * @return The converted value in pixels.
     */
    public static int convertDpToPixels(Context c,  float dp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dp, c.getResources().getDisplayMetrics()));
    }

    /**
     * Converts pixels into DP.
     *
     * @param pixels The value in pixels to be converted into DP.
     *
     * @return The converted value in DP.
     */
    public static int convertPixelsToDp(Context c, int pixels) {
        return Math.round(pixels / c.getResources().getDisplayMetrics().density);
    }

    /**
     * Converts SP into pixels.
     *
     * @param sp The value in SP to be converted into pixels.
     *
     * @return The converted value in pixels.
     */
    public static int convertSpToPixels(Context c, float sp) {
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                sp, c.getResources().getDisplayMetrics()));
    }

    /**
     * Converts pixels into SP.
     *
     * @param pixels The value in pixels to be converted into SP.
     *
     * @return The converted value in SP.
     */
    public static int convertPixelsToSp(Context c, int pixels) {
        return Math.round(pixels / c.getResources().getDisplayMetrics().density);
    }

    /**
     * Converts DP into SP.
     *
     * @param dp The value in DP to be converted into SP.
     *
     * @return The converted value in SP.
     */
    public static int convertDpToSp(Context c, float dp) {
        return Math.round(convertDpToPixels(c, dp) / (float) convertSpToPixels(c, dp));
    }
}
