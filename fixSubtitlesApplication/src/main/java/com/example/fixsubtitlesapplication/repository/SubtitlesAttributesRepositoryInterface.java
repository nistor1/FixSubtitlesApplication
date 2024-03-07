package com.example.fixsubtitlesapplication.repository;

import com.example.fixsubtitlesapplication.model.Time;

public interface SubtitlesAttributesRepositoryInterface {
    public int getId(String line);
    public Time getTime1(String line);
    public Time getTime2(String line);
}
