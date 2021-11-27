package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;


import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.Embeddable;

@Embeddable
public class Noten {

    private Double note1;

    private Double note2;

    private Double note3;

    public Noten() {
        note1 = null;
        note2 = null;
        note3 = null;
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

    public void setNote1(Double note1) {
        this.note1 = note1;
    }

    public void setNote2(Double note2) {
//        if(note1 == null || note1 < 4){
//            throw new IllegalArgumentException("Note");
//        }
        this.note2 = note2;
    }

    public void setNote3(Double note3) {
//        if(note1 == null || note2 == null){
//
//        }
//        if(note1 <4 || note2 < 4){
//
//        }
        this.note3 = note3;
    }

}
