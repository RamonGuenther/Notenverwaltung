package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.WahlmodulEnum;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtfach;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * TODO:
 *         - Kommentare machen AUCH DIE TESTS
 *         - Wenn alles implementiert diese Klasse hier alles löschen bis auf die main
 *
 **/
@SpringBootApplication
public class NotenverwaltungApplication {

    @Autowired
    private PflichtmodulRepository pflichtmodulRepository;

    @Autowired
    private WahlpflichtmodulRepository wahlpflichtmodulRepository;

    @Autowired
    private WahlmodulRepository wahlmodulRepository;

    @Autowired
    private AbschlussRepository abschlussRepository;


    public static void main(String[] args) {
        javafx.application.Application.launch(ChartApplication.class, args);
    }

    @PostConstruct
    public void testDB() {
        Studienleistung studienleistung = new Studienleistung(
                pflichtmodulRepository, wahlpflichtmodulRepository, wahlmodulRepository, abschlussRepository);
        studienleistung.pflichtmoduleAnlegen();
        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);
//        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.SYSTEMINTEGRATION);
        studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.WIRTSCHAFT);
//        studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.KUENSTLICHE_INTELLIGENZ);

        List<Pflichtmodul> list = studienleistung.getPflichtmoduleByPflichtmodul();
        for(Pflichtmodul pflichtmodul : list){
            System.out.println(pflichtmodul.getModulart());
        }

        studienleistung.updateNotePflichtmodul("Grundlagen der Informatik 1", 5.0);
        studienleistung.updateNotePflichtmodul("Grundlagen der Informatik 1", 2.0);
//        studienleistung.updateNotePflichtmodul("Grundlagen der Informatik 1", 2.2);

        studienleistung.updateNotePflichtmodul("Basistechniken", 1.0);
        studienleistung.updateNotePflichtmodul("Rechnerarchitektur", 3.0);

        studienleistung.updateNotePflichtmodul("Mathematik für Informatiker 1", 3.7);
        studienleistung.updateNotePflichtmodul("Programmierung mit C++ 1", 2.3);
        Pflichtmodul pflichtmodul = pflichtmodulRepository.findByModulname("Grundlagen der Informatik 1");
        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);
//        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);
        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.BETRIEBSSYSTEME3,6);
//        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.PRAKTISCHE_ANWENDUNG_VON_ALGORITHMEN,6);


//        studienleistung.updateNoteWahlpflichtmodul(Wahlpflichtfach.GEOINFORMATIK.label, 5.0);
//        studienleistung.updateNoteWahlpflichtmodul(Wahlpflichtfach.GEOINFORMATIK.label, 2.4);


        studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);

        studienleistung.updateNoteWahlmodul(WahlmodulEnum.ENGLISH1.label, 5.0);
        studienleistung.updateNoteWahlmodul(WahlmodulEnum.ENGLISH1.label, 5.0);
        studienleistung.updateNoteWahlmodul(WahlmodulEnum.ENGLISH1.label, 5.0);
//        studienleistung.updateNoteWahlmodul(WahlmodulEnum.ENGLISH1.label, 5.0);

//        studienleistung.updateNoteBachelor(5.0);
        studienleistung.updateNoteBachelor(1.0);

        studienleistung.updateNoteKolloquium(2.0);

        System.out.println("Notendurchscnitt Abschluss: " + studienleistung.getNotendurchschnittAbschluss());

//        System.out.println(studienleistung.getNotendurchschnittGesamt());
//        studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);


//        List<Pflichtmodul> list1 = studienleistung.test(4);
//
//        System.out.println("____________________________________________");
//        for(Pflichtmodul pflichtmodul : list1){
//            System.out.println(pflichtmodul.getModulname());
//        }

    }


}