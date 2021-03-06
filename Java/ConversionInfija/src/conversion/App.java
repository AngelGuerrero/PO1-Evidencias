package conversion;

/*
 * Nombre del programa:
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación:
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Angel
 */
public class App extends Application {
  
  MyStack stackOutput;                // Almacena el resultado final
  DoublyLinkedList listOperands;      // Almacena la lista de operandos posibles

  final String letters;               // Establece la lista de letras y alfabeto con el que se trabajará
  final String operands;              // Establece la lista de operadores disponibles
  final String openSeparators;        // Establece la lista de separadores de apertura disponibles
  final String closeSeparators;       // Establece la lista de separadores de cierre disponibles

  // Lista donde se mostrará el resultado final de la expresión,
  // esta se debe de almacenar en la lista ObservableList
  ListView listview;
  ObservableList<String> data;
  
  
  // Componentes gráficos
  BorderPane borderpane;

  Label inputLabel;
  TextField inputData;

  VBox vbTop;
  VBox vbCenter;

  Button btnCalculate;
  Label resultLabel;
  Label listTitleLabel;


  public App() {
    this.letters = "abcdefghijklmnopqrstuvwxyz0123456789";
    this.openSeparators = "([{";
    this.closeSeparators = ")]}";
    this.operands = "+-=/*^";

    // Inicializa la pila
    stackOutput = new MyStack();
    listOperands = new DoublyLinkedList();
  }

