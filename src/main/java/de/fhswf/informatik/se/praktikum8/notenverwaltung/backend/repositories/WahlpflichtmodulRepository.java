package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WahlpflichtmodulRepository extends JpaRepository<Wahlpflichtmodul, String> {
    Wahlpflichtmodul findByModulname(String modulname);
//    List<Pflichtmodul> findAllByNote_EndGreaterThanEqualAndLessThanEqual(double start, double note);
}

