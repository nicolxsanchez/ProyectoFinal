package visual;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import logico.Grafo;

import java.io.IOException;

public class MainController {

    private Grafo grafo = new Grafo();
    @FXML
    private Button btnAgregarParada;

    @FXML
    private void btnAgregarParada() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarParada.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Agregar Parada");
            stage.setScene(new Scene(loader.load(), 450, 290));

            AgregaParadas controller = loader.getController();
            controller.setGrafo(grafo);

            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo abrir la ventana de agregar parada.");
            e.printStackTrace();
        }
    }

    @FXML
    private void btnAgregarRuta() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AgregarRuta.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Agregar Ruta");
            stage.setScene(new Scene(loader.load(), 450, 400));

            AgregaRutas controller = loader.getController();
            controller.setGrafo(grafo);

            stage.show();
        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo abrir la ventana de agregar ruta.");
            e.printStackTrace();
        }
    }

    @FXML
    private void btnModificarParada() {
        mostrarAlerta("Parada modificada", "Se modificó la parada.");
    }

    @FXML
    private void btnModificarRuta() {
        mostrarAlerta("Ruta modificada", "Se modificó la ruta.");
    }

    @FXML
    private void btnEliminarParada() {
        mostrarAlerta("Parada eliminada", "Se eliminó la parada.");
    }

    @FXML
    private void btnEliminarRuta() {
        mostrarAlerta("Ruta eliminada", "Se eliminó la ruta.");
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}
