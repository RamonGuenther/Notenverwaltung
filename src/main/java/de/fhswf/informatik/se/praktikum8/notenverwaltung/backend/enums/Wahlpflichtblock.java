package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums;

/**
 * Die Enumeration Wahlpflichtblock enthält alle möglichen Wahlpflichtblöcke
 * für den Studiengang Informatik B.sc. der Fachhochschule Südwestfalen nach FPO 2019.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
public enum Wahlpflichtblock {
    ANWENDUNGSENTWICKLUNG ("Anwendungsentwicklung"),
    SYSTEMINTEGRATION ("Systemintegration"),
    UMWELTINFORMATIK ("Umweltinformatik"),
    KUENSTLICHE_INTELLIGENZ ("Künstliche Intelligenz"),
    MEDIENDESIGN ("Mediendesign"),
    WIRTSCHAFT ("Wirtschaft");

    public final String label;

    Wahlpflichtblock(String label) {
        this.label = label;
    }
}
