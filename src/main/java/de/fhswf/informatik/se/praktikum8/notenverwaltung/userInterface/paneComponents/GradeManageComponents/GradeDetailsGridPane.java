package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Noten;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.ComboBoxGrade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * Die Klasse GradeDetailsGridPane erstellt die Detailansicht
 * eines Moduls in der Modulübersicht des Studenten.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.4 vom 2. Dezember 2021
 */
public class GradeDetailsGridPane extends GridPane {

    private Button updateButton;
    private final GradeManagementSplitPane splitPane;
    private GradesTableView table;

    private final Studienleistung studienleistung;

    private final Label grade;
    private final Label creditpoints;

    private final Label moduleValue;
    private final Label moduleTypeValue;
    private final Label semesterValue;
    private final ComboBoxGrade gradeOneValue;
    private final ComboBoxGrade gradeTwoValue;
    private final ComboBoxGrade gradeThreeValue;

    private final Button save;
    private final Button cancel;

    private String moduleType;
    private String moduleName;

    /**
     * Der Konstruktor erstellt bzw. initialisiert die einzelnen
     * Elemente der Detailansicht.
     *
     * @param studienleistung       Studienleistungsobjekt der Anwendung, das
     *                              alle Module und den Abschluss enthält.
     * @param splitPane             SplitPane der Anwendung. Wird benötigt um
     *                              Daten und Attribute aus anderen Panes und
     *                              Components zu bekommen oder zu bearbeiten.
     */
    public GradeDetailsGridPane(Studienleistung studienleistung, GradeManagementSplitPane splitPane) {

        this.splitPane = splitPane;
        this.studienleistung = studienleistung;

        Label details = new Label("Details");
        details.setFont(new Font(30));
        details.setStyle("-fx-font-weight: bold");

        Label module = new Label("Modul:");
        module.setFont(new Font(16));
        Label moduleType = new Label("Modulart:");
        moduleType.setFont(new Font(16));
        Label semester = new Label("Semester:");
        semester.setFont(new Font(16));
        Label gradeOne = new Label("Note 1. Versuch:");
        gradeOne.setFont(new Font(16));
        Label gradeTwo = new Label("Note 2. Versuch:");
        gradeTwo.setFont(new Font(16));
        Label gradeThree = new Label("Note 3. Versuch:");
        gradeThree.setFont(new Font(16));

        grade = new Label("Endnote: ");
        grade.setFont(new Font(16));
        grade.setStyle("-fx-font-weight: bold");
        creditpoints = new Label("Creditpoints:");
        creditpoints.setFont(new Font(16));
        creditpoints.setStyle("-fx-font-weight: bold");

        moduleValue = new Label();
        moduleValue.setFont(new Font(16));
        moduleValue.setMinWidth(250);

        moduleTypeValue = new Label();
        moduleTypeValue.setFont(new Font(16));
        moduleValue.setMinWidth(250);

        semesterValue = new Label();
        semesterValue.setFont(new Font(16));
        semesterValue.setMinWidth(250);

        gradeOneValue = new ComboBoxGrade();
        gradeOneValue.setDisable(true);
        gradeOneValue.setMinWidth(250);
        gradeOneValue.setValue(null);

        gradeTwoValue = new ComboBoxGrade();
        gradeTwoValue.setDisable(true);
        gradeTwoValue.setMinWidth(250);

        gradeThreeValue = new ComboBoxGrade();
        gradeThreeValue.setDisable(true);
        gradeThreeValue.setMinWidth(250);

        HBox moduleResultBox = new HBox();
        moduleResultBox.getChildren().addAll(grade, creditpoints);
        HBox.setMargin(grade, new Insets(20, 0, 0, -126));
        HBox.setMargin(creditpoints, new Insets(20, 0, 0, 80));

        save = new Button("Speichern");
        save.setMinWidth(100);
        save.setDisable(true);
        save.setVisible(false);
        save.setOnAction(new UpdateGradeDetailsEventHandler());

        cancel = new Button("Abbrechen");
        cancel.setMinWidth(100);
        cancel.setDisable(true);
        cancel.setVisible(false);
        cancel.setOnAction(new CancelUpdateGradeDetailsEventHandler());

        HBox moduleUpdateDetailsBox = new HBox();
        moduleUpdateDetailsBox.getChildren().addAll(save, cancel);
        HBox.setMargin(save, new Insets(0, 0, 0, -50));
        HBox.setMargin(cancel, new Insets(0, 0, 0, 40));

        // page.add(Node, colIndex, rowIndex, colSpan, rowSpan):
        addRow(0, details);
        add(module, 0, 1, 1, 1);
        add(moduleValue, 1, 1, 1, 1);
        add(moduleType, 0, 2, 1, 1);
        add(moduleTypeValue, 1, 2, 1, 1);
        add(semester, 0, 3, 1, 1);
        add(semesterValue, 1, 3, 1, 1);
        add(gradeOne, 0, 4, 1, 1);
        add(gradeOneValue, 1, 4, 1, 1);
        add(gradeTwo, 0, 5, 1, 1);
        add(gradeTwoValue, 1, 5, 1, 1);
        add(gradeThree, 0, 6, 1, 1);
        add(gradeThreeValue, 1, 6, 1, 1);
        add(moduleResultBox, 1, 7, 2, 1);
        add(moduleUpdateDetailsBox, 1, 8, 2, 1);

        setVgap(20);
        setHgap(10);
        setPadding(new Insets(20, 0, 0, 20));
    }

