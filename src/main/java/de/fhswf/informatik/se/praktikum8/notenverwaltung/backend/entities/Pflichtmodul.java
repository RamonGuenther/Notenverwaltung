package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Noten;

import javax.persistence.Embedded;
import javax.persistence.Id;


@javax.persistence.Entity
public class Pflichtmodul{
    @Id
    private String modulname;

    private Integer creditpoints;

    @Embedded
    private Noten note;

    private Integer semester;
    private boolean bestanden;
    private String modulart;

    public Noten getNote() {
        return note;
    }

    public Pflichtmodul(String modulname, int creditpoints, int semester, String modulart) {
        this.modulname = modulname;
        this.creditpoints = creditpoints;
        this.semester = semester;
        this.modulart = modulart;
        note = new Noten();
        bestanden = false; //=????
    }

    public Pflichtmodul() {
        note = new Noten();
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

    public String getModulart() {
        return modulart;
    }
}
