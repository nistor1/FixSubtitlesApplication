package com.example.fixsubtitlesapplication.service;

import com.example.fixsubtitlesapplication.model.Subtitle;

import java.util.ArrayList;

public interface ServiceInterface {
    public void delayTime();
    public void fixSpecialCharacters();

    public ArrayList<Subtitle> getSubtitles();
}
