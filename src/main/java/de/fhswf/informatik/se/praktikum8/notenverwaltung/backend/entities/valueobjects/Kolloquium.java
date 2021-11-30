package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import javax.persistence.Embeddable;

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

    public void checkEndnote() {
        if (noteKolloquium1 <= 4.0) {
            endNoteKolloquium = noteKolloquium1;
        } else if (noteKolloquium2 <= 4.0) {
            endNoteKolloquium = noteKolloquium2;
        } else {
            endNoteKolloquium = 0.0;
        }
    }




}
