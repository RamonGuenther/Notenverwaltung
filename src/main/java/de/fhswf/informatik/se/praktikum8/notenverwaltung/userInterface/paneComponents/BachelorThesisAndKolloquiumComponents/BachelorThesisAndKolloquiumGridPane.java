package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.BachelorThesisAndKolloquiumComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.ComboBoxGrade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;

/**
 * Die Klasse BachelorThesisAndKolloquiumGridPane bildet die Ansicht für
 * die Bachelorarbeit und das Kolloquium. Hier werden die Noten eingetragen
 * bzw. angezeigt, die jeweiligen Notendurchschnitte berechnet und die Summe
 * der Creditpoints angezeigt
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.1 vom 2. Dezember 2021
 */
public class BachelorThesisAndKolloquiumGridPane extends GridPane {

    private final Studienleistung studienleistung;

    private final ComboBoxGrade gradeBachelorThesis1;
    private final ComboBoxGrade gradeBachelorThesis2;
    private final Label creditpointsBachelorThesis;

    private final ComboBoxGrade gradeKolloquium1;
    private final ComboBoxGrade gradeKolloquium2;

    private final Label averageGradeModules;
    private final Label averageGradeBachelor;
    private final Label sumCreditpoints;
    private final Label averageGradeAll;

    private final Button updateBachelor;
    private final Button updateKolloquium;
    private final Button saveBachelor;
    private final Button saveKolloquium;
    private final Button cancel;

