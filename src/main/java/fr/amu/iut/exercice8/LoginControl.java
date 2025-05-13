package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class LoginControl extends GridPane {

    @FXML
    private TextField name;

    @FXML
    private PasswordField pwd;

    @FXML
    private void okClicked() {
        String nom = name.getCharacters().toString();
        System.out.println(nom);

        String mdp = "";
        for (int i = 0; i < pwd.getCharacters().length(); i++) {
            mdp += "*";
        }
        System.out.println(mdp);
    }

    @FXML
    private void cancelClicked() {
        name.setText("");
        pwd.setText("");
    }
}