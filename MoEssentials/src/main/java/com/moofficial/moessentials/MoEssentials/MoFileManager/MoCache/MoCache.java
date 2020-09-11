package com.moofficial.moessentials.MoEssentials.MoFileManager.MoCache;

import android.content.Context;
import android.util.Log;
import android.util.Pair;

import com.moofficial.moessentials.MoEssentials.MoLog.MoLog;

import java.io.File;
import java.util.Objects;

// construction
public class MoCache {

    static final String TAG = "MoCache";

    public static void printCache(Context c) {
        File f = c.getCacheDir();
        recurse(f,0);
    }

    public static void recurse(File f,int indent) {
        if(f == null) {
            return;
        }
        write(f,indent);
        File[] files = f.listFiles();
        if(files == null) {
            return;
        }
        for(File a: files) {
            recurse(a,indent+1);
        }
    }

    public static void write(File f,int indent){
        if(f==null) return;
        Pair<Integer,Long> p = numItemsUnder(f);
        long length = p.second;
        int size = p.first;
        String name = f.getName();
        Log.d(TAG,produceIndent(indent) + String.format("Name = %s,length = %s,itemsCount = %s",name,length,size));
    }

    public static String produceIndent(int indent){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<indent;i++){
            sb.append("=");
        }
        return sb.toString();
    }

    /**
     * <number of files,total space of this file>
     * @param f
     * @return
     */
    public static Pair<Integer,Long> numItemsUnder(File f) {
        if(f==null) {
            //Log.d(TAG,"null m");
            return new Pair<>(0,0L) ;
        }
        File[] files = f.listFiles();
        if(files == null){
            //Log.d(TAG,"null files");
            return new Pair<>(1,f.length());
        }
        Integer i = 1;
        Long l = f.length();
        for(File a: files){
            Pair<Integer,Long> m = numItemsUnder(a);
            i+=m.first;
            l+=m.second;
        }

        return new Pair<>(i,l);
    }

}
