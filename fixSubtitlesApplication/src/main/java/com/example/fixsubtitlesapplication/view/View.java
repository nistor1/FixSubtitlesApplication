package com.example.fixsubtitlesapplication.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class View {

    private TextField delayTime;
    private PasswordField passwordField;
    private Button signInButton;
    private Button logInButton;
    private Button fileChooserButton;
    private FileChooser fileChooser;
    private Text actiontarget;
    private Stage stage;
    public View(Stage stage) {
        this.stage = stage;

        stage.setTitle("Fix Subtitles!");


        GridPane gridPane = new GridPane();
        initializeGridPane(gridPane);

        Scene scene = new Scene(gridPane, 800, 500);
        stage.setScene(scene);

        initializeSceneTitle(gridPane);
        initializeFields(gridPane);


        stage.show();
        this.stage = stage;
    }

    private void initializeGridPane(GridPane gridPane) {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
    }
    private void initializeSceneTitle(GridPane gridPane) {
        Text sceneTitle = new Text("Fix Subtitles");
        sceneTitle.setFont(Font.font("Tahome", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0, 2, 1);
    }

    private void initializeFields(GridPane gridPane) {
        fileChooser = new FileChooser();
        fileChooserButton = new Button("Open FileChooser");


        gridPane.add(fileChooserButton, 0, 2);
        Label userName = new Label("Enter delay time: ");
        gridPane.add(userName, 0, 1);

        delayTime = new TextField();
        gridPane.add(delayTime, 1, 1);

        signInButton = new Button("Add delay!");
        HBox signInButtonHBox = new HBox(10);
        signInButtonHBox.setAlignment(Pos.BOTTOM_RIGHT);
        signInButtonHBox.getChildren().add(signInButton);
        gridPane.add(signInButtonHBox, 1, 4);

        logInButton = new Button("Fix special characters!");
        HBox logInButtonHBox = new HBox(10);
        logInButtonHBox.setAlignment(Pos.BOTTOM_LEFT);
        logInButtonHBox.getChildren().add(logInButton);
        gridPane.add(logInButtonHBox, 0, 4);

        actiontarget = new Text();
        actiontarget.setFill(Color.FIREBRICK);
        gridPane.add(actiontarget, 1, 6);
    }

    public void setActionTargetText(String text) {
        this.actiontarget.setText(text);
    }
    public void addFileChooserButtonListener(EventHandler<ActionEvent> fileChooserButtonListener) {
        fileChooserButton.setOnAction(fileChooserButtonListener);
    }
    public void addFixSpecialCharactersButtonListener(EventHandler<ActionEvent> loginButtonListener) {
        logInButton.setOnAction(loginButtonListener);
    }

    public void addDelayButtonListener(EventHandler<ActionEvent> signInButtonListener) {
        signInButton.setOnAction(signInButtonListener);
    }

    public String getDelayTime() {
        return delayTime.getText();
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getSignInButton() {
        return signInButton;
    }

    public Button getLogInButton() {
        return logInButton;
    }

    public Button getFileChooserButton() {
        return fileChooserButton;
    }

    public Text getActiontarget() {
        return actiontarget;
    }

    public Stage getStage() {
        return stage;
    }

    public FileChooser getFileChooser() {
        return fileChooser;
    }
}
