package com.moofficial.moessentials.MoEssentials.MoDialog;

import android.content.DialogInterface;

public interface MoOnDialogTextInputListener {

    void onPositiveButtonPressed(DialogInterface dialogInterface, String input);
    void onNegativeButtonPressed(DialogInterface dialogInterface, String input);

}
