package visual;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import logico.Grafo;
import logico.Parada;
import logico.Ruta;
import java.util.List;

public class AgregaRutas {

    private Grafo grafo = new Grafo();

    @FXML private ComboBox<String> cbOrigen;
    @FXML private ComboBox<String> cbDestino;
    @FXML private TextField txtTiempo;
    @FXML private TextField txtCosto;
    @FXML private TextField txtTransbordos;
    @FXML private TextField txtDistancia;
    @FXML private Button btnGuardar;

    @FXML
    private void guardarRuta() {

        if (txtCosto.getText().isEmpty() || txtTransbordos.getText().isEmpty() || txtDistancia.getText().isEmpty() ||
        txtTiempo.getText().isEmpty() || cbOrigen.getValue() == null || cbDestino.getValue() == null) {
            mostrarAlerta("Campos vacíos", "Debes llenar todos los campos.");
        } else {

            Parada origen = obtnParadaSeleccionada(cbOrigen);
            Parada destino = obtnParadaSeleccionada(cbDestino);

            int tiempo = Integer.parseInt(txtTiempo.getText());
            int distancia = Integer.parseInt(txtDistancia.getText());
            double costo = Double.parseDouble(txtCosto.getText());
            int transbordos = Integer.parseInt(txtTransbordos.getText());

            if (origen.equals(destino)) {
                mostrarAlerta("Error de selección", "El origen y el destino no pueden ser la misma parada.");
                return;
            }

            /*if (existeRuta(origen, destino)) {
                mostrarAlerta("Ruta duplicada", "Ya existe una ruta entre " + origen.getNombre() + " y " + destino.getNombre());
                return;
            }*/

           grafo.agregarRuta(origen, destino, tiempo, distancia, costo, transbordos);
            mostrarAlerta("Ruta Agregada", "Se agregó la ruta desde " + origen.getNombre() + " hasta " + destino.getNombre());
            limpiarCampos();
        }
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
        llenarParadas();
    }

    @FXML
    private void llenarParadas() {
        List<Parada> paradas = grafo.getParadas();
        System.out.println("Número de paradas: " + paradas.size());
        for (Parada parada : paradas) {
            cbOrigen.getItems().add(parada.getNombre());
            cbDestino.getItems().add(parada.getNombre());
        }
    }

    /*private boolean existeRuta(Parada origen, Parada destino) {
        List<Ruta> rutas = grafo.getRutas();
        for (Ruta ruta : rutas) {
            if (ruta.getOrigen().equals(origen) && ruta.getDestino().equals(destino)) {
                return true;
            }
        }
        return false;
    }*/

    private Parada obtnParadaSeleccionada(ComboBox<String> comboBox) {
        String seleccionado = comboBox.getSelectionModel().getSelectedItem();
        List<Parada> paradas = grafo.getParadas();

        for (Parada parada : paradas) {
            if (parada.getNombre().equals(seleccionado)) {
                return parada;
            }
        }

        return null;
    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    private void limpiarCampos() {
        txtCosto.setText("");
        txtDistancia.setText("");
        txtTiempo.setText("");
        txtTransbordos.setText("");
        cbDestino.setValue(null);
        cbOrigen.setValue(null);
    }

}
