package com.example.fixsubtitlesapplication.repository;

import com.example.fixsubtitlesapplication.model.Subtitle;

import java.util.ArrayList;

public interface SubtitlesRepositoryInterface {
    public void findSubtitles();
    public ArrayList<Subtitle> getSubtitles();
}
