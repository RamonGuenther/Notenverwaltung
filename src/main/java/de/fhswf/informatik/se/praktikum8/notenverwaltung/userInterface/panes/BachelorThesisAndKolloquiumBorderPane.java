package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar.GradeManagementMenuBar;
import javafx.scene.layout.BorderPane;

/**
 * Die Klasse BachelorThesisAndKolloquiumBorderPane ist die Basis für die
 * Ansicht für den Abschluss des Studenten. Hier werden Noten und Creditpoints
 * für die Bachelorarbeit und das Kolloquium eingetragen und angezeigt.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 26. November 2021
 */
public class BachelorThesisAndKolloquiumBorderPane extends BorderPane {

    private GradeManagementMenuBar menuBar;

    /**
     * Der Konstruktor von BachelorThesisAndKolloquiumBorderPane setzt
     * die Elemente der Ansicht zusammen.
     * Die Ansicht enthält eine Übersicht über die Noten und die Creditpoints
     * für Bachelorarbeit und Kolloquium des Studenten.
     *
     * @param initializer       StageInitializer wird an Komponenten
     *                          weitergereicht, um in dessen EventHandlern
     *                          die Scenes wechseln zu können.
     */
    public BachelorThesisAndKolloquiumBorderPane(StageInitializer initializer){
        menuBar = new GradeManagementMenuBar(initializer);
        setTop(menuBar);
    }
}
