/**
 * @Author: Luis Ángel De Santiago Guerrero
 * @Date:   2017-08-09T01:46:08-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: AlertBox.java
 * @Last modified by:   Luis Ángel De Santiago Guerrero
 * @Last modified time: 2017-08-09T06:08:59-05:00
 * @License: MIT
 */



package main;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class AlertBox {
  public static void display(String windowTitle, String title, Text contentText) {
        Stage window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(windowTitle);
        window.setMinHeight(250);
        window.setMinWidth(400);

        BorderPane container = new BorderPane();
        container.setPadding(new Insets(10));

        GridPane gridBottom = new GridPane();
        gridBottom.setPadding(new Insets(10));

        gridBottom.setHgap(10);
        gridBottom.setVgap(10);
        //gridBottom.setGridLinesVisible(true);

        Label titleLabel = new Label(title);
        titleLabel.setTextAlignment(TextAlignment.LEFT);
        titleLabel.setFont(new Font("Helvetica", 20));
        GridPane.setConstraints(titleLabel, 0, 0);

        contentText.setStyle("-fx-margin: 20px");
        contentText.setWrappingWidth(300);
        contentText.setTextAlignment(TextAlignment.JUSTIFY);
        GridPane.setConstraints(contentText, 0, 1);

        Separator separator = new Separator();
        GridPane.setHgrow(separator, Priority.ALWAYS);
        GridPane.setConstraints(separator, 0, 2);

        Button closeButton = new Button("Cerrar esta ventana");
        closeButton.setOnAction(e -> window.close());
        GridPane.setHalignment(closeButton, HPos.CENTER);
        GridPane.setConstraints(closeButton, 0, 3);

        gridBottom.getChildren().addAll(separator, closeButton);

        container.setTop(titleLabel);
        container.setCenter(contentText);
        container.setBottom(gridBottom);

        //Display window and wait for it to be closed before returning
        Scene scene = new Scene(container);
        window.setScene(scene);
        window.showAndWait();
    }
}
