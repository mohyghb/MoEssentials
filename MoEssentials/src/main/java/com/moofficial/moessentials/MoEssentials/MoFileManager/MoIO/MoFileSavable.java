package com.moofficial.moessentials.MoEssentials.MoFileManager.MoIO;

import android.content.Context;

import com.moofficial.moessentials.MoEssentials.MoFileManager.MoFileManagerUtils;

import java.io.IOException;

// a mo savable class that has a directory name
// and a file name
// if the developer wants to save each one of its classes
// inside a file, they should use this interface
// they also get the ability to save or delete files
// of this class automatically
public interface MoFileSavable extends MoSavable {

    /**

     * @return
     */
    String getDirName();
    String getFileName();

    /**
     * saves the file inside the dir
     * that is provided with file name
     * and its savable content
     * @param c context required
     * @throws IOException
     */
    default void save(Context c) throws IOException {
        MoFileManagerUtils.write(c,this);
    }

    /**
     * deletes the file from
     * the dir that is provided
     * @param c context required
     */
    default void delete(Context c) {
        MoFileManagerUtils.delete(c,this);
    }

}
