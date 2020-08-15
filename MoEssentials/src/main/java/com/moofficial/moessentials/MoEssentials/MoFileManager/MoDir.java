package com.moofficial.moessentials.MoEssentials.MoFileManager;

import android.content.Context;
import android.util.Log;

import com.moofficial.moessentials.MoEssentials.MoLog.MoLog;

import java.io.File;

// a class to handle all the directory stuff
public class MoDir {

    public static String BASE_DIR = "mo_base_dir";


    /**
     * creates a directory of name dirName if
     * it already does not exist
     * and returns the directory
     * if it already exists, we just return the
     * directory
     * @param context of the app
     * @param dirName directory name
     * @return the directory as file
     */
    public static File getInternalDir(Context context,String dirName){
        File directory = context.getDir(dirName, Context.MODE_PRIVATE);
        if(!directory.exists() && !directory.mkdirs()){
            Log.e("MoDir","directory "+  dirName + "could not be made");
        }
        return directory;
    }

    /**
     * @param dirName directory name
     * @param fileName file name
     * @param context of the app
     * @return the file that is in directory dirName
     */
    public static File getInternalFile(Context context,String dirName,String fileName){
        return new File(getInternalDir(context,dirName == null?BASE_DIR:dirName),fileName);
    }

}
