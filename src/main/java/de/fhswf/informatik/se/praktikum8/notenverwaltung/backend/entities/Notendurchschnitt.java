package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import java.util.ArrayList;

public class Notendurchschnitt extends ArrayList {

    private Double endnote;
    private Integer creditpoints;

    public Notendurchschnitt(Double endnote, Integer creditpoints){
        this.endnote = endnote;
        this.creditpoints = creditpoints;
    }

    public Integer getCreditpoints() {
        return creditpoints;
    }

    public Double getEndnote() {
        return endnote;
    }
}
