package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.WahlmodulEnum;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtfach;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Die Klasse ModuleLoeschenTests prüft das Verhalten beim Löschen von Modulen.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModuleLoeschenTests {

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
            studienleistung = new Studienleistung(pflichtmodulRepository, wahlpflichtmodulRepository, wahlmodulRepository, abschlussRepository);

        }

        @BeforeEach
        public void alleModuleLoeschen(){
            pflichtmodulRepository.deleteAll();
            abschlussRepository.deleteAll();
            wahlmodulRepository.deleteAll();
            wahlpflichtmodulRepository.deleteAll();
            studienleistung.pflichtmoduleAnlegen();
        }


        @Test
        void studienrichtungLoeschen(){

            studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);

            //Darf nicht gehen, da eine Studienrichtung schon festgelegt wurde
            assertThrows(IllegalArgumentException.class, () ->{
                studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.KUENSTLICHE_INTELLIGENZ);
            });

            studienleistung.deleteAllByStudienrichtung();

            studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.KUENSTLICHE_INTELLIGENZ);

        }

        @Test
        void wahlpflichtblockLoeschen(){

            studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);


            studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.WIRTSCHAFT);

            //Darf nicht gehen weil schon ein Wahlpflichtblock definiert wurde
            assertThrows(IllegalArgumentException.class, () ->{
                studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.KUENSTLICHE_INTELLIGENZ);
            });

            studienleistung.deleteAllByWahlpflichtblock();

            studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.KUENSTLICHE_INTELLIGENZ);

        }

        @Test
        void wahlpflichtmodulLoeschen(){

            studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);

            //Gleiches Modul angeben
            assertThrows(IllegalArgumentException.class, () ->{
                studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);
            });

            studienleistung.deleteWahlpflichtmodul(Wahlpflichtfach.GEOINFORMATIK.label);

            studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);

            studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.BETRIEBSSYSTEME3,6);

            //Mehr als 2 Module anlegen
            assertThrows(IllegalArgumentException.class, () ->{
                studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.PRAKTISCHE_ANWENDUNG_VON_ALGORITHMEN,6);
            });

            studienleistung.deleteWahlpflichtmodul(Wahlpflichtfach.GEOINFORMATIK.label);

            studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.PRAKTISCHE_ANWENDUNG_VON_ALGORITHMEN,6);


        }

        @Test
        void wahlmodulLoeschen(){
            studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);

            //Gleiches Wahlmodul hinzufügen
            assertThrows(IllegalArgumentException.class, () ->{
                studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);
            });

            studienleistung.deleteWahlmodul(WahlmodulEnum.ENGLISH1.label);

            studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);
        }

}

