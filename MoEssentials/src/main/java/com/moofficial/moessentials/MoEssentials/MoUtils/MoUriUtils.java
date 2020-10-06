package com.moofficial.moessentials.MoEssentials.MoUtils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
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

    /**
     * allows the system to write or read the uri
     * @param context
     * @param data
     * @return true if the read/write permission
     *              was granted
     */
    public static boolean configSecurity(Context context,Uri data){
        final int takeFlags = (Intent.FLAG_GRANT_READ_URI_PERMISSION
                | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        try {
            context.getContentResolver().takePersistableUriPermission(data, takeFlags);
        }
        catch (SecurityException e){
            return false;
        }
        return true;
    }
}
