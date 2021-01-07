package com.moofficial.moessentials.MoEssentials.MoUI.MoDialog;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;
import com.moofficial.moessentials.MoEssentials.MoUI.MoDynamicUnit.MoDynamicUnit;
import com.moofficial.moessentials.MoEssentials.MoUI.MoInflatorView.MoInflaterView;
import com.moofficial.moessentials.R;


public class MoDialogBuilder extends MoContext {


    public static final float MO_EDIT_TEXT_PADDING = 14f;
    public static final float MO_ICON_PADDING =16f;

    public MoDialogBuilder(Context c) {
        super(c);
    }






//    public static void showUserInputTextLayoutDialog(Context context,String title,String message,
//                                                String pButton,String nButton,
//                                                MoOnDialogButtonClickedListener onDialogTextInputListener){
//        View v = MoInflaterView.inflate(R.layout.mo_input_bar,context);
//        applyPadding(v,MO_EDIT_TEXT_PADDING);
//        EditText editText = v.findViewById(R.id.input_bar_edit_text);
//        AlertDialog alertDialog = new AlertDialog.Builder(context)
//                .setTitle(title)
//                .setMessage(message)
//                .setView(v)
//                .setPositiveButton(pButton, (dialogInterface, i) -> {
//                    onDialogTextInputListener.onPositiveButtonPressed(dialogInterface, editText.getText().toString());
//                })
//                .setNegativeButton(nButton, (dialogInterface, i) -> {
//                    onDialogTextInputListener.onNegativeButtonPressed(dialogInterface,editText.getText().toString());
//                    dialogInterface.dismiss();
//                })
//                .create();
//        alertDialog.show();
//    }





}
