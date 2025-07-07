package com.example.csc325_capstoneproject;

import com.example.csc325_capstoneproject.model.CurrentUser;
import com.example.csc325_capstoneproject.model.Subject;
import com.example.csc325_capstoneproject.model.Test;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
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

import javax.sound.midi.SysexMessage;
import java.net.URL;
import java.time.Clock;
import java.time.ZoneId;
import java.util.*;

/**
 * TestController is the class which controls the tests for the application.
 * Both practice and timed test are directed to this page the only difference
 * is if the timer activates or not.
 * @since 7/2/2025
 * @author Nathaniel Rivera
 */
public class TestController implements Initializable {

    @FXML
    protected Label numQuestionsLabel;

    @FXML
    protected Label subjectLabel;

    @FXML
    protected Label timerText;

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
     * @since 7/2/2025
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
                    try {
                        timer();
                    } catch (InterruptedException e) {
                        System.out.println("failed");
                    }
                }
            }, 5000);
            try {
                timer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
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
        addTest();
    }

    /**
     * Method to start and move the timer through the application.
     * @since 7/4/2025
     * @author Nathaniel Rivera
     */
    protected void timer() throws InterruptedException {
        Timer timer = new Timer();
        /*
        int min = 5;
        int sec = 0;

        setTimer(min, sec);

        while(min != 0 && sec != 0) {

            if(sec > 0) {
                sec--;
            } else if(min > 0 && sec == 0) {
                min--;
                sec = 59;
            } else if(min == 0 && sec == 1) {
                sec--;
            }

            wait(1000);
            setTimer(min, sec);
            System.out.println("timed");
        }*/
    }

    /**
     * Sets the timer to the newly updated time.
     * @since 7/4/2025
     * @author Nathaniel Rivera
     */
    protected void setTimer(int min, int sec) {
        if(min >= 10) {
            if(sec >= 10) {
                timerText.setText(min + ":" + sec);
            } else {
                timerText.setText(min + ":0" + sec);
            }
        } else if(sec >= 10) {
            timerText.setText("0" + min + ":" + sec);
        } else {
            timerText.setText("0" + min + ":0" + sec);
        }
    }

    /**
     * Adds the current test to the firebase storage, if 10 tests exist for the current subject it will replace the oldest one.
     * @since 7/7/2025
     * @author Nathaniel Rivera
     */
    protected void addTest() {

        StringBuilder sb = new StringBuilder();

        Clock zoneClock = Clock.system(ZoneId.of("-05:00"));
        sb.append(zoneClock.instant().toString(), 5, 7).append("/");
        sb.append(zoneClock.instant().toString(), 8, 10).append("/");
        sb.append(zoneClock.instant().toString(), 0, 4);
        String time  = sb.toString();


        DocumentReference docRef = StudyApplication.fstore.collection("Tests").document(UUID.randomUUID().toString());

        Map<String, Object> tests = new HashMap<>();
        tests.put("Subject", subject);
        tests.put("Date", time);
        tests.put("Score", 0);
        tests.put("Questions", totalQuestions);
        tests.put("User", CurrentUser.getCurrentUID());

        //asynchronously write data
        ApiFuture<WriteResult> result = docRef.set(tests);
    }
}

