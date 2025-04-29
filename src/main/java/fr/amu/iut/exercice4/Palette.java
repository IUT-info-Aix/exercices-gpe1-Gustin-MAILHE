package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();

        // Définition du bas
        vert = new Button("Vert");
        HBox.setMargin(vert, new Insets(10));
        rouge = new Button("Rouge");
        HBox.setMargin(rouge, new Insets(10));
        bleu = new Button("Bleu");
        HBox.setMargin(bleu, new Insets(10));

        bas = new HBox(vert, rouge, bleu);
        bas.setAlignment(Pos.CENTER);
        root.setBottom(bas);

        // Définition du centre
        panneau = new Pane();
        root.setCenter(panneau);

        // Définition du Label
        label = new Label();
        HBox.setMargin(label, new Insets(10));
        root.setTop(label);

        // Gestion des évenement

        vert.setOnMouseClicked(e -> {
            nbVert += 10;
            panneau.setStyle("-fx-background-color: rgb(" + nbRouge + "," + nbVert + "," +  nbBleu + ");");
            label.setText("Vert choisi " + nbVert/10 + " fois");
        });

        rouge.setOnMouseClicked(e -> {
            nbRouge += 10;
            panneau.setStyle("-fx-background-color: rgb(" + nbRouge + "," + nbVert + "," +  nbBleu + ");");
            label.setText("Rouge choisi " + nbRouge/10 + " fois");
        });

        bleu.setOnMouseClicked(e -> {
            nbBleu += 10;
            panneau.setStyle("-fx-background-color: rgb(" + nbRouge + "," + nbVert + "," +  nbBleu + ");");
            label.setText("Bleu choisi " + nbBleu/10 + " fois");
        });

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

