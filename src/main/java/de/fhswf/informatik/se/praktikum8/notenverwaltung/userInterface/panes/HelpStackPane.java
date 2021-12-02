package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Die Klasse HelpStackPane öffnet ein Fenster mit Hinweisen zur
 * Anwendung.
 *
 * @author Ivonne Kneißig & Ramon Günther (Verantwortlich: Ivonne Kneißig)
 * @version 1.1 vom 2. Dezember 2021
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

        VBox items = new VBox();

        Label help = new Label("Sorry, hier kann dir keiner Helfen. :)");
        help.setFont(new Font(20));

        Button close = new Button("Schließen");
        close.setOnAction(new closeEventHandler());

        items.setAlignment(Pos.BASELINE_CENTER);
        VBox.setMargin(help, new Insets(20, 0, 20, 0));
        items.setSpacing(50);

        items.getChildren().addAll(help, close);
        getChildren().addAll(items);
    }

    /**
     * Die Klasse closeEventHandler bestimmt das Verhalten des Schließen-Buttons.
     * Klickt der Benutzer auf den Button, wird das Hilfe-Fenster geschlossen.
     */
    class closeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                stage.close();
            } catch(Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Klasse " + this.getClass().getSimpleName() +
                        ": Das Event konnte nicht ausgeführt werden.", ButtonType.OK);
                alert.setResizable(true);
                alert.showAndWait();
                e.printStackTrace();
            }
        }
    }
}