    /**
     * Im Konstruktor von BachelorThesisAndKolloquiumGridPane werden
     * die einzelnen Elemente der ansicht erzeugt bzw. initialisiert und
     * auf der GridPane entsprechend angeordnet.
     *
     * @param studienleistung   Studienleistungsobjekt der Anwendung, das
     *                          alle Module und den Abschluss enthält.
     */
    public BachelorThesisAndKolloquiumGridPane(Studienleistung studienleistung){

        this.studienleistung = studienleistung;

        if(studienleistung.getSummeCreditpointsOhneAbschluss() < 165){
            setDisable(true);
        }

        Label title = new Label("Abschluss & Kolloquium");
        title.setFont(new Font(30));
        title.setStyle("-fx-font-weight: bold");

        /*------------------------------------------------------------------------------------
                                        SEITE BACHELORARBEIT
        ---------------------------------------------------------------------------------------*/

        Label labelGradeBachelorThesis1 = new Label("Note der Bachelorarbeit (1. Versuch)");
        labelGradeBachelorThesis1.setFont(new Font(16));
        gradeBachelorThesis1 = new ComboBoxGrade();

        gradeBachelorThesis1.setValue(studienleistung
                .getAbschluss()
                .getBachelorarbeit()
                .getNoteBachelorarbeit1()
                != 0.0 ? studienleistung
                .getAbschluss()
                .getBachelorarbeit()
                .getNoteBachelorarbeit1() : null
        );

        gradeBachelorThesis1.setMinWidth(150);
        setValignment(gradeBachelorThesis1, VPos.TOP);
        gradeBachelorThesis1.setDisable(true);

        Label labelGradeBachelorThesis2 = new Label("Note der Bachelorarbeit (2.Versuch)");
        labelGradeBachelorThesis2.setFont(new Font(16));
        gradeBachelorThesis2 = new ComboBoxGrade();

        gradeBachelorThesis2.setValue(studienleistung
                .getAbschluss()
                .getBachelorarbeit()
                .getNoteBachelorarbeit2()
                != 0.0 ? studienleistung
                .getAbschluss()
                .getBachelorarbeit()
                .getNoteBachelorarbeit2() : null
        );

        gradeBachelorThesis2.setMinWidth(150);
        setValignment(gradeBachelorThesis2, VPos.TOP);
        gradeBachelorThesis2.setDisable(true);

        /*------------------------------------------------------------------------------------
                                           SEITE KOLLOQUIUM
        --------------------------------------------------------------------------------------- */

        Label labelGradeKolloquium1 = new Label("Note des Kolloquiums (1.Versuch)");
        labelGradeKolloquium1.setFont(new Font(16));
        gradeKolloquium1 = new ComboBoxGrade();

        gradeKolloquium1.setValue(studienleistung
                .getAbschluss()
                .getKolloquium()
                .getEndNoteKolloquium()
                != 0.0 ? studienleistung
                .getAbschluss().getKolloquium()
                .getEndNoteKolloquium() : null
        );

        gradeKolloquium1.setMinWidth(150);
        setValignment(gradeKolloquium1, VPos.TOP);
        gradeKolloquium1.setDisable(true);

        Label labelGradeKolloquium2 = new Label("Note des Kolloquiums (2. Versuch)");
        labelGradeKolloquium2.setFont(new Font(16));
        gradeKolloquium2 = new ComboBoxGrade();

        gradeKolloquium2.setValue(studienleistung
                .getAbschluss()
                .getKolloquium()
                .getEndNoteKolloquium()
                != 0.0 ? studienleistung
                .getAbschluss().getKolloquium()
                .getEndNoteKolloquium() : null
        );

        gradeKolloquium2.setMinWidth(150);
        setValignment(gradeKolloquium2, VPos.TOP);
        gradeKolloquium2.setDisable(true);

         /*------------------------------------------------------------------------------------
                                    CREDITPOINTS UND DURCHSCHNITTSNOTEN
        --------------------------------------------------------------------------------------- */

        creditpointsBachelorThesis = new Label();
        creditpointsBachelorThesis.setFont(new Font(16));

        Label creditpointsKolloquium = new Label("Creditpoints: ");
        creditpointsKolloquium.setFont(new Font(16));

        if(studienleistung.getAbschluss().getBachelorarbeit().getEndNoteBachelor() != 0.0 && studienleistung.getAbschluss().getKolloquium().getEndNoteKolloquium() != 0.0){
            creditpointsBachelorThesis.setText("Creditpoints: " + studienleistung.getAbschluss().getBachelorarbeit().getCreditpointsBachelorarbeit());
            creditpointsKolloquium.setText("Creditpoints: " + studienleistung.getAbschluss().getKolloquium().getCreditpointsKolloquium());
        }
        else{
            creditpointsBachelorThesis.setText("Creditpoints: ");
            creditpointsKolloquium.setText("Creditpoints: ");
        }

        averageGradeModules = new Label("Notendurchschnitt der Module: " + studienleistung.getNotendurchschnittModule());
        averageGradeModules.setFont(new Font(16));
        setValignment(averageGradeModules, VPos.BOTTOM);

        averageGradeBachelor = new Label("Notendurchschnitt Bachelorarbeit und Kolloquium: " + studienleistung.getNotendurchschnittAbschluss());
        averageGradeBachelor.setFont(new Font(16));

        sumCreditpoints =  new Label("Summe der Creditpoints: " + studienleistung.getSummeCreditPointsMitAbschluss());
        sumCreditpoints.setFont(new Font(16));

        averageGradeAll = new Label("Notendurchschnitt Gesamt:");
        String checkAverageGradeAll = studienleistung.getSummeCreditPointsMitAbschluss() != 180 ? " " : String.valueOf(studienleistung.getNotendurchschnittGesamt());
        averageGradeAll.setText("Notendurchschnitt Gesamt: " + checkAverageGradeAll);
        averageGradeAll.setFont(new Font(16));

        /*------------------------------------------------------------------------------------
                                               BUTTONS
        --------------------------------------------------------------------------------------- */

        updateBachelor = new Button("Bearbeiten");
        updateBachelor.setMinWidth(150);
        setValignment(updateBachelor, VPos.BOTTOM);
        updateBachelor.setOnAction(new updateBachelorEvent());

        if(studienleistung.getAbschluss().getBachelorarbeit().getEndNoteBachelor() != 0.0){
            updateBachelor.setDisable(true);
        }

        updateKolloquium= new Button("Bearbeiten");
        updateKolloquium.setMinWidth(150);
        setValignment(updateKolloquium, VPos.BOTTOM);
        updateKolloquium.setOnAction(new updateKolloquiumEvent());

        //        Von Intellij verkleinert?
        //        if(studienleistung.getAbschluss().getBachelorarbeit().getEndNoteBachelor() != 0.0){
        //            updateKolloquium.setDisable(false);
        //        }
        //        else{
        //            updateKolloquium.setDisable(true);
        //        }
        //        if(studienleistung.getAbschluss().getKolloquium().getEndNoteKolloquium() != 0.0){
        //            updateKolloquium.setDisable(true);
        //        }

        updateKolloquium.setDisable(studienleistung.getAbschluss().getBachelorarbeit().getEndNoteBachelor() == 0.0);
        if(studienleistung.getAbschluss().getKolloquium().getEndNoteKolloquium() != 0.0){
            updateKolloquium.setDisable(true);
        }

        saveBachelor = new Button("Speichern");
        saveBachelor.setMinWidth(150);
        setHalignment(saveBachelor, HPos.CENTER);
        setValignment(saveBachelor, VPos.BOTTOM);
        saveBachelor.setVisible(false);
        saveBachelor.setOnAction(new saveBachelorEvent());

        saveKolloquium = new Button("Speichern");
        saveKolloquium.setMinWidth(150);
        setHalignment(saveKolloquium, HPos.CENTER);
        setValignment(saveKolloquium, VPos.BOTTOM);
        saveKolloquium.setVisible(false);
        saveKolloquium.setOnAction(new saveKolloquiumEvent());

        cancel = new Button("Abbrechen");
        cancel.setMinWidth(150);
        setHalignment(cancel, HPos.CENTER);
        setValignment(cancel, VPos.BOTTOM);
        cancel.setVisible(false);
        cancel.setOnAction(new cancelBachelorThesisAndKolloquiumEvent());

        /*------------------------------------------------------------------------------------
                                        ANORDNUNG DER ELEMENTE
        --------------------------------------------------------------------------------------- */

        // page.add(Node, colIndex, rowIndex, colSpan, rowSpan):
        add(title, 0, 0, 2, 1);

        add(labelGradeBachelorThesis1,0,1,2,1);
        add(gradeBachelorThesis1,0,2,2,1);
        add(labelGradeBachelorThesis2,0,3,2,1);
        add(gradeBachelorThesis2,0,4,2,1);
        add(creditpointsBachelorThesis,0,5,2,1);
        add(updateBachelor,0,6,1,1);

        add(labelGradeKolloquium1,1,1,2,1);
        add(gradeKolloquium1,1,2,2,1);
        add(labelGradeKolloquium2,1,3,2,1);
        add(gradeKolloquium2,1,4,2,1);
        add(creditpointsKolloquium,1,5,2,1);
        add(updateKolloquium,1,6,1,1);

        add(averageGradeModules,0,7,4,1);
        add(averageGradeBachelor,0,8,4,1);
        add(sumCreditpoints,0,9,4,1);
        add(averageGradeAll,0,10,4,1);

        add(saveBachelor,0,11, 1,10);
        add(saveKolloquium,0,11, 1,10);
        add(cancel,1,11, 1,10);

        setPadding(new Insets(30, 0, 30, 50 ));
        setVgap(10);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(40);
        RowConstraints row2 = new RowConstraints();
        row2.setMinHeight(20);
        RowConstraints row3 = new RowConstraints();
        row3.setMinHeight(20);
        RowConstraints row4 = new RowConstraints();
        row4.setMinHeight(20);
        RowConstraints row5 = new RowConstraints();
        row5.setMinHeight(20);
        RowConstraints row6 = new RowConstraints();
        row6.setMinHeight(20);
        RowConstraints row7 = new RowConstraints();
        row7.setMinHeight(40);
        RowConstraints row8 = new RowConstraints();
        row8.setMinHeight(60);

        getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(400);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setMinWidth(400);

        getColumnConstraints().addAll(col1, col2);
    }


