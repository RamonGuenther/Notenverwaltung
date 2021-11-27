package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import javafx.scene.control.SplitPane;

/**
 * Die Klasse GradeManagementSplitPane dient als Basis für die zweigeteilte
 * Ansicht von Tabelle und Moduldetails in der Modulübersicht. Auf der linken
 * Seite ist die Tabelle mit den Modulen des Studenten, rechts die Details zu
 * einem ausgewählten Modul.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 25. November 2021
 */
public class GradeManagementSplitPane extends SplitPane {

    private GradesTableViewBorderPane gradesTable;
    private GradeDetailsGridPane gradeDetails;

    /**
     * Der Konstruktor von GradeManagementSplitPane initialisiert die Elemente
     * der SplitPane.
     */
    public GradeManagementSplitPane(){

        this.gradesTable = new GradesTableViewBorderPane();
        this.gradeDetails = new GradeDetailsGridPane();

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
