package com.moofficial.moessentials.MoEssentials.MoFileManager;

public interface MoOnFileReadListener {

    /**
     * this is called when the read
     * method is done reading the file and
     * the content of it is ready to be processed
     * @param content content of the file
     * @param position of the file (if there are
     *                 multiple files to be read inside a dir
     *                 if you are just reading one file, this is set to 0)
     */
    void onRead(String content,int position);

}
