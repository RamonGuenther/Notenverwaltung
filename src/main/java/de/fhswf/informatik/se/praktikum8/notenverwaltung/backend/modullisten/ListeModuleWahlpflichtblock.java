package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten;



import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;

import java.util.ArrayList;

/**
 * Die Klasse ListeModuleWahlpflichtblock erstellt eine Liste mit den Pflicht-
 * modulen des vom Studenten gewählten Wahlpflichtblocks.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */

public class ListeModuleWahlpflichtblock extends ArrayList {

    private static final String WAHLPFLICHTBLOCK = Wahlpflichtblock.class.getSimpleName();

    /**
     * Der Konstruktor ListeModuleWahlpflichtblock füllt die Liste mit
     * den Pflichtmodulen für die vom Studenten gewählte Studienrichtung
     *
     * @param wahlpflichtblock  Der vom Studenten gewählte Wahlpflichtblock
     */

    public ListeModuleWahlpflichtblock (Wahlpflichtblock wahlpflichtblock) {
//18
        switch (wahlpflichtblock){
            case KUENSTLICHE_INTELLIGENZ:
                add(new Pflichtmodul("Datenbanken 2", 6, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Einführung Machine Learning", 6, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Deep Learning", 6, 5, WAHLPFLICHTBLOCK));
                break;
            case UMWELTINFORMATIK:
                add(new Pflichtmodul("Mensch und Umwelt", 6, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Umweltinformationssysteme", 6, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Systembiologie", 6, 5, WAHLPFLICHTBLOCK));
                break;
            case SYSTEMINTEGRATION:
                add(new Pflichtmodul("Betriebssysteme 2", 6, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Rechnernetze 2", 6, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Skriptsprachen", 6, 5, WAHLPFLICHTBLOCK));
                break;
            case ANWENDUNGSENTWICKLUNG:
                add(new Pflichtmodul("Datenbanken 2", 6, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Java Programmierung 2", 6, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Effiziente Algorithmen", 6, 5, WAHLPFLICHTBLOCK));
                break;
            case MEDIENDESIGN:
                add(new Pflichtmodul("Grundlagen Grafikdesign", 6, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Grundlagen Audiovisuelles Mediendesign", 6, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Digital and Social Media Marketing", 6, 5, WAHLPFLICHTBLOCK));
                break;
            case WIRTSCHAFT:
                add(new Pflichtmodul("Betriebswirtschaft", 6, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Rechnungswesen 1", 6, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Rechnungswesen 2", 6, 5, WAHLPFLICHTBLOCK));
                break;
        }
    }
}