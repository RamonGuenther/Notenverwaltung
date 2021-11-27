package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PflichtmodulService {

    private PflichtmodulRepository repository;

    public PflichtmodulService(PflichtmodulRepository repository) {
        this.repository = repository;
    }

    public void savePflichtmodule(List<Pflichtmodul> pflichtmodulList){
        repository.saveAll(pflichtmodulList);
    }

    public Pflichtmodul findByModulname(String modulname){
       return repository.findByModulname(modulname);
    }

    public List<Pflichtmodul> findAllPflichtModule(String s){
        return repository.findAllByModulart(s);
    }

    public void setNote(String modulname, double note){
        Pflichtmodul pflichtmodul = repository.findByModulname(modulname);
        pflichtmodul.getNote().setNote1(note);
        repository.save(pflichtmodul);
    }

//    public List<Pflichtmodul> findByNote(double note){
//        return repository.findAllByNoteLessThanEqual(note);
//    }

}
