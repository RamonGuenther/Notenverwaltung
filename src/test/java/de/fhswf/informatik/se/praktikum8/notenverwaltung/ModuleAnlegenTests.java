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
 * Die Klasse ModuleAnlegenTests prüft das Anlegen der Module.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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

    @BeforeAll
    public void init(){
        alleModuleLoeschen();
        studienleistung = new Studienleistung(pflichtmodulRepository, wahlpflichtmodulRepository, wahlmodulRepository, abschlussRepository);
    }

    @BeforeEach
    public void alleModuleLoeschen(){
        pflichtmodulRepository.deleteAll();
        abschlussRepository.deleteAll();
        wahlmodulRepository.deleteAll();
        wahlpflichtmodulRepository.deleteAll();
    }


    @Test
    void pflichtmoduleAnlegen(){
        studienleistung.pflichtmoduleAnlegen();
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.pflichtmoduleAnlegen();
        });
    }


    @Test
    void studienrichtungAngeben(){
        studienleistung.pflichtmoduleAnlegen();

        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);

        //Darf nicht gehen, da eine Studienrichtung schon festgelegt wurde
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.KUENSTLICHE_INTELLIGENZ);
        });
    }

    @Test
    void wahlpflichtblockFestlegen(){
        studienleistung.pflichtmoduleAnlegen();

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

        studienleistung.pflichtmoduleAnlegen();
        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);


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
