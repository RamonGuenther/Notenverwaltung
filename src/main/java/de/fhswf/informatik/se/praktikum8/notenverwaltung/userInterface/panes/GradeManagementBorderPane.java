package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar.GradeManagementMenuBar;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradeManagementButtonBox;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradeManagementSplitPane;
import javafx.scene.layout.BorderPane;

/**
 * Die Klasse GradeManagementBorderPane ist die Basis für die
 * Ansicht der Modulübersicht des Studenten.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.2 vom 1. Dezember 2021
 */

public class GradeManagementBorderPane extends BorderPane {

    /**
     * Der Konstruktor von GradeManagementBorderPane setzt Elemente
     * für die Modulübersicht des Studenten zusammen.
     * Diese Besteht aus der MenüBar, einer Tabelle mit den Modulen
     * des Studenten und einer Detailansicht für ein ausgewähltes
     * Modul.
     *
     * @param initializer       StageInitializer wird an Komponenten
     *                          weitergereicht, um in dessen EventHandlern
     *                          die Scenes wechseln zu können.
     * @param studienleistung   Studienleistungsobjekt der Anwendung, das
     *                          alle Module und den Abschluss enthält.
     */
    public GradeManagementBorderPane(StageInitializer initializer, Studienleistung studienleistung){

        GradeManagementMenuBar menuBar = new GradeManagementMenuBar(initializer);
        setTop(menuBar);

        GradeManagementSplitPane gradesTable = new GradeManagementSplitPane(studienleistung);
        setCenter(gradesTable);

        GradeManagementButtonBox buttonBox = new GradeManagementButtonBox(gradesTable, studienleistung);
        setBottom(buttonBox);

        gradesTable.setUpdateButton(buttonBox.getUpdateModule());
    }
}
