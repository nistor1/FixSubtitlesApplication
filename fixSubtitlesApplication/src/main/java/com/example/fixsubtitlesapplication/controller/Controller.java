package com.example.fixsubtitlesapplication.controller;

import com.example.fixsubtitlesapplication.constants.Constants;
import com.example.fixsubtitlesapplication.launcher.ComponentFactory;
import com.example.fixsubtitlesapplication.model.Subtitle;
import com.example.fixsubtitlesapplication.view.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Controller {
    private View view;
    private ComponentFactory componentFactory;
    private File selectedFile;
    public Controller(View view, ComponentFactory componentFactory) {
        this.view = view;
        this.componentFactory = componentFactory;

        view.addFixSpecialCharactersButtonListener(new FixSpecialCharactersButtonListener());
        view.addDelayButtonListener(new DelayButtonListener());
        view.addFileChooserButtonListener(new FileChooserButtonListener());
    }
    private class FixSpecialCharactersButtonListener implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            System.out.println("sterge t");
            if(componentFactory.getInstance() == null) {
                view.setActionTargetText("Vezi ca esti prost?! Alege un fisier!");
                return;
            }

            componentFactory.getService().fixSpecialCharacters();

            System.out.printf("START\n-\n");

            for(Subtitle s : componentFactory.getService().getSubtitles()) {
                System.out.println(s.toString());
            }
            System.out.println("\n-\nEND");

            String fileName = "subtitrareReparata.srt";

            try {
                // Create a FileWriter object with the given file name (or path)
                FileWriter fileWriter = new FileWriter(fileName);

                // Create a BufferedWriter object to write text efficiently
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));

                for(Subtitle s : componentFactory.getService().getSubtitles()) {
                    bufferedWriter.write(s.toString());
                }

                bufferedWriter.close();

                System.out.println("Text written to " + fileName);
            } catch (IOException e) {
                // Handle IO exceptions
                e.printStackTrace();
            }

        }
    }
    private class DelayButtonListener implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("celalt pisat");
            String delay = view.getDelayTime();
            if(delay.length() > 6) {
                view.setActionTargetText("Vezi ca esti prost?! Scrie un numar 00.000!");
                return;
            }
            double delayValue = 0;
            try {
                delayValue = Double.parseDouble(delay);
                Constants.setDelay(delayValue);
                if(componentFactory.getInstance() == null) {
                    view.setActionTargetText("Vezi ca esti prost?! Alege un fisier!");
                    return;
                }
                componentFactory.getService().delayTime();

            } catch (NumberFormatException e) {
                view.setActionTargetText("Vezi ca esti prost?! Scrie un numar 00.000!");
                return;
            }
            System.out.printf("START\n-\n");

            for(Subtitle s : componentFactory.getService().getSubtitles()) {
                System.out.println(s.toString());
            }
            System.out.println("\n-\nEND");

         //   view.setActionTargetText(delay);
            String fileName = "subtitrareReparata.srt";

            try {
                // Create a FileWriter object with the given file name (or path)
                FileWriter fileWriter = new FileWriter(fileName);

                // Create a BufferedWriter object to write text efficiently
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));

                for(Subtitle s : componentFactory.getService().getSubtitles()) {
                    bufferedWriter.write(s.toString());
                }

                bufferedWriter.close();

                System.out.println("Text written to " + fileName);
            } catch (IOException e) {
                // Handle IO exceptions
                e.printStackTrace();
            }


        }
    }
    private class FileChooserButtonListener implements EventHandler<ActionEvent> {
        private static void configureFileChooser(final FileChooser fileChooser) {
            fileChooser.setTitle("Select File");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("All Files", "*.*"),
                    new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif")
            );

        }
        @Override
        public void handle(ActionEvent event) {
                configureFileChooser(view.getFileChooser());
                selectedFile = view.getFileChooser().showOpenDialog(view.getStage());
            Constants.setPath(selectedFile.getPath());
            Constants.setFile(selectedFile);

            if (selectedFile == null) {
                view.setActionTargetText("Vezi ca esti prost?! Da alege si un fisier!");
                return;
            }
           componentFactory = ComponentFactory.getInstance(selectedFile);
        }
    }

}
