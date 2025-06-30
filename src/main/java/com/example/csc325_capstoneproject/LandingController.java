package com.example.csc325_capstoneproject;

import com.example.csc325_capstoneproject.model.Subject;
import com.example.csc325_capstoneproject.model.Test;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class LandingController implements Initializable {

    @FXML
    private TableView<Test> tv;

    @FXML
    private TableColumn<Test, String> tv_subject, tv_date;

    @FXML
    private TableColumn<Test, Double> tv_score;

    @FXML
    private TableColumn<Test, Integer> tv_count;

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

        tv_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        tv_date.setCellValueFactory(new PropertyValueFactory<>("dateTaken"));
        tv_score.setCellValueFactory(new PropertyValueFactory<>("score"));
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

    }
}
