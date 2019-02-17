import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class App extends Application implements Initializable {

    @FXML private Button addProductBtn;
    @FXML private Button searchProductBtn;
    @FXML private Button removeProductBtn;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("App.fxml"));

        // Carga a la ventana principal los componentes desde fxml
        primaryStage.setScene(new Scene(root.load()));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Administración de productos");
        primaryStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
