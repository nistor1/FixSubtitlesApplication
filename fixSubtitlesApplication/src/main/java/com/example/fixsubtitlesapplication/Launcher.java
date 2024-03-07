package com.example.fixsubtitlesapplication;

import com.example.fixsubtitlesapplication.controller.Controller;
import com.example.fixsubtitlesapplication.launcher.ComponentFactory;
import com.example.fixsubtitlesapplication.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        View view = new View(primaryStage);
        Controller controller = new Controller(view, null);
    }

    public static void main(String[] args) {

        launch(args);

/*



        System.out.printf("START\n-\n");
        SubtitlesAttributesRepositoryInterface subtitlesRepositoryInterface = new SubtitlesAttributesRepository();
        SubtitlesRepositoryInterface repository = new SubtitlesRepository(subtitlesRepositoryInterface);
        repository.findSubtitles();
        Service service= new Service();
        service.fixSpecialCharacters();
        service.delayTime();

        for(Subtitle s : service.getSubtitles()) {
            System.out.println(s.toString());
        }
        System.out.println("\n-\nEND");

        String fileName = "example.srt";

        try {
            // Create a FileWriter object with the given file name (or path)
            FileWriter fileWriter = new FileWriter(fileName);

            // Create a BufferedWriter object to write text efficiently
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8));

            for(Subtitle s : service.getSubtitles()) {
                bufferedWriter.write(s.toString());
            }

            bufferedWriter.close();

            System.out.println("Text written to " + fileName);
        } catch (IOException e) {
            // Handle IO exceptions
            e.printStackTrace();


        } */
    }
}