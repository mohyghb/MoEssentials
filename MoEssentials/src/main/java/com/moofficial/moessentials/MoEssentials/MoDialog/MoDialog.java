package com.moofficial.moessentials.MoEssentials.MoDialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;


import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

import java.util.HashMap;

public class MoDialog extends MoContext {

    private View parentView;
    private AlertDialog alertDialog;
    private HashMap<Integer,View> viewHashMap = new HashMap<>();
    private String title,message;
    private Drawable icon;
    private ListAdapter listAdapter;
    private DialogInterface.OnClickListener onClickListener;

    public MoDialog(Context c,View parentView){
        super(c);
        this.parentView = parentView;
    }

    public MoDialog addViews(int key,int id){
        viewHashMap.put(key,parentView.findViewById(id));
        return this;
    }

    public MoDialog addEditText(int key,int id,int hintId){
        addEditText(key,id,getString(hintId),null);
        return this;
    }

    public MoDialog addEditText(int key,int id,int hintId,TextWatcher watcher){
        addEditText(key,id,getString(hintId),watcher);
        return this;
    }

    /**
     * adds an edit text to the views
     * @param key
     * @param id
     * @param hint
     * @param textWatcher
     * @return
     */
    public MoDialog addEditText(int key, int id, String hint, TextWatcher textWatcher){
        EditText editText = parentView.findViewById(id);
        editText.setHint(hint);
        editText.addTextChangedListener(textWatcher);
        viewHashMap.put(key,editText);
        return this;
    }


    /**
     * builds the dialog up
     * @return
     */
    public MoDialog build(){
        alertDialog = new AlertDialog.Builder(this.context)
                .setMessage(this.message)
                .setTitle(this.title)
                .setIcon(this.icon)
                .setView(this.parentView)
                .setAdapter(this.listAdapter,this.onClickListener)
                .create();
        return this;
    }

    public void show(){
        alertDialog.show();
    }

}
