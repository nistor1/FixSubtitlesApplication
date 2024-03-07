package com.example.fixsubtitlesapplication.service;

import com.example.fixsubtitlesapplication.model.Subtitle;
import com.example.fixsubtitlesapplication.repository.SubtitlesRepositoryInterface;

import java.util.ArrayList;

public class Service implements ServiceInterface{
    private SubtitlesRepositoryInterface subtitlesRepository;
    private ArrayList<Subtitle> subtitles;
    private SpecialCharactersServiceInterface specialCharactersService;
    private TimeServiceInterface timeService;
    public Service(){};

    public Service(SubtitlesRepositoryInterface subtitlesRepository, SpecialCharactersServiceInterface specialCharactersService, TimeServiceInterface timeService) {
        this.subtitlesRepository = subtitlesRepository;
        this.subtitles = subtitlesRepository.getSubtitles();
        this.specialCharactersService = specialCharactersService;
        this.timeService = timeService;
    }

    public void delayTime() {
        this.subtitles = this.timeService.delayTime();
    }
    public void fixSpecialCharacters() {
        this.subtitles = this.specialCharactersService.fixSpecialCharacters();
    }

    public ArrayList<Subtitle> getSubtitles() {
        return subtitles;
    }
}
