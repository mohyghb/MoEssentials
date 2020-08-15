package com.moofficial.moessentials.MoEssentials.MoFileManager;

import android.content.Context;
import android.graphics.Bitmap;

import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoFileSavable;
import com.moofficial.moessentials.MoEssentials.MoLog.MoLog;


import java.io.IOException;

public class MoFileManagerUtils {

    /**
     * saves all the mo name savable inside their
     * own files and their own directory
     * @param c context of the app
     * @param list of MoNameSavable
     * @throws IOException
     */
    public static void write(Context c, Iterable<? extends MoFileSavable> list) throws IOException {
        for(MoFileSavable s: list){
            write(c,s);
        }
    }

    /**
     * saves the object to the file that
     * is specified
     * @param c
     * @param object
     * @param <T>
     * @throws IOException
     */
    public static <T extends MoFileSavable> void write(Context c, T object) throws IOException {
        MoFileManager.writeInternalFile(c,
                object.getDirName(),
                object.getFileName(),
                object.getData());
    }

    /**
     * reading an internal file and getting string
     * as the result of reading it
     * @param c
     * @param object
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T extends MoFileSavable> String read(Context c, T object) throws IOException {
        return MoFileManager.readInternalFile(c,object.getDirName(),object.getFileName());
    }


    /**
     * reads a bitmap from a MoFileSavable object
     * @param c
     * @param savable
     * @param <T>
     * @return
     * @throws IOException
     */
    public static <T extends MoFileSavable> Bitmap readBitmap(Context c,T savable) throws IOException {
        return MoFileManager.readInternalBitmap(c,savable.getDirName(),savable.getFileName());
    }

    /**
     * writes the bitmap to the
     * correct directory with the file name
     * @param c
     * @param savable
     * @param b
     * @param <T>
     * @throws IOException
     */
    public static <T extends MoFileSavable> void writeBitmap(Context c,T savable,Bitmap b) throws IOException {
        MoFileManager.writeInternalFile(c,savable.getDirName(),savable.getFileName(),b);
    }

    /**
     * saves the bitmap with quality and format
     * inside the directory with file name
     * @param c
     * @param savable
     * @param quality
     * @param format
     * @param b
     * @param <T>
     * @throws IOException
     */
    public static <T extends MoFileSavable> void writeBitmap(Context c,T savable,int quality,
                                                             Bitmap.CompressFormat format,Bitmap b) throws IOException {
        MoFileManager.writeInternalFile(c,savable.getDirName(),savable.getFileName(),b,quality,format);
    }


    /**
     * deletes a file when passing any object that
     * extends MoFileSavable
     * @param c context of the app
     * @param object to be deleted
     * @param <T> dynamic type of an object
     */
    public static <T extends MoFileSavable> void delete(Context c, T object){
        MoFileManager.deleteInternalFile(c,object.getDirName(),object.getFileName());
    }


    @SuppressWarnings("ConstantConditions")
    public static void printDirectoryFiles(Context c, String dirName){
        MoLog.print(dirName,MoDir.getInternalDir(c,dirName).list());
    }


}
