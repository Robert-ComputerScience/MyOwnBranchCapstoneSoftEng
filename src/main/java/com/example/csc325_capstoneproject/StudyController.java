package com.example.csc325_capstoneproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Controller class which controls the actions for the landing page of the application.
 * @since 6/14/2025
 * @author Nathaniel Rivera
 */
public class StudyController {

    @FXML
    protected ImageView pfp;

    /**
     * Allows the user to change their profile picture.
     * @since 6/19/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void changePFP() {

        File file = (new FileChooser()).showOpenDialog(pfp.getScene().getWindow());

        if(file != null) {
            pfp.setImage(new Image(file.toURI().toString()));
        }

    }

}