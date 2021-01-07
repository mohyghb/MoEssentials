package com.moofficial.moessentials.MoEssentials.MoBitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.annotation.NonNull;

import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;

public class MoBitmapUtils {

    public
    static Bitmap createBitmapFromView(@NonNull View view, int width, int height) {
        if (width > 0 && height > 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(MoDynamicUnit
                            .convertDpToPixels(view.getContext(), width), View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(MoDynamicUnit
                            .convertDpToPixels(view.getContext(), height), View.MeasureSpec.EXACTLY));
        }
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        int w = view.getMeasuredWidth();
        int h = view.getMeasuredHeight();

        if(w<=0 || h<=0){
            return null;
        }

        Bitmap bitmap = Bitmap.createBitmap(w,
                h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable background = view.getBackground();

        if (background != null) {
            background.draw(canvas);
        }
        view.draw(canvas);

        return bitmap;
    }




}
