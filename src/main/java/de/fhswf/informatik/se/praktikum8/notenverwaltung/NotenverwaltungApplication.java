package de.fhswf.informatik.se.praktikum8.notenverwaltung;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * TODO: - WAHLFÄCHER ENUMS
 *          - Wahlfplichtmodul/Wahlmodul werden per Methode angelegt und nicht als Liste mit nem Case
 *          - update note mit bedinung wegen nur 3 Noten und darf nur gehen wenn man durchgefallen ist sonst natülich nicht
 *          - if note < 4 bestanden = true und crdditpoints werden mit beachtet bei summe sowie durchschnitt auch also abhängig von bestanden
 *         - Alle repositories in einer Service Klasse oder mehrere Service Klassen in Studienleistung
 *         - Kommentare machen
 *
 * Folgende Randbedingungen müssen erfüllt sein:
 *
 * o Korrekte Noteneingabe im zulässigen Wertebereich
 * o Verwendung der Creditpoints als Gewichtungsfaktors
 * o Hinterlegung geeigneter Wahlpflichtfächer
 * o Erreichen von 180 CP bei erfolgreichem Abschluss
 *
 *
 *
 * - Noten müssen im Bereich 1.0 - 5.0 sein. Notenschritte sind zu beachten.
 * - Noten können nur eingetragen werden, wenn entweder keine Note vorhanden oder die letzte
 *   Note eine 5.0 war.
 * - Es dürfen keine Fächer doppelt auftreten (Case Sensitivität).
 * - Creditpoints liegen zwischen 0-30.
 * - Die Durchschnittsnote wird ohne Wahlfächer und ohne nicht bestandene Leistungen
 *   berechnet.
 * - Abschlussarbeit und Kolloquium haben nur zwei Versuche.
 * - Es sind Wahl- und Pflichtfächer beim Anlegen von Fächern zu unterscheiden.
 *
 *
 */
@SpringBootApplication
public class NotenverwaltungApplication {

    @Autowired
    private PflichtmodulRepository repository;


    public static void main(String[] args) {
        javafx.application.Application.launch(ChartApplication.class, args);
    }

    @PostConstruct
    public void testDB() {
        Studienleistung studienleistung = new Studienleistung(repository);
        studienleistung.pflichtmoduleAnlegen();
        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);
        studienleistung.setPflichtmodule();
        List<Pflichtmodul> list = studienleistung.getPflichtmodule();
        for(Pflichtmodul pflichtmodul : list){
            System.out.println(pflichtmodul.getModulname());
        }

        studienleistung.updateNote("Grundlagen der Informatik 1", 4);

//        List<Pflichtmodul> list1 = studienleistung.test(4);
//
//        System.out.println("____________________________________________");
//        for(Pflichtmodul pflichtmodul : list1){
//            System.out.println(pflichtmodul.getModulname());
//        }

    }

}