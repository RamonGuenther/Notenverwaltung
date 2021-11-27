package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

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
 * Die Klasse AddModuleBorderPane ist die Basis für die Ansicht zum Hinzufügen neuer
 * Module. Es kann zwischen verschiedenen Modularten gewählt werden. Je nach Modulart
 * werden gleichzeitig mehrere Module zur Ansicht hinzugefügt oder es kann ein einzelnes
 * Modul gewählt werden.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 27. November 2021
 */
public class AddModuleGridPane extends GridPane {

    private final Stage stage;

    private final ComboBox<String> moduleType;
    private ComboBox<String> modulesStudienrichtung;
    private ComboBox<String> modulesWahlpflichtblock;
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
    public AddModuleGridPane(Stage stage) {

        this.stage = stage;

        Label title = new Label("Module hinzufügen");
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

        labelModules = new Label("Richtung");
        labelModules.setFont(new Font(16));

        createModuleChoiceBoxes();

        Button save = new Button("Speichern");
        save.setMinWidth(100);
        save.setOnAction(new saveModulesEventHandler());

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
        add(modulesStudienrichtung, 0, 4, 1, 1);
        add(modulesWahlpflichtblock, 0, 4, 1, 1);
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
        modulesStudienrichtung = new ComboBox<>();
        modulesStudienrichtung.getItems().addAll("Anwendungsentwicklung", "Systemintegration", "Umweltinformatik", "Künstliche Intelligenz");
        modulesStudienrichtung.setVisible(true);
        modulesStudienrichtung.setMinWidth(280);
        modulesStudienrichtung.setValue("Anwendungsentwicklung");
        modulesStudienrichtung.isShowing();

        modulesWahlpflichtblock = new ComboBox<>();
        modulesWahlpflichtblock.getItems().addAll("Anwendungsentwicklung", "Systemintegration", "Umweltinformatik", "Künstliche Intelligenz", "Mediendesign", "Wirtschaft");
        modulesWahlpflichtblock.setVisible(false);
        modulesWahlpflichtblock.setMinWidth(280);
        modulesWahlpflichtblock.setValue("Anwendungsentwicklung");
        modulesWahlpflichtblock.isShowing();

        modulesWahlpflichtfach = new ComboBox<>();
        modulesWahlpflichtfach.getItems().addAll("Praktische Anwendung von Algorithmen",
                "Geoinformatik",
                "Grundlagen der Bildverarbeitung",
                "Multimediaprogrammierung",
                "Operations Research",
                "Rechnernetze 2",
                "Betriebswirtschaftslehre",
                "Controlling",
                "Marketing",
                "Rechnungswesen 1",
                "Rechnungswesen 2",
                "Datenbanken 2",
                "Gender und Diversity in der Informatik",
                "Technik und Ethik",
                "Datenschutz",
                "IT-Recht",
                "Machine Learning",
                "Natural Language Processing",
                "Frontend Frameworks für Webanwendungen",
                "Fortgeschrittene Internettechnologien",
                "Java Programmierung",
                "Skriptsprachen",
                "Einführung in die theoretische Informatik",
                "Betriebssysteme 2",
                "Betriebssysteme 3",
                "Virtualisierung",
                "Partizipatives Design");
        modulesWahlpflichtfach.setVisible(false);
        modulesWahlpflichtfach.setMinWidth(280);
        modulesWahlpflichtfach.setValue("Praktische Anwendung von Algorithmen");
        modulesWahlpflichtfach.isShowing();

        modulesWahlfach = new ComboBox<>();
        modulesWahlfach.getItems().addAll("Englisch");
        modulesWahlfach.setVisible(false);
        modulesWahlfach.setMinWidth(280);
        modulesWahlfach.setValue("Englisch");
        modulesWahlfach.isShowing();

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
                    case "Studienrichtung" -> {
                        modulesWahlpflichtblock.setVisible(false);
                        modulesStudienrichtung.setVisible(true);
                        modulesWahlpflichtfach.setVisible(false);
                        modulesWahlfach.setVisible(false);
                        labelModules.setText("Richtung");
                    }
                    case "Wahlpflichtblock" -> {
                        modulesWahlpflichtblock.setVisible(true);
                        modulesStudienrichtung.setVisible(false);
                        modulesWahlpflichtfach.setVisible(false);
                        modulesWahlfach.setVisible(false);
                        labelModules.setText("Richtung");
                    }
                    case "Wahlpflichtmodul" -> {
                        modulesWahlpflichtblock.setVisible(false);
                        modulesStudienrichtung.setVisible(false);
                        modulesWahlpflichtfach.setVisible(true);
                        modulesWahlfach.setVisible(false);
                        labelModules.setText("Modul");
                    }
                    case "Wahlmodul" -> {
                        modulesWahlpflichtblock.setVisible(false);
                        modulesStudienrichtung.setVisible(false);
                        modulesWahlpflichtfach.setVisible(false);
                        modulesWahlfach.setVisible(true);
                        labelModules.setText("Modul");
                    }
                    default -> {
                    }
                }
            }
            catch(Exception e) {
                Alert alert =
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
    class saveModulesEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                switch (moduleType.getValue()){
                    case "Studienrichtung":
                        // Speichern
                        break;

                    case "Wahlpflichtblock":
                        // Speichern
                        break;
                    case "Wahlpflichtmodul":
                        // ...
                        break;
                    case "Wahlmodul":
                        // ...
                        break;
                    default:
                        break;
                }
                stage.close();
            }
            catch(Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR,
                                "Klasse " + AddModuleGridPane.class.getSimpleName() +
                                        ": " + this.getClass().getSimpleName() + " konnte nicht ausgeführt werden.", ButtonType.OK);
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
                Alert alert =
                        new Alert(Alert.AlertType.ERROR,
                                "Klasse " + AddModuleGridPane.class.getSimpleName() +
                                        ": " + this.getClass().getSimpleName() + " konnte nicht ausgeführt werden.", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }
}
