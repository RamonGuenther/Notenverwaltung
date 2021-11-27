package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Die Klasse GradesTableView erzeugt die Tabelle mit den Modulen
 * des Studenten.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 25. November 2021
 */
public class GradesTableView extends TableView<String> {

    /**
     * Im Konstruktor von GradesTableView wird die Tabelle initialisiert.
     */
    public GradesTableView(){
        TableColumn<String, String> columnModule = new TableColumn<>("Modul");

        TableColumn<String, String> columnModuleType = new TableColumn<>("Modulart");

        TableColumn<String, String> columnGrade = new TableColumn<>("Note");

        TableColumn<String, String> columnCreditpoints = new TableColumn<>("Creditpoints");

        TableColumn<String, String> columnSemester = new TableColumn<>("Semester");

        getColumns().addAll(columnModule, columnModuleType, columnGrade, columnCreditpoints, columnSemester);

    }
}
