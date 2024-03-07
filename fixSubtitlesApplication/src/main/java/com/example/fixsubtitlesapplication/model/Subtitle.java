package com.example.fixsubtitlesapplication.model;

import java.util.ArrayList;

public class Subtitle {
    private int id;
    private Time time1;
    private Time time2;
    private ArrayList<String> lines;

    public Subtitle (int id, Time time1, Time time2, ArrayList<String> lines) {
        this.id = id;
        this.time1 = time1;
        this.time2 = time2;
        this.lines = lines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getTime1() {
        return time1;
    }

    public void setTime1(Time time1) {
        this.time1 = time1;
    }

    public Time getTime2() {
        return time2;
    }

    public void setTime2(Time time2) {
        this.time2 = time2;
    }

    public ArrayList<String> getLines() {
        return lines;
    }

    public void setLines(ArrayList<String> lines) {
        this.lines = lines;
    }
    public void addLine(String line) {
        this.lines.add(line);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(id);
        stringBuilder.append("\n");
        stringBuilder.append(String.format("%02d", time1.getHours()) + ":" + String.format("%02d", time1.getMinutes()) + ":" + String.format("%05.3f", time1.getSeconds()));
        stringBuilder.append(" --> ");
        stringBuilder.append(String.format("%02d", time2.getHours()) + ":" + String.format("%02d", time2.getMinutes()) + ":" + String.format("%05.3f", time2.getSeconds()));
        stringBuilder.append("\n");
        for(String l : lines) {
            stringBuilder.append(l.toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }
}
