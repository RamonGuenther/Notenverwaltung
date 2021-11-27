package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Die Klasse HelpStackPane öffnet ein Fenster mit Hinweisen zur
 * Anwendung.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 27. November 2021
 */
public class HelpStackPane extends StackPane {

    Stage stage;

    /**
     * Im Konstruktor von HelpStackPane werden die einzelnen Elemente der Ansicht
     * erzeugt bzw. initialisiert und der StackPane entsprechend hinzugefügt.
     *
     * @param stage     Stage-Object des Fensters. Wird im closeEventHandler zum
     *                  Schließen des Fensters benötigt.
     */
    public HelpStackPane(Stage stage){

        this.stage = stage;

        Button close = new Button("Schließen");
        close.setOnAction(new closeEventHandler());

        getChildren().add(close);

    }

    /**
     * Die Klasse closeEventHandler bestimmt das Verhalten des Schließen-Button.
     * Klickt der Benutzer auf den Button, wird das Hilfe-Fenster geschlossen.
     */
    class closeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                stage.close();
            }
            catch(Exception e) {
                Alert alert =
                        new Alert(Alert.AlertType.ERROR,
                                "Klasse " + HelpStackPane.class.getSimpleName() +
                                        ": " + this.getClass().getSimpleName() + " konnte nicht ausgeführt werden.", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
            }
        }
    }
}
