package com.moofficial.moessentials.MoEssentials.MoConnections;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.moofficial.moessentials.MoEssentials.MoString.MoString;
import com.moofficial.moessentials.MoEssentials.MoUtils.MoUriUtils;

import java.util.ArrayList;

public class MoShare {

    private String action;
    private String type;
    private String text;
    private String shareMessage = MoShareUtils.SHARE_MESSAGE;
    private ArrayList<Uri> images = new ArrayList<>();
    private ArrayList<Uri> videos = new ArrayList<>();


    public String getAction() {
        return action;
    }

    public MoShare setAction(String action) {
        this.action = action;
        return this;
    }

    public String getType() {
        return type;
    }

    public MoShare setType(String type) {
        this.type = type;
        return this;
    }

    public String getText() {
        return text;
    }

    public MoShare setText(String text) {
        this.text = text;
        return this;
    }

    public ArrayList<Uri> getImages() {
        return images;
    }

    public MoShare setImages(ArrayList<Uri> images) {
        this.images = images;
        return this;
    }

    public MoShare addImage(Uri i) {
        this.images.add(i);
        return this;
    }


    public ArrayList<Uri> getVideos() {
        return videos;
    }

    public MoShare setVideos(ArrayList<Uri> videos) {
        this.videos = videos;
        return this;
    }

    public MoShare addVideo(Uri v){
        this.videos.add(v);
        return this;
    }

    /**
     * init type and action if they are not valid
     * @param nType
     * @param nAction
     */
    private void initTypeActionIfNull(String nType,String nAction) {
        if(!MoString.isValid(this.type)){
            type = nType;
        }
        if(!MoString.isValid(this.action)){
            action = nAction;
        }
    }

    public MoShare shareText(Context c){
        initTypeActionIfNull(MoShareUtils.TYPE_PLAIN_TEXT,Intent.ACTION_SEND);
        MoShareUtils.share(c,this.text,this.shareMessage,this.type,this.action);
        return this;
    }

    public MoShare shareImages(Context c){
        initMultipleContent(c,images,MoShareUtils.TYPE_ALL_IMAGE);
        return this;
    }

    public MoShare shareVideos(Context c){
        initMultipleContent(c,videos,MoShareUtils.TYPE_ALL_VIDEO);
        return this;
    }

    private void initMultipleContent(Context c,ArrayList<Uri> uris,String allType) {
        if(uris.size()>1){
            initTypeActionIfNull(allType, Intent.ACTION_SEND_MULTIPLE);
            MoShareUtils.share(c,uris,this.shareMessage,this.type,this.action);
        }else {
            initTypeActionIfNull(MoUriUtils.getMimeType(c,uris.get(0)),Intent.ACTION_SEND);
            MoShareUtils.share(c,uris.get(0),this.shareMessage,this.type,this.action);
        }
    }


}
