package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import javax.persistence.Embeddable;


@Embeddable
public class Bachelorarbeit {

    private double noteBachelorarbeit1;

    private double noteBachelorarbeit2;

    private double endNoteBachelor;

    private int creditpointsBachelorarbeit;

    public Bachelorarbeit(){
        creditpointsBachelorarbeit = 12;
    }

    public int getCreditpointsBachelorarbeit() {
        return creditpointsBachelorarbeit;
    }

    private void setCreditpointsBachelorarbeit(int creditpointsBachelorarbeit) {
        this.creditpointsBachelorarbeit = creditpointsBachelorarbeit;
    }

    public double getEndNoteBachelor() {
        return endNoteBachelor;
    }

    public Double notenFaktor(){
        return endNoteBachelor * creditpointsBachelorarbeit;
    }

    public void setNote(Double note) {
        if (noteBachelorarbeit1 == 0.0) {
            noteBachelorarbeit1 = note;
        } else if (noteBachelorarbeit1 > 4 && noteBachelorarbeit2 == 0.0) {
            noteBachelorarbeit2 = note;
        } else {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Es wurden bereits 2 Noten eingetragen oder die Bachelorarbeit wurde schon bestanden!");
        }
    }

    public void checkEndnote() {
        if (noteBachelorarbeit1 <= 4.0) {
            endNoteBachelor = noteBachelorarbeit1;
        } else if (noteBachelorarbeit2 <= 4.0) {
            endNoteBachelor = noteBachelorarbeit2;
        } else {
            endNoteBachelor = 0.0;
        }
    }

}