    /*------------------------------------------------------------------------------------
                                        GETTER UND SETTER
     -------------------------------------------------------------------------------------*/

    public ComboBoxGrade getGradeOneValue() {
        return gradeOneValue;
    }

    public ComboBoxGrade getGradeTwoValue() {
        return gradeTwoValue;
    }

    public ComboBoxGrade getGradeThreeValue() {
        return gradeThreeValue;
    }

    public Button getSave() {
        return save;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setTable(GradesTableView table) {
        this.table = table;
    }

    /*------------------------------------------------------------------------------------
                                        EVENT HANDLER
     ---------------------------------------------------------------------------------------*/

    /**
     * Die Klasse UpdateGradeDetailsEventHandler bestimmt das Verhalten des
     * Speichern-Buttons der Detailansicht. Wird der Button geklickt, werden
     * die Textfelder deaktiviert, die Daten gespeichert und die Buttons zum
     * Speichern und Abbrechen wieder ausgeblendet. Die Tabelle mit den
     * Modulen wird aktualisiert.
     */
    class UpdateGradeDetailsEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            save.setDisable(true);
            save.setVisible(false);
            cancel.setDisable(true);
            cancel.setVisible(false);

            try {
                if (moduleType == null || moduleType.equals("")){
                    throw new IllegalArgumentException("Es wurde kein Modul ausgewählt");
                }
                switch (moduleType) {
                    case "Pflichtmodul" -> {
                        studienleistung.updateNotePflichtmodul(moduleName, gradeOneValue.isDisable() ? null : gradeOneValue.getValue());
                        studienleistung.updateNotePflichtmodul(moduleName, gradeTwoValue.isDisable() ? null : gradeTwoValue.getValue());
                        studienleistung.updateNotePflichtmodul(moduleName, gradeThreeValue.isDisable() ? null : gradeThreeValue.getValue());
                        if (studienleistung.getPflichtmodulByModulname(moduleName).isBestanden()) {
                            updateButton.setDisable(true);
                            setDetails(studienleistung.getPflichtmodulByModulname(moduleName), table.getRadioValue());
                        }
                    }
                    case "Wahlpflichtmodul" -> {
                        studienleistung.updateNoteWahlpflichtmodul(moduleName, gradeOneValue.isDisable() ? null : gradeOneValue.getValue());
                        studienleistung.updateNoteWahlpflichtmodul(moduleName, gradeTwoValue.isDisable() ? null : gradeTwoValue.getValue());
                        studienleistung.updateNoteWahlpflichtmodul(moduleName, gradeThreeValue.isDisable() ? null : gradeThreeValue.getValue());
                        if (studienleistung.getWahlpflichtmodulByModulname(moduleName).isBestanden()) {
                            updateButton.setDisable(true);
                            setDetails(studienleistung.getWahlpflichtmodulByModulname(moduleName), table.getRadioValue());
                        }
                    }
                    case "Wahlmodul" -> {
                        studienleistung.updateNoteWahlmodul(moduleName, gradeOneValue.isDisable() ? null : gradeOneValue.getValue());
                        studienleistung.updateNoteWahlmodul(moduleName, gradeTwoValue.isDisable() ? null : gradeTwoValue.getValue());
                        studienleistung.updateNoteWahlmodul(moduleName, gradeThreeValue.isDisable() ? null : gradeThreeValue.getValue());
                        if (studienleistung.getWahlmodulByModulname(moduleName).isBestanden()) {
                            updateButton.setDisable(true);
                            setDetails(studienleistung.getWahlmodulByModulname(moduleName), table.getRadioValue());
                        }
                    }
                    default -> {
                    }
                }
                gradeOneValue.setDisable(true);
                gradeTwoValue.setDisable(true);
                gradeThreeValue.setDisable(true);

                table.getItems().clear();
                switch (table.getRadioValue()) {
                    case "Alle Module" -> table.getItems().addAll(studienleistung.getAllePflichtmoduleUndWahlpflichtmodule());
                    case "Offen" -> table.getItems().addAll(studienleistung.getOffenePflichtmoduleUndWahlpflichtmodule());
                    case "Bestanden" -> table.getItems().addAll(studienleistung.getBestandenePflichtmoduleUndWahlpflichtmodule());
                    case "Wahlmodule" -> table.getItems().addAll(studienleistung.getWahlmodule());
                }
                splitPane.getGradesTableBorderPane().getAverageGrade().setText("Notendurchschnitt " + studienleistung.getNotendurchschnittModule());
                splitPane.getGradesTableBorderPane().getSumCreditpoints().setText("Creditpoints " + studienleistung.getSummeCreditpointsOhneAbschluss());

            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    /**
     * Die Klasse CancelUpdateGradeDetailsEventHandler bestimmt das Verhalten des
     * Abbrechen-Buttons der Detailansicht. Wird der Button geklickt, werden
     * die Textfelder deaktiviert und eventuell getätigte Eingaben nicht übernommen.
     * Die Buttons zum Speichern und Abbrechen wieder ausgeblendet.
     */
    class CancelUpdateGradeDetailsEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            gradeOneValue.setDisable(true);
            gradeTwoValue.setDisable(true);
            gradeThreeValue.setDisable(true);

            save.setDisable(true);
            save.setVisible(false);
            cancel.setDisable(true);
            cancel.setVisible(false);

        }
    }

