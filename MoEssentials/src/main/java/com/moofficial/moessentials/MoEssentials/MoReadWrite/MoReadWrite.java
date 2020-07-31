package com.moofficial.moessentials.MoEssentials.MoReadWrite;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Objects;

public class MoReadWrite {

    private static final HashMap<String,String> files = new HashMap<>();

    /**
     *
     * @param file
     * @param text
     * @param context
     */
    public static void saveFile(String file, String text, Context context) {
        try{
            FileOutputStream fos = context.openFileOutput(file, Context.MODE_PRIVATE);
            fos.write(text.getBytes());
            fos.close();
        }catch(Exception ignore){
            Log.e("MoReadWrite","not able to save " + file);
        }
        updateFiles(file,text);
    }

    /**
     * if update is true, we only save the new file if
     * it is different than it's previous version
     * otherwise we don't save it
     * uf update is false, we save it no matter what
     * @param file file name that they want to save it in
     * @param text text they want to save
     * @param context
     * @param update whether or not just update the file if the text is different
     *               than it's previous version
     */
    public static void saveFile(String file, String text, Context context,boolean update) {
        if(update){
            if(isDifferent(file,text)){
                saveFile(file,text,context);
            }
        }else{
            saveFile(file,text,context);
        }
    }

    public static String readFile(String filename, Context context) {
        String text = "";
        try{
            if(fileExist(filename,context)) {
                FileInputStream fis = context.openFileInput(filename);
                int size = fis.available();
                byte[] buffer = new byte[size];
                fis.read(buffer);
                fis.close();
                text = new String(buffer);
            }
        }catch(Exception e) {
            Log.e("MoReadWrite","not able to read " + filename);
        }
        updateFiles(filename,text);
        return text;
    }

    public static boolean fileExist(String fileName, Context context){
        File file = context.getFileStreamPath(fileName);
        return file.exists();
    }


    private static void updateFiles(String filename,String fileData){
        files.put(filename,fileData);
    }

    /**
     * either we still haven't saved the file
     * or the new text that they want to save is different
     * @param filename
     * @param text
     * @return
     */
    private static boolean isDifferent(String filename,String text){
        return !files.containsKey(filename) || !Objects.equals(files.get(filename), text);
    }

}
