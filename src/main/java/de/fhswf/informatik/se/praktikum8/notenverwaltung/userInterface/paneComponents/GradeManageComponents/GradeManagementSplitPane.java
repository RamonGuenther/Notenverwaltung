package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import javafx.scene.control.SplitPane;

public class GradeManagementSplitPane extends SplitPane {

    private GradesTableViewBorderPane gradesTable;
    private GradeDetailsGridPane gradeDetails;

    public GradeManagementSplitPane(){

        this.gradesTable = new GradesTableViewBorderPane();
        this.gradeDetails = new GradeDetailsGridPane();

        getItems().addAll(gradesTable, gradeDetails);
    }

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
