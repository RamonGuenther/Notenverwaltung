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
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
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
        try{
            this.semester = semester;
            this.modulname = modulname;
            bestanden = false;
            note = new Noten();
            modulart = MODULART;
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Das eingegeben Semester ist keine ganzzahlige Zahl!");
        }

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