    /*------------------------------------------------------------------------------------
                                        EVENT-HANLDER KLASSEN
     --------------------------------------------------------------------------------------- */
    /**
     * Die Klasse updateBachelorEvent kümmert sich um das Verhalten des Bearbeiten-Buttons
     * für die Bachelorarbeit. Es werden entsprechende Felder zur Bearbeitung der
     * Bachelorarbeit freigeschaltet und der Speichern-Button und Abbrechen-Button eingeblendet.
     */
    class updateBachelorEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                if(gradeBachelorThesis1.getValue() == null ){
                    gradeBachelorThesis1.setDisable(false);
                    gradeBachelorThesis2.setDisable(true);
                    saveBachelor.disableProperty().bind(gradeBachelorThesis1.valueProperty().isNull());
                }
                else if(gradeBachelorThesis1.getValue() >= 0.0 && gradeBachelorThesis2.getValue() == null){
                    gradeBachelorThesis2.setDisable(false);
                    saveBachelor.disableProperty().bind(gradeBachelorThesis2.valueProperty().isNull());
                }
                updateBachelor.setVisible(false);
                updateKolloquium.setDisable(true);
                saveBachelor.setVisible(true);

                saveKolloquium.setVisible(false);
                cancel.setVisible(true);

            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    /**
     * Die Klasse updateKolloquiumEvent kümmert sich um das Verhalten des Bearbeiten-Buttons
     * für das Kolloquium. Es werden entsprechende Felder zur Bearbeitung des Kolloquiums
     * freigeschaltet und der Speichern-Button und Abbrechen-Button eingeblendet.
     */
    class updateKolloquiumEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                if(gradeKolloquium1.getValue() == null ){
                    gradeKolloquium1.setDisable(false);
                    gradeKolloquium2.setDisable(true);
                    saveKolloquium.disableProperty().bind(gradeKolloquium1.valueProperty().isNull());
                }
                else if(gradeKolloquium1.getValue() >= 0.0 && gradeKolloquium2.getValue() == null){
                    gradeKolloquium2.setDisable(false);
                    saveKolloquium.disableProperty().bind(gradeKolloquium2.valueProperty().isNull());
                }
                updateKolloquium.setVisible(false);
                updateBachelor.setDisable(true);
                saveKolloquium.setVisible(true);

