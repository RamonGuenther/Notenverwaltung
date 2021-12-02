package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * Die Klasse GradesTableView erzeugt die Tabelle mit den Modulen
 * des Studenten.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.1 vom 2. November 2021
 */
public class GradesTableView extends TableView<Object> {

    private final GradeManagementSplitPane splitPane;

    private final TableColumn<Object, Integer> columnCreditpoints;

    private final GradeDetailsGridPane gradeDetails;

    private String radioValue;

    /**
     * Im Konstruktor von GradesTableView wird die Tabelle initialisiert.
     *
     * @param studienleistung   Studienleistungsobjekt der Anwendung, das
     *                          alle Module und den Abschluss enthält.
     * @param gradeDetails      GridPane der Modulübersicht, welche die Detailansicht
     *                          der Module zeigt
     * @param splitPane         SplitPane der Modulübersicht, welche die Tabelle und
     *                          die Details anzeigt.
     */
    public GradesTableView(Studienleistung studienleistung, GradeDetailsGridPane gradeDetails, GradeManagementSplitPane splitPane){

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

        setOnMouseClicked((MouseEvent mouseEvent) -> {
            if (mouseEvent.getClickCount() >= 1) {
                onSelect();
            }
        });
    }

    /*------------------------------------------------------------------------------------
                                    GETTER UND SETTER
     -------------------------------------------------------------------------------------*/

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

    /*------------------------------------------------------------------------------------
                                        METHODEN
     -------------------------------------------------------------------------------------*/

    /**
     * Die Methode onSelect aktiviert oder deaktiviert Elemente der Detailansicht,
     * je nach ausgewähltem Modul und setzt die entsprechenden Werte in die Detailfelder
     * ein.
     */
    public void onSelect() {
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
