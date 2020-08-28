package com.moofficial.moessentials.MoEssentials.MoFileManager.MoFileProvider;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import androidx.core.content.FileProvider;

import com.moofficial.moessentials.MoEssentials.MoFileManager.MoDir;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoFileManager;
import com.moofficial.moessentials.MoEssentials.MoLog.MoLog;

import java.io.File;
import java.io.IOException;

// helper for file provider
public class MoFileProvider {

    /**
     * Saves the image as PNG to the app's cache directory.
     * @param context
     * @param image to be saved and it's uri returned
     * @param dir directory of the image
     * @param name of the file of the image
     * @param authority authority of the app so we
     *                  know that this operation is authorized and let other
     *                  things access this uri
     * @return the uri of the saved image to be shared
     */
    public static Uri getImageUri(Context context,Bitmap image, String dir,String name,String authority) {
        File imagesFolder = MoDir.getCacheDir(context,dir);
        Uri uri = null;
        try {
            File file = new File(imagesFolder, name);
            MoFileManager.writeFile(image,100,Bitmap.CompressFormat.PNG,file);
            uri = FileProvider.getUriForFile(context, authority, file);
        } catch (IOException e) {
            MoLog.print("IOException while trying to write file for sharing: " + e.getMessage());
        }
        return uri;
    }


}
