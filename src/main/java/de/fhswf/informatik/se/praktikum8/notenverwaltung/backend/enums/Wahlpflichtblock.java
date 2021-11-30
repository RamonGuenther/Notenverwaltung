package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums;

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
