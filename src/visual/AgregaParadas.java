package visual;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logico.Parada;
import logico.Grafo;

public class AgregaParadas
{
    private Grafo grafo;

    @FXML private TextField txtNombre;
    @FXML private TextField txtLatitud;
    @FXML private TextField txtLongitud;
    @FXML private Button btnGuardar;

    @FXML
    private void guardarParada() {

        if (txtNombre.getText().isEmpty() || txtLatitud.getText().isEmpty() || txtLongitud.getText().isEmpty()) {
            mostrarAlerta("Campos vacíos", "Debes llenar todos los campos.");
        } else {

            double latitud = Double.parseDouble(txtLatitud.getText());
            double longitud = Double.parseDouble(txtLongitud.getText());

            Parada nuevaParada = new Parada(txtNombre.getText(), latitud, longitud);
            grafo.agregarParada(nuevaParada);

            mostrarAlerta("Parada Agregada", "Se agregó la parada: " + txtNombre.getText());
            limpiarCampos();
        }
    }

    @FXML
    private void cerrarVentana() {
        Stage stage = (Stage) txtNombre.getScene().getWindow();
        stage.close();
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");
    }
}