  @Override
  public void start(Stage primaryStage) {
    // Configuración del borderPane
    borderpane = new BorderPane();

    // Configuración del vbTop
    vbTop = new VBox();
    vbTop.setId("vbTop");

    // Configuración del vbCenter
    vbCenter = new VBox();
    vbCenter.setId("vbCenter");

    // Configuración de la caja de texto
    inputLabel = new Label("Ingresa una expresión a evaluar:");
    inputData = new TextField();
    inputData.setPromptText("Ejemplo: (a + b)");
    HBox.setHgrow(inputData, Priority.ALWAYS);

    // Configuración del botón para calcular
    btnCalculate = new Button("Calcular");
    btnCalculate.setMaxWidth(Double.MAX_VALUE);
    btnCalculate.setOnAction(e -> {
      if (!inputData.getText().isEmpty()) {
        // Comienza a realizar el cálculo
        System.out.println("Calculando...");
        if (checkBalance(inputData.getText())) {
          postfix(inputData.getText());
        }
      }
    });

    // Agrega los elementos al vbTop
    vbTop.getChildren().addAll(inputLabel, inputData, btnCalculate);

    // Configuración de la lista
    listTitleLabel = new Label("Historial de conversiones");
    data = FXCollections.observableArrayList("(a+b) = ab+", "( 6 + 2 )*3/2^2-4 =  62+3*22^/4-", "(x^2+3*x+5)*(2+x) =  x2^3x*+5+2x+*", "x^y/(5*z+10) =  xy^5z*10+/");
    listview = new ListView(data);

    // Agrega los elementos al vbCenter
    vbCenter.getChildren().addAll(listTitleLabel, listview);

    // Agrega los elementos al borderpane
    borderpane.setTop(vbTop);
    borderpane.setCenter(vbCenter);

    Scene scene = new Scene(borderpane, 300, 400);
    scene.getStylesheets().add("conversion/main.css");

    primaryStage.setTitle("Calcular de infijo a postfijo");
    primaryStage.setResizable(false);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * Función que realiza una evaluación de una expresión infija a postfija
   * se da como parámetro una cadena de texto que después será evaluada.
   * @param param 
   */
  public void postfix(String param) {
    String result = param + " = ";
    
    param = param.replaceAll("\\s", "");
    System.out.println("Evaluando la expresión: " + param);

    int openSeparatorCount = 0;
    
    char[] theString = param.toCharArray();
    char character = '\0';

    int i = 0;
    for (i = 0; i < theString.length; i++) 
    {
      character = theString[i]; // Para no hacer tan verboso las operaciones
      
      System.out.println("\nIniciando la evaluación de: " + character);
      
      // Si el character es una letra, va directamente al resultado.
      if (letters.indexOf(character) != -1)
      {
        System.out.println("El elemento : " + character + " es una letra.");
        System.out.println("Se agrega a la pila directamente: " + stackOutput.push(character));
      }
      // Si es un separador de apertura.
      else if (openSeparators.indexOf(character) != -1) 
      {
        System.out.println("Es un separador de apertura.");
        openSeparatorCount++;
        System.out.println("Cuenta de separadores abiertos es: " + openSeparatorCount);
        System.out.println("Separador de apertura agregado a la lista: " + listOperands.add(character));
      }
      // Si es un operando
      else if (operands.indexOf(character) != -1)
      {
        System.out.println("El elemento: " +  character + " es un operando.");
        
        // si la lista de operandos está vacía
        if (listOperands.isEmpty()) 
        {
          System.out.println("La lista de operadores está vacía.");
          System.out.println("Agregando el operador a la lista: " + listOperands.add(character));
        }
        // Si es un operador, saca de la pila los elementos mayores o iguales al operador en cuestión.
        // Después se agrega el operador en la lista.
        else
        {
          DoublyLinkedList auxList = new DoublyLinkedList();
          
          int len = listOperands.getSize();
          for (int j = 0; j < len; j++) 
          {
            if (listOperands.getLast() != '(') 
            {
              if (compare(listOperands.getLast()) > compare(character) || compare(listOperands.getLast()) == compare(character)) {
                System.out.println("Los operadores son iguales, se sacará para agregar al resultado.");
                System.out.println("Se agregó el operador a la lista: " + stackOutput.push(listOperands.getLast()));
                System.out.println("Se ha eliminado el último elemento: " + listOperands.removeLast());
              } else {
                // Esto lo hago para hacer un recorrido a todos los elementos de la lista de operandos, sacar y meter...
                System.out.println("El elemento de la lista es menor. Se agregará a la lista aux: " + auxList.add(listOperands.getLast()));
                System.out.println("Se ha eliminado el último elemento de la lista: " + listOperands.removeLast());
              }
              
            } else {
              break;
            }
          }
          // Termina el ciclo y agrega los elementos que se eliminó de la lista de operadores
          System.out.println("Agregando los operadores que se eliminó de la lista");
          len = auxList.getSize();
          for (int j = 0; j < len; j++) {
            listOperands.add(auxList.getFirst());
            auxList.removeFirst();
          }
          System.out.println("Agregando el caracter en cuestión: " + listOperands.add(character));
          
          System.out.println("La lista quedó: ");
          System.out.println(listOperands.show());
        }
      }
      // Si es un separador de cierre.
      else if (closeSeparators.indexOf(character) != -1)
      {
        openSeparatorCount--;
        System.out.println("Es un separador de cierre.");
        System.out.println("La cuenta va en: " + openSeparatorCount);
        System.out.println("Realiza un ciclo interno en la lista de operadores");
        do {
          if (! listOperands.isEmpty()) {
            stackOutput.push(listOperands.getLast());
            listOperands.removeLast();
          }
        } while (listOperands.getLast() != '(');
        // Si encontró un paréntesis izquierdo, significa que se tiene que eliminar
        listOperands.removeLast();
        
        System.out.println("La lista quedó: " + listOperands.show());
      }
    }
    
    // Si es el final del ciclo
    if (i >= theString.length) {
      if (!listOperands.isEmpty()) {        
        stackOutput.push(listOperands.getLast());
        listOperands.removeLast();
      }
    }
    
    MyStack stackResult = new MyStack();

    int len = stackOutput.getSize();
    for (i = 0; i < len; i++) {
      stackResult.push(stackOutput.pop());
    }
    stackResult.push(stackOutput.pop());

    System.out.println("La lista está vacía: " + stackOutput.isEmpty());

    len = stackResult.getSize();
    for (i = 0; i < len; i++) {
      result += stackResult.pop();
    }
    System.out.println(result);
    data.add(result);
    
  }
  
  /**
   * Verifica que la expresión esté correctamente balanceada
   * @param param 
   */
  public Boolean checkBalance(String param) {
    Boolean val = true;
    
    param = param.replaceAll("\\s", "");
    System.out.println("Verificando la expresión: " + param);

    int openSeparatorCount = 0;
    int closeSeparatorCount = 0;
    char[] theString = param.toCharArray();
    
    for (int i = 0; i < theString.length; i++) {
      if (openSeparators.indexOf(theString[i]) != -1) 
      {
        openSeparatorCount++;
      } 
      else if (closeSeparators.indexOf(theString[i]) != -1) 
      {
        closeSeparatorCount++;
      }
    }
    
    System.out.println("Cuenta de separadores.");
    System.out.println("Apertura: " + openSeparatorCount);
    System.out.println("Cierre: " + closeSeparatorCount);
    
    if (openSeparatorCount != closeSeparatorCount) 
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error de sintaxis");
      alert.setContentText("No hay un buen balance en la expresión, esto puede causar que se dé un mal resultado.");
      alert.showAndWait();
      val = false;
    }
    
    return val;
  }

  /**
   * Realiza una comparación de los operadores de acuerdo
   * a un nivel de prioridad establecido y se retorna un 
   * resultado.
   * @param param
   * @return 
   */
  public int compare(char param) {
    int retVal = 0;

    switch (param) {
      case '^':
      case '=':
        retVal = 3;
        break;
      case '*':
      case '/':
        retVal = 2;
        break;
      case '+':
      case '-':
        retVal = 1;
        break;
    }

    return retVal;
  }

}