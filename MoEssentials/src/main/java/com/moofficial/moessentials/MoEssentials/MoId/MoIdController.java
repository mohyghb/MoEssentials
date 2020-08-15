package com.moofficial.moessentials.MoEssentials.MoId;

// controls the id so no duplicate ids
// are present inside the application for the same
// class twice
public class MoIdController {

    private long highestTrackedId;


    /**
     * returns an id which is not yet used inside
     * our application, since we are tracking
     * the highest id seen so far
     * @return an available id
     */
    protected long getNextId(){
        highestTrackedId++;
        return highestTrackedId;
    }

    /**
     * we update the tracked id
     * so that we always have an id that is never
     * used before
     * @param id
     */
    protected void updateTrackedId(long id){
        if(id>highestTrackedId){
            highestTrackedId = id;
        }
    }

}
