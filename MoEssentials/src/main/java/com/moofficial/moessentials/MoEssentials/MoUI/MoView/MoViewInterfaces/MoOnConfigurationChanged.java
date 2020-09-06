package com.moofficial.moessentials.MoEssentials.MoUI.MoView.MoViewInterfaces;

import android.content.res.Configuration;

public interface MoOnConfigurationChanged {

    String ON_CONFIG_CHANGED = "on_config_changed";

    void onConfigurationChanged(Configuration newConfig);

}
