package com.moofficial.moessentials.MoEssentials.MoBitmap;

import android.content.Context;

import com.moofficial.moessentials.MoEssentials.MoId.MoId;
import com.moofficial.moessentials.MoEssentials.MoId.MoIdController;

public class MoBitmapId extends MoId {

    public static final MoIdController controller = new MoIdController();

    public MoBitmapId() {
        super(controller);
    }

    @Override
    public void load(String data, Context context) {
        this.setId(Long.parseLong(data));
    }

    @Override
    public String getData() {
        return String.valueOf(this.getId());
    }
}
