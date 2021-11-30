package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Wahlpflichtmodul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WahlmodulRepository extends JpaRepository<Wahlmodul, String> {
    Wahlmodul findByModulname(String modulname);
}
