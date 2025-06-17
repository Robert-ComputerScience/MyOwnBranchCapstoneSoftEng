package com.example.csc325_capstoneproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 *
 * @since 6/14/25
 * @author Nathaniel Rivera
 */
public class StudyApplication extends Application {

    /**
     * The initial start method for the study application. Launches and calls the setup for the splash screen.
     * @param stage The stage in which the splash screen is held
     * @throws IOException Throws an exception
     * @author Nathaniel Rivera
     * @since 6/14/2025
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyApplication.class.getResource("splash-view.fxml"));

        AnchorPane root = new AnchorPane();
        root.getChildren().add(fxmlLoader.load());
        splashSetup(root, stage);

        Scene scene = new Scene(root, 1200, 700);
        //scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("splashscreen.css")).toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.getIcons().add(new Image(Objects.requireNonNull(StudyApplication.class.getResourceAsStream())));
        stage.show();
    }

    /**
     * Main method of the program. Launches the application when the program is run.
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Sets up the interactable parts of the Splash page.
     * These elements include the system tray replacements, the login button and the launcher.
     * @param root  The AnchorPane for the splash screen.
     * @param stage The stage the splash scene is set in.
     * @author Nathaniel Rivera
     * @since 6/14/2025
     */
    public static void splashSetup(AnchorPane root, Stage stage) {

        Button launcher = new Button();
        launcher.setPrefWidth(300);
        launcher.setPrefHeight(100);
        launcher.setLayoutX(850);
        launcher.setLayoutY(550);
        launcher.setText("Launch");
        root.getChildren().add(launcher);
        launcher.setOnAction(e -> {

            FXMLLoader fxmlLoader = new FXMLLoader(StudyApplication.class.getResource("landing-view.fxml"));

            try {
                Stage landingStage = new Stage();
                AnchorPane landingRoot = new AnchorPane();
                landingRoot.getChildren().add(fxmlLoader.load());

                Scene scene = new Scene(landingRoot, 1200, 700);
                //landingStage.getStylesheets().add(Objects.requireNonNull(getClass().getResource("splashscreen.css")).toExternalForm());
                landingStage.setScene(scene);
                landingStage.setResizable(false);
                //landingStage.getIcons().add(new Image(Objects.requireNonNull(StudyApplication.class.getResourceAsStream())));
                stage.close();
                landingStage.show();
            } catch(Exception _) { }
        });

        /*------------------------------------------System Tray Replacement Buttons------------------------------------------*/

        Button close = new Button();
        close.setPrefWidth(25);
        close.setPrefHeight(25);
        close.setLayoutX(1160);
        close.setLayoutY(15);
        close.setOpacity(0);
        root.getChildren().add(close);

        close.setOnAction(e -> {
            stage.close();
        });

        Button minimize = new Button();
        minimize.setPrefWidth(25);
        minimize.setPrefHeight(25);
        minimize.setLayoutX(1120);
        minimize.setLayoutY(15);
        minimize.setOpacity(0);
        root.getChildren().add(minimize);

        minimize.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).setIconified(true);
            }
        });

        Button login = new Button();
        login.setPrefWidth(25);
        login.setPrefHeight(25);
        login.setLayoutX(1080);
        login.setLayoutY(15);
        login.setOpacity(0);
        root.getChildren().add(login);

        login.setOnAction(e -> {

            FXMLLoader fxmlLoader = new FXMLLoader(StudyApplication.class.getResource("login-view.fxml"));

            try {
                Stage loginStage = new Stage();
                AnchorPane loginRoot = new AnchorPane();
                loginRoot.getChildren().add(fxmlLoader.load());
                loginSetup(loginRoot, loginStage);

                Scene scene = new Scene(loginRoot, 800, 600);
                //loginStage.getStylesheets().add(Objects.requireNonNull(getClass().getResource("splashscreen.css")).toExternalForm());
                loginStage.setScene(scene);
                loginStage.setResizable(false);
                loginStage.initStyle(StageStyle.TRANSPARENT);
                //loginStage.getIcons().add(new Image(Objects.requireNonNull(StudyApplication.class.getResourceAsStream())));
                loginStage.show();
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        });


    }

    /**
     * Sets up the interactable parts of the Login page.
     * @param root  The AnchorPane for the login screen.
     * @param stage The stage the login scene is set in.
     * @author Nathaniel Rivera
     * @since 6/15/2025
     */
    public static void loginSetup(AnchorPane root, Stage stage) {
    }

}