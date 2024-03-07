package com.example.fixsubtitlesapplication.service;

import com.example.fixsubtitlesapplication.model.Subtitle;
import com.example.fixsubtitlesapplication.repository.SubtitlesRepositoryInterface;

import java.util.ArrayList;

public class SpecialCharactersService implements SpecialCharactersServiceInterface{

    private ArrayList<Subtitle> subtitles;
    public SpecialCharactersService(ArrayList<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }
    public SpecialCharactersService() {}
    public ArrayList<Subtitle> fixSpecialCharacters(){
        for(Subtitle s : subtitles) {
            int cnt = 0;
            for(String l : s.getLines()) {
                StringBuilder stringBuilder = new StringBuilder(l);
                int ok = 0;
                for (int i = 0; i < stringBuilder.length(); i++) {
                    if (stringBuilder.charAt(i) == 0xE3) { // ă ciudat
                        char c = 0x103;
                        stringBuilder.setCharAt(i, c);
                        ok++;
                    } else if (stringBuilder.charAt(i) == 0xFE) { // ț ciudat
                        char c = 0x21B;
                        stringBuilder.setCharAt(i, c);
                        ok++;
                    } if (stringBuilder.charAt(i) == 0xBA) { // ș ciudat
                        char c = 0x219;
                        stringBuilder.setCharAt(i, c);
                        ok++;
                    } if (stringBuilder.charAt(i) == 0xAA) { // Ș ciudat
                        char c = 0x218;
                        stringBuilder.setCharAt(i, c);
                        ok++;
                    }
                }
                if(ok > 0) {
                    s.getLines().set(cnt, stringBuilder.toString());
                }
                cnt++;
            }
        }
        return subtitles;
    }
}
