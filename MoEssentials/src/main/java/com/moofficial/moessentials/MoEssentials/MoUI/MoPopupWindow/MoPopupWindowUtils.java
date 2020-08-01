package com.moofficial.moessentials.MoEssentials.MoUI.MoPopupWindow;

import android.content.Context;
import android.util.DisplayMetrics;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public class MoPopupWindowUtils {

    public static int MAX_HEIGHT = 0;
    public static int MAX_WIDTH  = 0;
    public static int MIN_HEIGHT = 0;
    public static int MIN_WIDTH  = 0;



    public static void init(Context c){
            DisplayMetrics dm = c.getResources().getDisplayMetrics();
            MAX_HEIGHT = dm.heightPixels-10;
            MAX_WIDTH = dm.widthPixels - 10;
            MIN_HEIGHT = MAX_HEIGHT/2;
            MIN_WIDTH = MAX_WIDTH/2;
    }

}
