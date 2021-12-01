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
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 * Die Klasse GradeDetailsGridPane erstellt die Detailansicht
 * eines Moduls in der Modulübersicht des Studenten.
 *
 * @author Ivonne Kneißig
 * @version 1.3 vom 1. Dezember 2021
 */
public class GradeDetailsGridPane extends GridPane {

    private Studienleistung studienleistung;

    private Label grade;
    private Label creditpoints;

    private Label moduleValue;
    private Label moduleTypeValue;
    private Label semesterValue;
    private ComboBoxGrade gradeOneValue;
    private ComboBoxGrade gradeTwoValue;
    private ComboBoxGrade gradeThreeValue;

    private Button save;
    private Button cancel;

    private String moduleType;
    private String moduleName;

    /**
     * Der Konstruktor erstellt bzw. initialisiert die einzelnen
     * Elemente der Detailansicht.
     */
    public GradeDetailsGridPane(Studienleistung studienleistung) {

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

    public Label getGrade() {
        return grade;
    }

    public void setGrade(Label grade) {
        this.grade = grade;
    }

    public Label getCreditpoints() {
        return creditpoints;
    }

    public void setCreditpoints(Label creditpoints) {
        this.creditpoints = creditpoints;
    }

    public Label getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(Label moduleValue) {
        this.moduleValue = moduleValue;
    }

    public Label getModuleTypeValue() {
        return moduleTypeValue;
    }

    public void setModuleTypeValue(Label moduleTypeValue) {
        this.moduleTypeValue = moduleTypeValue;
    }

    public Label getSemesterValue() {
        return semesterValue;
    }

    public void setSemesterValue(Label semesterValue) {
        this.semesterValue = semesterValue;
    }

    public ComboBoxGrade getGradeOneValue() {
        return gradeOneValue;
    }

    public void setGradeOneValue(ComboBoxGrade gradeOneValue) {
        this.gradeOneValue = gradeOneValue;
    }

    public ComboBoxGrade getGradeTwoValue() {
        return gradeTwoValue;
    }

    public void setGradeTwoValue(ComboBoxGrade gradeTwoValue) {
        this.gradeTwoValue = gradeTwoValue;
    }

    public ComboBoxGrade getGradeThreeValue() {
        return gradeThreeValue;
    }

    public void setGradeThreeValue(ComboBoxGrade gradeThreeValue) {
        this.gradeThreeValue = gradeThreeValue;
    }

    public Button getSave() {
        return save;
    }

    public void setSave(Button save) {
        this.save = save;
    }

    public Button getCancel() {
        return cancel;
    }

    public void setCancel(Button cancel) {
        this.cancel = cancel;
    }


    /**
     * Die Klasse UpdateGradeDetailsEventHandler bestimmt das Verhalten des
     * Speichern-Buttons der Detailansicht. Wird der Button geklickt, werden
     * die Textfelder deaktiviert, die Daten gespeichert und die Buttons zum
     * Speichern und Abbrechen wieder ausgeblendet.
     */
    class UpdateGradeDetailsEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            gradeOneValue.setDisable(true);
            gradeTwoValue.setDisable(true);
            gradeThreeValue.setDisable(true);

            save.setDisable(true);
            save.setVisible(false);
            cancel.setDisable(true);
            cancel.setVisible(false);


            try {
                switch (moduleType) {
                    case "Pflichtmodul":
                        studienleistung.updateNotePflichtmodul(moduleName, gradeOneValue.getValue());
                        studienleistung.updateNotePflichtmodul(moduleName, gradeTwoValue.getValue());
                        studienleistung.updateNotePflichtmodul(moduleName, gradeThreeValue.getValue());
                        break;
                    case "Wahlpflichtmodul":
                        studienleistung.updateNoteWahlpflichtmodul(moduleName, gradeOneValue.getValue());
                        studienleistung.updateNoteWahlpflichtmodul(moduleName, gradeTwoValue.getValue());
                        studienleistung.updateNoteWahlpflichtmodul(moduleName, gradeThreeValue.getValue());
                        break;
                    case "Wahlmodul":
                        studienleistung.updateNoteWahlmodul(moduleName, gradeOneValue.getValue());
                        studienleistung.updateNoteWahlmodul(moduleName, gradeTwoValue.getValue());
                        studienleistung.updateNoteWahlmodul(moduleName, gradeThreeValue.getValue());
                        break;
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
                alert.setResizable(true);
                alert.showAndWait();
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

    public void setDetails(Object module, String radioValue) {

        if (radioValue.equals("Wahlmodule")) {
            Wahlmodul wahlmodul = (Wahlmodul) module;
            setItems(wahlmodul.getModulname(), wahlmodul.getModulart(), String.valueOf(wahlmodul.getSemester()),
                    wahlmodul.getNote(), wahlmodul.getEndNote());
            creditpoints.setText("");
            moduleName = wahlmodul.getModulname();
            moduleType = "Wahlmodul";
        } else {
            try {
                Wahlpflichtmodul wahlpflichtmodul = (Wahlpflichtmodul) module;
                setItems(wahlpflichtmodul.getModulname(), wahlpflichtmodul.getModulart(),
                        String.valueOf(wahlpflichtmodul.getSemester()), wahlpflichtmodul.getNote(), wahlpflichtmodul.getEndNote());
                creditpoints.setText(wahlpflichtmodul.isBestanden() == false ? "Creditpoints: " : "Creditpoints: " + wahlpflichtmodul.getCreditpoints());
                moduleName = wahlpflichtmodul.getModulname();
                moduleType = "Wahlpflichtmodul";


            } catch (Exception e) {
                Pflichtmodul pflichtmodul = (Pflichtmodul) module;
                setItems(pflichtmodul.getModulname(), pflichtmodul.getModulart(),
                        String.valueOf(pflichtmodul.getSemester()), pflichtmodul.getNote(), pflichtmodul.getEndNote());
                creditpoints.setText(pflichtmodul.isBestanden() == false ? "Creditpoints: " : "Creditpoints: " + pflichtmodul.getCreditpoints());
                moduleName = pflichtmodul.getModulname();
                moduleType = "Pflichtmodul";

            }
        }
    }

    private void setItems(String modulname, String modulart, String s, Noten note, String endNote) {
        moduleValue.setText(modulname);
        moduleTypeValue.setText(modulart);
        semesterValue.setText(s);
        gradeOneValue.setValue(note.getNote1() == 0.0 ? null : note.getNote1());
        gradeTwoValue.setValue(note.getNote2() == 0.0 ? null : note.getNote2());
        gradeThreeValue.setValue(note.getNote3() == 0.0 ? null : note.getNote3());
        grade.setText(endNote == " " ? "Endnote: " : "Endnote: " + endNote);
    }
}
