package com.alesandro.aeropuertos.controller;

import com.alesandro.aeropuertos.model.Help;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
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
        TreeItem<Help> rItem = new TreeItem<>(new Help("Raiz", ""));
        TreeItem<Help> rRoot = new TreeItem<>(new Help("Introducción", "src/main/resources/help/html/index.html"));
        rItem.getChildren().add(rRoot);
        TreeItem<Help> rAena = new TreeItem<Help>(new Help("Aena", "https://www.aena.es/es/pasajeros/pasajeros.html)", false));
        rItem.getChildren().add(rAena);
        arbol.setRoot(rItem);
        arbol.setShowRoot(false);
        webEngine = visor.getEngine();
        webEngine.load(getClass().getResource("src/main/resources/help/html/index.html").toExternalForm());
        //Añadimos un evento para cambiar de html al pinchar en el árbol
        arbol.setOnMouseClicked(e -> {
            if (arbol.getSelectionModel().getSelectedItem() != null) {
                Help elemento = (Help) arbol.getSelectionModel().getSelectedItem().getValue();
                if (elemento.getHtml() != null) {
                    cargarAyuda(elemento.getHtml(), elemento.isLocal());
                }
            }
        });
    }

    /**
     * Función que carga la ayuda del item seleccionado en el árbol
     *
     * @param archivo a cargar
     * @param local local o en web
     */
    private void cargarAyuda(String archivo, boolean local) {
        if (visor != null) {
            if (local) {
                webEngine.load(getClass().getResource("help/html/" + archivo).toExternalForm());
            } else {
                webEngine.load(archivo);
            }
        }
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
