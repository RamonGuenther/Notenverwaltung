package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PflichtmodulRepository extends JpaRepository<Pflichtmodul,String> {
    List<Pflichtmodul> findAllByModulart(String modulart);
    Pflichtmodul findByModulname(String modulname);
//    List<Pflichtmodul> findAllByNoteLessThanEqual(double note);
}
