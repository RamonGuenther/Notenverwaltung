package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Abschluss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbschlussRepository extends JpaRepository<Abschluss,Long> {
    Abschluss findAbschlussById(Long id);
}
