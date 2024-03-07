package com.example.fixsubtitlesapplication.service;

import com.example.fixsubtitlesapplication.constants.Constants;
import com.example.fixsubtitlesapplication.model.Subtitle;
import com.example.fixsubtitlesapplication.model.Time;

import java.util.ArrayList;

public class TimeService implements TimeServiceInterface {
    private ArrayList<Subtitle> subtitles;
    public TimeService(ArrayList<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }

    public Time addDelay(Time t) {
        double seconds = t.getSeconds() + Constants.getDelay();
        if(seconds > 59.9) {
            int cate = (int)(seconds / 60);
            seconds %= 60;
            int minutes = t.getMinutes();
            minutes += cate;
            if(minutes > 59) {
                cate = (int)(minutes / 60);
                minutes %= 60;
                int hours = t.getHours();
                hours++;
                t.setHours(hours);
            }
            t.setMinutes(minutes);
        }
        t.setSeconds(seconds);
        return t;
    }
    @Override
    public ArrayList<Subtitle>  delayTime() {
        for (Subtitle s : subtitles) {
            subtitles.get(s.getId()-1).setTime1(addDelay(s.getTime1()));
            subtitles.get(s.getId()-1).setTime2(addDelay(s.getTime2()));
        }
        return subtitles;
    }
}
