package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * ...
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 1. Dezember 2021
 */
public class DeleteModuleGridPane extends GridPane {

    private final Stage stage;
    private Studienleistung studienleistung;
    private Alert alert;

    private final ComboBox<String> moduleType;
    private ComboBox<String> modulesWahlpflichtfach;
    private ComboBox<String> modulesWahlfach;

    private final Label labelModules;

    /**
     * Im Konstruktor von AddModuleStackPane werden die einzelnen Elemente der Ansicht
     * erzeugt bzw. initialisiert und der GridPane entsprechend hinzugefügt.
     *
     * @param stage     Stage-Object des Fensters. Wird im cancelEventHandler zum
     *                  Schließen des Fensters benötigt.
     */
    public DeleteModuleGridPane(Stage stage, Studienleistung studienleistung) {

        this.stage = stage;
        this.studienleistung = studienleistung;

        Label title = new Label("Module entfernen");
        title.setFont(new Font(30));
        title.setStyle("-fx-font-weight: bold");

        Label labelModuleType = new Label("Modulart");
        labelModuleType.setFont(new Font(16));

        moduleType = new ComboBox<>();
        moduleType.getItems().addAll("Studienrichtung", "Wahlpflichtblock", "Wahlpflichtmodul", "Wahlmodul");
        moduleType.setValue("Studienrichtung");
        moduleType.isShowing();
        moduleType.setMinWidth(280);
        moduleType.setOnAction(new moduletypeEventHandler());

        labelModules = new Label("Modul");
        labelModules.setFont(new Font(16));
        labelModules.setVisible(false);

        createModuleChoiceBoxes();

        Button save = new Button("Speichern");
        save.setMinWidth(100);
        save.setOnAction(new deleteModulesEventHandler());

        Button cancel = new Button("Abbrechen");
        cancel.setMinWidth(100);
        cancel.setOnAction(new cancelEventHandler());

        HBox buttons = new HBox();
        buttons.getChildren().addAll(save, cancel);
        buttons.setAlignment(Pos.BASELINE_CENTER);
        buttons.setSpacing(50);
        HBox.setMargin(save, new Insets(20, 0, 0, 0));

        // page.add(Node, colIndex, rowIndex, colSpan, rowSpan):
        add(title, 0, 0, 1, 1);
        add(labelModuleType, 0, 1, 1, 1);
        add(moduleType, 0, 2, 1, 1);
        add(labelModules, 0, 3, 1, 1);
        add(modulesWahlpflichtfach, 0, 4, 1, 1);
        add(modulesWahlfach, 0, 4, 1, 1);
        add(buttons, 0,5,1,1);

        setVgap(10);
    }

    /**
     * Die Methode createModuleChoiceBoxes erstellt die Modulauswahlboxen für die
     * jeweiligen Modultypen. Standardmäßig ist die Auswahlbox für den Modultyp
     * Studienrichtung sichtbar. Die anderen Auswahlboxen werden durch den moduletypeEventHandler
     * eingeblendet, wenn der Nutzer einen anderen Modultyp auswählt.
     */
    private void createModuleChoiceBoxes(){

        modulesWahlpflichtfach = new ComboBox<>();
        if(!studienleistung.getWahlpflichtmodule().isEmpty()){
            for(Wahlpflichtmodul wahlpflichtmodul: studienleistung.getWahlpflichtmodule()) {
                modulesWahlpflichtfach.getItems().add(wahlpflichtmodul.getModulname());
            }
        }
        modulesWahlpflichtfach.setVisible(false);
        modulesWahlpflichtfach.setMinWidth(280);
        modulesWahlpflichtfach.setValue("Kein Modul ausgewählt");
        modulesWahlpflichtfach.isShowing();


        modulesWahlfach = new ComboBox<>();
        if(!studienleistung.getWahlmodule().isEmpty()){
            for(Wahlmodul wahlmodul: studienleistung.getWahlmodule()) {
                modulesWahlfach.getItems().add(wahlmodul.getModulname());
            }
        }
        modulesWahlfach.setVisible(false);
        modulesWahlfach.setMinWidth(280);
        modulesWahlpflichtfach.setValue("Kein Modul ausgewählt");
        modulesWahlpflichtfach.isShowing();

        setPadding(new Insets(30, 0, 30, 60 ));
        setVgap(20);
    }

