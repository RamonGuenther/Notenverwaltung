package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler.AddModuleEventHandler;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler.GradeDetailsEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 * Die Klasse GradeManagementButtonBox erstellt die Buttonzeile mit den Buttons
 * zum Hinzufügen eines Moduls, zum Entfernen eines Moduls und zum Aktualisieren
 * der Prüfungsleistung eines Moduls für die Modulübersicht.
 *
 * @author Ivonne Kneißig
 * @version 1.1 vom 27. November 2021
 */
public class GradeManagementButtonBox extends HBox {

    /**
     * Der Konstruktor von GradeManagementSplitPane initialisiert die Elemente
     * der Buttonzeile
     *
     * @param pane              SplitPane der Modulübersicht, welche die Tabelle und
     *                          die Details anzeigt. Wird dem GradeDetailsEventHandler
     *                          übergeben.
     */
    public GradeManagementButtonBox(GradeManagementSplitPane pane){

        Button addModule = new Button("Module hinzufügen");
        addModule.setMinWidth(180);
        setMargin(addModule, new Insets(20, 0, 20, 0));
        addModule.setOnAction(new AddModuleEventHandler());

        Button deleteModule = new Button("Modul entfernen");
        deleteModule.setMinWidth(180);
        setMargin(deleteModule, new Insets(20, 0, 20, 0));

        Button updateModule = new Button ("Prüfungsleistung aktualisieren");
        updateModule.setMinWidth(180);
        setMargin(updateModule, new Insets(20, 0, 20, 0));
        updateModule.setOnAction(new GradeDetailsEventHandler(pane));

        setAlignment(Pos.BASELINE_CENTER);
        setWidth(800);
        setSpacing(100);

        getChildren().addAll(addModule, deleteModule, updateModule);
    }
}
