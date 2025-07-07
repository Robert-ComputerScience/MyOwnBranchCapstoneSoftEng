package com.example.csc325_capstoneproject;

import com.example.csc325_capstoneproject.model.CurrentUser;
import com.example.csc325_capstoneproject.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.ListUsersPage;
import com.google.firebase.auth.UserRecord;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class LoginController implements Initializable {

    @FXML
    protected Button loginButton;

    @FXML
    protected Button registerButton;

    @FXML
    protected Button closeButton;

    @FXML
    protected TextField emailField;

    @FXML
    protected TextField passwordField;

    protected static boolean loginStatus = false;

    protected LinkedList<User> users = new LinkedList<>();

    /**
     * Retrieves the list of Users to make sure the new User has a unique username and email.
     * @param url URL.
     * @param resourceBundle ResourceBundle.
     * @since 6/27/25
     * @author Nathaniel Rivera
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            ListUsersPage page = FirebaseAuth.getInstance().listUsers(null);
            for (UserRecord user : page.iterateAll()) {
                User newUser = new User(user.getDisplayName(), user.getEmail(), user.getUid());
                users.add(newUser);
            }
        } catch (FirebaseAuthException e) {
            throw new RuntimeException(e);
        }

        /*--------------------------------------------Regex Patterns--------------------------------------------------*/

        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
        Pattern passwordPattern = Pattern.compile("\\w{2,25}");

        /*------------------------------------------Live Updates to UI------------------------------------------------*/

        // Live border coloring while typing
        emailField.textProperty().addListener((obs, oldText, newText) -> {
            boolean valid = emailPattern.matcher(newText).matches();
            emailField.setStyle(valid ? "-fx-border-color: Lime;" : "-fx-border-color: red;");
        });

        // Show/hide error message on focus loss
        emailField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                boolean valid = emailPattern.matcher(emailField.getText()).matches();
                //emailError.setText(valid ? "" : "Must be a valid email address format");
                emailField.setStyle(valid ? "-fx-border-color: Lime;" : "-fx-border-color: red;");
            }
        });

        // Live border coloring while typing
        passwordField.textProperty().addListener((obs, oldText, newText) -> {
            boolean valid = passwordPattern.matcher(newText).matches();
            passwordField.setStyle(valid ? "-fx-border-color: Lime;" : "-fx-border-color: red;");
        });
        // Show/hide error message on focus loss
        passwordField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (!isNowFocused) {
                boolean valid = passwordPattern.matcher(passwordField.getText()).matches();
                //passwordError.setText(valid ? "" : "2–25 characters, letters or digits only");
                passwordField.setStyle(valid ? "-fx-border-color: Lime;" : "-fx-border-color: red;");
            }
        });

    }

    /**
     * Logs the current user into the application,
     * @since 6/28/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void login() {

        boolean canLogin;
        User currUser = null;
        String email = emailField.getText();
        String password = passwordField.getText();

        if (password.isEmpty() || email.isEmpty()) {
            System.out.println("Error: One or more fields do not have inputs");
            //errorLabel.setText("All fields must be filled."); // Print error to UI

            // Highlight empty fields with a red border
            if (password.isEmpty()) passwordField.setStyle("-fx-border-color: red;");
            if (email.isEmpty()) emailField.setStyle("-fx-border-color: red;");
            canLogin = false;
        } else {
            canLogin = true;

            try {
                User user = new User(StudyApplication.fauth.getUserByEmail(email).getDisplayName(), StudyApplication.fauth.getUserByEmail(email).getEmail(), StudyApplication.fauth.getUserByEmail(email).getUid());
                CurrentUser.setCurrentUser(user);
                loginStatus = true;
                System.out.println("User successfully logged in");
            } catch (FirebaseAuthException e) {
                //errorLabel.setText("An account with this email does not exist"); // print error to UI
            }
        }

        if(canLogin) {
            Stage stage = (Stage) loginButton.getScene().getWindow();

            stage.close();
        } else {
            //errorLabel.setText("Username, email, or password are incorrect."); // print error to UI
        }

    }

    /**
     * Swaps the scene from the Login Screen to the Register Screen.
     * @since 6/28/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void register() {
        FXMLLoader fxmlLoader = new FXMLLoader(StudyApplication.class.getResource("register-view.fxml"));

        Stage stage = (Stage) registerButton.getScene().getWindow();

        try {
            Stage registerStage = new Stage();
            AnchorPane registerRoot = new AnchorPane();
            registerRoot.getChildren().add(fxmlLoader.load());

            Scene scene = new Scene(registerRoot, 650, 380);
            registerStage.setScene(scene);
            registerStage.setResizable(false);
            registerStage.initStyle(StageStyle.UNDECORATED);
            stage.close();
            registerStage.show();
        } catch(Exception ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }

    }

    /**
     * Closes the Login Screen
     * @since 6/28/2025
     * @author Nathaniel Rivera
     */
    @FXML
    protected void close() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Static method that updates the users login status
     * @since 7/7/2025
     * @author Nathaniel Rivera
     */
    public static void updateLoginStatus(boolean status) {
        loginStatus = status;
    }

    /**
     * Static method that returns the users login status.
     * @since 7/7/2025
     * @author Nathaniel Rivera
     */
    public static boolean getLoginStatus() {
        return loginStatus;
    }
}
