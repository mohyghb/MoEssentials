package com.moofficial.moessentials.MoEssentials.MoFileManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.core.content.ContextCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoFileManager {


    /**
     *  saves the [content] of the file inside
     *  the file
     * @param content to be saved
     * @param file that we want our content to be inside
     * @throws IOException
     */
    public static void writeFile(byte[] content, File file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content);
        fos.close();
    }

    /**
     * saves a bitmap with a quality and format
     * inside a file
     * @param bitmap to be saved
     * @param quality of the saved bitmap
     * @param format of the bitmap to be saved in
     * @param file where the bitmap should be saved
     * @throws IOException
     */
    public static void writeFile(Bitmap bitmap, int quality, Bitmap.CompressFormat format, File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        bitmap.compress(format, quality, fos);
        fos.close();
    }

    /**
     * saves a bitmap inside the file
     * @param bitmap
     * @param file
     * @throws IOException
     */
    public static void writeFile(Bitmap bitmap, File file) throws IOException {
        writeFile(bitmap,100, Bitmap.CompressFormat.PNG,file);
    }

    /**
     * saves a bitmap with quality and format
     * inside the dirName with fileName [fileName]
     * @param context
     * @param dirName
     * @param fileName
     * @param content
     * @param quality
     * @param format
     * @throws IOException
     */
    public static void writeInternalFile(Context context,
                                         String dirName, String fileName, Bitmap content,
                                         int quality,
                                         Bitmap.CompressFormat format) throws IOException {
        writeFile(content,quality,format,MoDir.getInternalFile(context,dirName,fileName));
    }

    /**
     * saves a bitmap inside the directory[dirName] with
     * file name of [fileName]
     * @param context of the app
     * @param dirName directory name
     * @param fileName name of file
     * @param content bitmap to be saved
     * @throws IOException
     */
    public static void writeInternalFile(Context context, String dirName, String fileName, Bitmap content) throws IOException {
        writeFile(content,MoDir.getInternalFile(context,dirName,fileName));
    }

    /**
     *
     * @param context
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeInternalFile(Context context, String fileName, Bitmap content) throws IOException {
        writeFile(content,MoDir.getInternalFile(context,MoDir.BASE_DIR,fileName));
    }



    /**
     * saves the [content] of the file inside
     * the file with [fileName]
     * @param fileName of the file
     * @param content of the object we are saving
     * @param context of the app
     * @throws IOException if file could not be opened or we could not
     *                      write to it
     */
    public static void writeInternalFile(Context context, String dirName, String fileName, String content) throws IOException {
        writeFile(content.getBytes(),MoDir.getInternalFile(context,dirName,fileName));
    }

    /**
     * uses the base directory for saving the file contents
     * @param context
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeInternalFile(Context context, String fileName, String content) throws IOException {
        writeInternalFile(context,MoDir.BASE_DIR,fileName,content);
    }


    /**
     * reads the content of the file as
     * string and returns it
     * @param file specific file to be read
     * @return content of the file as string
     * @throws IOException
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static String readFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        int size = fis.available();
        byte[] buffer = new byte[size];
        fis.read(buffer);
        fis.close();
        return new String(buffer);
    }

    /**
     * reads the file name from
     * the asset folder of the android
     * return the content of it in string
     * format
     * @param c context
     * @param fileName of the file
     * @return content of the file name
     * @throws IOException
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static String readAssetFile(Context c, String fileName) throws IOException {
        InputStream f = c.getAssets().open(fileName);
        byte[] b = new byte[f.available()];
        f.read(b);
        f.close();
        return new String(b);
    }

    /**
     * reads a bitmap file
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static Bitmap readBitmapFile(File file) throws FileNotFoundException {
        FileInputStream stream = new FileInputStream(file);
        return BitmapFactory.decodeStream(stream);
    }

    /**
     *
     * @param c context of app
     * @param dirName directory
     * @param fileName file name
     * @return bitmap from fileName inside dirName
     * @throws IOException
     */
    public static Bitmap readInternalBitmap(Context c, String dirName, String fileName) throws IOException {
        return readBitmapFile(MoDir.getInternalFile(c,dirName,fileName));
    }

    /**
     *
     * @param c context of app
     * @param fileName of the bitmap
     * @return bitmap from file name
     * @throws IOException
     */
    public static Bitmap readInternalBitmap(Context c, String fileName) throws IOException {
        return readBitmapFile(MoDir.getInternalFile(c,MoDir.BASE_DIR,fileName));
    }


    /**
     * reads the content of the file as
     * string and returns it
     * @param c context of the app
     * @param fileName of the file
     * @return the content of the file as string
     * @throws IOException
     */
    public static String readInternalFile(Context c, String dirName, String fileName) throws IOException {
        return readFile(MoDir.getInternalFile(c,dirName,fileName));
    }

    /**
     * uses the base directory as the directory name
     * to find a file inside there
     * @param c
     * @param fileName
     * @return
     * @throws IOException
     */
    public static String readInternalFile(Context c,String fileName) throws IOException {
        return readInternalFile(c,MoDir.BASE_DIR,fileName);
    }


    /**
     * one by one reads each one of the files
     * inside the directory with name dirName
     * and calls the listener each time the data is
     * obtained, so the developer can handle what they
     * want to with the data
     * @param context of app
     * @param dirName directory name
     * @param listener provides the position and data obtained from there
     * @throws IOException
     */
    public static void readAllDirFiles(Context context,String dirName,MoOnFileReadListener listener) throws IOException {
        File directory = MoDir.getInternalDir(context,dirName);
        File[] files = directory.listFiles();
        if(files==null)
            return;
        for(int i  =0; i < files.length;i++) {
            listener.onRead(readFile(files[i]),i);
        }
    }


    /**
     * same as read all dir files
     * but now everything happens async
     * that means that each file will approximately have its
     * own thread, so the order of file reader listener
     * might be messed up
     * @param context of app
     * @param dirName directory name
     * @param listener provides the position and data obtained from there
     */
    public static void readAllDirFilesAsync(Context context,String dirName,MoOnFileReadListener listener,int nThreads) {
        File directory = MoDir.getInternalDir(context,dirName);
        File[] files = directory.listFiles();
        ExecutorService e = Executors.newFixedThreadPool(nThreads);
        if(files==null)
            return;
        for(int i  =0; i < files.length;i++) {
            int finalI = i;
            e.execute(() -> {
                try {
                    listener.onRead(readFile(files[finalI]), finalI);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }
        e.shutdown();
        while(!e.isTerminated()){}
    }


    /**
     * same as read all dir files
     * but now everything happens async
     * that means that each file will approximately have its
     * own thread, so the order of file reader listener
     * might be messed up
     * @param context of app
     * @param dirName directory name
     * @param listener provides the position and data obtained from there
     */
    public static void readAllDirFilesAsync(Context context,String dirName,MoOnFileReadListener listener) {
        readAllDirFilesAsync(context, dirName, listener,20);
    }



    /**
     * deletes the file from
     * wherever it was located (Internal/External)
     * @param f file to be deleted
     * @return true if the file was deleted
     */
    public static boolean deleteFile(File f){
        return f.delete();
    }

    /**
     * deletes the file located inside
     * [dirName] with the file name [fileName]
     * @param c context of app
     * @param dirName directory name
     * @param fileName file name to be deleted
     * @return true if the file was deleted
     */
    public static boolean deleteInternalFile(Context c,String dirName,String fileName){
        return deleteFile(MoDir.getInternalFile(c,dirName,fileName));
    }

    /**
     * the base directory is used as
     * the directory of the file
     * @param c context of the app
     * @param fileName of the file
     * @return true if the file was deleted
     */
    public static boolean deleteInternalFile(Context c,String fileName){
        return deleteInternalFile(c,MoDir.BASE_DIR,fileName);
    }

}
