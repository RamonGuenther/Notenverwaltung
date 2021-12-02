package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums;

/**
 * Die Enumeration Wahlmodul enthält alle möglichen Wahlmodule
 * für den Studiengang Informatik B.sc. der Fachhochschule Südwestfalen nach BPO 2013.
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 */
public enum WahlmodulEnum {

    BIONIK("Bionik"),
    ENGLISH1("English 1"),
    ENGLISH2("English 2"),
    ADVANCED_ENGLISH("Advanced English"),
    KARRIERETRAINING("Karrieretraining");

    public final String label;

    WahlmodulEnum(String label) {
        this.label = label;
    }
}
