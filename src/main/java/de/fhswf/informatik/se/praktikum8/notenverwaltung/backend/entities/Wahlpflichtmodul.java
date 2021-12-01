package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Noten;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Die Klasse Wahlpflichtmodul enthält alle wichtigen Informationen zu einem
 * Wahlpflichtmodul für den Studiengang Informatik B.sc.
 *
 * @author Ramon Günther
 * @version 1.0 vom 1. Dezember 2021
 */
@Entity
public class Wahlpflichtmodul {

    @Id
    private String modulname;

    private Integer creditpoints;

    @Embedded
    Noten note;

    private Integer semester;

    private String modulart;

    private boolean bestanden;


    @Transient
    private final static String MODULART = "Wahlpflichtmodul";


    public Wahlpflichtmodul(String modulname, int semester) {
        try{
            this.semester = semester;
            this.modulname = modulname;
            this.creditpoints = 6;
            bestanden = false;
            modulart = MODULART;
            note = new Noten();
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Das eingegeben Semester ist keine ganzzahlige Zahl!");
        }
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

    public String getModulart() {
        return modulart;
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

    //TODO: ENTFERNEN DENTE NUR FÜR TESTS
    public void setModulart(String modulart) {
        this.modulart = modulart;
    }

    public String getEndNote(){
        return note.getEndNote() == 0.0 ? " " : String.valueOf(note.getEndNote());
    }
}
