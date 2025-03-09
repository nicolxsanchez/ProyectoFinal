package visual;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class Interfaz extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        Parent fxmLoader = FXMLLoader.load(getClass().getResource("Registro.fxml"));
        stage.setTitle("Sistema de Gestión de Rutas");
        stage.setScene(new Scene(fxmLoader, 800, 600));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args); // Esto arranca JavaFX
    }
}