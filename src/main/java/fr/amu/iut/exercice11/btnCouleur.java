package fr.amu.iut.exercice11;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class btnCouleur {
    private StringProperty couleur;
    private IntegerProperty nbFois = new SimpleIntegerProperty(0);

    public btnCouleur(String couleur) {
        this.couleur = new SimpleStringProperty(couleur);
    }

    public final String getCouleur() {return couleur.get();}
    public final StringProperty stringProperty() {return couleur;}
    public final void setCouleur(String couleur) {this.couleur.set(couleur);}

    public final int getNbFois() {return nbFois.get();}
    public final IntegerProperty nbFoisProperty() {return nbFois;}
    public final void setNbFois(int nbFois) {this.nbFois.set(nbFois);}
}
