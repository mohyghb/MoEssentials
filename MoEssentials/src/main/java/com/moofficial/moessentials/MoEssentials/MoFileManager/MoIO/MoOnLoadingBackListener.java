package com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO;

import android.content.Context;

public interface MoOnLoadingBackListener <T extends MoLoadable>{


    T getObject(Context context,String data);
}
