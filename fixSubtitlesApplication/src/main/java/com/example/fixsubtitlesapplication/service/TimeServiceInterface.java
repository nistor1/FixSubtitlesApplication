package com.example.fixsubtitlesapplication.service;

import com.example.fixsubtitlesapplication.model.Subtitle;
import com.example.fixsubtitlesapplication.repository.SubtitlesRepositoryInterface;

import java.util.ArrayList;

public interface TimeServiceInterface {
    public ArrayList<Subtitle> delayTime();
}
