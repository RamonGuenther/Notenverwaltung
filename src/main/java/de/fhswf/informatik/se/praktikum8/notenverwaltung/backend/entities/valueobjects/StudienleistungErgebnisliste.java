package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects;

import java.util.ArrayList;

/**
 * Die Klasse StudienleistungErgebnisliste wird für Pflichtmodul und Wahlpflichtmodule
 * verwendet, um die bestandenen Noten mit den zugehörigen Creditpoints in einer
 * Liste zu sammeln.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
public class StudienleistungErgebnisliste extends ArrayList {

    private Double endnote;
    private Integer creditpoints;

    public StudienleistungErgebnisliste(Double endnote, Integer creditpoints){
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
