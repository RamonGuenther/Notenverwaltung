package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;

import java.util.ArrayList;

/**
 * Die Klasse ListePflichtmodule erstellt eine Liste mit den allgemeinen
 * Pflichtmodulen für den Studiengang Informatik B.sc. an der Fachhochschule
 * Südwestfalen
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */

public class ListePflichtmodule extends ArrayList {
    private static final String PFLICHTMODUL = "Pflichtmodul";

    /**
     * Der Konstruktor ListeModuleStudienrichtung füllt die Liste mit
     * den allgemeinen Pflichtmodulen.
     */
    public ListePflichtmodule() {
        //27
        add(new Pflichtmodul("Basistechniken", 3, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Grundlagen der Informatik 1", 5, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Mathematik für Informatiker 1", 7, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Programmierung mit C++ 1", 7, 1, PFLICHTMODUL));
        add(new Pflichtmodul("Rechnerarchitektur", 5, 1, PFLICHTMODUL));

        //35
        add(new Pflichtmodul("Vertiefung Basistechniken", 4, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Grundlagen der Informatik 2", 5, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Mathematik für Informatiker 2", 7, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Programmierung mit C++ 2", 7, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Datenbanken 1", 6, 2, PFLICHTMODUL));
        add(new Pflichtmodul("Betriebssysteme 1", 6, 2, PFLICHTMODUL));

        //16
        add(new Pflichtmodul("Grundlagen der Informatik 3", 5, 3, PFLICHTMODUL));
        add(new Pflichtmodul("Java Programmierung 1", 6, 3, PFLICHTMODUL));
        add(new Pflichtmodul("Rechnernetze", 5, 3, PFLICHTMODUL));

        //12
        add(new Pflichtmodul("Internettechnologien", 6, 4, PFLICHTMODUL));
        add(new Pflichtmodul("IT-Projektmanagement", 6, 4, PFLICHTMODUL));

        //6
        add(new Pflichtmodul("Software Engineering", 6, 5, PFLICHTMODUL));

        //9
        add(new Pflichtmodul("Projektarbeit", 9, 6, PFLICHTMODUL));
    }
}