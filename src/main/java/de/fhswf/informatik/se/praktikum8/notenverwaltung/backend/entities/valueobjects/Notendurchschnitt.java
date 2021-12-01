package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import java.util.ArrayList;

/**
 * Die Klasse Notendurchschnitt wird für Pflichtmodul und Wahlpflichtmodule
 * verwendet, um die bestandenen Noten mit den zugehörigen Creditpoints in einer
 * Liste zu sammeln.
 *
 * @author Ramon Günther
 * @version 1.0 vom 1. Dezember 2021
 */
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
