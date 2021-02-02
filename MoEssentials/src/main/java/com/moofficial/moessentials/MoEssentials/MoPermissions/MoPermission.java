package com.moofficial.moessentials.MoEssentials.MoPermissions;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class MoPermission {

    public static final int MULTIPLE_PERMISSIONS_REQUEST_ID = 12;

    private Activity ac;
    private String[] requestPermissions;
    private int requestCode = MULTIPLE_PERMISSIONS_REQUEST_ID;

    public MoPermission(Activity context){
        this.ac = context;
    }


    public MoPermission setPermissions(String ... permissions){
        this.requestPermissions = permissions;
        return this;
    }

    public MoPermission setRequestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public boolean checkAndRequestPermissions() {
        List<String> listPermissionsNeeded = new ArrayList<>();
        for(String permission:this.requestPermissions){
            int status = ContextCompat.checkSelfPermission(ac, permission);
            if(status != PackageManager.PERMISSION_GRANTED){
                // then that permission is not granted
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(ac,listPermissionsNeeded.toArray
                    (new String[0]),this.requestCode);
            return false;
        }
        return true;
    }

    /**
     * if all the permissions were granted
     * @param grantResults
     * @return
     */
    public static boolean allGranted(int[] grantResults) {
        for (int permission : grantResults) {
            if (permission == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }

}
