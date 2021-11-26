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


public class BachelorThesisAndKolloquiumMenuItem extends MenuItem {

    StageInitializer initializer;

    public BachelorThesisAndKolloquiumMenuItem(StageInitializer initializer){
        this.initializer = initializer;
        setText("_Bachelorarbeit & Kolloquium");
        setMnemonicParsing(true);
        setAccelerator(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.CONTROL_DOWN));
        setOnAction(new BachelorThesisAndKolloquiumEventHandler());

    }

    class BachelorThesisAndKolloquiumEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                initializer.switchToDegreeAndKolloquium();
            }
            catch(Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR, "Unbekannter Fehler", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }
}
