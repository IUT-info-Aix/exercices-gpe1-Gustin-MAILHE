package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import java.util.List;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;

    private static ListChangeListener<Personne> plusieursChangementsListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[] {personne.ageProperty()});

        unChangementListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> c) {
                while (c.next()) {
                    if (c.wasAdded()){
                        System.out.println("On été ajouté :");
                        for (int i = c.getFrom(); i < c.getTo(); ++i) {
                            System.out.println(lesPersonnes.get(i).getNom());
                        }
                    }
                    if (c.wasRemoved()){
                        System.out.println("On été supprimé :");
                        for (Personne el : c.getRemoved()) {
                            System.out.println(el.getNom());
                        }
                    }
                    if (c.wasUpdated()){
                        System.out.println("On été mis à jour :");
                        for (int i = c.getFrom(); i < c.getTo(); ++i) {
                            int age = lesPersonnes.get(i).getAge();
                            String nom = lesPersonnes.get(i).getNom();
                            System.out.println(nom + " a maintenant " + age + " ans");
                        }
                    }
                }
            }
        };

//        plusieursChangementsListener = new ListChangeListener<Personne>() {
//            @Override
//            public void onChanged(Change<? extends Personne> change) {
//
//            }
//        }

        lesPersonnes.addListener(unChangementListener);
//        lesPersonnes.addListener(plusieursChangementsListener);

        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

