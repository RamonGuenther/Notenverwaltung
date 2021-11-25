package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

public class QuitMenuItem extends MenuItem {

    public QuitMenuItem(){
        setText("_Beenden");
        setMnemonicParsing(true);
        setAccelerator(new KeyCodeCombination(KeyCode.DIGIT1, KeyCombination.CONTROL_DOWN));
        setOnAction(new QuitEventHandler());
    }

    class QuitEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                Platform.exit();
            }
            catch(Exception e) {
                Alert alert =
                        new Alert(AlertType.ERROR, "Unbekannter Fehler", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }
}
