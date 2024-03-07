package com.example.fixsubtitlesapplication.repository;

import com.example.fixsubtitlesapplication.constants.Constants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadLine {
    private File file;
    private BufferedReader br;
    private int lineNumber;
    private String line;
     private ReadLine(File selectedFile) {
         lineNumber = 0;
         file = selectedFile;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            System.out.println("Can't open the file!!!");
        }
    }
    public static ReadLine createInstance(File selectedFile) {
        return new ReadLine(selectedFile);
    }

    public String read(){
         String line = new String();
         if(br == null) {
             System.out.println("ReadLine no instance!!!");
             return null;
         } else {
             try {
                 if ((line = br.readLine()) != null) {
                     if(line.equals("")) {
                         lineNumber = 0;
                     } else {
                         lineNumber++;
                     }
                 }
             } catch (Exception e) {
                 System.out.println("Can't read from file!!!");
             }
         }
         this.line = line;
         return line;
    }
    public void close() {
        try {
            if (br != null) {
                br.close();
            }
            br = null;
        } catch (Exception e) {
            System.out.println("Error closing the file!");
        }
    }
    public int getLineNumber() {
        return lineNumber;
    }

    public String getLine() {
        return line;
    }
}
