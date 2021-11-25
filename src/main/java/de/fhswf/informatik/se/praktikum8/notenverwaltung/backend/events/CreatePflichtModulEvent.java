package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.events;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.dao.PflichtmodulDao;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.exceptions.DuplicateEntityException;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.input.CreatePflichtModulInput;

public class CreatePflichtModulEvent {

    private final CreatePflichtModulInput input;

    private final PflichtmodulDao dao;

    private Pflichtmodul pflichtmodul;

    public CreatePflichtModulEvent(CreatePflichtModulInput input, PflichtmodulDao dao) {
        this.input = input;
        this.dao = dao;
    }

    public void execute() throws DuplicateEntityException{
        pflichtmodul = new Pflichtmodul(
                input.getModulname(),
                input.getCreditpoints(),
                input.getSemester(),
                input.getModulart()
        );

        dao.save(pflichtmodul);
    }
}