    /*------------------------------------------------------------------------------------
                                        METHODEN
     ---------------------------------------------------------------------------------------*/

    /**
     * Die Methode setDetails holt die Daten des entsprechenden Moduls, das in der Tabelle vom
     * Studenten angeklickt wurde.
     *
     * @param module        Modul, das in der Tabelle ausgewählt wurde
     * @param radioValue    RadioButton der zum Filtern der Tabelle ausgewählt wurde
     */
    public void setDetails(Object module, String radioValue) {

        updateButton = splitPane.getUpdateButton();
        updateButton.setDisable(false);

        if (radioValue.equals("Wahlmodule")) {
            Wahlmodul wahlmodul = (Wahlmodul) module;
            setItems(wahlmodul.getModulname(), wahlmodul.getModulart(), String.valueOf(wahlmodul.getSemester()),
                    wahlmodul.getNote(), wahlmodul.getEndNote());
            creditpoints.setText("");
            moduleName = wahlmodul.getModulname();
            moduleType = "Wahlmodul";

            if(wahlmodul.isBestanden() || wahlmodul.getNote().getNote3() == 5.0){
                updateButton.setDisable(true);
            }
        } else {
            try {
                Wahlpflichtmodul wahlpflichtmodul = (Wahlpflichtmodul) module;
                setItems(wahlpflichtmodul.getModulname(), wahlpflichtmodul.getModulart(),
                        String.valueOf(wahlpflichtmodul.getSemester()), wahlpflichtmodul.getNote(), wahlpflichtmodul.getEndNote());
                creditpoints.setText(!wahlpflichtmodul.isBestanden() ? "Creditpoints: " : "Creditpoints: " + wahlpflichtmodul.getCreditpoints());
                moduleName = wahlpflichtmodul.getModulname();
                moduleType = "Wahlpflichtmodul";

                if(wahlpflichtmodul.isBestanden() || wahlpflichtmodul.getNote().getNote3() == 5.0){
                    updateButton.setDisable(true);
                }
            } catch (Exception e) {
                Pflichtmodul pflichtmodul = (Pflichtmodul) module;
                setItems(pflichtmodul.getModulname(), pflichtmodul.getModulart(),
                        String.valueOf(pflichtmodul.getSemester()), pflichtmodul.getNote(), pflichtmodul.getEndNote());
                creditpoints.setText(!pflichtmodul.isBestanden() ? "Creditpoints: " : "Creditpoints: " + pflichtmodul.getCreditpoints());
                moduleName = pflichtmodul.getModulname();
                moduleType = "Pflichtmodul";

                if(pflichtmodul.isBestanden() || pflichtmodul.getNote().getNote3() == 5.0){
                    updateButton.setDisable(true);
                }
            }
        }
    }

    /**
     * Die Methode setItems füllt die Felder der Ansicht mit den Daten aus dem Modul,
     * welches in der Tabelle ausgewählt wurde. Die Methode setItems wird in der Methode
     * setDetails aufgerufen.
     *
     * @param modulname         Name des gewählten Moduls
     * @param modulart          Modulart des gewählten Moduls
     * @param semester          Semester, in dem das Modul standardmäßig belegt wird
     * @param note              Noten, die für das gewählte Modul bisher eingetragen wurden
     * @param endNote           Endnote des Moduls, falls es bereits bestanden wurde
     */
    private void setItems(String modulname, String modulart, String semester, Noten note, String endNote) {
        moduleValue.setText(modulname);
        moduleTypeValue.setText(modulart);
        semesterValue.setText(semester);
        gradeOneValue.setValue(note.getNote1() == 0.0 ? null : note.getNote1());
        gradeTwoValue.setValue(note.getNote2() == 0.0 ? null : note.getNote2());
        gradeThreeValue.setValue(note.getNote3() == 0.0 ? null : note.getNote3());
        grade.setText(endNote.equals(" ") ? "Endnote: " : "Endnote: " + endNote);
    }
}
