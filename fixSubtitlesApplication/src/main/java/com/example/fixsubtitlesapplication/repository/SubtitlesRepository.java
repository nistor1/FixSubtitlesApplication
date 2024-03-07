package com.example.fixsubtitlesapplication.repository;

import com.example.fixsubtitlesapplication.model.Subtitle;

import java.io.File;
import java.util.ArrayList;

public class SubtitlesRepository implements SubtitlesRepositoryInterface{
    private SubtitlesAttributesRepositoryInterface subtitlesInterface;
    private ReadLine readLine;
    private ArrayList<Subtitle> subtitles = new ArrayList<>();
    private File selectedFile;
    public SubtitlesRepository(SubtitlesAttributesRepositoryInterface subtitlesInterface, File selectedFile) {
        this.subtitlesInterface = subtitlesInterface;
        this.selectedFile = selectedFile;
        readLine = ReadLine.createInstance(selectedFile);
    }
    public void findSubtitles(){
        Subtitle subtitle = new Subtitle(0, null, null, new ArrayList<>());
        while(readLine.read() != null) {
            if(readLine.getLineNumber() == 1) {
                subtitle.setId(subtitlesInterface.getId(readLine.getLine()));
            } else if (readLine.getLineNumber() == 2) {
                subtitle.setTime1(subtitlesInterface.getTime1(readLine.getLine()));
                subtitle.setTime2(subtitlesInterface.getTime2(readLine.getLine()));
            } else if (readLine.getLineNumber() > 2) {
                subtitle.addLine(readLine.getLine());
            } else if (readLine.getLineNumber() == 0) {
                subtitles.add(subtitle);
                subtitle = new Subtitle(0, null, null, new ArrayList<>());
            }
        }
        readLine.close();
    }
    public ArrayList<Subtitle> getSubtitles() {
        return subtitles;
    }
}
