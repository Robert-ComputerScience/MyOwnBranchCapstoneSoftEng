package com.example.csc325_capstoneproject;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    protected TextField usernameField;

    @FXML
    protected TextField emailField;

    @FXML
    protected TextField passwordField;

    @FXML
    protected TextField firstNameField;

    @FXML
    protected TextField lastNameField;

    /**
     * Registers a new user into the program.
     * @author Nathaniel Rivera
     * @since 6/23/2025
     */
    @FXML
    protected void register() {
        System.out.println(usernameField.getText());
    }
}
