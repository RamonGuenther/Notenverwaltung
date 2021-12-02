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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Die Testfälle überschreiben den Inhalt der Datenbank!
 */
@SpringBootTest
public class NotendurchschnittTests {

    @Autowired
    private PflichtmodulRepository pflichtmodulRepository;

    @Autowired
    private WahlpflichtmodulRepository wahlpflichtmodulRepository;

    @Autowired
    private WahlmodulRepository wahlmodulRepository;

    @Autowired
    private AbschlussRepository abschlussRepository;

    private Studienleistung studienleistung;


    void alleModuleLoeschen(){
        pflichtmodulRepository.deleteAll();
        abschlussRepository.deleteAll();
        wahlmodulRepository.deleteAll();
        wahlpflichtmodulRepository.deleteAll();
    }

    @BeforeEach
    void init(){
        alleModuleLoeschen();
        studienleistung = new Studienleistung(pflichtmodulRepository, wahlpflichtmodulRepository, wahlmodulRepository, abschlussRepository);
        studienleistung.pflichtmoduleAnlegen();
        studienleistung.pflichtmoduleStudienrichtungFestlegen(Studienrichtung.ANWENDUNGSENTWICKLUNG);
        studienleistung.pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock.WIRTSCHAFT);
        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.GEOINFORMATIK,5);
        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.BETRIEBSSYSTEME3,6);
        studienleistung.wahlmodulHinzufuegen(WahlmodulEnum.ENGLISH1, 5);
    }

    @Test
    void summeCreditpointsNotendurchschnittTests(){
        List<TestModuleEnum> testModuleEnumEnumList =  new ArrayList<>(Arrays.asList(TestModuleEnum.values()));
        for(TestModuleEnum e : testModuleEnumEnumList){
            studienleistung.updateNotePflichtmodul(e.label,3.0); //153*3=459
        }
        studienleistung.updateNoteWahlpflichtmodul(Wahlpflichtfach.BETRIEBSSYSTEME3.label, 4.0); //4*6
        studienleistung.updateNoteWahlpflichtmodul(Wahlpflichtfach.GEOINFORMATIK.label, 2.3); //2.3 * 6

        studienleistung.updateNoteBachelor(2.3);

        studienleistung.updateNoteKolloquium(5.0);


        //Da der Abschluss nicht bestanden wurde gibt die Notenberechnugn eine 0.0 zurück
        assertEquals(0.0,studienleistung.getNotendurchschnittAbschluss());



        studienleistung.updateNoteKolloquium(3.7);
        assertEquals(2.58, studienleistung.getNotendurchschnittAbschluss());

        assertEquals(3.01, studienleistung.getNotendurchschnittModule());

        assertEquals(2.98, studienleistung.getNotendurchschnittGesamt());

        assertEquals(165, studienleistung.getSummeCreditpointsOhneAbschluss());
        assertEquals(180, studienleistung.getSummeCreditPointsMitAbschluss());
    }

    @Test
    void durchschnittsberechnung(){
        studienleistung.updateNotePflichtmodul(TestModuleEnum.GRUNDLAGEN_DER_INFORMATIK1.label, 2.0);
        studienleistung.updateNotePflichtmodul(TestModuleEnum.BASISTECHNIKEN.label, 1.0);
        studienleistung.updateNotePflichtmodul(TestModuleEnum.RECHNERARCHITEKTUR.label, 3.0);
        studienleistung.updateNotePflichtmodul(TestModuleEnum.MATHEMATIK_FUER_INFORMATIKER1.label, 3.7);
        studienleistung.updateNotePflichtmodul(TestModuleEnum.PROGRAMMIERUNG_MIT_Cpp1.label, 2.3);

        studienleistung.updateNoteWahlmodul(WahlmodulEnum.ENGLISH1.label, 2.0);

//        studienleistung.wahlpflichtmodulHinzufuegen(Wahlpflichtfach.EINFUEHRUNG_IN_DIE_THEORETISCHE_INFORMATIK,5);
//        studienleistung.updateNoteWahlpflichtmodul(Wahlpflichtfach.EINFUEHRUNG_IN_DIE_THEORETISCHE_INFORMATIK.label,4.0);


        assertEquals(2.59, studienleistung.getNotendurchschnittModule()); //2.85 mit Einführung in die ..

        studienleistung.updateNoteBachelor(2.0);
        studienleistung.updateNoteKolloquium(2.0);

        //Darf nicht gehen, weil keine 180 CP
        assertThrows(IllegalArgumentException.class, () ->{
            studienleistung.getNotendurchschnittGesamt();
        });

    }

}
