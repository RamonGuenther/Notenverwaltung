package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.ChartApplication.StageReadyEvent;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.*;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.BachelorThesisAndKolloquiumBorderPane;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.GradeManagementBorderPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Die Klasse StageInitializer initialisiert die Stage für die Notenverwaltungs-Applikation
 * und implementiert die Möglichkeit zwischen verschiedenen Scenes zu wechseln.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @version 2.0 vom 26. November 2021
 */

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Autowired
    private PflichtmodulRepository pflichtmodulRepository;

    @Autowired
    private WahlpflichtmodulRepository wahlpflichtmodulRepository;

    @Autowired
    private WahlmodulRepository wahlmodulRepository;

    @Autowired
    private AbschlussRepository abschlussRepository;

    private Parent root;
    private Stage stage;
    private Scene scene;
    private Studienleistung studienleistung;

    /**
     * Die Methode onApplicationEvent erzeugt die Stage und die Scene
     * zum Start der Applikation.
     *
     * @param event     Stage der Applikation
     */
    @Override
    public void onApplicationEvent(StageReadyEvent event) {

        studienleistung = new Studienleistung(
                pflichtmodulRepository,
                wahlpflichtmodulRepository,
                wahlmodulRepository,
                abschlussRepository
        );
        studienleistung.pflichtmoduleAnlegen();
//        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);
//        studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.WIRTSCHAFT);
//        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);
//        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.BETRIEBSSYSTEME3,6);
//        studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);
//
//        List<TestModuleEnum> testModuleEnumEnumList =  new ArrayList<>(Arrays.asList(TestModuleEnum.values()));
//        for(TestModuleEnum e : testModuleEnumEnumList){
//            studienleistung.updateNotePflichtmodul(e.label,3.0); //153*3=459
//        }
//        studienleistung.updateNoteWahlpflichtmodul(Wahlpflichtfach.BETRIEBSSYSTEME3.label, 4.0); //4*6
//        studienleistung.updateNoteWahlpflichtmodul(Wahlpflichtfach.GEOINFORMATIK.label, 2.3); //2.3 * 6

        stage = event.getStage();
        stage.setTitle("Notenverwaltung Informatik B.sc.");
        root = new GradeManagementBorderPane(this, studienleistung);
        scene = new Scene(root, 950, 600);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }

    /**
     * Die Methode switchToGradeManagement wechselt die Ansicht zur
     * Startseite der Applikation, mit der Übersicht der Module des
     * Studenten.
     */
    public void switchToGradeManagement() {
        root = new GradeManagementBorderPane(this, studienleistung);
        scene = new Scene(root, 950, 600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Die Methode switchToDegreeAndKolloquium wechselt die Ansicht der
     * Applikation zu der Übersicht für die Bachelorarbeit und das
     * Kolloquium.
     */
    public void switchToDegreeAndKolloquium(){
        root = new BachelorThesisAndKolloquiumBorderPane(this, studienleistung);
        scene = new Scene(root, 950, 600);
        stage.setScene(scene);
        stage.show();
    }

}
