package com.example.csc325_capstoneproject;

import com.example.csc325_capstoneproject.model.Subject;
import com.example.csc325_capstoneproject.model.Test;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * Controller class which controls the actions for the landing page of the application.
 * @since 6/14/2025
 * @author Nathaniel Rivera
 */
public class StudyController implements Initializable {

    @FXML
    protected ImageView pfp;

    @FXML
    protected Button mathButton;

    @FXML
    protected Button englishButton;

    @FXML
    protected TableView<Test> tv;

    @FXML
    protected TableColumn<Test, String> tv_subject, tv_date;

    @FXML
    protected TableColumn<Test, Double> tv_score;

    @FXML
    protected TableColumn<Test, Integer> tv_count;

    protected Subject currentSubject;

    protected int currentGradeLevel;

    protected ObservableList<Test> math_tests = FXCollections.observableList(new LinkedList<>());

    /**
     * Initializes the TableView and Percentage wheel on the main page. The default is math.
     * @param url URL
     * @param resourceBundle ResourceBundle
     * @since 6/30/2025
     * @author Nathaniel Rivera
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Test test = new Test(Subject.math, 20, 10, "6/30/2025");
        math_tests.add(test);

        System.out.println("tested");
        tv_subject.setCellValueFactory(new PropertyValueFactory<>("Subject"));
        tv_date.setCellValueFactory(new PropertyValueFactory<>("DateTaken"));
        tv_score.setCellValueFactory(new PropertyValueFactory<>("Score"));
        tv_count.setCellValueFactory(new PropertyValueFactory<>("questionCount"));

        tv.setItems(math_tests);
    }

    /**
     * Switches the page into math mode changing the stylesheets and the average and the list of the past tests.
     * @since 6/30/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void mathMode() {
        tv.setItems(math_tests);
        currentSubject = Subject.math;

        Scene scene = mathButton.getScene();
        scene.getStylesheets().removeAll();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("math-landingscreen.css")).toExternalForm());
    }

    /**
     * Switches the page into english mode changing the stylesheets and the average and the list of the past tests.
     * @since 6/30/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void englishMode() {
        tv.setItems(math_tests);
        currentSubject = Subject.english;

        Scene scene = englishButton.getScene();
        scene.getStylesheets().removeAll();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("english-landingscreen.css")).toExternalForm());
    }

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