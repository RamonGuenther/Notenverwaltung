package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PflichtmodulRepostory extends EntityRepository<String, Pflichtmodul>, JpaRepository<Pflichtmodul,String> {
    Pflichtmodul save (Pflichtmodul pflichtmodul);
}
