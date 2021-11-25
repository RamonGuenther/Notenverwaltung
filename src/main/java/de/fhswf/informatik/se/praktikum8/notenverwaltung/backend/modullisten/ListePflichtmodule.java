package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;

import java.util.ArrayList;

/**
 * Die Klasse ListePflichtmodule erstellt eine Liste mit den allgemeinen
 * Pflichtmodulen für den Studiengang Informatik B.sc. an der Fachhochschule
 * Südwestfalen
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @Version 1.0 vom 23. November 2021
 */

public class ListePflichtmodule extends ArrayList {
    private static final String PFLICHTMODUL = "Pflichtmodul";

    /**
     * Der Konstruktor ListeModuleStudienrichtung füllt die Liste mit
     * den allgemeinen Pflichtmodulen.
     */
    public ListePflichtmodule(){
        add(new Pflichtmodul("Basistechniken", 5, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Grundlagen der Informatik 1", 5, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Mathematik für Informatiker 1", 5, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Programmierung mit C++ 1", 5, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Rechnerarchitektur", 5, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Vertiefung Basistechniken", 5, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Grundlagen der Infomatik 2", 5, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Mathematik für Informatiker 2", 5, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Programmierung mit C++ 2", 5, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Datenbanken 1", 5, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Betriebssysteme 1", 5, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Grundlagen der Informatik 3", 5, 3, PFLICHTMODUL));
        add(new Pflichtmodul("Java Programmierung 1", 5, 3, PFLICHTMODUL));
        add(new Pflichtmodul("Rechnernetze", 5, 3, PFLICHTMODUL));
        add(new Pflichtmodul("Internettechnologien", 5, 4, PFLICHTMODUL));
        add(new Pflichtmodul("IT-Projektmanagement", 5, 4, PFLICHTMODUL));
        add(new Pflichtmodul("Software Engineering", 5, 5, PFLICHTMODUL));
        add(new Pflichtmodul("Projektarbeit", 5, 6, PFLICHTMODUL));
    }
}
