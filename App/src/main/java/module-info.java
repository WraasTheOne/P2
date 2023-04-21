module com.example.app {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.dotenv;
    requires java.desktop;
    requires core;


    opens com.example.app to javafx.fxml;
    exports com.example.app;
    exports com.example.app.TableStructure;
    opens com.example.app.TableStructure to javafx.fxml;
    exports com.example.app.View;
    opens com.example.app.View to javafx.fxml;
    exports com.example.app.controllers;
    opens com.example.app.controllers to javafx.fxml;
}