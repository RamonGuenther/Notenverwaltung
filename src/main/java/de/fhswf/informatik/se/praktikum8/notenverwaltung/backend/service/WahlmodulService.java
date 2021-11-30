package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WahlmodulService {

    private static final List<Double> NOTENINTERVALL = List.of(1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 5.0);

    private final WahlmodulRepository repository;

    public WahlmodulService(WahlmodulRepository repository) {
        this.repository = repository;
    }

    public void saveWahlmodul(Wahlmodul wahlmodul) {
        repository.save(wahlmodul);
    }

    public Wahlmodul findByModulname(String modulname) {
        return repository.findByModulname(modulname);
    }

    public List<Wahlmodul> findAllWahlmodule() {
        return repository.findAll();
    }

    public void setNote(String modulname, Double note) {
        if (!NOTENINTERVALL.contains(note)) {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Die Note ist nicht im Intervall.");
        }
        Wahlmodul wahlmodul = repository.findByModulname(modulname);
        if(wahlmodul == null){
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Das gesuchte Modul wurde nicht gefunden.");
        }
        if (note <= 4) {
            wahlmodul.setBestanden();
        }
        wahlmodul.getNote().setNote(note);
        wahlmodul.getNote().checkEndnote();
        repository.save(wahlmodul);
    }
}


