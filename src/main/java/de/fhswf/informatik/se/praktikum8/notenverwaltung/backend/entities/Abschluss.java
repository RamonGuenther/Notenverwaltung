package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Bachelorarbeit;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Kolloquium;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


/**
 * Die Klasse Abschluss enthält die einzelnen Studienleistungen für die
 * Bachelorarbeit und das Kolloquium des Studenten.
 *
 * @author Ramon Günther
 * @version 1.0 vom 1. Dezember 2021
 */
@Entity
public class Abschluss {

    @Id
    private Long id;

    @Embedded
    private Bachelorarbeit bachelorarbeit;

    @Embedded
    private Kolloquium kolloquium;

    private Studienrichtung studienrichtung;

    private Wahlpflichtblock wahlpflichtblock;

    @Transient
    private final static Long ID = 1L;


    public Abschluss() {
        id = ID;
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

    public Studienrichtung getStudienrichtung() {
        return studienrichtung;
    }

    public Wahlpflichtblock getWahlpflichtblock() {
        return wahlpflichtblock;
    }

    public void setStudienrichtung(Studienrichtung studienrichtung) {
        this.studienrichtung = studienrichtung;
    }

    public void setWahlpflichtblock(Wahlpflichtblock wahlpflichtblock) {
        this.wahlpflichtblock = wahlpflichtblock;
    }
}
