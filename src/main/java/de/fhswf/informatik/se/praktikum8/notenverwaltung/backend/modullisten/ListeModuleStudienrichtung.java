package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten;



import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;

import java.util.ArrayList;

/**
 * Die Klasse ListeModuleStudienrichtung erstellt eine Liste mit den Pflicht-
 * modulen der vom Studenten gewählten Studienrichtung.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @Version 1.0 vom 23. November 2021
 */
public class ListeModuleStudienrichtung extends ArrayList {

    private static final String STUDIENRICHTUNG = Studienrichtung.class.getSimpleName();

    /**
     * Der Konstruktor ListeModuleStudienrichtung füllt die Liste mit
     * den Pflichtmodulen für die vom Studenten gewählte Studienrichtung
     *
     * @param studienrichtung   Die vom Studenten gewählte Studienrichtung
     */

    public ListeModuleStudienrichtung(Studienrichtung studienrichtung) {
//30
        switch (studienrichtung) {
            case ANWENDUNGSENTWICKLUNG -> {
                add(new Pflichtmodul("Datenbanken 2", 6, 3, STUDIENRICHTUNG));
                add(new Pflichtmodul("Effiziente Algorithmen", 6, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Java Programmierung 2", 6, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Mobile Applikationen", 6, 5, STUDIENRICHTUNG));
                add(new Pflichtmodul("Fortgeschrittene Internettechnologien", 6, 5, STUDIENRICHTUNG));
            }
            case KUENSTLICHE_INTELLIGENZ -> {
                add(new Pflichtmodul("Datenbanken 2", 6, 3, STUDIENRICHTUNG));
                add(new Pflichtmodul("Einführung Machine Learning", 6, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Skriptsprachen", 6, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Natural Language Processing", 6, 5, STUDIENRICHTUNG));
                add(new Pflichtmodul("Deep Learning", 6, 5, STUDIENRICHTUNG));
            }
            case UMWELTINFORMATIK -> {
                add(new Pflichtmodul("Allgemeine Chemie", 6, 3, STUDIENRICHTUNG));
                add(new Pflichtmodul("Mensch und Umwelt", 6, 3, STUDIENRICHTUNG));
                add(new Pflichtmodul("Ökosysteme", 6,4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Umweltinformationssysteme", 6, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Systembiologie", 6, 5, STUDIENRICHTUNG));
            }
            case SYSTEMINTEGRATION -> {
                add(new Pflichtmodul("Betriebssysteme 2", 6, 3, STUDIENRICHTUNG));
                add(new Pflichtmodul("Betriebssysteme 3", 6, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Rechnernetze 2", 6, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Skriptsprachen", 6, 5, STUDIENRICHTUNG));
                add(new Pflichtmodul("Virtualisierung", 6, 5, STUDIENRICHTUNG));
            }
        }
    }
}
