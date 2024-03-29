package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar.GradeManagementMenuBar;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.BachelorThesisAndKolloquiumComponents.BachelorThesisAndKolloquiumGridPane;
import javafx.scene.layout.BorderPane;

/**
 * Die Klasse BachelorThesisAndKolloquiumBorderPane ist die Basis für die
 * Ansicht für den Abschluss des Studenten. Hier werden Noten und Creditpoints
 * für die Bachelorarbeit und das Kolloquium eingetragen und angezeigt.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.1 vom 2. Dezember 2021
 */
public class BachelorThesisAndKolloquiumBorderPane extends BorderPane {

    /**
     * Der Konstruktor von BachelorThesisAndKolloquiumBorderPane setzt
     * die Elemente der Ansicht zusammen.
     * Die Ansicht enthält eine Übersicht über die Noten und die Creditpoints
     * für Bachelorarbeit und Kolloquium des Studenten.
     *
     * @param initializer       StageInitializer wird an Komponenten
     *                          weitergereicht, um in dessen EventHandlern
     *                          die Scenes wechseln zu können.
     * @param studienleistung   Studienleistungsobjekt der Anwendung, das
     *                          alle Module und den Abschluss enthält.
     */
    public BachelorThesisAndKolloquiumBorderPane(StageInitializer initializer, Studienleistung studienleistung){
        GradeManagementMenuBar menuBar = new GradeManagementMenuBar(initializer);
        setTop(menuBar);

        BachelorThesisAndKolloquiumGridPane bachelorThesisAndKolloquiumDetails = new BachelorThesisAndKolloquiumGridPane(studienleistung);
        setCenter(bachelorThesisAndKolloquiumDetails);
    }
}
