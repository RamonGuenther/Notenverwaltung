package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Die Klasse WahlmodulService implementiert die Methoden aus dem Interface @{@link WahlmodulRepository}
 * und weitere Methoden um die Studienleistung bearbeiten zu können.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
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

    public void deleteWahlmodul(String modulname){
        if(repository.findByModulname(modulname) == null){
            throw new IllegalArgumentException("Das gewählte Wahlmodul wurde nicht gefunden.");
        }
        Wahlmodul wahlmodul = repository.findByModulname(modulname);
        repository.delete(wahlmodul);
    }

    /**
     * Die Methode holt sich das jeweilige Wahlmodul und trägt anschließend, wenn
     * alle Bedingungen zutreffen, die Note ein.
     *
     * @param note einzutragende Note
     */
    public void setNote(String modulname, Double note) {
        if(note == null){
            return;
        }

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


