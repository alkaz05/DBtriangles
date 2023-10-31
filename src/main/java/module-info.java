module com.example.dbtriangles {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dbtriangles to javafx.fxml;
    exports com.example.dbtriangles;
}