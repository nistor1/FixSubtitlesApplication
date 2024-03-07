package com.example.fixsubtitlesapplication.repository;

import com.example.fixsubtitlesapplication.model.Time;

public class SubtitlesAttributesRepository implements SubtitlesAttributesRepositoryInterface {
    @Override
    public int getId(String line) {
        int id = Integer.parseInt(line);
        return id;
    }

    @Override
    public Time getTime1(String line) {
        String[] parts = line.split(":|-->");
        try {
            // Parse the first part to an integer
            int firstNumber = Integer.parseInt(parts[1]);

            // Parse the second part to an integer
            int secondNumber = Integer.parseInt(parts[0]);

            StringBuilder stringBuilder = new StringBuilder(parts[2]);
            stringBuilder.setCharAt(2, '.');
            double thirdNumber = Double.parseDouble(stringBuilder.toString());

            return new Time(thirdNumber, firstNumber, secondNumber);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number format or missing parts");
        }
        return null;
    }

    @Override
    public Time getTime2(String line) {
        String[] parts = line.split("[:\\-]+| --> ");
        try {
            // Parse the first part to an integer
            int firstNumber = Integer.parseInt(parts[4]);

            // Parse the second part to an integer
            int secondNumber = Integer.parseInt(parts[3]);

            StringBuilder stringBuilder = new StringBuilder(parts[5]);
            stringBuilder.setCharAt(2, '.');
            double thirdNumber = Double.parseDouble(stringBuilder.toString());

            return new Time(thirdNumber, firstNumber, secondNumber);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid number format or missing parts");
        }
        return null;
    }
}
