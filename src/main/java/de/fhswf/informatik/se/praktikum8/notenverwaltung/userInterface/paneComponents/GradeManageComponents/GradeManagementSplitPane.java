package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import javafx.scene.control.SplitPane;

/**
 * Die Klasse GradeManagementSplitPane dient als Basis für die zweigeteilte
 * Ansicht von Tabelle und Moduldetails in der Modulübersicht. Auf der linken
 * Seite ist die Tabelle mit den Modulen des Studenten, rechts die Details zu
 * einem ausgewählten Modul.
 *
 * @author Ivonne Kneißig
 * @version 1.1 vom 1. Dezember 2021
 */
public class GradeManagementSplitPane extends SplitPane {

    private GradesTableViewBorderPane gradesTable;
    private GradeDetailsGridPane gradeDetails;

    /**
     * Der Konstruktor von GradeManagementSplitPane initialisiert die Elemente
     * der SplitPane.
     */
    public GradeManagementSplitPane(Studienleistung studienleistung){

        this.gradeDetails = new GradeDetailsGridPane(studienleistung);
        this.gradesTable = new GradesTableViewBorderPane(studienleistung, gradeDetails);

        setDividerPositions(0.56);
        getItems().addAll(gradesTable, gradeDetails);
    }

    //Getter und Setter

    public GradesTableViewBorderPane getGradesTable() {
        return gradesTable;
    }

    public void setGradesTable(GradesTableViewBorderPane gradesTable) {
        this.gradesTable = gradesTable;
    }

    public GradeDetailsGridPane getGradeDetails() {
        return gradeDetails;
    }

    public void setGradeDetails(GradeDetailsGridPane gradeDetails) {
        this.gradeDetails = gradeDetails;
    }
}
