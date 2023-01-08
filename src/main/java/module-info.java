module com.example.supplerchain {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplerchain to javafx.fxml;
    exports com.example.supplerchain;
}