package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.HelpMenuItem;
import javafx.scene.control.Menu;

/**
 * Die Klasse HelpMenu erstellt einen Hilfe-Menüpunkt für die MenuBar der
 * Anwendung
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 25. November 2021
 */
public class HelpMenu extends Menu {

    /**
     * Der Konstruktor von HelpMenu initialisiert den Hilfe-Menüpunkt
     * für die MenuBar der Anwendung.
     */
    public HelpMenu(){
        setText("_Hilfe");
        setMnemonicParsing(true);
        getItems().add(new HelpMenuItem());
    }
}
