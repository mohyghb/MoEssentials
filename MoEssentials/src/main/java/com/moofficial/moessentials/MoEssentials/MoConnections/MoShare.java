package com.moofficial.moessentials.MoEssentials.MoConnections;

import android.content.Context;
import android.content.Intent;

public class MoShare {

    public static final String SHARE_MESSAGE = "Choose an app";



    /**
     * shares the textToShare with other apps
     * who can receive a text/html type intent
     * @param c
     * @param textToShare
     */
    public static void share(Context c,String textToShare,String shareMessage){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
        sendIntent.setType("text/html");
        Intent shareIntent = Intent.createChooser(sendIntent, shareMessage);
        c.startActivity(shareIntent);
    }

    public static void share(Context c,String textToShare){
        share(c,textToShare,SHARE_MESSAGE);
    }

}
