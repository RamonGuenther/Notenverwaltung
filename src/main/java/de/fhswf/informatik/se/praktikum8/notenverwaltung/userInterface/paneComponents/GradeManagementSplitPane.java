package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents;

import javafx.scene.control.SplitPane;

public class GradeManagementSplitPane extends SplitPane {

    public GradeManagementSplitPane(){
        GradesTableView tableView = new GradesTableView();
        GradeDetailsStackPane gradeDetails = new GradeDetailsStackPane();

        getItems().addAll(tableView, gradeDetails);

    }
}
