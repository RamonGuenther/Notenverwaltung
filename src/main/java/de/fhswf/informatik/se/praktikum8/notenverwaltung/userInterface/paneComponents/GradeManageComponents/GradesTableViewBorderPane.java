package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradesTableView;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GradesTableViewBorderPane extends BorderPane {

    public GradesTableViewBorderPane(){
        GradesTableView tableView = new GradesTableView();
        setCenter(tableView);

        Label averageGrade = new Label("Notendurchschnitt: ");
        Label sumCreditpoints = new Label("Creditpoints: ");

        HBox labelBox = new HBox();
        labelBox.getChildren().addAll(averageGrade, sumCreditpoints);
        labelBox.setSpacing(100);
        labelBox.setMargin(averageGrade, new Insets(10, 0, 10, 30));
        labelBox.setMargin(sumCreditpoints, new Insets(10, 0, 10, 30));
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
        radioButtonBox.setMargin(radioButtonAllModules, new Insets(10, 0, 10, 30));
        radioButtonBox.setMargin(radioButtonOpenModules, new Insets(10, 0, 10, 30));
        radioButtonBox.setMargin(radioButtonCompletedModules, new Insets(10, 0, 10, 30));
        setTop(radioButtonBox);

    }

}
