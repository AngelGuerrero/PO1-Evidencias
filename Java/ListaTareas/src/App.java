/*
 * Nombre del programa:
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 
 */

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Angel
 */
public class App extends Application {

  Stage window; // Ventana principal

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

    // Configuración de la ventana principal
    window = primaryStage;
    window.setTitle("Lista de tareas");
    window.setResizable(false);
    window.show();

    // Agrega el layout forms y establece las dimensiones
    Scene scene = new Scene(root);

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    window.setX(screen.width - window.getWidth());
    window.setY(screen.height - window.getHeight());

    window.setScene(scene);
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
