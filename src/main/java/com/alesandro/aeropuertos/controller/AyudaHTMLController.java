package com.alesandro.aeropuertos.controller;

import com.alesandro.aeropuertos.model.Help;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Clase que controla los eventos de la ventana de ayuda HTML
 */
public class AyudaHTMLController implements Initializable {
    @FXML // fx:id="arbol"
    private TreeView<Help> arbol; // Value injected by FXMLLoader

    @FXML // fx:id="visor"
    private WebView visor; // Value injected by FXMLLoader
    private WebEngine webEngine;

    /**
     * Función que se ejecuta cuando se carga la ventana
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //
    }

    /**
     * Función que muestra un mensaje de alerta al usuario
     *
     * @param texto contenido de la alerta
     */
    public void alerta(String texto) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setTitle("ERROR");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }

    /**
     * Función que muestra un mensaje de confirmación al usuario
     *
     * @param texto contenido del mensaje
     */
    public void confirmacion(String texto) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setHeaderText(null);
        alerta.setTitle("Info");
        alerta.setContentText(texto);
        alerta.showAndWait();
    }
}
