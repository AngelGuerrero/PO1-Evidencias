/**
 * @Author: Luis Ángel De Santiago Guerrero
 * @Date:   2017-08-08T16:10:03-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: App.java
 * @Last modified by:   Luis Ángel De Santiago Guerrero
 * @Last modified time: 2017-08-09T06:08:49-05:00
 * @License: MIT
 */



package main;

import javafx.scene.layout.Pane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application {

  // ----- Containers -----
  // Scene
  private Scene mainScene;
  private Scene alterScene;

  // BorderPane
  private BorderPane mainBorderPane;
  private BorderPane subBorderPane;

  // GridPane
  private GridPane gridTop, gridContent;

  // Menu
  private MenuBar menuBar;
  // Menu file
  Menu fileMenu;
  Menu helpMenu;

  // Table
  private TableView<main.Task> table;
  private ObservableList<main.Task> taskSelected, allTasks;



  // ----- Components ---
  // Labels
  private Label titleLabel, taskLabel, todoTaskLabel;

  // Buttons
  Button addBtn, completeBtn, deleteBtn;

  // TextField
  TextField inputTask;

  @Override
  public void start(Stage primaryStage) {
    // ---- Containers -----
    Stage window;
    window = primaryStage;
    window.setResizable(false);
    window.setTitle("Awesomelist");


    // BorderPane
    mainBorderPane = new BorderPane();
    subBorderPane = new BorderPane();

    // GridPane
    gridTop = new GridPane();
    gridTop.setPadding(new Insets(10));
    gridTop.setHgap(10);
    gridTop.setVgap(10);
    // gridTop.setGridLinesVisible(true);

    gridContent = new GridPane();
    gridContent.setPadding(new Insets(10));
    gridContent.setHgap(10);
    gridContent.setVgap(10);
    // gridContent.setGridLinesVisible(true);

    // Menu ---
    menuBar = new MenuBar();
    // File menu
    fileMenu = new Menu("_Archivo");
    MenuItem exit = new MenuItem("Salir");
    exit.setOnAction(e -> window.close());

    fileMenu.getItems().add(exit);

    // Help menu
    helpMenu = new Menu("Ayu_da");
    MenuItem about = new MenuItem("Acerca...");
    about.setOnAction(e -> {
      Text info = new Text(
                      "Awesomelist es un programa que sirve como lista de tareas "
                      + "todavía de una manera muy primitiva, este programa tiene "
                      + "como propósito demostrar los tipos de eventos que se pueden "
                      + "generar a partir de una aplicación con componentes GUI.\n\n"
                      + "Autor: Luis Ángel De Santiago Guerrero\n"
                      + "Matrícula: ES1611300455\n"
                      + "Programación orientada a objetos 2\n"
                      + "Ingeniería en Desarrollo de Software\n"
                      + "Universidad Abierta y a Distancia de México");

      AlertBox.display("Acerca de este programa", "Awesomelist", info);
    });
    helpMenu.getItems().addAll(about);

    menuBar.getMenus().addAll(fileMenu, helpMenu);

    // ----- Components -----
    // Title app label
    titleLabel = new Label("Awesomelist");
    titleLabel.setFont(new Font("Helvetica", 20));
    titleLabel.setTextFill(Color.web("#0076a3"));
    // Set on the grid
    GridPane.setConstraints(titleLabel, 0, 0);

    // Name task label
    taskLabel = new Label("Nueva tarea:");
    GridPane.setConstraints(taskLabel, 0, 1);

    // Input task
    inputTask = new TextField();
    inputTask.setPromptText("Ingresa una nueva tarea");
    inputTask.setOnAction((ActionEvent event) -> addTask() );
    GridPane.setHgrow(inputTask, Priority.ALWAYS);
    GridPane.setConstraints(inputTask, 1, 1);

    // Button add task
    addBtn = new Button("Agregar tarea");
    addBtn.setOnAction(e -> addTask());
    GridPane.setConstraints(addBtn, 2, 1);

    // Register the components to the grid
    gridTop.getChildren().addAll(titleLabel, taskLabel, inputTask, addBtn);


    // ----- Table -----
    // Pending tasks Label
    todoTaskLabel = new Label("Lista de tareas");
    GridPane.setConstraints(todoTaskLabel, 0, 0);

    // Name column
    TableColumn<main.Task, String> nameColumn = new TableColumn<>("Tarea");
    nameColumn.setMinWidth(380);
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("_name"));

    // Status column
    TableColumn doneColumn = new TableColumn<>("Realizado");
    doneColumn.setMinWidth(100);
    doneColumn.setCellValueFactory(new PropertyValueFactory<>("_done"));

    // Table view
    table = new TableView<>();
    table.setItems(getTasks());
    table.getColumns().addAll(nameColumn, doneColumn);
    gridContent.add(table, 0, 1, 3, 1);

     // --- Bottom Side ---
    completeBtn = new Button("Completar");
    completeBtn.setStyle("-fx-background-color: #5b965f");
    completeBtn.setTextFill(Color.web("#fff"));
    GridPane.setConstraints(completeBtn, 0, 2);

    Pane separator = new Pane();
    GridPane.setHgrow(separator, Priority.ALWAYS);
    GridPane.setConstraints(separator, 1, 2);

    deleteBtn = new Button("Eliminar");
    deleteBtn.setStyle("-fx-background-color: #D05955");
    deleteBtn.setTextFill(Color.web("#fff"));
    GridPane.setConstraints(deleteBtn, 2, 2);

    completeBtn.setOnAction(event -> completeTask());
    deleteBtn.setOnAction(event -> removeTask());

    // Register to the gridContent
    gridContent.getChildren().addAll(todoTaskLabel, completeBtn, separator, deleteBtn);

    // ----- Add components to the subBorderPane -----
    // Set the grid at the top of topBorderPane
    subBorderPane.setTop(gridTop);
    subBorderPane.setCenter(gridContent);

    // ----- Add components to the mainBorderPane -----
    mainBorderPane.setTop(menuBar);
    mainBorderPane.setCenter(subBorderPane);

    // ----- Set scene -----
    mainScene = new Scene(mainBorderPane, 500, 400);
    window.setScene(mainScene);
    window.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  public ObservableList<main.Task> getTasks() {
    ObservableList<main.Task> tasks = FXCollections.observableArrayList();
    tasks.add(new main.Task("Aprender javaFX", false));

    return tasks;
  }

  public void addTask() {
    if (!inputTask.getText().isEmpty()) {
      main.Task task = new main.Task(inputTask.getText(), false);
      table.getItems().add(task);
      inputTask.clear();
    }
  }

  public void completeTask() {
    main.Task myTask = table.getSelectionModel().getSelectedItem();
    myTask.set_done(true);
    table.refresh();
  }

  public void removeTask() {
    allTasks = table.getItems();
    taskSelected = table.getSelectionModel().getSelectedItems();

    taskSelected.forEach(allTasks::remove);
  }

}
