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

public class GradeManagementMenuItem extends MenuItem {

    StageInitializer initializer;

    public GradeManagementMenuItem(StageInitializer initializer){
        this.initializer = initializer;
        setText("Modulübersicht");
        setMnemonicParsing(true);
        setAccelerator(new KeyCodeCombination(KeyCode.DIGIT3, KeyCombination.CONTROL_DOWN));
        setOnAction(new GradeManagementEventHandler());
    }

    class GradeManagementEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                initializer.switchToGradeManagement();
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
