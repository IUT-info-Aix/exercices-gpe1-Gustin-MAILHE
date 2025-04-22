package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        // code de l'exercice 1
        BorderPane root = new BorderPane();

        // Creation de la menuBar
        Menu file = new Menu("File");
            MenuItem New = new MenuItem("New");
            MenuItem Open = new MenuItem("Open");
            MenuItem Save = new MenuItem("Save");
            MenuItem Close = new MenuItem("Close");
        Menu edit = new Menu("Edit");
            MenuItem Cut = new MenuItem("Cut");
            MenuItem Copy = new MenuItem("Copy");
            MenuItem Paste = new MenuItem("Paste");
        Menu help = new Menu("Help");


        file.getItems().addAll(New, Open, Save, Close);
        edit.getItems().addAll(Cut, Copy, Paste);
        MenuBar menuBar = new MenuBar(file, edit, help);

        root.setTop(menuBar);

        // Creation de la leftBox
        Label textArea = new Label("Boutons :");
        VBox.setMargin(textArea, new Insets(10, 0, 10, 0));
        Button btn1 = new Button("Bouton1");
        VBox.setMargin(btn1, new Insets(10, 0, 10, 0));
        Button btn2 = new Button("Bouton2");
        VBox.setMargin(btn2, new Insets(10, 0, 10, 0));
        Button btn3 = new Button("Bouton3");
        VBox.setMargin(btn3, new Insets(10, 0, 10, 0));

        VBox leftBox1 = new VBox(textArea, btn1, btn2, btn3);
        leftBox1.setAlignment(Pos.CENTER);
        HBox leftBox = new HBox(leftBox1, new Separator(Orientation.VERTICAL));

        root.setLeft(leftBox);

        // Creation de centerBox
        GridPane grid = new GridPane();
        Label name = new Label("Nom :");
        VBox.setMargin(name, new Insets(10));
        GridPane.setConstraints(name, 0, 0);
        Label email = new Label("Email :");
        VBox.setMargin(email, new Insets(10));
        GridPane.setConstraints(email, 0, 1);
        Label password = new Label("Password :");
        VBox.setMargin(password, new Insets(10));
        GridPane.setConstraints(password, 0, 2);

        TextField nameFeild = new TextField();
        GridPane.setColumnIndex(nameFeild, 1);
        TextField emailFeild = new TextField();
        GridPane.setColumnIndex(emailFeild, 1);
        PasswordField passwordFeild = new PasswordField();
        GridPane.setColumnIndex(passwordFeild, 1);

        grid.getChildren().addAll(name, email, password, nameFeild, emailFeild, passwordFeild);
        HBox submitCancel = new HBox();
        Button submitButton = new Button("Submit");
        Button cancelButton = new Button("Cancel");

        grid.setAlignment(Pos.CENTER);
        VBox centerBox = new VBox(grid, submitCancel);
        VBox.setVgrow(centerBox, Priority.ALWAYS);

        root.setCenter(centerBox);


        // Création de downBox
        VBox bottomBox = new VBox(new Separator(Orientation.HORIZONTAL), new Label("Ceci est un label de bas de page"));
        bottomBox.setAlignment(Pos.CENTER);
        root.setBottom(bottomBox);


        // Définition de la Scène
        Scene scene = new Scene(root, 800, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

