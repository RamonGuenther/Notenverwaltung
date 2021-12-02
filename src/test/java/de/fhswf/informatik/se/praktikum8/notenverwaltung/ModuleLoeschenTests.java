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
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 * Die Testfälle überschreiben den Inhalt der Datenbank!
 *
 * WICHTIG: Properties auf UPDATE und @Component bei Stageinitializer.class entfernen sonst laufen die Tests nicht
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
            alleModuleLoeschen();
            studienleistung = new Studienleistung(pflichtmodulRepository, wahlpflichtmodulRepository, wahlmodulRepository, abschlussRepository);
            studienleistung.pflichtmoduleAnlegen();
        }

        @BeforeEach
        public void alleModuleLoeschen(){
//            pflichtmodulRepository.deleteAll();
//            abschlussRepository.deleteAll();
//            wahlmodulRepository.deleteAll();
//            wahlpflichtmodulRepository.deleteAll();
        }


        @Test
        void studienrichtungLoeschen(){

            studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);

            //Darf nicht gehen, da eine Studienrichtung schon festgelegt wurde
            assertThrows(IllegalArgumentException.class, () ->{
                studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.KUENSTLICHE_INTELLIGENZ);
            });

            studienleistung.deleteAllByStudienrichtung();

            studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);

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

