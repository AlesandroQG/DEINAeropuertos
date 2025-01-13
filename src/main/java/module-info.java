module com.alesandro.aeropuertos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.web;
    requires java.sql;
    requires jdk.security.auth;
    requires org.checkerframework.checker.qual;
    requires java.desktop;


    opens com.alesandro.aeropuertos to javafx.fxml;
    exports com.alesandro.aeropuertos;
    exports com.alesandro.aeropuertos.controller;
    opens com.alesandro.aeropuertos.controller to javafx.fxml;
    exports com.alesandro.aeropuertos.model;
    exports com.alesandro.aeropuertos.dao;
}