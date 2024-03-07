package com.example.fixsubtitlesapplication.constants;

import java.io.File;

public class Constants {
    private static String FILE_PATH = "subtitrari.srt";
    private static File FILE = null;
    private static double DELAY = 3.0;

    public static void setPath(String s){
        FILE_PATH = s;
    }
    public static void setDelay(double delay){
        DELAY = delay;
    }
    public static String getPath(){
        return FILE_PATH;
    }
    public static double getDelay(){
        return DELAY;
    }
    public static File getFile() {
        return FILE;
    }

    public static void setFile(File File) {
        Constants.FILE = File;
    }
}
