package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class IHMPendu extends Application {

    //Initialisation des variables
    private Dico dico = new Dico();
    private String leMot = dico.getMot();
    private char[] leMotCache = new char[leMot.length()];
    private char[] lettresEssaye = {};
    private int nbVie = 6;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        for (int i = 0; i < leMotCache.length; i++) {
            leMotCache[i] = '*';
        }

        // Structure de la VBox

        ImageView imgView = new ImageView();
        imgView.setImage(new Image("exercice6/pendu7.png"));
        VBox.setMargin(imgView, new Insets(15));

        Label labelVie = new Label("Nombre de vies : " + nbVie);
        VBox.setMargin(labelVie, new Insets(15));

        Label leMotCacheLabel = new Label(new String(leMotCache));
        VBox.setMargin(leMotCacheLabel, new Insets(15));

        TextField zoneDeSaisie = new TextField();
        zoneDeSaisie.setPromptText("Nombre de vies : " + nbVie);
        zoneDeSaisie.setOnAction(actionEvent -> {
            char lettre = zoneDeSaisie.getText().charAt(0);
            leJeu(lettre);
            labelVie.setText("Nombre de vies : " + nbVie);
            leMotCacheLabel.setText(new String(leMotCache));
            imgView.setImage(new Image("exercice6/pendu" + (nbVie+1) + ".png"));
            if (new String(leMotCache).equals(leMot) || nbVie <= 0) primaryStage.close();

        });


        //Clavier
        String alphabet = "azertyuiopqsdfghjkmlwxcvbn";
        HBox ligne1 = new HBox();
        ligne1.setAlignment(Pos.CENTER);
        for (int i = 0 ; i < 10 ; ++i) {
            char maLettre = alphabet.charAt(i);
            Button btn = new Button(maLettre + "");
            btn.setPrefSize(40, 40);
            ligne1.getChildren().add(btn);
            btn.setOnAction(actionEvent -> {
                leJeu(btn.getText().charAt(0));
                labelVie.setText("Nombre de vies : " + nbVie);
                leMotCacheLabel.setText(new String(leMotCache));
                imgView.setImage(new Image("exercice6/pendu" + (nbVie+1) + ".png"));
                if (new String(leMotCache).equals(leMot) || nbVie <= 0) primaryStage.close();
            });
        }
        HBox ligne2 = new HBox();
        ligne2.setAlignment(Pos.CENTER);
        for (int i = 10 ; i < 20 ; ++i) {
            char maLettre = alphabet.charAt(i);
            Button btn = new Button(maLettre + "");
            btn.setPrefSize(40, 40);
            ligne2.getChildren().add(btn);
            btn.setOnAction(actionEvent -> {
                leJeu(btn.getText().charAt(0));
                labelVie.setText("Nombre de vies : " + nbVie);
                leMotCacheLabel.setText(new String(leMotCache));
                imgView.setImage(new Image("exercice6/pendu" + (nbVie+1) + ".png"));
                if (new String(leMotCache).equals(leMot) || nbVie <= 0) primaryStage.close();
            });
        }
        HBox ligne3 = new HBox();
        ligne3.setAlignment(Pos.CENTER);
        for (int i = 20 ; i < 26 ; ++i) {
            char maLettre = alphabet.charAt(i);
            Button btn = new Button(maLettre + "");
            btn.setPrefSize(40, 40);
            ligne3.getChildren().add(btn);
            btn.setOnAction(actionEvent -> {
                leJeu(btn.getText().charAt(0));
                labelVie.setText("Nombre de vies : " + nbVie);
                leMotCacheLabel.setText(new String(leMotCache));
                imgView.setImage(new Image("exercice6/pendu" + (nbVie+1) + ".png"));
                if (new String(leMotCache).equals(leMot) || nbVie <= 0) primaryStage.close();
            });
        }

        VBox clavier = new VBox();
        clavier.setAlignment(Pos.CENTER);
        clavier.getChildren().addAll(ligne1, ligne2, ligne3);

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(imgView, labelVie, leMotCacheLabel, zoneDeSaisie, clavier);


        // Création de la scene
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void leJeu(char lettreEssaye ) {
        ArrayList<Integer> listIndex = dico.getPositions(lettreEssaye, leMot);
        if (listIndex.isEmpty()) --nbVie;
        else {
            for (Integer index : listIndex) {
                leMotCache[index] = lettreEssaye;
            }
        }
    }
}
