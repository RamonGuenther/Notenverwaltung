package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

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
 * @author Ivonne Kneißig
 * @version 1.0 vom 25. November 2021
 */
public class GradesTableViewBorderPane extends BorderPane {

    /**
     * Im Konstruktor von GradesTableViewBorderPane werden die einzelnen Elemente der
     * Ansicht erzeugt bzw. initialisiert und der BorderPane entsprechend hinzugefügt.
     */
    public GradesTableViewBorderPane(){
        GradesTableView tableView = new GradesTableView();
        setCenter(tableView);

        Label averageGrade = new Label("Notendurchschnitt: ");
        Label sumCreditpoints = new Label("Creditpoints: ");

        HBox labelBox = new HBox();
        labelBox.getChildren().addAll(averageGrade, sumCreditpoints);
        labelBox.setSpacing(100);
        HBox.setMargin(averageGrade, new Insets(10, 0, 10, 30));
        HBox.setMargin(sumCreditpoints, new Insets(10, 0, 10, 30));
        setBottom(labelBox);

        ToggleGroup group = new ToggleGroup();
        RadioButton radioButtonAllModules = new RadioButton("Alle Module");
        radioButtonAllModules.setToggleGroup(group);
        radioButtonAllModules.setSelected(true);
        RadioButton radioButtonOpenModules = new RadioButton("Offene Module");
        radioButtonOpenModules.setToggleGroup(group);
        RadioButton radioButtonCompletedModules = new RadioButton("Abgeschlossene Module");
        radioButtonCompletedModules.setToggleGroup(group);

        HBox radioButtonBox = new HBox();
        radioButtonBox.getChildren().addAll(radioButtonAllModules, radioButtonOpenModules, radioButtonCompletedModules);
        HBox.setMargin(radioButtonAllModules, new Insets(10, 0, 10, 30));
        HBox.setMargin(radioButtonOpenModules, new Insets(10, 0, 10, 30));
        HBox.setMargin(radioButtonCompletedModules, new Insets(10, 0, 10, 30));
        setTop(radioButtonBox);
    }
}
