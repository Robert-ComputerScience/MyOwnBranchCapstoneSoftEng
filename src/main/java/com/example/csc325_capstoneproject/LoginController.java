package com.example.csc325_capstoneproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    protected Button registerButton;

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

    @FXML
    protected void register() {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyApplication.class.getResource("register-view.fxml"));

        Stage stage = (Stage) registerButton.getScene().getWindow();

        try {
            Stage registerStage = new Stage();
            AnchorPane registerRoot = new AnchorPane();
            registerRoot.getChildren().add(fxmlLoader.load());

            Scene scene = new Scene(registerRoot, 650, 380);
            //registerStage.getStylesheets().add(Objects.requireNonNull(getClass().getResource("splashscreen.css")).toExternalForm());
            registerStage.setScene(scene);
            registerStage.setResizable(false);
            registerStage.initStyle(StageStyle.UNDECORATED);
            //registerStage.getIcons().add(new Image(Objects.requireNonNull(StudyApplication.class.getResourceAsStream())));
            stage.close();
            registerStage.show();
        } catch(Exception _) { }
    }
}
