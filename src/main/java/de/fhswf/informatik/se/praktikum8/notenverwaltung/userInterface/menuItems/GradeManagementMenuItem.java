package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * Die Klasse GradeManagementMenuItem erstellt eine
 * Menüoption für das Prüfungsleistungsmenü der MenuBar. Das Menü-Item
 * führt zur Übersichtsseite für die Modulübersicht des Studenten.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 26. November 2021
 */
public class GradeManagementMenuItem extends MenuItem {

    StageInitializer initializer;

    /**
     * Der Konstruktor von GradeManagementMenuItem initialisiert
     * das MenuItem für die Modulübersicht.
     *
     * @param initializer       StageInitializer wird an Komponenten
     *                          weitergereicht, um in dessen EventHandlern
     *                          die Scenes wechseln zu können.
     */
    public GradeManagementMenuItem(StageInitializer initializer){
        this.initializer = initializer;
        setText("Modulübersicht");
        setMnemonicParsing(true);
        setAccelerator(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.CONTROL_DOWN));
        setOnAction(new GradeManagementEventHandler());
    }

    /**
     * Der GradeManagementEventHandler sorgt dafür, dass mit dem Klick
     * auf das Menü-Item GradeManagementMenuItem der Nutzer die Übersicht
     * seiner Module angezeigt wird.
     */
    class GradeManagementEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                initializer.switchToGradeManagement();
            }
            catch(Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR,
                                "Klasse " + this.getClass().getSimpleName() +
                                        ": Das Event konnte nicht ausgeführt werden.", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }
}
