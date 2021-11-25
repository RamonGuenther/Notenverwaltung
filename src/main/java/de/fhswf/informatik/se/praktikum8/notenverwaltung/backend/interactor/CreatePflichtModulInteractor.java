package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.interactor;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.dao.PflichtmodulDao;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.events.CreatePflichtModulEvent;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.exceptions.DuplicateEntityException;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.input.CreatePflichtModulInput;

public class CreatePflichtModulInteractor {

    private final CreatePflichtModulInput input;

    private final PflichtmodulDao pflichtmodulDao;

    public CreatePflichtModulInteractor(CreatePflichtModulInput input, PflichtmodulDao pflichtmodulDao) {
        this.input = input;
        this.pflichtmodulDao = pflichtmodulDao;
    }

    public void createPflichtmodul() throws DuplicateEntityException{
        CreatePflichtModulEvent event = new CreatePflichtModulEvent(input,pflichtmodulDao);
        event.execute();
    }
}
