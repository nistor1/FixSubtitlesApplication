package com.example.fixsubtitlesapplication.launcher;


import com.example.fixsubtitlesapplication.repository.SubtitlesAttributesRepository;
import com.example.fixsubtitlesapplication.repository.SubtitlesAttributesRepositoryInterface;
import com.example.fixsubtitlesapplication.repository.SubtitlesRepository;
import com.example.fixsubtitlesapplication.repository.SubtitlesRepositoryInterface;
import com.example.fixsubtitlesapplication.service.Service;
import com.example.fixsubtitlesapplication.service.ServiceInterface;
import com.example.fixsubtitlesapplication.service.SpecialCharactersService;
import com.example.fixsubtitlesapplication.service.TimeService;

import java.io.File;

public class ComponentFactory {


    private static ComponentFactory instance;
    private SubtitlesAttributesRepositoryInterface subtitlesRepositoryInterface;
    private SubtitlesRepositoryInterface repository;
    private ServiceInterface service;
    public static ComponentFactory getInstance(File selectedFile) {
        instance = new ComponentFactory(selectedFile);

        return instance;
    }

    public ComponentFactory(File selectedFile) {
        this.subtitlesRepositoryInterface = new SubtitlesAttributesRepository();
        this.repository = new SubtitlesRepository(subtitlesRepositoryInterface, selectedFile);
        repository.findSubtitles();
        this.service = new Service(repository, new SpecialCharactersService(repository.getSubtitles()), new TimeService(repository.getSubtitles()));
    }

    public static ComponentFactory getInstance() {
        return instance;
    }

    public SubtitlesAttributesRepositoryInterface getSubtitlesRepositoryInterface() {
        return subtitlesRepositoryInterface;
    }

    public SubtitlesRepositoryInterface getRepository() {
        return repository;
    }

    public ServiceInterface getService() {
        return service;
    }

}
