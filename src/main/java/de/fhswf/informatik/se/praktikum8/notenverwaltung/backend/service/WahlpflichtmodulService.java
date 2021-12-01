package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Notendurchschnitt;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WahlpflichtmodulService {

    private final WahlpflichtmodulRepository repository;

    private static final List<Double> NOTENINTERVALL = List.of(1.0, 1.3, 1.7, 2.0, 2.3,2.7,3.0,3.3,3.7,4.0,5.0);

    public WahlpflichtmodulService(WahlpflichtmodulRepository repository) {
        this.repository = repository;
    }

    public void saveWahlpflichtmodul(Wahlpflichtmodul wahlpflichtmodul){
        repository.save(wahlpflichtmodul);
    }

    public Wahlpflichtmodul findByModulname(String modulname){
        return repository.findByModulname(modulname);
    }

    public List<Wahlpflichtmodul> findAllWahlpflichtModule(){
        return repository.findAll();
    }

    public List<Wahlpflichtmodul> findAllBestandeneWahlpflichtmodule(){return repository.findAllByBestandenIsTrue();}

    public List<Wahlpflichtmodul> findAllOffeneWahlpflichtmodule(){return repository.findAllByBestandenIsFalse();}

    public void deleteWahlpflichtmodul(String modulname){
        Wahlpflichtmodul wahlpflichtmodul = repository.findByModulname(modulname);
        repository.delete(wahlpflichtmodul);
    }

    public void setNote(String modulname, Double note){

        if(note == null){
            return;
        }
        if(!NOTENINTERVALL.contains(note)) {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Die Note ist nicht im Intervall.");
        }
        Wahlpflichtmodul wahlpflichtmodul = repository.findByModulname(modulname);

        if(wahlpflichtmodul == null){
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Das gesuchte Modul wurde nicht gefunden.");
        }
        if (note <= 4) {
            wahlpflichtmodul.setBestanden();
        }
        wahlpflichtmodul.getNote().setNote(note);
        wahlpflichtmodul.getNote().checkEndnote();
        repository.save(wahlpflichtmodul);
    }

    public List<Notendurchschnitt> getNotenliste(){
        List<Wahlpflichtmodul> test = repository.findAll();
        List<Notendurchschnitt> notenListe = new ArrayList<>();
        for(Wahlpflichtmodul wahlpflichtmodul : test){
            if(wahlpflichtmodul.getNote().getEndNote() != 0.0) {
                notenListe.add(new Notendurchschnitt(
                        wahlpflichtmodul.getNote().getEndNote(),
                        wahlpflichtmodul.getCreditpoints()
                ));
            }
        }
        return notenListe;
    }
}
