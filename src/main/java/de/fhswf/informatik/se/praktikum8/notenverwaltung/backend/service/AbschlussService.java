package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Abschluss;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Notendurchschnitt;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    public List<Notendurchschnitt> getNotenliste(){
        Abschluss abschluss = repository.findAbschlussById(1L);
        List<Notendurchschnitt> notenListe = new ArrayList<>();
        notenListe.add(new Notendurchschnitt(
                abschluss.getBachelorarbeit().getEndNoteBachelor(),
                abschluss.getBachelorarbeit().getCreditpointsBachelorarbeit()
        ));
        notenListe.add(new Notendurchschnitt(
                abschluss.getKolloquium().getEndNoteKolloquium(),
                abschluss.getKolloquium().getCreditpointsKolloquium()
        ));
        return notenListe;
    }
}
