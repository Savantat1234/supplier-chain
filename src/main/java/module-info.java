module com.example.supplerchain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.supplerchain to javafx.fxml;
    exports com.example.supplerchain;
}