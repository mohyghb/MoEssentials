package com.moofficial.moessentials.MoEssentials.MoKeyGuard;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;

import static android.content.Context.KEYGUARD_SERVICE;

public class MoKeyGuard {

    public static final int AUTHENTICATION_REQUEST_CODE = 1;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void authenticateUser(Activity a, String title, String description) {
        authenticateUser(a,AUTHENTICATION_REQUEST_CODE,title,description);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void authenticateUser(Activity a, int requestCode ,String title, String description) {
        KeyguardManager km = (KeyguardManager) a.getSystemService(KEYGUARD_SERVICE);
        Intent authIntent = km.createConfirmDeviceCredentialIntent(title, description);
        a.startActivityForResult(authIntent,requestCode);
    }

}