                saveBachelor.setVisible(false);
                cancel.setVisible(true);
            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    /**
     * Die Klasse saveBachelorEvent kümmert sich um das Verhalten des Speichern-Buttons für die Bachelorarbeit.
     * Er deaktiviert die mögliche Bearbeitung der Notenfelder und speichert die zuvor eingegebenen Werte.
     * Außerdem wird der Bearbeiten-Button wieder eingeblendet, sofern noch weitere Noten für die Bachelorarbeit
     * eingetragen werden können.
     */
    class saveBachelorEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                if(!gradeBachelorThesis1.isDisabled()){
                    studienleistung.updateNoteBachelor(gradeBachelorThesis1.getValue());
                }
                else if(!gradeBachelorThesis2.isDisabled()){
                    studienleistung.updateNoteBachelor(gradeBachelorThesis2.getValue());
                }

                gradeBachelorThesis1.setDisable(true);
                gradeBachelorThesis2.setDisable(true);
                saveBachelor.setVisible(false);
                cancel.setVisible(false);

                if(studienleistung.getAbschluss().getBachelorarbeit().getEndNoteBachelor() != 0.0 ||
                    studienleistung.getAbschluss().getBachelorarbeit().getNoteBachelorarbeit2() > 4.0){
                    if(studienleistung.getAbschluss().getBachelorarbeit().getEndNoteBachelor() != 0.0){
                        updateKolloquium.setVisible(true);
                        updateKolloquium.setDisable(false);
                    }
                    updateBachelor.setVisible(true);
                    updateBachelor.setDisable(true);
                }
                else{
                    updateBachelor.setDisable(false);
                    updateBachelor.setVisible(true);
                }

