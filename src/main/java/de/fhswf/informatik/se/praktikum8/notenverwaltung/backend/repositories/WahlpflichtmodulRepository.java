package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WahlpflichtmodulRepository extends JpaRepository<Wahlpflichtmodul, String> {
    Wahlpflichtmodul findByModulname(String modulname);
    List<Wahlpflichtmodul> findAllByBestandenIsTrue();
    List<Wahlpflichtmodul> findAllByBestandenIsFalse();
}

