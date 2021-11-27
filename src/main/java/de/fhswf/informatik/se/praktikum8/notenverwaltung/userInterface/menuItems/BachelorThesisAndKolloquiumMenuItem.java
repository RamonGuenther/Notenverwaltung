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
 * Die Klasse BachelorThesisAndKolloquiumMenuItem erstellt eine
 * Menüoption für das Prüfungsleistungsmenü der MenuBar. Das Menü-Item
 * führt zur Übersichtsseite für die Bachelorarbeit und das Kolloquium.
 *
 * @author Ivonne Kneißig
 * @version 1.0 vom 26. November 2021
 */
public class BachelorThesisAndKolloquiumMenuItem extends MenuItem {

    StageInitializer initializer;

    /**
     * Der Konstruktor von BachelorThesisAndKolloquiumMenuItem initialisiert
     * das MenuItem für Bachelorarbeit & Kolloquium.
     *
     * @param initializer       StageInitializer wird an Komponenten
     *                          weitergereicht, um in dessen EventHandlern
     *                          die Scenes wechseln zu können.
     */
    public BachelorThesisAndKolloquiumMenuItem(StageInitializer initializer){
        this.initializer = initializer;
        setText("_Bachelorarbeit & Kolloquium");
        setMnemonicParsing(true);
        setAccelerator(new KeyCodeCombination(KeyCode.DIGIT2, KeyCombination.CONTROL_DOWN));
        setOnAction(new BachelorThesisAndKolloquiumEventHandler());
    }

    /**
     * Der BachelorThesisAndKolloquiumEventHandler sorgt dafür, dass mit dem Klick
     * auf das Menü-Item BachelorThesisAndKolloquiumMenuItem der Nutzer die Übersicht
     * von Bachelorarbeit und Kolloquium angezeigt wird.
     */
    class BachelorThesisAndKolloquiumEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event)
        {
            try {
                initializer.switchToDegreeAndKolloquium();
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
