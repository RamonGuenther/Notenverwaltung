package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.DeleteModuleGridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DeleteModuleEventHandler implements EventHandler<ActionEvent> {

    private Studienleistung studienleistung;
    public DeleteModuleEventHandler(Studienleistung studienleistung) {
        this.studienleistung = studienleistung;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setTitle("Notenverwaltung Informatik B.sc. - Module entfernen");
        Parent root = new DeleteModuleGridPane(stage, studienleistung);
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
