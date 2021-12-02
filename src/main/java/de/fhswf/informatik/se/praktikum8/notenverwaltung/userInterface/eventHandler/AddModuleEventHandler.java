package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.eventHandler;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.paneComponents.GradeManageComponents.GradesTableView;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.AddModuleGridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Die Klasse AddModuleEventHandler öffnet beim Klick auf den Button
 * "Module hinzufügen" ein neues Fenster, in dem ausgewählt werden
 * kann, welche Module hinzugefügt werden sollen.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.2 vom 2. Dezember 2021
 */
public class AddModuleEventHandler implements EventHandler<ActionEvent> {

    private final Studienleistung studienleistung;
    private final GradesTableView table;

    /**
     * Der Konstruktor von AddModuleEventHandler bekommt
     * das Studienleistungsobjekt und die Grades TableView der Applikation,
     * um mit dessen Daten und Attributen arbeiten zu können.
     *
     * @param studienleistung       Studienleistungsobjekt der Anwendung, das
     *                              alle Module und den Abschluss enthält.
     * @param table                 Tabelle mit den Modulen des Studenten.
     */
    public AddModuleEventHandler(Studienleistung studienleistung, GradesTableView table) {
        this.studienleistung = studienleistung;
        this.table = table;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        try{
            Stage stage = new Stage();
            stage.setTitle("Notenverwaltung Informatik B.sc. - Module hinzufügen");
            Parent root = new AddModuleGridPane(stage, studienleistung, table);
            Scene scene = new Scene(root, 400, 400);
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
