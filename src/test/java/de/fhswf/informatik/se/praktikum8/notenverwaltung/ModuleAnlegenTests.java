package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.*;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Die Testfälle überschreiben den Inhalt der Datenbank!
 */

@SpringBootTest
class ModuleAnlegenTests {

    @Autowired
    private PflichtmodulRepository pflichtmodulRepository;

    @Autowired
    private WahlpflichtmodulRepository wahlpflichtmodulRepository;

    @Autowired
    private WahlmodulRepository wahlmodulRepository;

    @Autowired
    private AbschlussRepository abschlussRepository;

    private Studienleistung studienleistung;


    @BeforeEach
    void init(){
        studienleistung = new Studienleistung(pflichtmodulRepository, wahlpflichtmodulRepository, wahlmodulRepository, abschlussRepository);
    }

    void alleModuleLoeschen(){
        pflichtmodulRepository.deleteAll();
        abschlussRepository.deleteAll();
        wahlmodulRepository.deleteAll();
        wahlpflichtmodulRepository.deleteAll();
    }

    @Test
    void pflichtmoduleAnlegen(){
        studienleistung.pflichtmoduleAnlegen(); // Sollte man es verhindern?
        studienleistung.pflichtmoduleAnlegen();
    }


    @Test
    void studienrichtungAngeben(){
        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);

        //Darf nicht gehen, da eine Studienrichtung schon festgelegt wurde
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.KUENSTLICHE_INTELLIGENZ);
        });
    }

    @Test
    void wahlpflichtblockFestlegen(){
        //Darf nicht gehen weil noch keine Studienrichtung angegeben worden ist
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.WIRTSCHAFT);
        });

        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);

        studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.WIRTSCHAFT);
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.KUENSTLICHE_INTELLIGENZ);
        });
    }

    @Test
    void wahlpflichtmodulAnlegen(){
        wahlpflichtmodulRepository.deleteAll();

        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);

        //Gleiches Modul angeben
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);
        });

        //Schon hinzugefügt durch Studienrichtung Anwendungsentwicklung
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.FORTGESCHRITTENE_INTERNETTECHNOLOGIEN,5);
        });

        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.BETRIEBSSYSTEME3,6);

        //Mehr als 2 Module anlegen
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.PRAKTISCHE_ANWENDUNG_VON_ALGORITHMEN,6);
        });
    }

    @Test
    void wahlmodulAnlegen(){
        studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);
        //Gleiches Wahlmodul hinzufügen
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);
        });
    }


}