    /**
     * Die Klasse moduletypeEventHandler wechselt die Auswahlbox für die Module
     * anhand des gewählten Modultyps der Auswahlbox für den Modultypen.
     */
    class moduletypeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                switch (moduleType.getValue()) {
                    case "Wahlpflichtmodul" -> {
                        modulesWahlpflichtfach.setVisible(true);
                        modulesWahlfach.setVisible(false);
                        labelModules.setVisible(true);
                    }
                    case "Wahlmodul" -> {
                        modulesWahlpflichtfach.setVisible(false);
                        modulesWahlfach.setVisible(true);
                        labelModules.setVisible(true);
                    }
                    default -> {
                        modulesWahlpflichtfach.setVisible(false);
                        modulesWahlfach.setVisible(false);
                        labelModules.setVisible(false);
                        break;
                    }
                }
            }
            catch(Exception e) {
                alert =
                        new Alert(Alert.AlertType.ERROR,
                                "Klasse " + AddModuleGridPane.class.getSimpleName() +
                                        ": " + this.getClass().getSimpleName() + " konnte nicht ausgeführt werden.", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }

    /**
     * Die Klasse saveModulesEventHandler bestimmt das Verhalten des Speichern-Buttons.
     * Mit dem Klick auf den Button werden die Module anhand der gewählten Angaben erzeugt
     * und in der Modulübersicht der Modulliste hinzugefügt. Das Fenster zum Hinzufügen
     * von Modulen wird geschlossen.
     */
    class deleteModulesEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                switch (moduleType.getValue()){
                    case "Studienrichtung":
                        studienleistung.deleteAllByStudienrichtung();
                        alert = new Alert(Alert.AlertType.INFORMATION, "Alle Module der Studienrichtung wurden gelöscht");
                        alert.setResizable(true);
                        alert.showAndWait();
                        break;

                    case "Wahlpflichtblock":
                        studienleistung.deleteAllByWahlpflichtblock();
                        alert = new Alert(Alert.AlertType.INFORMATION, "Alle Module des Wahlpflichtblocks wurden gelöscht");
                        alert.setResizable(true);
                        alert.showAndWait();
                        break;
                    case "Wahlpflichtmodul":
                        studienleistung.deleteWahlpflichtmodul(modulesWahlpflichtfach.getValue());
                        alert = new Alert(Alert.AlertType.INFORMATION, "Das Wahlpflichtfach " + modulesWahlpflichtfach.getValue() + " wurde gelöscht");
                        alert.setResizable(true);
                        alert.showAndWait();
                        break;
                    case "Wahlmodul":
                        studienleistung.deleteWahlmodul(modulesWahlfach.getValue());
                        alert = new Alert(Alert.AlertType.INFORMATION, "Das Wahlpflichtfach " + modulesWahlfach.getValue() + " wurde gelöscht");
                        alert.setResizable(true);
                        alert.showAndWait();
                        break;
                    default:
                        break;
                }
                stage.close();
            }
            catch(Exception e) {
                alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }

    /**
     * Die Klasse cancelEventHandler bestimmt das Verhalten des Abbrechen-Buttons.
     * Klickt der Benutzer auf den Button wird das Fenster zum Hinzufügen von Modulen
     * geschlossen und keine Module hinzugefügt.
     */
    class cancelEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                stage.close();
            }
            catch(Exception e) {
//                alert =
//                        new Alert(Alert.AlertType.ERROR,
//                                "Klasse " + AddModuleGridPane.class.getSimpleName() +
//                                        ": " + this.getClass().getSimpleName() + " konnte nicht ausgeführt werden.", ButtonType.OK);
//                alert.setResizable(true);
//                alert.showAndWait();
            }
        }
    }
}
