module com.example.csc325_capstoneproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc325_capstoneproject to javafx.fxml;
    exports com.example.csc325_capstoneproject;
}