                averageGradeModules.setText("Notendurchschnitt der Module: " + studienleistung.getNotendurchschnittModule());
                averageGradeBachelor.setText("Notendurchschnitt Bachelorarbeit und Kolloquium: " + studienleistung.getNotendurchschnittAbschluss());
                sumCreditpoints.setText("Summe der Creditpoints: " + studienleistung.getSummeCreditPointsMitAbschluss());
                creditpointsBachelorThesis.setText("Creditpoints: " + studienleistung.getAbschluss().getBachelorarbeit().getCreditpointsBachelorarbeit());
                String checkAverageGradeAll = studienleistung.getSummeCreditPointsMitAbschluss() != 180 ? " " : String.valueOf(studienleistung.getNotendurchschnittGesamt());
                averageGradeAll.setText("Notendurchschnitt Gesamt: " + checkAverageGradeAll);
            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    /**
     * Die Klasse saveKolloquiumEvent kümmert sich um das Verhalten des Speichern-Buttons für das Kolloquium.
     * Er deaktiviert die mögliche Bearbeitung der Notenfelder und speichert die zuvor eingegebenen Werte.
     * Außerdem wird der Bearbeiten-Button wieder eingeblendet, sofern noch weitere Noten für das Kolloquium
     * eingetragen werden können.
     */
    class saveKolloquiumEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                if(!gradeKolloquium1.isDisabled()){
                    studienleistung.updateNoteKolloquium(gradeKolloquium1.getValue());
                }
                else if(!gradeKolloquium2.isDisabled()){
                    studienleistung.updateNoteKolloquium(gradeKolloquium2.getValue());
                }

                gradeKolloquium1.setDisable(true);
                gradeKolloquium2.setDisable(true);
                saveKolloquium.setVisible(false);
                cancel.setVisible(false);

                if(studienleistung.getAbschluss().getKolloquium().getEndNoteKolloquium()!= 0.0 ||
                        studienleistung.getAbschluss().getKolloquium().getNoteKolloquium2() > 4.0){
                    updateKolloquium.setVisible(true);
                    updateKolloquium.setDisable(true);
                }
                else{
                    updateKolloquium.setDisable(false);
                    updateKolloquium.setVisible(true);
                }
                averageGradeModules.setText("Notendurchschnitt der Module: " + studienleistung.getNotendurchschnittModule());
                averageGradeBachelor.setText("Notendurchschnitt Bachelorarbeit und Kolloquium: " + studienleistung.getNotendurchschnittAbschluss());
                sumCreditpoints.setText("Summe der Creditpoints: " + studienleistung.getSummeCreditPointsMitAbschluss());
                creditpointsBachelorThesis.setText("Creditpoints: " + studienleistung.getAbschluss().getKolloquium().getCreditpointsKolloquium());
                String checkAverageGradeAll = studienleistung.getSummeCreditPointsMitAbschluss() != 180 ? " " : String.valueOf(studienleistung.getNotendurchschnittGesamt());
                averageGradeAll.setText("Notendurchschnitt Gesamt: " + checkAverageGradeAll);
            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }

    /**
     * Die Klasse cancelBachelorThesisAndKolloquiumEvent kümmert sich um das Verhalten des
     * Abbrechen-Buttons. Er deaktiviert die mögliche Bearbeitung der Notenfelder und verwirft
     * die zuvor eingegebenen Werte. Außerdem wird der Bearbeiten-Button wieder eingeblendet.
     */
    class cancelBachelorThesisAndKolloquiumEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                gradeBachelorThesis1.setDisable(true);
                gradeKolloquium1.setDisable(true);

                saveBachelor.setVisible(false);
                cancel.setVisible(false);
                updateBachelor.setVisible(true);

            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }
}
