package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradeManagementSplitPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * Die Klasse GradeDetailsEventHandler ist für das Verhalten des Buttons
 * "Prüfungsleistung aktualisieren" in der Modulübersicht der Anwendung.
 * Mit dem Klickt auf den Button können bestimmte Details der gewählten
 * Prüfungsleistung verändert werden.
 */
public class GradeDetailsEventHandler implements EventHandler<ActionEvent> {

    private final GradeManagementSplitPane pane;

    /**
     * Im Konstruktor von GradeDetailsEventHandler wird dem Pane-Objekt der
     * Klasse die GradeManagementSplitPane zugewiesen. Der EventHandler benötigt
     * die Pane für die Verbindung zwischen der GradeManagementSplitPane und der
     * GradeDetailsGridPane.
     *
     * @param pane      GradeManagementSplitPane, welche die GradeDetailsGridPane
     *                  enthält, in der beim Klicken des Buttons Änderungen
     *                  vorgenommen werden sollen.
     */
    public GradeDetailsEventHandler(GradeManagementSplitPane pane){
        this.pane = pane;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        if(pane.getGradeDetails().getGradeOneValue().getValue() == null){
            pane.getGradeDetails().getGradeOneValue().setDisable(false);
        }

        if(pane.getGradeDetails().getGradeOneValue().getValue() != null
                && pane.getGradeDetails().getGradeOneValue().getValue() > 4.0
                && pane.getGradeDetails().getGradeTwoValue().getValue() == null){
            pane.getGradeDetails().getGradeTwoValue().setDisable(false);
        }

        if(pane.getGradeDetails().getGradeOneValue().getValue() != null && pane.getGradeDetails().getGradeOneValue().getValue() > 4.0 &&
                pane.getGradeDetails().getGradeTwoValue().getValue() != null && pane.getGradeDetails().getGradeTwoValue().getValue() > 4.0
                && pane.getGradeDetails().getGradeThreeValue().getValue() == null ){
            pane.getGradeDetails().getGradeThreeValue().setDisable(false);
        }

        pane.getGradeDetails().getSave().setDisable(false);
        pane.getGradeDetails().getSave().setVisible(true);
        pane.getGradeDetails().getCancel().setDisable(false);
        pane.getGradeDetails().getCancel().setVisible(true);
    }
}
