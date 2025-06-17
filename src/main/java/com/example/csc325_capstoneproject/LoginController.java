package com.example.csc325_capstoneproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private TextField userText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField passText;

    String password;
    String email;
    String username;


    @FXML
    private void loginPressed() {

    }


    public void passTyped(ActionEvent actionEvent) {
     password = passText.getText();
    }

    public void emailTyped(ActionEvent actionEvent) {
        email = emailText.getText();
    }

    public void UserTyped(ActionEvent actionEvent) {
      username = userText.getText();
    }
}
