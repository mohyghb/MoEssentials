package com.moofficial.moessentials.MoEssentials.MoUI.MoDialog.MoProgressDialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.annotation.StringRes;

import com.moofficial.moessentials.MoEssentials.MoContext.MoContext;

public class MoProgressDialog extends MoContext {

    private ProgressDialog progressDialog;

    public MoProgressDialog(Context c) {
        super(c);
        this.progressDialog = new ProgressDialog(c);
    }

    public MoProgressDialog withTitle(@StringRes int title) {
        return withTitle(getString(title));
    }

    public MoProgressDialog withTitle(String title) {
        progressDialog.setTitle(title);
        return this;
    }

    public MoProgressDialog withMax(int max) {
        progressDialog.setMax(max);
        return this;
    }

    public MoProgressDialog withProgress(int progress) {
        progressDialog.setProgress(progress);
        return this;
    }

    public MoProgressDialog withStyle(int style) {
        progressDialog.setProgressStyle(style);
        return this;
    }

    public MoProgressDialog withProgressDrawable(Drawable d) {
        progressDialog.setProgressDrawable(d);
        return this;
    }

    public MoProgressDialog makeIndeterminate() {
        progressDialog.setIndeterminate(true);
        return this;
    }

    public MoProgressDialog notIndeterminate() {
        progressDialog.setIndeterminate(false);
        return this;
    }

    public ProgressDialog build() {
        return this.progressDialog;
    }


}
