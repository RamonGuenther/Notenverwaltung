package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.ChartApplication.StageReadyEvent;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.BachelorThesisAndKolloquiumBorderPane;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.GradeManagementBorderPane;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
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
    private TableView<Object> table = new TableView();

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

    /**
     * Die Methode onApplicationEvent erzeugt die Stage und die Scene
     * zum Start der Applikation.
     *
     * @param event     Stage der Applikation
     */
    @Override
    public void onApplicationEvent(StageReadyEvent event) {

        Studienleistung studienleistung = new Studienleistung(
                pflichtmodulRepository,
                wahlpflichtmodulRepository,
                wahlmodulRepository,
                abschlussRepository
        );


        stage = event.getStage();

        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(500);

        final Label label = new Label("Krasses Beispiel");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Object,String> modulenameCol = new TableColumn<>("Modulname");
        modulenameCol.setCellValueFactory(new PropertyValueFactory<>("modulname"));


        TableColumn<Object,String> moduleTypeCol = new TableColumn("Modulart");
        moduleTypeCol.setCellValueFactory(new PropertyValueFactory<>("modulart"));

        TableColumn<Object,Integer>creditpointsCol = new TableColumn("Creditpoints");
        creditpointsCol.setCellValueFactory(new PropertyValueFactory<>("creditpoints"));


        table.getColumns().addAll(modulenameCol, moduleTypeCol, creditpointsCol);

//        table.getItems().addAll(studienleistung.getAllePflichtmoduleUndWahlpflichtmodule());
        table.getItems().addAll(studienleistung.getBestandenePflichtmoduleUndWahlpflichtmodule());
//        table.getItems().addAll(studienleistung.getOffenePflichtmoduleUndWahlpflichtmodule());


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));


//TODO: So könnte es ungefähr dann aussehen wegen rechte Seite formular füllen
        table.setOnMouseClicked((MouseEvent event2) -> {
            if (event2.getClickCount() > 1) {
                onEdit();
            }
        });

        vbox.getChildren().addAll(label, table);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        stage.setScene(scene);
        stage.show();

//        stage = event.getStage();
//        stage.setTitle("Notenverwaltung Informatik B.sc.");
//        root = new GradeManagementBorderPane(this);
//        scene = new Scene(root, 900, 600);
//        stage.setScene(scene);
//        stage.show();
//        stage.setResizable(false);
//        //stage.setMaximized(true);
    }
//TODO: So könnte es ungefähr dann aussehen wegen rechte Seite formular füllen
    public void onEdit() {
        try {
            Wahlpflichtmodul wahlpflichtmodul = (Wahlpflichtmodul) table.getSelectionModel().getSelectedItem();
            System.out.println(wahlpflichtmodul.getModulname() + " " + wahlpflichtmodul.getModulart() + " " + wahlpflichtmodul.getNote().getEndNote());
            wahlpflichtmodul.setModulart("Apfel");
            //Note eintragen button löst studienleistung methode aus
            System.out.println("Wahlpflcht: Modulart = Apfel");
            wahlpflichtmodulRepository.save(wahlpflichtmodul);
        }
        catch (Exception e) {
            Pflichtmodul pflichtmodul = (Pflichtmodul) table.getSelectionModel().getSelectedItem();
            System.out.println(pflichtmodul.getModulname());
            pflichtmodul.setModulart("Apfel");
            System.out.println("Pflichtmodul: Modulart = Apfel");
            pflichtmodulRepository.save(pflichtmodul);
        }
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
