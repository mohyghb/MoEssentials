package com.moofficial.moessentials.MoEssentials.MoUtils;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;

public class MoUriUtils {

    /**
     * returns the mime type of the passed uri
     * @param context
     * @param uri
     * @return
     */
    public static String getMimeType(Context context,Uri uri){
        return context.getContentResolver().getType(uri);
    }

}
