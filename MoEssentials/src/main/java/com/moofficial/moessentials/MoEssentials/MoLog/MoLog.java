package com.moofficial.moessentials.MoEssentials.MoLog;

import android.util.Log;

public class MoLog {

    private static final String TAG = "MoLog";

    public static void print(String text){
        Log.d(TAG,String.format("========%s========\n",text));
    }


    public static void print(String title,String[] values){
        print(title);
        for(String v:values){
            Log.d(TAG,v);
        }
        print(title);
    }


    public static void print(String[] labels,String[] values,String ... id){
        String a = "";
        for(String i: id){
            a+="|"+i;
        }
        print("start " + a);
        for(int i = 0; i <labels.length; i++){
            System.out.printf("(%s) = %s",labels[i],values[i]);
        }
        System.out.println("\n");
    }


    public static void printRunTime(String tag,Runnable r){
        long s = System.currentTimeMillis();
        r.run();
        long e = System.currentTimeMillis();
        long runtime = e-s;
        MoLog.print(tag+ "Runtime (milliseconds) = " + runtime);
    }



}
