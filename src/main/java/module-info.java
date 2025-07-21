module com.trusthecode.trustyjack {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.trusthecode.trustyjack to javafx.fxml;
    exports com.trusthecode.trustyjack;
    exports com.trusthecode.trustyjack.controllers;
    opens com.trusthecode.trustyjack.controllers to javafx.fxml;
}