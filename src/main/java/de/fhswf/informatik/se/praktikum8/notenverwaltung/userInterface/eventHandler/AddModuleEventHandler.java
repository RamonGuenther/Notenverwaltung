package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.AddModuleGridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Die Klasse AddModuleEventHandler öffnet beim Klick auf den Button
 * "Module hinzufügen" ein neues Fenster, in dem ausgewählt werden
 * kann, welche Module hinzugefügt werden sollen.
 *
 * @author Ivonne Kneißig
 * @version 1.1 vom 1. Dezember 2021
 */
public class AddModuleEventHandler implements EventHandler<ActionEvent> {

    private Studienleistung studienleistung;

    public AddModuleEventHandler(Studienleistung studienleistung) {
        this.studienleistung = studienleistung;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        stage.setTitle("Notenverwaltung Informatik B.sc. - Module hinzufügen");
        Parent root = new AddModuleGridPane(stage, studienleistung);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
