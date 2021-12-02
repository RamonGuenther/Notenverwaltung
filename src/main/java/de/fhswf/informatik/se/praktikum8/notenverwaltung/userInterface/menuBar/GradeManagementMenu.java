package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.BachelorThesisAndKolloquiumMenuItem;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.GradeManagementMenuItem;
import javafx.scene.control.Menu;

/**
 * Die Klasse GradeManagementMenu erstellt einen Prüfungsleistungen-Menüpunkt
 * für die MenuBar der Anwendung
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 25. November 2021
 */
public class GradeManagementMenu extends Menu {

    /**
     * Der Konstruktor von HelpMenu initialisiert den Prüfungsleistung-Menüpunkt
     * für die MenuBar der Anwendung.
     *
     * @param initializer   StageInitializer wird an Komponenten
     *                      weitergereicht, um in dessen EventHandlern
     *                      die Scenes wechseln zu können.
     */
    public GradeManagementMenu(StageInitializer initializer){
        setText("_Prüfungsleistungen");
        setMnemonicParsing(true);
        getItems().addAll(new BachelorThesisAndKolloquiumMenuItem(initializer), new GradeManagementMenuItem(initializer));
    }
}
