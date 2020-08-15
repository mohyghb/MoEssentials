package com.moofficial.moessentials.MoEssentials.MoId;


import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoLoadable;
import com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO.MoSavable;

// provides id for different classes
public abstract class MoId implements MoSavable,MoLoadable {

    private long id;
    private MoIdController controller;

    public MoId(MoIdController controller){
        this.controller = controller;
        this.id =  this.controller.getNextId();
    }



    public long getId() {
        return id;
    }

    public MoId setId(long id) {
        this.id = id;
        this.controller.updateTrackedId(this.id);
        return this;
    }

    public String stringify(){
        return String.valueOf(id);
    }


}
