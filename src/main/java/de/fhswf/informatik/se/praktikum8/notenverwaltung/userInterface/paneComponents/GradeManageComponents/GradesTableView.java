package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * Die Klasse GradesTableView erzeugt die Tabelle mit den Modulen
 * des Studenten.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 25. November 2021
 */
public class GradesTableView extends TableView<Object> {

    private GradeManagementSplitPane splitPane;

    private TableColumn<Object, Integer> columnCreditpoints;

    private GradeDetailsGridPane gradeDetails;

    private Studienleistung studienleistung;

    private String radioValue;

    /**
     * Im Konstruktor von GradesTableView wird die Tabelle initialisiert.
     */
    public GradesTableView(Studienleistung studienleistung, GradeDetailsGridPane gradeDetails, GradeManagementSplitPane splitPane){

        this.studienleistung = studienleistung;
        this.gradeDetails = gradeDetails;
        this.splitPane = splitPane;
        gradeDetails.setTable(this);
        radioValue = "Alle Module";

        TableColumn<Object, String> columnModule = new TableColumn<>("Modul");
        columnModule.setCellValueFactory(new PropertyValueFactory<>("modulname"));


        TableColumn<Object, String> columnModuleType = new TableColumn<>("Modulart");
        columnModuleType.setCellValueFactory(new PropertyValueFactory<>("modulart"));


        TableColumn<Object, String> columnGrade = new TableColumn<>("Note");
        columnGrade.setCellValueFactory(new PropertyValueFactory<>("endNote"));

        columnCreditpoints = new TableColumn<>("Creditpoints");
        columnCreditpoints.setCellValueFactory(new PropertyValueFactory<>("creditpoints"));

        TableColumn<Object, Integer> columnSemester = new TableColumn<>("Semester");
        columnSemester.setCellValueFactory(new PropertyValueFactory<>("semester"));

        getColumns().addAll(columnModule, columnModuleType, columnGrade, columnCreditpoints, columnSemester);
        getItems().addAll(studienleistung.getAllePflichtmoduleUndWahlpflichtmodule());

        setOnMouseClicked((MouseEvent event2) -> {
            if (event2.getClickCount() >= 1) {
                onEdit();
            }
        });
    }

    public String getRadioValue() {
        return radioValue;
    }

    public void setRadioValue(String radioValue) {
        this.radioValue = radioValue;
    }

    public void setColumnsPflichtmodule(){
        if(!getColumns().get(3).equals(columnCreditpoints)){
            getColumns().add(3, columnCreditpoints);
        }
    }

    public void setColumnsWahlmodule(){
        getColumns().remove(3);
    }

    public void onEdit() {
        if( getSelectionModel().getSelectedItem() == null){
            return;
        }
        splitPane.getUpdateButton().setDisable(false);
        gradeDetails.getGradeOneValue().setDisable(true);
        gradeDetails.getGradeTwoValue().setDisable(true);
        gradeDetails.getGradeThreeValue().setDisable(true);
        gradeDetails.getSave().setVisible(false);
        gradeDetails.getCancel().setVisible(false);
        gradeDetails.setDetails(getSelectionModel().getSelectedItem(),radioValue);
    }


}
