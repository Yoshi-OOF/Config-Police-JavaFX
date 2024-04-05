module com.td.configpolice {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.td.configpolice to javafx.fxml;
    exports com.td.configpolice;
}