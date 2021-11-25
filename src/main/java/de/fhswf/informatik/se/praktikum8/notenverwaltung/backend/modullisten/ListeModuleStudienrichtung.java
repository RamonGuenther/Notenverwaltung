package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten;



import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Die Klasse ListeModuleStudienrichtung erstellt eine Liste mit den Pflicht-
 * modulen der vom Studenten gewählten Studienrichtung.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @Version 1.0 vom 23. November 2021
 */
public class ListeModuleStudienrichtung extends ArrayList {

    @Autowired
    private PflichtmodulRepostory repostory;

    private static final String STUDIENRICHTUNG = Studienrichtung.class.getSimpleName();

    /**
     * Der Konstruktor ListeModuleStudienrichtung füllt die Liste mit
     * den Pflichtmodulen für die vom Studenten gewählte Studienrichtung
     *
     * @param studienrichtung   Die vom Studenten gewählte Studienrichtung
     */

    public ListeModuleStudienrichtung(Studienrichtung studienrichtung) {

        switch (studienrichtung){
            case KUENSTLICHE_INTELLIGENZ:
                repostory.save(new Pflichtmodul("Datenbanken 2", 3, 3, STUDIENRICHTUNG));
                repostory.save(new Pflichtmodul("Einführung Machine Learning", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Skriptsprachen", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Natural Language Processing", 4, 5,STUDIENRICHTUNG));
                add(new Pflichtmodul("Deep Learning", 4, 5,STUDIENRICHTUNG));
                break;
            case UMWELTINFORMATIK:
                add(new Pflichtmodul("Allgemeine Chemie", 3, 3,STUDIENRICHTUNG));
                add(new Pflichtmodul("Mensch und Umwelt", 4, 3,  STUDIENRICHTUNG));
                add(new Pflichtmodul("Ökosysteme", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Umweltinformationssysteme", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Systembiologie", 4, 5, STUDIENRICHTUNG));
                break;
            case SYSTEMINTEGRATION:
                add(new Pflichtmodul("Betriebssysteme 2", 3, 3, STUDIENRICHTUNG));
                add(new Pflichtmodul("Betriebssysteme 3", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Rechnernetze 2", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Skriptsprachen", 4, 5, STUDIENRICHTUNG));
                add(new Pflichtmodul("Virtualisierung", 4, 5, STUDIENRICHTUNG));
                break;
            case ANWENDUNGSENTWICKLUNG:
                add(new Pflichtmodul("Datenbanken 2", 3, 3, STUDIENRICHTUNG));
                add(new Pflichtmodul("Effiziente Algorithmen", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Java Programmierung 2", 4, 4, STUDIENRICHTUNG));
                add(new Pflichtmodul("Mobile Applikationen", 4, 5, STUDIENRICHTUNG));
                add(new Pflichtmodul("Fortgeschrittene Internettechnologien", 4, 5, STUDIENRICHTUNG));
                break;
        }
    }
}
