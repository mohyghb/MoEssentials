package com.moofficial.moessentials.MoEssentials.MoFileManager;

import java.io.File;
import java.util.HashSet;

public class MoFileExtension {

    public static final HashSet<String> IMAGE_EXTENSIONS = new HashSet<String>(){{
        add("jpeg");
        add("png");
        add("jpg");
    }};

    public static final HashSet<String> MUSIC_EXTENSIONS = new HashSet<String>(){{
        add("mp3");
        add("wav");
    }};

    public static final HashSet<String> VIDEO_EXTENSIONS = new HashSet<String>(){{
        add("mp4");
        add("mov");
        add("avi");
    }};

    public enum FileType {
        IMAGE,
        VIDEO,
        MUSIC,
        OTHER
    }

    /**
     * returns the file type based on the extension of the file
     * if file is null, we return null
     * @param file to find the type for
     * @return file type
     */
    public static FileType getType(File file) {
        if (file == null) {
            return null;
        }
        String extension = getExtension(file);
        if (IMAGE_EXTENSIONS.contains(extension)) {
            return FileType.IMAGE;
        } else if (MUSIC_EXTENSIONS.contains(extension)) {
            return FileType.MUSIC;
        } else if (VIDEO_EXTENSIONS.contains(extension)) {
            return FileType.VIDEO;
        } else {
            return FileType.OTHER;
        }
    }

    /**
     * gets the extension of the file in lower case
     * @param file to get extension for
     * @return extension of the file in string format
     */
    private static String getExtension(File file) {
        return file.getAbsolutePath()
                .substring(file.getAbsolutePath().lastIndexOf("."))
                .toLowerCase()
                .replace(".","");
    }


}
