package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.BachelorThesisAndKolloquiumComponents;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.ComboBoxGrade;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
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
 * @author Ivonne Kneißig
 * @version 1.0 vom 27. November 2021
 */
public class BachelorThesisAndKolloquiumGridPane extends GridPane {

    private final Studienleistung studienleistung;

    private final ComboBoxGrade gradeBachelorThesis1; //TODO IVONNE DAS MIT FINAL ZEIGEN
    private final ComboBoxGrade gradeBachelorThesis2;
    private final Label creditpointsBachelorThesis;

    private final ComboBoxGrade gradeKolloquium;
    private final Label creditpointsKolloquium;

    private final Label averageGradeModules;
    private final Label averageGradeBachelor;
    private final Label sumCreditpoints;

    private final Button update;
    private final Button save;
    private final Button cancel;

    /**
     * Im Konstruktor von BachelorThesisAndKolloquiumGridPane werden
     * die einzelnen Elemente der ansicht erzeugt bzw. initialisiert und
     * auf der GridPane entsprechend angeordnet.
     */
    public BachelorThesisAndKolloquiumGridPane(Studienleistung studienleistung){

        this.studienleistung = studienleistung;

        Label title = new Label("Abschluss & Kolloquium");
        title.setFont(new Font(30));
        title.setStyle("-fx-font-weight: bold");

        Label labelGradeBachelorThesis1 = new Label("Note der Bachelorarbeit");
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

        Label labelGradeBachelorThesis2 = new Label("Note der Bachelorarbeit");
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

        Label labelGradeKolloquium = new Label("Note des Kolloquiums");
        labelGradeKolloquium.setFont(new Font(16));
        gradeKolloquium = new ComboBoxGrade();

        gradeKolloquium.setValue(studienleistung
                .getAbschluss()
                .getKolloquium()
                .getEndNoteKolloquium()
                != 0.0 ? studienleistung
                .getAbschluss().getKolloquium()
                .getEndNoteKolloquium() : null
        );

        gradeKolloquium.setMinWidth(150);
        setValignment(gradeKolloquium, VPos.TOP);
        gradeKolloquium.setDisable(true);


        creditpointsBachelorThesis = new Label();
        creditpointsBachelorThesis.setFont(new Font(16));

        creditpointsKolloquium = new Label("Creditpoints: ");
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

        averageGradeBachelor = new Label("Notendurchschnitt der Bachelorarbeit: ");
        averageGradeBachelor.setText("Notendurchschnitt der Bachelorarbeit: " + studienleistung.getNotendurchschnittAbschluss());
        averageGradeBachelor.setFont(new Font(16));

        sumCreditpoints =  new Label("Summe der Creditpoints: ");
        sumCreditpoints.setText("Summe der Creditpoints: " + studienleistung.getSummeCreditPointsMitAbschluss());
        sumCreditpoints.setFont(new Font(16));

        update = new Button("Bearbeiten");
        update.setMinWidth(150);
        setHalignment(update, HPos.CENTER);
        setValignment(update, VPos.BOTTOM);
        update.setOnAction(new updateBachelorThesisAndKolloquiumEventHandler());

        save = new Button("Speichern");
        save.setMinWidth(150);
        setHalignment(save, HPos.CENTER);
        setValignment(save, VPos.BOTTOM);
        save.setVisible(false);
        save.setOnAction(new saveBachelorThesisAndKolloquiumEventHandler());

        cancel = new Button("Abbrechen");
        cancel.setMinWidth(150);
        setHalignment(cancel, HPos.CENTER);
        setValignment(cancel, VPos.BOTTOM);
        cancel.setVisible(false);
        cancel.setOnAction(new cancelBachelorThesisAndKolloquiumEventHandler());


        // page.add(Node, colIndex, rowIndex, colSpan, rowSpan):
        add(title, 0, 0, 2, 1);

        add(labelGradeBachelorThesis1,0,1,2,1);
        add(gradeBachelorThesis1,0,2,2,1);
        add(labelGradeBachelorThesis2,0,3,2,1);
        add(gradeBachelorThesis2,0,4,2,1);
        add(creditpointsBachelorThesis,0,5,2,1);

        add(labelGradeKolloquium,1,1,2,1);
        add(gradeKolloquium,1,2,2,1);
        add(creditpointsKolloquium,1,5,2,1);

        add(averageGradeModules,0,6,4,1);
        add(averageGradeBachelor,0,7,4,1);
        add(sumCreditpoints,0,8,4,1);

        add(update,0,9,2,10);
        add(save,0,9, 1,10);
        add(cancel,1,9, 1,10);

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
        row7.setMinHeight(20);

        getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setMinWidth(400);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setMinWidth(400);

        getColumnConstraints().addAll(col1, col2);

    }

