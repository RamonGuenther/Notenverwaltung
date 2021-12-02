package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.QuitMenuItem;
import javafx.scene.control.Menu;

/**
 * Die Klasse DataMenu erstellt einen Datei-Menüpunkt für die MenuBar der Anwendung
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.0 vom 25. November 2021
 */
public class DataMenu extends Menu {

    /**
     * Der Konstruktor von DataMenu initialisiert den Datei-Menüpunkt
     * für die MenuBar der Anwendung.
     */
    public DataMenu(){
        setText("_Datei");
        setMnemonicParsing(true);
        getItems().add(new QuitMenuItem());
    }
}
