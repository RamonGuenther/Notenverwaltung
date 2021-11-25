package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Entity;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.exceptions.DuplicateEntityException;

public interface EntityRepository <I, E extends Entity<I>> {
//    Optional<E> findOne(I id);

    E save(E entity) throws DuplicateEntityException;
}