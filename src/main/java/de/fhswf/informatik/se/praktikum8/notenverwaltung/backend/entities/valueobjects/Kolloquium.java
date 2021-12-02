package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import javax.persistence.Embeddable;

/**
 * Die Klasse Bachelorarbeit ist ein Bestandteil der Klasse Abschluss und
 * enthält die Studienleistungen des Kolloquium.
 *
 * @author Ramon Günther
 * @version 1.0 vom 1. Dezember 2021
 */
@Embeddable
public class Kolloquium {

    private double noteKolloquium1;

    private double noteKolloquium2;

    private double endNoteKolloquium;

    private int creditpointsKolloquium;

    public Kolloquium() {
        creditpointsKolloquium = 3;
    }

    public int getCreditpointsKolloquium() {
        return creditpointsKolloquium;
    }

    public void setCreditpointsKolloquium(int creditpointsKolloquium) {
        this.creditpointsKolloquium = creditpointsKolloquium;
    }

    public double getEndNoteKolloquium() {
        return endNoteKolloquium;
    }

    public Double notenFaktor(){
        return endNoteKolloquium * creditpointsKolloquium;
    }

    /**
     * Methode um eine Note für das Kolloquium zu speichern.
     *
     * @param note einzutragene Note
     */
    public void setNote(Double note) {
        if (noteKolloquium1 == 0.0) {
            noteKolloquium1 = note;
        } else if (noteKolloquium1 > 4 && noteKolloquium2 == 0.0) {
            noteKolloquium2 = note;
        } else {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Es wurden bereits 2 Noten eingetragen oder das Kolloquium wurde schon bestanden!");
        }
    }

    /**
     * Methode um die bestandene Endnote der Bachelorarbeit zu ermitteln
     * und zu speichern.
     */
    public void checkEndnote() {
        if (noteKolloquium1 <= 4.0) {
            endNoteKolloquium = noteKolloquium1;
        } else if (noteKolloquium2 <= 4.0) {
            endNoteKolloquium = noteKolloquium2;
        } else {
            endNoteKolloquium = 0.0;
        }
    }

    public double getNoteKolloquium1() {
        return noteKolloquium1;
    }

    public void setNoteKolloquium1(double noteKolloquium1) {
        this.noteKolloquium1 = noteKolloquium1;
    }

    public double getNoteKolloquium2() {
        return noteKolloquium2;
    }

    public void setNoteKolloquium2(double noteKolloquium2) {
        this.noteKolloquium2 = noteKolloquium2;
    }
}
