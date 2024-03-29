package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import javax.persistence.Embeddable;

/**
 * Die Klasse Bachelorarbeit ist ein Bestandteil der Klasse Abschluss und
 * enthält die Studienleistungen der Bachelorarbeit.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
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

    /**
     * Methode um eine Note für den Bachelor zu speichern.
     *
     * @param note einzutragene Note
     */
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

    /**
     * Methode um die bestandene Endnote der Bachelorarbeit zu ermitteln
     * und zu speichern.
     */
    public void checkEndnote() {
        if (noteBachelorarbeit1 <= 4.0) {
            endNoteBachelor = noteBachelorarbeit1;
        } else if (noteBachelorarbeit2 <= 4.0) {
            endNoteBachelor = noteBachelorarbeit2;
        } else {
            endNoteBachelor = 0.0;
        }
    }

    public double getNoteBachelorarbeit1() {
        return noteBachelorarbeit1;
    }

    public void setNoteBachelorarbeit1(double noteBachelorarbeit1) {
        this.noteBachelorarbeit1 = noteBachelorarbeit1;
    }

    public double getNoteBachelorarbeit2() {
        return noteBachelorarbeit2;
    }

    public void setNoteBachelorarbeit2(double noteBachelorarbeit2) {
        this.noteBachelorarbeit2 = noteBachelorarbeit2;
    }
}
