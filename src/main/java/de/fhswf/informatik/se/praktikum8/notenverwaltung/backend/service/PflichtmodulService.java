package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Notendurchschnitt;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PflichtmodulService {

    private static final List<Double> NOTENINTERVALL = List.of(1.0, 1.3, 1.7, 2.0, 2.3,2.7,3.0,3.3,3.7,4.0,5.0);

    public static final String WAHLPFLICHTBLOCK = "Wahlpflichtblock";

    public static final String STUDIENRICHTUNG = "Studienrichtung";

    private final PflichtmodulRepository repository;

    public PflichtmodulService(PflichtmodulRepository repository) {
        this.repository = repository;
    }

    public void savePflichtmodule(List<Pflichtmodul> pflichtmodulList){
        repository.saveAll(pflichtmodulList);
    }

    public Pflichtmodul findByModulname(String modulname){
       return repository.findByModulname(modulname);
    }

    public List<Pflichtmodul> findAllPflichtModule(){
        return repository.findAll();
    }

    public List<Pflichtmodul> findAllBestandenePflichtmodule(){return repository.findAllByBestandenIsTrue();}

    public List<Pflichtmodul> findAllOffenePflichtmodule(){return repository.findAllByBestandenIsFalse();}

    public void deleteAllByWahlpflichtblock(){
        if(repository.findAllByModulart(WAHLPFLICHTBLOCK).isEmpty()){
            throw new IllegalArgumentException("Es wurden keine Module vom Typ Wahlpflichtblock gefunden.");
        }
        repository.deleteAllByModulart(WAHLPFLICHTBLOCK);
    }

    public void deleteAllByStudienrichtung(){
        if(repository.findAllByModulart(STUDIENRICHTUNG).isEmpty()){
            throw new IllegalArgumentException("Es wurden keine Module vom Typ Studienrichtung gefunden.");
        }
        repository.deleteAllByModulart(STUDIENRICHTUNG);
    }


    public void setNote(String modulname, Double note){
        if(note == null){
            return;
        }

        if(!NOTENINTERVALL.contains(note)) {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Die Note ist nicht im Intervall.");
        }

        Pflichtmodul pflichtmodul = repository.findByModulname(modulname);

        if(pflichtmodul == null){
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Das gesuchte Modul wurde nicht gefunden.");
        }
        if(note <= 4){
            pflichtmodul.setBestanden();
        }
        pflichtmodul.getNote().setNote(note);
        pflichtmodul.getNote().checkEndnote();
        repository.save(pflichtmodul);
    }

    public List<Notendurchschnitt> getNotenliste(){
        List<Pflichtmodul> test = repository.findAll();
        List<Notendurchschnitt> notenListe = new ArrayList<>();
        for(Pflichtmodul pflichtmodul : test){
            if(pflichtmodul.getNote().getEndNote() != 0.0) {
                notenListe.add(new Notendurchschnitt(
                        pflichtmodul.getNote().getEndNote(),
                        pflichtmodul.getCreditpoints()
                ));
            }
        }
        return notenListe;
    }
}
