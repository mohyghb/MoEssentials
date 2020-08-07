package com.moofficial.moessentials.MoEssentials.MoUI.MoDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.moofficial.moessentials.R;

public class MoDialogs {

    /**
     *
     * @param c context
     * @param title of the dialog
     * @param message of the dialog
     * @param pl when the positive button is pressed we run
     *           this listener
     */
    public static void showAlertDialog(Context c,String title, String message,DialogInterface.OnClickListener pl){
        new AlertDialog.Builder(c)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(c.getString(R.string.yes), pl)
                .setNegativeButton(c.getString(R.string.cancel),null)
                .create().show();
    }

    public static void showAlertDialog(Context c,int title, int message,DialogInterface.OnClickListener pl){
        showAlertDialog(c,c.getString(title),c.getString(message),pl);
    }


}
