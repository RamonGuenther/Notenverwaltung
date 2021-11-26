package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar.GradeManagementMenuBar;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradeManagementButtonBox;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradeManagementSplitPane;
import javafx.scene.layout.BorderPane;

/**
 * Die Klasse GradeManagementBorderPane ist die Basis für die
 * Ansicht der Modulübersicht des Studenten.
 *
 * @author Ivonne Kneißig
 * @version 1.1 vom 26. November 2021
 */

public class GradeManagementBorderPane extends BorderPane {

    private GradeManagementMenuBar menuBar;
    private GradeManagementButtonBox buttonBox;
    private GradeManagementSplitPane gradesTable;

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
     */
    public GradeManagementBorderPane(StageInitializer initializer){

        this.menuBar = new GradeManagementMenuBar(initializer);
        setTop(menuBar);

        this.gradesTable = new GradeManagementSplitPane();
        setCenter(gradesTable);

        this.buttonBox = new GradeManagementButtonBox(gradesTable);
        setBottom(buttonBox);
    }
}
