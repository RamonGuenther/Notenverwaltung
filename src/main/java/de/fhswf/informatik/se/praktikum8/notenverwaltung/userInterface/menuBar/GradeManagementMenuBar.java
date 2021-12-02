package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import javafx.scene.control.MenuBar;

/**
 * Die Klasse GradeManagementMenuBar erstellt eine Menubar für die Anwendung.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 25. November 2021
 */
public class GradeManagementMenuBar extends MenuBar {

    /**
     * Der Konstruktor von GradeManagementMenuBar setzt die Elemente der MenuBar
     * zusammen.
     *
     * @param initializer   StageInitializer wird an Komponenten
     *                      weitergereicht, um in dessen EventHandlern
     *                      die Scenes wechseln zu können.
     */
    public GradeManagementMenuBar(StageInitializer initializer){
        getMenus().addAll(new DataMenu(), new GradeManagementMenu(initializer), new HelpMenu());
    }
}
