package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradeManagementSplitPane;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.DeleteModuleGridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Die Klasse DeleteModuleEventHandler öffnet beim Klick auf den Button
 * "Hilfe" ein neues Fenster, in dem (vielleicht) hilfreiche Informationen
 * für den Studenten stehen. :)
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.0 vom 2. Dezember 2021
 */
public class DeleteModuleEventHandler implements EventHandler<ActionEvent> {

    private final Studienleistung studienleistung;
    private final GradeManagementSplitPane splitPane;

    /**
     * Der Konstruktor von DeleteModuleEventHandler bekommt
     * das Studienleistungsobjekt, um mit dessen Daten und Attributen arbeiten
     * zu können.
     *
     * @param studienleistung   Studienleistungsobjekt der Anwendung, das
     *                          alle Module und den Abschluss enthält.
     */
    public DeleteModuleEventHandler(Studienleistung studienleistung, GradeManagementSplitPane splitPane) {
        this.studienleistung = studienleistung;
        this.splitPane = splitPane;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try{
            Stage stage = new Stage();
            stage.setTitle("Notenverwaltung Informatik B.sc. - Module entfernen");
            Parent root = new DeleteModuleGridPane(stage, studienleistung, splitPane.getGradesTableBorderPane().getTableView());
            Scene scene = new Scene(root, 400, 300);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Klasse " + this.getClass().getSimpleName() +
                                    ": Das Event konnte nicht ausgeführt werden.", ButtonType.OK);
            alert.setResizable(true);
            alert.showAndWait();
            e.printStackTrace();
        }

    }
}
