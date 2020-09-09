package com.moofficial.moessentials.MoEssentials.MoFileManager;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.util.Objects;

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
        return mkDir(directory);
    }

    /**
     * creates the directory if
     * it does not exist or prompts an error
     * log that the directory could not be made
     * @param directory directory to be made
     */
    public static File mkDir(File directory) {
        if(!directory.exists() && !directory.mkdirs()){
            Log.e("MoDir","directory "+  directory.getName() + "could not be made");
        }
        return directory;
    }

    /**
     * @param dirName directory name if null we use the base dir
     * @param fileName file name
     * @param context of the app
     * @return the file that is in directory dirName
     */
    public static File getInternalFile(Context context,String dirName,String fileName){
        return new File(getInternalDir(context,dirName == null?BASE_DIR:dirName),fileName);
    }

    /**
     * returns the cache directory of the app
     * @param context of the app
     * @return the cache dir file
     */
    public static File getCacheDir(Context context){
        return context.getCacheDir();
    }

    /**
     * returns the cache directory of the app
     * @param context of the app
     * @return the cache dir file
     */
    public static File getCacheDir(Context context,String dirName){
        return mkDir(new File(getCacheDir(context),dirName));
    }

    /**
     * returns the number of files + directories inside
     * the directory with dirName
     * @param context of the app
     * @param dirName directory name
     * @return number of files + directories in dirName dir
     */
    public static int getFilesSizeDir(Context context,String dirName) {
        File directory = MoDir.getInternalDir(context,dirName);
         return Objects.requireNonNull(directory.listFiles()).length;
    }

}
