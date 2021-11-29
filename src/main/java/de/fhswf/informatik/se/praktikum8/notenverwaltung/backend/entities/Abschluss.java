package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Bachelorarbeit;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Kolloquium;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Abschluss {

    @Id
    private Long id;

    @Embedded
    private Bachelorarbeit bachelorarbeit;

    @Embedded
    private Kolloquium kolloquium;

    public Abschluss() {
        id=1L;
        bachelorarbeit = new Bachelorarbeit();
        kolloquium = new Kolloquium();
    }

    public Long getId() {
        return id;
    }

    public Bachelorarbeit getBachelorarbeit() {
        return bachelorarbeit;
    }

    public Kolloquium getKolloquium() {
        return kolloquium;
    }
}
