package com.moofficial.moessentials.MoEssentials.MoLog;

public class MoLog {

    public static void print(String text){
        System.out.printf("====================%s====================\n",text);
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


}
