package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.dao;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Entity;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.exceptions.DuplicateEntityException;

import java.util.Optional;

public interface Dao<I,E extends Entity<I>> {
    Optional<E> findOne(I id);
    void save (E entity) throws DuplicateEntityException;
}
