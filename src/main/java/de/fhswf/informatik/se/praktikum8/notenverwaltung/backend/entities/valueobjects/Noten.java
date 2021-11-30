package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import javax.persistence.Embeddable;

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

    public void setEndNote(Double endNote){ this.endNote = endNote;}

    public void setNote(Double note){
        if(note1 == 0.0) {
            note1 = note;
        }
        else if( note1 > 4 && note2 == 0.0) {
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
