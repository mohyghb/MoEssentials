package com.moofficial.moessentials.MoEssentials.MoUI.MoDialog;

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
    private MoOnDialogButtonClickedListener onDialogButtonClickedListener;

    public MoDialog(Context c,View parentView){
        super(c);
        this.parentView = parentView;
    }

    public View getParentView() {
        return parentView;
    }

    public MoDialog setParentView(View parentView) {
        this.parentView = parentView;
        return this;
    }

    public AlertDialog getAlertDialog() {
        return alertDialog;
    }

    public MoDialog setAlertDialog(AlertDialog alertDialog) {
        this.alertDialog = alertDialog;
        return this;
    }

    public HashMap<Integer, View> getViewHashMap() {
        return viewHashMap;
    }

    public MoDialog setViewHashMap(HashMap<Integer, View> viewHashMap) {
        this.viewHashMap = viewHashMap;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public MoDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public MoDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public Drawable getIcon() {
        return icon;
    }

    public MoDialog setIcon(Drawable icon) {
        this.icon = icon;
        return this;
    }

    public ListAdapter getListAdapter() {
        return listAdapter;
    }

    public MoDialog setListAdapter(ListAdapter listAdapter) {
        this.listAdapter = listAdapter;
        return this;
    }

    public DialogInterface.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public MoDialog setOnClickListener(DialogInterface.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public MoDialog addViews(int key, int id){
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
