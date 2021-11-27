package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.ChartApplication.StageReadyEvent;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.BachelorThesisAndKolloquiumBorderPane;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.GradeManagementBorderPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Die Klasse StageInitializer initialisiert die Stage für die Notenverwaltungs-Applikation
 * und implementiert die Möglichkeit zwischen verschiedenen Scenes zu wechseln.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @version 2.0 vom 26. November 2021
 */

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    private Parent root;
    private Stage stage;
    private Scene scene;

    /**
     * Die Methode onApplicationEvent erzeugt die Stage und die Scene
     * zum Start der Applikation.
     *
     * @param event     Stage der Applikation
     */
    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        stage = event.getStage();
        stage.setTitle("Notenverwaltung Informatik B.sc.");
        root = new GradeManagementBorderPane(this);
        scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        //stage.setMaximized(true);
    }

    /**
     * Die Methode switchToGradeManagement wechselt die Ansicht zur
     * Startseite der Applikation, mit der Übersicht der Module des
     * Studenten.
     */
    public void switchToGradeManagement() {
        root = new GradeManagementBorderPane(this);
        scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Die Methode switchToDegreeAndKolloquium wechselt die Ansicht der
     * Applikation zu der Übersicht für die Bachelorarbeit und das
     * Kolloquium.
     */
    public void switchToDegreeAndKolloquium(){
        root = new BachelorThesisAndKolloquiumBorderPane(this);
        scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }


}
