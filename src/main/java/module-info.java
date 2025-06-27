module com.example.csc325_capstoneproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires google.cloud.firestore;
    requires firebase.admin;
    requires com.google.auth.oauth2;


    opens com.example.csc325_capstoneproject to javafx.fxml;
    exports com.example.csc325_capstoneproject;
    exports com.example.csc325_capstoneproject.model;
    opens com.example.csc325_capstoneproject.model to javafx.fxml;
}