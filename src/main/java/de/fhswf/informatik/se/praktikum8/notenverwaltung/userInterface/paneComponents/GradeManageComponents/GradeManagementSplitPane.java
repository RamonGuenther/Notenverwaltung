package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;

/**
 * Die Klasse GradeManagementSplitPane dient als Basis für die zweigeteilte
 * Ansicht von Tabelle und Moduldetails in der Modulübersicht. Auf der linken
 * Seite ist die Tabelle mit den Modulen des Studenten, rechts die Details zu
 * einem ausgewählten Modul.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.2 vom 2. Dezember 2021
 */
public class GradeManagementSplitPane extends SplitPane {

    private Button updateButton;

    private final GradesTableViewBorderPane gradesTable;
    private final GradeDetailsGridPane gradeDetails;

    /**
     * Der Konstruktor von GradeManagementSplitPane initialisiert die Elemente
     * der SplitPane.
     *
     * @param studienleistung   Studienleistungsobjekt der Anwendung, das
     *                          alle Module und den Abschluss enthält.
     */
    public GradeManagementSplitPane(Studienleistung studienleistung){

        this.gradeDetails = new GradeDetailsGridPane(studienleistung, this);
        this.gradesTable = new GradesTableViewBorderPane(studienleistung, gradeDetails, this);

        setDividerPositions(0.56);
        getItems().addAll(gradesTable, gradeDetails);
    }

    /*------------------------------------------------------------------------------------
                                        GETTER UND SETTER
     -------------------------------------------------------------------------------------*/

    public GradesTableViewBorderPane getGradesTableBorderPane() {
        return gradesTable;
    }

    public GradeDetailsGridPane getGradeDetails() {
        return gradeDetails;
    }

    public Button getUpdateButton() {
        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }
}
