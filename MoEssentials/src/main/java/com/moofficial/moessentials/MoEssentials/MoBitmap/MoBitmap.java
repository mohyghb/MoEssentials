package com.moofficial.moessentials.MoEssentials.MoBitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.moofficial.moessentials.MoEssentials.MoFileManager.MoFileManager;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoFileManagerUtils;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoFile;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoFileSavable;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoLoadable;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoSavable;
import com.moofficial.moessentials.MoEssentials.MoLog.MoLog;

import java.io.IOException;

public abstract class MoBitmap implements MoFileSavable, MoLoadable {



    private MoBitmapId bitmapId = new MoBitmapId();
    private String name;
    private boolean optimized = true;
    private Bitmap bitmap;
    private MoOnBitmapCapturedListener onBitmapCapturedListener = b -> {};


    public MoBitmap(){}

    public MoBitmap(String data,Context context){
        this.load(data,context);
    }

    public MoBitmapId getBitmapId() {
        return bitmapId;
    }

    public MoBitmap setBitmapId(MoBitmapId bitmapId) {
        this.bitmapId = bitmapId;
        return this;
    }

    public MoOnBitmapCapturedListener getOnBitmapCapturedListener() {
        return onBitmapCapturedListener;
    }

    public MoBitmap setOnBitmapCapturedListener(MoOnBitmapCapturedListener onBitmapCapturedListener) {
        this.onBitmapCapturedListener = onBitmapCapturedListener;
        return this;
    }


    public boolean isOptimized() {
        return optimized;
    }

    public MoBitmap setOptimized(boolean optimized) {
        this.optimized = optimized;
        return this;
    }


    public String getName() {
        if(name == null)
            return "";
        return name;
    }

    public MoBitmap setName(String name) {
        this.name = name;
        return this;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


    public void captureBitmap(View view,String name){
        if(optimized && getName().equals(name)){
            MoLog.print("(Optimized) SKIPPED SS");
            return;
        }
        this.bitmap = MoBitmapUtils.createBitmapFromView(view,
                0, 0);
        onBitmapCapturedListener.onBitmapCaptured(this.bitmap);
        setName(name);
    }


    /**
     * captures a bitmap from web view
     * we consider the optimized version as well
     * @param wv
     */
    public void captureBitmap(WebView wv){
        captureBitmap(wv,wv.getUrl());
    }

    /**
     * captures a bitmap from web view with delay
     * @param wv
     * @param delay
     */
    public void captureBitmapWithDelay(WebView wv,long delay){
        Handler h = new Handler();
        h.postDelayed(()->this.captureBitmap(wv),delay);
    }

    /**
     * if the web view is not loading, we capture a bitmap
     * @param wv
     */
    public void captureBitmapIfNotLoading(WebView wv){
        if(wv.getProgress()==100){
            captureBitmap(wv);
            MoLog.print("TAKE_PIC 100");
        }else{
            MoLog.print("NO_PIC " + wv.getProgress());
        }
    }

    /**
     * makes sure that we capture the bitmap
     * even if the name of the new bitmap and the
     * previous one is the same
     * @param wv web view
     */
    public void forceCaptureBitmapIfNotLoading(WebView wv){
        boolean save = optimized;
        optimized = false;
        captureBitmapIfNotLoading(wv);
        optimized = save;
    }

    /**
     * force captures a bitmap from web view even if the
     * optimized version is on
     * @param wv
     */
    public void forceCaptureBitmap(WebView wv){
        boolean save = optimized;
        optimized = false;
        captureBitmap(wv);
        optimized = save;
    }

    /**
     * saves the bitmap inside the directory that is specified,
     * using the file name that has been given to it
     * @param context
     * @throws IOException
     */
    public void saveBitmap(Context context) throws IOException {
        MoFileManagerUtils.writeBitmap(context,this,this.bitmap);
    }

    public void saveBitmap(Context context,int quality,Bitmap.CompressFormat format) throws IOException {
        MoFileManagerUtils.writeBitmap(context,this,quality,format,this.bitmap);
    }

    /**
     * loads a savable object into its class
     *
     * @param data
     * @param context
     */
    @Override
    public void load(String data, Context context) {
        String[] com = MoFile.loadable(data);
        this.bitmapId.load(com[0],context);
        this.name = com[1];
        // loading the bitmap
        loadBitmap(context);
    }

    public void loadBitmap(Context context) {
        try {
            this.bitmap = MoFileManagerUtils.readBitmap(context,this);
        } catch (IOException e) {
            MoLog.print(e.getMessage());
        }
    }

    /**
     * deletes the bitmap file
     * @param c
     */
    public void deleteBitmap(Context c){
        MoFileManagerUtils.delete(c,this);
    }

    /**
     * @return the data that is going to be saved by the save method
     * inside the class which implements MoSavable
     */
    @Override
    public String getData() {
        return MoFile.getData(this.bitmapId,name);
    }



}
