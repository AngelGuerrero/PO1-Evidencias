/*
 * Nombre del programa:
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;

/**
 *
 * @author Angel
 */
public class FXMLDocumentController implements Initializable {
  
  @FXML public MenuItem closeMenubtn;
  @FXML public TextField inputTask;
  @FXML public ListView<String> listview;
    
  ObservableList<String> data = FXCollections.observableArrayList("Aprender JavaFX");

  public FXMLDocumentController() {}
  
  
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    // Agregando los datos a la listView
    // Es importante recordar que la lista está
    // instanciada en el documento FXMLDocument
    // No se debe de instanciar en este momento
    listview.setItems(data);
    listview.setEditable(true);
    // Editar la tarea dando doble click en ella
    listview.setCellFactory(TextFieldListCell.forListView());
  }
  
  /**
   * Función para agregar un nuevo elemento
   * a la lista de tareas ListView
   * 
   */
  public void addNewTask() {
    if (!inputTask.getText().isEmpty()) {
      data.add(inputTask.getText());
      inputTask.setText("");
    }
  }
  
  /**
   * Función para eliminar la tarea seleccionada
   */
  public void completeTask() {
    String task = listview.getSelectionModel().getSelectedItem();
    if (!task.isEmpty()) {
      data.remove(task);
      listview.getSelectionModel().clearSelection();
    }
  }
  
  /**
   * Abre la ventana de información
   * @throws IOException 
   */
  public void info() throws IOException {
    Stage window = new Stage();
    Parent info = FXMLLoader.load(getClass().getResource("informacion.fxml"));
    
    // Configuración de la ventana principal
    window.setTitle("Acerca de este programa");
    
    // Agrega el layout y establece las dimensiones
    Scene scene = new Scene(info);
    window.setScene(scene);
    window.setResizable(false);
    window.show();
  }
  
  /**
   * Función para cerrar aplicación.
   * 
   * Con esta función se puede cerrar la aplicación
   * desde varios botones, el botón de menú y el 
   * botón principal de cerrar por ejemplo.
   * 
   */
  public void closeApplication() {
    System.out.println("Aplicación cerrada correctamente");
    Platform.exit();
  }
  
}
