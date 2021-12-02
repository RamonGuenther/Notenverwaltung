package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.WahlmodulEnum;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtfach;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradesTableView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import java.util.regex.Pattern;

/**
 * Die Klasse AddModuleBorderPane ist die Basis für die Ansicht zum Hinzufügen neuer
 * Module. Es kann zwischen verschiedenen Modularten gewählt werden. Je nach Modulart
 * werden gleichzeitig mehrere Module zur Ansicht hinzugefügt oder es kann ein einzelnes
 * Modul gewählt werden.
 *
 * @author Ivonne Kneißig
 * @version 1.1 vom 1. Dezember 2021
 */
public class AddModuleGridPane extends GridPane {

    private final Stage stage;
    private Studienleistung studienleistung;
    private GradesTableView table;

    private final ComboBox<String> moduleType;
    private ComboBox<Studienrichtung> modulesStudienrichtung;
    private ComboBox<Wahlpflichtblock> modulesWahlpflichtblock;
    private ComboBox<Wahlpflichtfach> modulesWahlpflichtfach;
    private ComboBox<WahlmodulEnum> modulesWahlfach;
    private TextField semester;

    private final Label labelModules;
    private final Label labelSemester;

    /**
     * Im Konstruktor von AddModuleStackPane werden die einzelnen Elemente der Ansicht
     * erzeugt bzw. initialisiert und der GridPane entsprechend hinzugefügt.
     *
     * @param stage     Stage-Object des Fensters. Wird im cancelEventHandler zum
     *                  Schließen des Fensters benötigt.
     * @param studienleistung
     */
    public AddModuleGridPane(Stage stage, Studienleistung studienleistung, GradesTableView table) {

        this.stage = stage;
        this.studienleistung = studienleistung;
        this.table = table;

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

        labelSemester = new Label();

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
        add(labelSemester, 0,5,1,1);
        add(semester, 0,6,1,1);
        add(buttons, 0,7,1,1);

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
        modulesStudienrichtung.getItems().addAll(Studienrichtung.values());
        modulesStudienrichtung.setVisible(true);
        modulesStudienrichtung.setMinWidth(280);
        modulesStudienrichtung.setValue(Studienrichtung.ANWENDUNGSENTWICKLUNG);
        modulesStudienrichtung.isShowing();

        modulesWahlpflichtblock = new ComboBox<>();
        modulesWahlpflichtblock.getItems().addAll(Wahlpflichtblock.values());
        modulesWahlpflichtblock.setVisible(false);
        modulesWahlpflichtblock.setMinWidth(280);
        modulesWahlpflichtblock.setValue(Wahlpflichtblock.ANWENDUNGSENTWICKLUNG);
        modulesWahlpflichtblock.isShowing();

        modulesWahlpflichtfach = new ComboBox<>();
        modulesWahlpflichtfach.getItems().addAll(Wahlpflichtfach.values());
        modulesWahlpflichtfach.setVisible(false);
        modulesWahlpflichtfach.setMinWidth(280);
        modulesWahlpflichtfach.setValue(Wahlpflichtfach.PRAKTISCHE_ANWENDUNG_VON_ALGORITHMEN);
        modulesWahlpflichtfach.isShowing();

        modulesWahlfach = new ComboBox<>();
        modulesWahlfach.getItems().addAll(WahlmodulEnum.values());
        modulesWahlfach.setVisible(false);
        modulesWahlfach.setMinWidth(280);
        modulesWahlfach.setValue(WahlmodulEnum.ENGLISH1);
        modulesWahlfach.isShowing();

        labelSemester.setText("Semester");
        labelSemester.setFont(new Font(16));
        labelSemester.setVisible(false);

        TextFormatter<Integer> formatter = new TextFormatter<>(
                new IntegerStringConverter(),
                0,
                c -> Pattern.matches("\\d*", c.getText()) ? c : null );
        semester = new TextField();
        semester.setTextFormatter(formatter);
        semester.setVisible(false);

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
                        labelSemester.setVisible(false);
                        semester.setVisible(false);
                        labelModules.setText("Richtung");
                    }
                    case "Wahlpflichtblock" -> {
                        modulesWahlpflichtblock.setVisible(true);
                        modulesStudienrichtung.setVisible(false);
                        modulesWahlpflichtfach.setVisible(false);
                        modulesWahlfach.setVisible(false);
                        labelSemester.setVisible(false);
                        semester.setVisible(false);
                        labelModules.setText("Richtung");
                    }
                    case "Wahlpflichtmodul" -> {
                        modulesWahlpflichtblock.setVisible(false);
                        modulesStudienrichtung.setVisible(false);
                        modulesWahlpflichtfach.setVisible(true);
                        modulesWahlfach.setVisible(false);
                        labelSemester.setVisible(true);
                        semester.setVisible(true);
                        labelModules.setText("Modul");
                    }
                    case "Wahlmodul" -> {
                        modulesWahlpflichtblock.setVisible(false);
                        modulesStudienrichtung.setVisible(false);
                        modulesWahlpflichtfach.setVisible(false);
                        modulesWahlfach.setVisible(true);
                        labelSemester.setVisible(true);
                        semester.setVisible(true);
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
                switch (moduleType.getValue()) {
                    case "Studienrichtung" -> studienleistung.pflichtmoduleStudienrichtungFestlegen(modulesStudienrichtung.getValue());
                    case "Wahlpflichtblock" -> studienleistung.pflichtmoduleWahlpflichtblockFestlegen(modulesWahlpflichtblock.getValue());
                    case "Wahlpflichtmodul" -> studienleistung.wahlpflichtmodulHinzufuegen(modulesWahlpflichtfach.getValue(), Integer.parseInt(semester.getText()));
                    case "Wahlmodul" -> studienleistung.wahlmodulHinzufuegen(modulesWahlfach.getValue(), Integer.parseInt(semester.getText()));
                    default -> {
                    }
                }
                table.getItems().clear();
                switch (table.getRadioValue()){
                    case "Alle Module":

                        table.getItems().addAll(studienleistung.getAllePflichtmoduleUndWahlpflichtmodule());
                        break;
                    case "Offen":
                        table.getItems().addAll(studienleistung.getOffenePflichtmoduleUndWahlpflichtmodule());
                        break;
                    case "Bestanden":
                        table.getItems().addAll(studienleistung.getBestandenePflichtmoduleUndWahlpflichtmodule());
                        break;
                    case "Wahlmodule":
                        table.getItems().addAll(studienleistung.getWahlmodule());
                        break;
                }

                stage.close();
            }
            catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
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
