package com.example.csc325_capstoneproject;

import com.example.csc325_capstoneproject.model.Subject;
import com.example.csc325_capstoneproject.model.Test;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class TestController implements Initializable {

    @FXML
    protected Label numQuestionsLabel;

    @FXML
    protected Label subjectLabel;

    @FXML
    protected Label gradeLabel;

    @FXML
    protected Label questionLabel;

    @FXML
    protected TextArea answerField;

    @FXML
    protected Button previousButton;

    @FXML
    protected Button nextButton;

    @FXML
    protected Button submitButton;

    protected ArrayList<String> questions;

    protected ArrayList<String> answers;

    protected int currentQuestion;

    protected int totalQuestions;

    protected Subject subject;

    protected int gradeLevel;

    protected boolean isTimed;

    /**
     * Initializes the test values and generates the test.
     * @param url URL
     * @param resourceBundle ResourceBundle
     * @since 6/30/2025
     * @author Nathaniel Rivera
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        subject = StudyController.getCurrentSubject();
        gradeLevel = StudyController.getCurrentGradeLevel();
        totalQuestions = StudyController.getQuestionCount();
        isTimed = StudyController.getTimed();
        currentQuestion = 1;

        subjectLabel.setText("Subject: " + subject);
        gradeLabel.setText("Grade: " + gradeLevel);
        numQuestionsLabel.setText("Question " + currentQuestion + " of " + totalQuestions);
        previousButton.setDisable(true);

        questions = new ArrayList<>();
        for(int i = 0; i < totalQuestions; i++) {
            questions.add(i, "");
        }

        answers = new ArrayList<>();
        for(int i = 0; i < totalQuestions; i++) {
            answers.add(i, "");
        }

        if(isTimed) {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println("Times out");
                    /*
                    FXMLLoader fxmlLoader = new FXMLLoader(StudyApplication.class.getResource("landing-view.fxml"));

                    Stage stage = (Stage) submitButton.getScene().getWindow();

                    try {
                        Stage landingStage = new Stage();
                        AnchorPane landingRoot = new AnchorPane();
                        landingRoot.getChildren().add(fxmlLoader.load());

                        Scene scene = new Scene(landingRoot, 1200, 800);
                        scene.getStylesheets().add(Objects.requireNonNull(StudyApplication.class.getResource("math-theme.css")).toExternalForm());
                        landingStage.setScene(scene);
                        landingStage.setResizable(false);
                        //landingStage.getIcons().add(new Image(Objects.requireNonNull(StudyApplication.class.getResourceAsStream())));
                        stage.close();
                        landingStage.show();
                    } catch(Exception _) { }*/
                }
            }, 5000);
        }
    }

    /**
     * Goes to the next question, disabled if it is the last question.
     * @since 7/2/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void next() {

        answers.set(currentQuestion - 1, answerField.getText());

        currentQuestion++;
        numQuestionsLabel.setText("Question " + currentQuestion + " of " + totalQuestions);

        if(currentQuestion == totalQuestions) {
            nextButton.setDisable(true);
        }

        if(currentQuestion != 1 && previousButton.isDisable()) {
            previousButton.setDisable(false);
        }
    }

    /**
     * Goes to the previous question, disabled if it is the first question.
     * @since 7/2/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void previous() {

        answers.set(currentQuestion - 1, answerField.getText());

        currentQuestion--;
        numQuestionsLabel.setText("Question " + currentQuestion + " of " + totalQuestions);

        if(currentQuestion != totalQuestions && nextButton.isDisable()) {
            nextButton.setDisable(false);
        }

        if(currentQuestion == 1) {
            previousButton.setDisable(true);
        }
    }

    /**
     * Submits the exam.
     * @since 7/2/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void submit() {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyApplication.class.getResource("landing-view.fxml"));

        Stage stage = (Stage) submitButton.getScene().getWindow();

        try {
            Stage landingStage = new Stage();
            AnchorPane landingRoot = new AnchorPane();
            landingRoot.getChildren().add(fxmlLoader.load());

            Scene scene = new Scene(landingRoot, 1200, 800);
            scene.getStylesheets().add(Objects.requireNonNull(StudyApplication.class.getResource("math-theme.css")).toExternalForm());
            landingStage.setScene(scene);
            landingStage.setResizable(false);
            //landingStage.getIcons().add(new Image(Objects.requireNonNull(StudyApplication.class.getResourceAsStream())));
            stage.close();
            landingStage.show();
        } catch(Exception _) { }
    }
}
