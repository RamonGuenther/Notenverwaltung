package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class GradesTableView extends TableView<String> {

    public GradesTableView(){
        TableColumn<String, String> columnModule = new TableColumn<>("Modul");

        TableColumn<String, String> columnModuleType = new TableColumn<>("Modulart");

        TableColumn<String, String> columnGrade = new TableColumn<>("Note");

        TableColumn<String, String> columnCreditpoints = new TableColumn<>("Creditpoints");

        TableColumn<String, String> columnSemester = new TableColumn<>("Semester");

        getColumns().addAll(columnModule, columnModuleType, columnGrade, columnCreditpoints, columnSemester);

    }

}
