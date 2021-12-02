package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents;

import javafx.scene.control.ComboBox;

/**
 * Die Klasse ChoiceBoxGrade erstellt eine Selections-Auswahl mit allen
 * möglichen Noten für ein Modul.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.1 vom 2. November 2021
 */
public class ComboBoxGrade extends ComboBox<Double> {

    /**
     * Der Konstruktor von ChoiceBoxGrade fügt der Auswahlbox
     * die möglichen Noten für ein Modul zur Auswahl hinzu.
     */
    public ComboBoxGrade(){

        getItems().addAll(1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 5.0);

    }
}
