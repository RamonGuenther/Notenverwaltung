package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.HelpStackPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

/**
 * Die Klasse HelpMenuItem erstellt eine Menüoption für das Hilfemenü der MenuBar.
 * Das Menü-Item öffnet ein Fenster mit Informationen zur Anwendung, die dem Nutzer
 * bei der Verwendung helfen sollen.
 *
 * @author Ivonne Kneißig
 * @version 1.1 vom 27. November 2021
 */
public class HelpMenuItem extends MenuItem {

    /**
     * Der Konstruktor von HelpMenuItem() initialisiert das MenuItem zum Beenden
     * der Anwendung.
     */
    public HelpMenuItem(){

        setText("_Hilfe");
        setMnemonicParsing(true);
        setAccelerator(new KeyCodeCombination(KeyCode.DIGIT4, KeyCombination.CONTROL_DOWN));
        setOnAction(new HelpEventHandler());

    }

    /**
     * Der HelpEventHandler sorgt dafür, dass mit dem Klick auf das Menü-Item
     * HelpMenuItem ein Fenster mit Informationen für den Studenten geöffnet
     * wird.
     */
    static class HelpEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                Stage stage = new Stage();
                stage.setTitle("Notenverwaltung Informatik B.sc. - Module hinzufügen");
                Parent root = new HelpStackPane(stage);
                Scene scene = new Scene(root, 400, 200);
                stage.setScene(scene);
                stage.show();
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
