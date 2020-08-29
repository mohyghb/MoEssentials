package com.moofficial.moessentials.MoEssentials.MoValidate;

import android.view.View;
import android.widget.TextView;

public class MoTextValidate {

    private boolean validate = true;
    private String errorMessage;
    private View view;

    public boolean isValidate() {
        return validate;
    }

    public MoTextValidate setValidate(boolean validate) {
        this.validate = validate;
        return this;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public MoTextValidate setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public View getView() {
        return view;
    }

    public MoTextValidate setView(View view) {
        this.view = view;
        return this;
    }
}
