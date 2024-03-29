package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * Die Klasse GradesTableViewBorderPane erstellt die Tabellenübersicht für die
 * Modulübersicht des Studenten. Der Student kann die Module über
 * RadioButtons filtern und sieht seinen aktuellen Notendurchschnitt und
 * die bisher gesammelten Creditpoints.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.1 vom 2. November 2021
 */
public class GradesTableViewBorderPane extends BorderPane {

    private String radioValue;
    private final GradesTableView tableView;

    private final Label averageGrade;
    private final Label sumCreditpoints;

    /**
     * Im Konstruktor von GradesTableViewBorderPane werden die einzelnen Elemente der
     * Ansicht erzeugt bzw. initialisiert und der BorderPane entsprechend hinzugefügt.
     *
     * @param studienleistung           Studienleistungsobjekt der Anwendung, das
     *                                  alle Module und den Abschluss enthält.
     * @param gradeDetails              GridPane der Modulübersicht, welche die Detailansicht
     *                                  der Module zeigt
     * @param splitPane                 SplitPane der Modulübersicht, welche die Tabelle und
     *                                  die Details anzeigt.
     */
    public GradesTableViewBorderPane(Studienleistung studienleistung, GradeDetailsGridPane gradeDetails, GradeManagementSplitPane splitPane){

        tableView = new GradesTableView(studienleistung, gradeDetails, splitPane);
        setCenter(tableView);

        averageGrade = new Label("Notendurchschnitt: " + studienleistung.getNotendurchschnittModule());
        sumCreditpoints = new Label("Creditpoints: " + studienleistung.getSummeCreditpointsOhneAbschluss());

        HBox labelBox = new HBox();
        labelBox.getChildren().addAll(averageGrade, sumCreditpoints);
        labelBox.setSpacing(100);
        HBox.setMargin(averageGrade, new Insets(10, 0, 10, 30));
        HBox.setMargin(sumCreditpoints, new Insets(10, 0, 10, 30));
        setBottom(labelBox);

        ToggleGroup group = new ToggleGroup();
        RadioButton radioButtonAllModules = new RadioButton("Alle Module");
        radioButtonAllModules.setUserData("Alle Module");
        radioButtonAllModules.setToggleGroup(group);
        radioButtonAllModules.setSelected(true);
        RadioButton radioButtonOpenModules = new RadioButton("Offen");
        radioButtonOpenModules.setUserData("Offen");
        radioButtonOpenModules.setToggleGroup(group);
        RadioButton radioButtonCompletedModules = new RadioButton("Bestanden");
        radioButtonCompletedModules.setUserData("Bestanden");
        radioButtonCompletedModules.setToggleGroup(group);
        RadioButton radioButtonWahlmodul = new RadioButton("Wahlmodule");
        radioButtonWahlmodul.setUserData("Wahlmodule");
        radioButtonWahlmodul.setToggleGroup(group);

        group.selectedToggleProperty().addListener((ov, old_toggle, new_toggle) -> {

            if (group.getSelectedToggle() != null) {
                radioValue = group.getSelectedToggle().getUserData().toString();

                switch (radioValue) {
                    case "Alle Module" -> {
                        tableView.getItems().clear();
                        tableView.getItems().addAll(studienleistung.getAllePflichtmoduleUndWahlpflichtmodule());
                        tableView.setColumnsPflichtmodule();
                        tableView.setRadioValue(radioValue);
                    }
                    case "Offen" -> {
                        tableView.getItems().clear();
                        tableView.getItems().addAll(studienleistung.getOffenePflichtmoduleUndWahlpflichtmodule());
                        tableView.setColumnsPflichtmodule();
                        tableView.setRadioValue(radioValue);
                    }
                    case "Bestanden" -> {
                        tableView.getItems().clear();
                        tableView.getItems().addAll(studienleistung.getBestandenePflichtmoduleUndWahlpflichtmodule());
                        tableView.setColumnsPflichtmodule();
                        tableView.setRadioValue(radioValue);
                    }
                    case "Wahlmodule" -> {
                        tableView.getItems().clear();
                        tableView.getItems().addAll(studienleistung.getWahlmoduleForTable());
                        tableView.setColumnsWahlmodule();
                        tableView.setRadioValue(radioValue);
                    }
                    default -> {
                        tableView.getItems().clear();
                        tableView.getItems().addAll(studienleistung.getAllePflichtmoduleUndWahlpflichtmodule());
                    }
                }
            }
        });

        HBox radioButtonBox = new HBox();
        radioButtonBox.getChildren().addAll(radioButtonAllModules, radioButtonOpenModules, radioButtonCompletedModules, radioButtonWahlmodul);
        HBox.setMargin(radioButtonAllModules, new Insets(10, 0, 10, 30));
        HBox.setMargin(radioButtonOpenModules, new Insets(10, 0, 10, 30));
        HBox.setMargin(radioButtonCompletedModules, new Insets(10, 0, 10, 30));
        HBox.setMargin(radioButtonWahlmodul, new Insets(10, 0, 10, 30));
        setTop(radioButtonBox);
    }

    /*------------------------------------------------------------------------------------
                                      GETTER UND SETTER
     -------------------------------------------------------------------------------------*/

    public GradesTableView getTableView() {
        return tableView;
    }

    public Label getAverageGrade() {
        return averageGrade;
    }

    public Label getSumCreditpoints() {
        return sumCreditpoints;
    }
}
