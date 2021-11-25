package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten;



import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;

import java.util.ArrayList;

/**
 * Die Klasse ListeModuleWahlpflichtblock erstellt eine Liste mit den Pflicht-
 * modulen des vom Studenten gewählten Wahlpflichtblocks.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @Version 1.0 vom 23. November 2021
 */

public class ListeModuleWahlpflichtblock extends ArrayList {

    private static final String WAHLPFLICHTBLOCK = Wahlpflichtblock.class.getSimpleName();

    /**
     * Der Konstruktor ListeModuleWahlpflichtblock füllt die Liste mit
     * den Pflichtmodulen für die vom Studenten gewählte Studienrichtung
     *
     * @param wahlpflichtblock  Der vom Studenten gewählte Wahlpflichtblock
     */

    public ListeModuleWahlpflichtblock (Wahlpflichtblock wahlpflichtblock){

        switch (wahlpflichtblock){
            case KUENSTLICHE_INTELLIGENZ:
                add(new Pflichtmodul("Datenbanken 2", 3, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Einführung Machine Learning", 4, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Deep Learning", 4, 5, WAHLPFLICHTBLOCK));
                break;
            case UMWELTINFORMATIK:
                add(new Pflichtmodul("Mensch und Umwelt", 4, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Umweltinformationssysteme", 4, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Systembiologie", 4, 5, WAHLPFLICHTBLOCK));
                break;
            case SYSTEMINTEGRATION:
                add(new Pflichtmodul("Betriebssysteme 2", 3, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Rechnernetze 2", 4, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Skriptsprachen", 4, 5, WAHLPFLICHTBLOCK));
                break;
            case ANWENDUNGSENTWICKLUNG:
                add(new Pflichtmodul("Datenbanken 2", 3, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Java Programmierung 2", 4, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Effiziente Algorithmen", 4, 5, WAHLPFLICHTBLOCK));
                break;
            case MEDIENDESIGN:
                add(new Pflichtmodul("Grundlagen Grafikdesign", 3, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Grundlagen Audiovisuelles Mediendesign", 4, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Digital and Social Media Marketing", 4, 5, WAHLPFLICHTBLOCK));
                break;
            case WIRTSCHAFT:
                add(new Pflichtmodul("Betriebswirtschaft", 3, 3, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Rechnungswesen 1", 4, 4, WAHLPFLICHTBLOCK));
                add(new Pflichtmodul("Rechnungswesen 2", 4, 5, WAHLPFLICHTBLOCK));
                break;
        }
    }
}
