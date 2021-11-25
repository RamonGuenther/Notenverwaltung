package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


public class GradeManagementButtonBox extends HBox {

    public GradeManagementButtonBox(){

        Button addModule = new Button("Modul hinzufügen");
        addModule.setMinWidth(180);
        setMargin(addModule, new Insets(20, 0, 50, 0));

        Button deleteModule = new Button("Modul entfernen");
        deleteModule.setMinWidth(180);
        setMargin(deleteModule, new Insets(20, 0, 50, 0));

        Button updateModule = new Button ("Prüfungsleistung aktualisieren");
        updateModule.setMinWidth(180);
        setMargin(updateModule, new Insets(20, 0, 50, 0));

        setAlignment(Pos.BASELINE_CENTER);
        setWidth(800);
        setSpacing(100);

        getChildren().addAll(addModule, deleteModule, updateModule);
    }
}
