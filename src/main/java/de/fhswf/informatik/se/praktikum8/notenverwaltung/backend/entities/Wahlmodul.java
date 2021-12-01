package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Noten;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Die Klasse Wahlmodul enthält alle wichtigen Daten zu einem
 * Wahlmodul des Studiengangs Informatik B.sc.
 *
 * @author Ramon Günther
 * @version 1.1 vom 1. Dezember 2021
 */
@Entity
public class Wahlmodul{

    @Id
    private String modulname;

    @Embedded
    Noten note;

    private Integer semester;

    private boolean bestanden;

    private String modulart;

    @Transient
    private final static String MODULART = "Wahlmodul";

    public Wahlmodul(String modulname, int semester) {
        this.modulname = modulname;
        this.semester = semester;
        bestanden = false;
        note = new Noten();
        modulart = MODULART;
    }

    public Wahlmodul() {

    }

    public String getModulname() {
        return modulname;
    }

    public Noten getNote() {
        return note;
    }

    public Integer getSemester() {
        return semester;
    }

    public boolean isBestanden() {
        return bestanden;
    }

    public void setBestanden() {
        bestanden = true;
    }

    public String getModulart() {
        return modulart;
    }

    public String getEndNote(){
        return note.getEndNote() == 0.0 ? " " : String.valueOf(note.getEndNote());
    }
}