    /**
     * Die Klasse updateBachelorThesisAndKolloquiumEventHandler kümmert sich
     * um das Verhalten des Bearbeiten-Buttons. Es werden entsprechende Felder
     * zur Bearbeitung freigeschaltet und der Speichern-Button und
     * Abbrechen-Button eingeblendet.
     */
    class updateBachelorThesisAndKolloquiumEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {



            try {
                save.disableProperty().bind(
                        gradeBachelorThesis1.valueProperty().isNull()
                                .and(gradeKolloquium.valueProperty().isNull()));

//                //Damit der Save Button grau bleibt bis die Felder gesetzt wurden
//                //TODO: WENN MAN DIREKT WIEDER DEN BEARBEITEN BUTTON DRÜCK WIRD DER SAFE BUTTON NICHT GRAU BEIM VERLASSEN UND HINGEHEN SCHON
//                if(studienleistung.getAbschluss().getBachelorarbeit().getEndNoteBachelor() != 0.0 && studienleistung.getAbschluss().getKolloquium().getEndNoteKolloquium() != 0.0){
//                    save.setDisable(true);
//                }
//                else {
//
//                    );
//                }

                if(gradeBachelorThesis1.getValue() != null){
                    gradeBachelorThesis1.setDisable(true);
                    gradeBachelorThesis2.setDisable(false);

                }
                else{
                    gradeBachelorThesis1.setDisable(false);
                    gradeBachelorThesis2.setDisable(true);
                }

                gradeKolloquium.setDisable(false);

                update.setVisible(false);
                save.setVisible(true);
                cancel.setVisible(true);


            }
            catch(Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR,
                              e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }

    /**
     * Die Klasse saveBachelorThesisAndKolloquiumEventHandler kümmert sich um das Verhalten des
     * Speichern-Buttons. Er deaktiviert die mögliche Bearbeitung der Notenfelder und speichert
     * die zuvor eingegebenen Werte. Außerdem wird der Bearbeiten-Button wieder eingeblendet.
     */
    class saveBachelorThesisAndKolloquiumEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {

                save.setVisible(false);
                cancel.setVisible(false);
                update.setVisible(true);

                //TODO: DIE IFS ERGEBEN KEINEN SINN, DA SIE BEIM ZWEITEN RUN BEIDE ZUTREFFEN AU?ER ERSTE
                if(gradeBachelorThesis1.getValue() == null ||
                        gradeKolloquium.getValue() == null ){

                    throw new IllegalArgumentException("Die Note für den Bachelor oder für das Kolloquium wurde nicht ausgewählt.");
                }
                else if(gradeBachelorThesis1.getValue()!= null &&
                        gradeKolloquium.getValue() != null){
                    gradeBachelorThesis1.setValue(gradeBachelorThesis1.getValue());
                    studienleistung.updateNoteBachelor(gradeBachelorThesis1.getValue());
                    studienleistung.updateNoteKolloquium(gradeKolloquium.getValue());
                }
                else if(gradeBachelorThesis2.getValue()!= null &&
                        gradeKolloquium.getValue() != null){
                    System.out.println("Hallol");
                    studienleistung.updateNoteBachelor(gradeBachelorThesis2.getValue());
                    studienleistung.updateNoteKolloquium(gradeKolloquium.getValue());
                }

                gradeBachelorThesis1.setDisable(true);
                gradeBachelorThesis2.setDisable(true);
                gradeKolloquium.setDisable(true);

            }
            catch(Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR,
                                e.getMessage(), ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }

    /**
     * Die Klasse saveBachelorThesisAndKolloquiumEventHandler kümmert sich um das Verhalten des
     * Speichern-Buttons. Er deaktiviert die mögliche Bearbeitung der Notenfelder und verwirft
     * die zuvor eingegebenen Werte. Außerdem wird der Bearbeiten-Button wieder eingeblendet.
     */
    class cancelBachelorThesisAndKolloquiumEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                gradeBachelorThesis1.setDisable(true);
                gradeKolloquium.setDisable(true);

                save.setVisible(false);
                cancel.setVisible(false);
                update.setVisible(true);

            }
            catch(Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR,
                                "Klasse " + BachelorThesisAndKolloquiumGridPane.class.getSimpleName() +
                                        ": " + this.getClass().getSimpleName() + " konnte nicht ausgeführt werden.", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }
}
