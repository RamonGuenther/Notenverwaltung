package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import javax.persistence.Embeddable;


/**
 * Die Klasse Note wird für Pflichtmodule, Wahlpflichtmodule
 * und Wahlmodule verwendet, um die jeweiligen Noten zu speichern.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
@Embeddable
public class Noten {

    private double note1;

    private double note2;

    private double note3;

    private double endNote;

    public Noten(){

    }

    public double getNote1() {
        return note1;
    }

    public double getNote2() {
        return note2;
    }

    public double getNote3() {
        return note3;
    }

    public double getEndNote(){ return endNote;}


    /**
     * Methode um eine Note für das jeweilige Modul zu speichern
     *
     * @param note einzutragende Note
     */
    public void setNote(Double note){
        if(note1 == 0.0) { //4
            note1 = note;
        }
        else if( note1 > 4 && note2 == 0.0) { //2
            note2 = note;
        }
        else if(note2 > 4 && note3 == 0.0) {
            note3 = note;
        }
        else {
            throw new IllegalArgumentException("Fehler in " + this.getClass().getSimpleName() +
                    ": Es wurden bereits 3 Noten eingetragen oder das Modul wurde schon bestanden! ");
        }
    }

    /**
     * Methode um die bestandene Endnote des jeweiligen Moduls zu ermitteln
     * und zu speichern
     */
    public void checkEndnote (){
        if(note1 <= 4.0) {
            endNote = note1;
        }
        else if(note2 <= 4.0) {
            endNote = note2;
        }
        else if(note3 <= 4.0) {
            endNote = note3;
        }
        else{
            endNote = 0.0;
        }
    }

}
