package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.BachelorThesisAndKolloquiumComponents;

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
 * @author Ivonne Kneißig
 * @version 1.0 vom 27. November 2021
 */
public class BachelorThesisAndKolloquiumGridPane extends GridPane {

    private ComboBoxGrade gradeBachelorThesis;
    private Label creditpointsBachelorThesis;

    private ComboBoxGrade gradeKolloquium;
    private Label creditpointsKolloquium;

    private Label averageGradeModules;
    private Label averageGradeBachelor;
    private Label sumCreditpoints;

    private Button update;
    private Button save;
    private Button cancel;

    /**
     * Im Konstruktor von BachelorThesisAndKolloquiumGridPane werden
     * die einzelnen Elemente der ansicht erzeugt bzw. initialisiert und
     * auf der GridPane entsprechend angeordnet.
     */
    public BachelorThesisAndKolloquiumGridPane(){

        Label title = new Label("Abschluss & Kolloquium");
        title.setFont(new Font(30));
        title.setStyle("-fx-font-weight: bold");

        Label labelGradeBachelorThesis = new Label("Note der Bachelorarbeit");
        labelGradeBachelorThesis.setFont(new Font(16));
        gradeBachelorThesis = new ComboBoxGrade();
        gradeBachelorThesis.setMinWidth(150);
        setValignment(gradeBachelorThesis, VPos.TOP);
        gradeBachelorThesis.setDisable(true);

        Label labelGradeKolloquium = new Label("Note des Kolloquiums");
        labelGradeKolloquium.setFont(new Font(16));
        gradeKolloquium = new ComboBoxGrade();
        gradeKolloquium.setMinWidth(150);
        setValignment(gradeKolloquium, VPos.TOP);
        gradeKolloquium.setDisable(true);

        creditpointsBachelorThesis = new Label("Creditpoints: ");
        creditpointsBachelorThesis.setFont(new Font(16));

        creditpointsKolloquium = new Label("Creditpoints: ");
        creditpointsKolloquium.setFont(new Font(16));

        averageGradeModules = new Label("Notendurchschnitt der Module: ");
        averageGradeModules.setFont(new Font(16));
        averageGradeBachelor = new Label("Notendurchschnitt der bachelorarbeit: ");
        averageGradeBachelor.setFont(new Font(16));
        sumCreditpoints =  new Label("Summe der Creditpoints: ");
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

        add(labelGradeBachelorThesis,0,1,2,1);
        add(gradeBachelorThesis,0,2,2,1);
        add(creditpointsBachelorThesis,0,3,2,1);

        add(labelGradeKolloquium,1,1,2,1);
        add(gradeKolloquium,1,2,2,1);
        add(creditpointsKolloquium,1,3,2,1);

        add(averageGradeModules,0,4,4,1);
        add(averageGradeBachelor,0,5,4,1);
        add(sumCreditpoints,0,6,4,1);

        add(update,0,7,2,10);
        add(save,0,7, 1,10);
        add(cancel,1,7, 1,10);

        setPadding(new Insets(30, 0, 30, 50 ));
        setVgap(10);

        RowConstraints row1 = new RowConstraints();
        row1.setMinHeight(40);
        RowConstraints row2 = new RowConstraints();
        row2.setMinHeight(20);
        RowConstraints row3 = new RowConstraints();
        row3.setMinHeight(60);
        RowConstraints row4 = new RowConstraints();
        row4.setMinHeight(60);
        RowConstraints row5 = new RowConstraints();
        row5.setMinHeight(20);
        RowConstraints row6 = new RowConstraints();
        row6.setMinHeight(20);
        RowConstraints row7 = new RowConstraints();
        row7.setMinHeight(100);

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
                gradeBachelorThesis.setDisable(false);
                gradeKolloquium.setDisable(false);

                update.setVisible(false);
                save.setVisible(true);
                cancel.setVisible(true);
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
                gradeBachelorThesis.setDisable(true);
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
                gradeBachelorThesis.setDisable(true);
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
