package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Noten;

import javax.persistence.Embedded;
import javax.persistence.Id;

/**
 * Die Klasse Wahlpflichtmodul enthält alle wichtigen Informationen zu einem
 * Wahlpflichtmodul für den Studiengang Informatik B.sc.
 * Ein Wahlpflichtmodul entspricht einem Modul aus der Enumeration-Klasse Wahlpflichtfach.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @version 1.0 vom 20. November 2021
 */
@javax.persistence.Entity
public class Wahlpflichtmodul {

    @Id
    private String modulname;

    private Integer creditpoints;

    @Embedded
    Noten note;

    private Integer semester;

    private boolean bestanden;


    public Wahlpflichtmodul(String modulname, int semester) {
        this.modulname = modulname;
        this.creditpoints = 6;
        this.semester = semester;
        bestanden = false;
        note = new Noten();
    }

    public Wahlpflichtmodul() {

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


    public boolean isBestanden() {
        return bestanden;
    }

    public void setBestanden() {
        bestanden = true;
    }

    public Noten getNote() {
        return note;
    }
}
