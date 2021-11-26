package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradeManagementSplitPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GradeDetailsEventHandler implements EventHandler<ActionEvent> {

    private GradeManagementSplitPane pane;

    public GradeDetailsEventHandler(GradeManagementSplitPane pane){
        this.pane = pane;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        pane.getGradeDetails().getModuleValue().setDisable(false);
        pane.getGradeDetails().getModuleTypeValue().setDisable(false);
        pane.getGradeDetails().getSemesterValue().setDisable(false);
        pane.getGradeDetails().getGradeOneValue().setDisable(false);
        pane.getGradeDetails().getGradeTwoValue().setDisable(false);
        pane.getGradeDetails().getGradeThreeValue().setDisable(false);

        pane.getGradeDetails().getSave().setDisable(false);
        pane.getGradeDetails().getSave().setVisible(true);
        pane.getGradeDetails().getCancel().setDisable(false);
        pane.getGradeDetails().getCancel().setVisible(true);
    }
}
