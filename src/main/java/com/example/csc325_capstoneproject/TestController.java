package com.example.csc325_capstoneproject;

import com.example.csc325_capstoneproject.model.Subject;
import com.example.csc325_capstoneproject.model.Test;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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

        questions = new ArrayList<>(totalQuestions);
        answers = new ArrayList<>(totalQuestions);
    }

    /**
     * Goes to the next question, disabled if it is the last question.
     * @since 7/2/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void next() {

        //answers.set(currentQuestion - 1, answerField.getText());

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

        //answers.set(currentQuestion - 1, answerField.getText());

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

    }
}
