package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Noten;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wahlmodul{

    @Id
    private String modulname;

    @Embedded
    Noten note;

    private Integer semester;

    private boolean bestanden;

    public Wahlmodul(String modulname, int semester) {
        this.modulname = modulname;
        this.semester = semester;
        bestanden = false;
        note = new Noten();
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
}