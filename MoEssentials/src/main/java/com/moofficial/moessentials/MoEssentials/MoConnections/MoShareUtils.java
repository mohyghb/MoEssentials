package com.moofficial.moessentials.MoEssentials.MoConnections;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.util.ArrayList;

public class MoShareUtils {

    public static final String SHARE_MESSAGE = "Choose an app";




    // Types of sharing simple data

    public static final String TYPE_ALL_TEXT = "text/*";
    public static final String TYPE_PLAIN_TEXT = "text/plain";
    public static final String TYPE_RTF_TEXT = "text/rtf";
    public static final String TYPE_HTML_TEXT = "text/html";
    public static final String TYPE_JSON_TEXT = "text/json";

    public static final String TYPE_ALL_IMAGE = "image/*";
    public static final String TYPE_JPG_IMAGE = "image/jpg";
    public static final String TYPE_PNG_IMAGE = "image/png";
    public static final String TYPE_GIF_IMAGE = "image/gif";

    public static final String TYPE_ALL_VIDEO= "video/*";
    public static final String TYPE_MP4_VIDEO= "video/mp4";
    public static final String TYPE_3GP_VIDEO= "video/3gp";

    public static final String TYPE_PDF_APPLICATION = "application/pdf";



    /**
     * shares the textToShare with other apps
     * who can receive a text/html type intent
     * @param c
     * @param textToShare
     */
    public static void share(Context c, String textToShare, String shareMessage, String type,String action){
        Intent sendIntent = new Intent();
        sendIntent.setAction(action);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textToShare);
        sendIntent.setType(type);
        createChooserActivity(c,sendIntent,shareMessage);
    }

    public static void share(Context c, Uri uri,String shareMessage,String type,String action){
        Intent sendIntent = new Intent();
        sendIntent.setAction(action);
        sendIntent.putExtra(Intent.EXTRA_STREAM, uri);
        sendIntent.setType(type);
        createChooserActivity(c,sendIntent,shareMessage);
    }

    public static void share(Context c, ArrayList<Uri> uri, String shareMessage, String type, String action){
        Intent sendIntent = new Intent();
        sendIntent.setAction(action);
        sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uri);
        sendIntent.setType(type);
        createChooserActivity(c,sendIntent,shareMessage);
    }

    /**
     *
     * @param c
     * @param send
     * @param message
     */
    public static void createChooserActivity(Context c,Intent send,String message){
        Intent shareIntent = Intent.createChooser(send, message);
        c.startActivity(shareIntent);
    }

}
