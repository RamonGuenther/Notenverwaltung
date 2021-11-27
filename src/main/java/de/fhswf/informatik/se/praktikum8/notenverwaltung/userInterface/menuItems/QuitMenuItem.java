package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * Die Klasse QuitMenuItem erstellt eine Menüoption für das Dateimenü der MenuBar.
 * Das Menü-Item beendet die Anwendung.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 26. November 2021
 */
public class QuitMenuItem extends MenuItem {

    /**
     * Der Konstruktor von QuitMenuItem initialisiert das MenuItem zum Beenden
     * der Anwendung.
     */
    public QuitMenuItem(){
        setText("_Beenden");
        setMnemonicParsing(true);
        setAccelerator(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.CONTROL_DOWN));
        setOnAction(new QuitEventHandler());
    }

    /**
     * Der QuitEventHandler sorgt dafür, dass mit dem Klick
     * auf das Menü-Item QuitMenuItem die Anwendung beendet wird.
     */
    static class QuitEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                Platform.exit();
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
