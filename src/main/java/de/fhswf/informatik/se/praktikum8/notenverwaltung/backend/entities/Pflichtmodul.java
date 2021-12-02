package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Noten;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Die Klasse Pflichtmodul enthält alle wichtigen Daten zu einem
 * Pflichtmodul des Studiengangs Informatik B.sc.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
@Entity
public class Pflichtmodul{
    @Id
    private String modulname;

    private Integer creditpoints;

    @Embedded
    Noten note;

    private Integer semester;

    private String modulart;

    private boolean bestanden;


    public Pflichtmodul(String modulname, int creditpoints, int semester, String modulart) {
        this.modulname = modulname;
        this.creditpoints = creditpoints;
        this.semester = semester;
        this.modulart = modulart;
        bestanden = false;
        note = new Noten();
    }

    public Pflichtmodul() {

    }


    public String getId() {
        return modulname;
    }

    public String getModulname() {
        return modulname;
    }

    public int getCreditpoints() {
        return creditpoints;
    }

    public int getSemester() {
        return semester;
    }

    public String getModulart() {
        return modulart;
    }

    public boolean isBestanden() {
        return bestanden;
    }

    public void setBestanden(){
        bestanden = true;
    }

    public Noten getNote() {
        return note;
    }

    public String getEndNote(){
        return note.getEndNote() == 0.0 ? " " : String.valueOf(note.getEndNote());
    }
}
