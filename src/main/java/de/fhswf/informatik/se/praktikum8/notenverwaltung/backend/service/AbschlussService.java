package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Abschluss;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.StudienleistungErgebnisliste;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Die Klasse AbschlussService implementiert primär die Methoden aus dem Interface @{@link AbschlussRepository}
 * und weitere Methoden um die Studienleistung zu bearbeiten. Diese Methoden werden alle von der Klasse
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
@Service
public class AbschlussService {

    private static final List<Double> NOTENINTERVALL = List.of(1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 5.0);

    private final AbschlussRepository repository;

    public AbschlussService(AbschlussRepository repository) {
        this.repository = repository;
    }

    public void saveAbschluss(Abschluss abschluss) {
        repository.save(abschluss);
    }

    public Abschluss findAbschluss() {
        return repository.findAbschlussById(1L);
    }

    /**
     * Die Methode holt sich das Abschluss-Objekt und trägt anschließend, wenn
     * alle Bedingungen zutreffen, die Note für den Bachelor ein.
     *
     * @param note einzutragende Note
     */
    public void setNoteBachelor(Double note) {
        if (!NOTENINTERVALL.contains(note)) {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Die Note ist nicht im Intervall.");
        }
        Abschluss abschluss = repository.findAbschlussById(1L);

        abschluss.getBachelorarbeit().setNote(note);
        abschluss.getBachelorarbeit().checkEndnote();

        repository.save(abschluss);
    }


    /**
     * Die Methode holt sich das Abschluss-Objekt und trägt anschließend, wenn
     * alle Bedingungen zutreffen, die Note für das Kolloquium ein.
     *
     * @param note einzutragende Note
     */
    public void setNoteKolloquium(Double note){
        if (!NOTENINTERVALL.contains(note)) {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Die Note ist nicht im Intervall.");
        }
        Abschluss abschluss = repository.findAbschlussById(1L);

        if(abschluss.getBachelorarbeit().getEndNoteBachelor() == 0.0 || abschluss.getBachelorarbeit().getEndNoteBachelor() > 4) {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Die Bachelorarbeit muss bestanden sein um eine Note im Kolloquium einzutragen.");
        }

        abschluss.getKolloquium().setNote(note);
        abschluss.getKolloquium().checkEndnote();

        repository.save(abschluss);
    }

    /**
     * Die Methode getNotenliste holt sich den Abschluss und prüft diesen auf bestandene
     * Noten und fügt sie der Liste hinzu.
     *
     * @return Liste der Endnoten und Creditpoints der jeweiligen Module
     */
    public List<StudienleistungErgebnisliste> getNotenliste(){
        Abschluss abschluss = repository.findAbschlussById(1L);
        List<StudienleistungErgebnisliste> notenListe = new ArrayList<>();
        if(abschluss.getBachelorarbeit().getEndNoteBachelor() != 0.0 && abschluss.getKolloquium().getEndNoteKolloquium() != 0.0) {
            notenListe.add(new StudienleistungErgebnisliste(
                    abschluss.getBachelorarbeit().getEndNoteBachelor(),
                    abschluss.getBachelorarbeit().getCreditpointsBachelorarbeit()
            ));
            notenListe.add(new StudienleistungErgebnisliste(
                    abschluss.getKolloquium().getEndNoteKolloquium(),
                    abschluss.getKolloquium().getCreditpointsKolloquium()
            ));
            return  notenListe;
        }
        else{
            return Collections.emptyList();
        }
    }
}
