package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar.GradeManagementMenuBar;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManagementButtonBox;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManagementSplitPane;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class GradeManagementBorderPane extends BorderPane {

    public GradeManagementBorderPane(){
        GradeManagementMenuBar menuBar = new GradeManagementMenuBar();
        setTop(menuBar);

        GradeManagementButtonBox buttonBox = new GradeManagementButtonBox();
        setBottom(buttonBox);

        GradeManagementSplitPane gradesTable = new GradeManagementSplitPane();
        setCenter(gradesTable);
    }
}
