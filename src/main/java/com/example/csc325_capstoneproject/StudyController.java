package com.example.csc325_capstoneproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StudyController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}