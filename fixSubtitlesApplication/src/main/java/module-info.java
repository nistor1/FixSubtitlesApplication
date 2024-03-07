module com.example.fixsubtitlesapplication {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fixsubtitlesapplication to javafx.fxml;

    exports com.example.fixsubtitlesapplication;
    exports com.example.fixsubtitlesapplication.controller;
    exports com.example.fixsubtitlesapplication.repository;
    exports com.example.fixsubtitlesapplication.service;
    exports com.example.fixsubtitlesapplication.model;
    exports com.example.fixsubtitlesapplication.constants;
    exports com.example.fixsubtitlesapplication.view;
    exports com.example.fixsubtitlesapplication.launcher;
    opens com.example.fixsubtitlesapplication.launcher to javafx.fxml;
}