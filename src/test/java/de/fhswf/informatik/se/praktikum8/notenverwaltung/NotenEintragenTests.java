package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.Studienleistung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtfach;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Die Testfälle überschreiben den Inhalt der Datenbank!
 */
@SpringBootTest
public class NotenEintragenTests {

    @Autowired
    private PflichtmodulRepository pflichtmodulRepository;

    @Autowired
    private WahlpflichtmodulRepository wahlpflichtmodulRepository;

    @Autowired
    private WahlmodulRepository wahlmodulRepository;

    @Autowired
    private AbschlussRepository abschlussRepository;

    private Studienleistung studienleistung;

    void alleModuleLoeschen() {
        pflichtmodulRepository.deleteAll();
        abschlussRepository.deleteAll();
        wahlmodulRepository.deleteAll();
        wahlpflichtmodulRepository.deleteAll();
    }

    @BeforeEach
    void init() {
        alleModuleLoeschen();
        studienleistung = new Studienleistung(pflichtmodulRepository, wahlpflichtmodulRepository, wahlmodulRepository, abschlussRepository);
        studienleistung.pflichtmoduleAnlegen();
        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);
        studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.WIRTSCHAFT);
        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK, 5);
        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.BETRIEBSSYSTEME3, 6);
    }

    @Test
    void modulNotenEintragen() {

        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    studienleistung.updateNotePflichtmodul(TestModuleEnum.SOFTWARE_ENGINEERING.label, 1.5);
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    studienleistung.updateNotePflichtmodul(TestModuleEnum.SOFTWARE_ENGINEERING.label, 5.1);
                }),
                () -> assertThrows(IllegalArgumentException.class, () -> {
                    studienleistung.updateNotePflichtmodul(TestModuleEnum.SOFTWARE_ENGINEERING.label, -1.5);
                })
        );


        studienleistung.updateNotePflichtmodul(TestModuleEnum.SOFTWARE_ENGINEERING.label, 5.0);

        studienleistung.updateNotePflichtmodul(TestModuleEnum.SOFTWARE_ENGINEERING.label, 5.0);

        studienleistung.updateNotePflichtmodul(TestModuleEnum.SOFTWARE_ENGINEERING.label, 2.0);

        //Weil 3 Noten schon eingetragen wurden
        assertThrows(IllegalArgumentException.class, () -> {
            studienleistung.updateNotePflichtmodul(TestModuleEnum.SOFTWARE_ENGINEERING.label, 1.0);
        });


        studienleistung.updateNotePflichtmodul(TestModuleEnum.MATHEMATIK_FUER_INFORMATIKER1.label, 1.0);

        //Weil Mathe 1 schon bestanden ist
        assertThrows(IllegalArgumentException.class, () -> {
            studienleistung.updateNotePflichtmodul(TestModuleEnum.MATHEMATIK_FUER_INFORMATIKER1.label, 3.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            studienleistung.updateNotePflichtmodul("Existiert nicht", 1.0);
        });

    }

    @Test
    void abschlussNotenEintragen() {
        studienleistung.updateNoteBachelor(5.0);


        //Da die Bachelorarbeit nicht bestanden wurde kann keine Note für das Kolloquium eingetragen werden
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.updateNoteKolloquium(4.0);
        });

        studienleistung.updateNoteBachelor(4.0);
        studienleistung.updateNoteKolloquium(4.0);
    }
}
