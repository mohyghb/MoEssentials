package com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO;

// a mo savable class that has a directory name
// and a file name
// if the developer wants to save each one of its classes
// inside a file, they should use this interface
public interface MoFileSavable extends MoSavable {

    /**

     * @return
     */
    String getDirName();
    String getFileName();

}
