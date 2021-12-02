package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums;

public enum TestModuleEnum {
    BASISTECHNIKEN ("Basistechniken"),
    GRUNDLAGEN_DER_INFORMATIK1 ("Grundlagen der Informatik 1"),
    MATHEMATIK_FUER_INFORMATIKER1 ("Mathematik für Informatiker 1"),
    PROGRAMMIERUNG_MIT_Cpp1 ("Programmierung mit C++ 1"),
    RECHNERARCHITEKTUR ("Rechnerarchitektur"),

    VERTIEFUNG_BASISTECHNIKEN ("Vertiefung Basistechniken"),
    GRUNDLAGEN_DER_INFORMATIK2 ("Grundlagen der Informatik 2"),
    MATHEMATIK_FUER_INFORMATIKER2 ("Mathematik für Informatiker 2"),
    PROGRAMMIERUNG_MIT_Cpp2 ("Programmierung mit C++ 2"),
    DATENBANKEN1 ("Datenbanken 1"),
    BETRIEBSSYSTEME1 ("Betriebssysteme 1"),

    GRUNDLAGEN_DER_INFORMATIK3 ("Grundlagen der Informatik 3"),
    JAVA_PROGRAMMIERUNG1 ("Java Programmierung 1"),
    RECHNERNETZE ("Rechnernetze"),

    INTERNETTECHNOLOGIEN("Internettechnologien"),
    IT_PROJEKTMANAGEMENT("IT-Projektmanagement"),

    SOFTWARE_ENGINEERING("Software Engineering"),
    PROJEKTARBEIT ("Projektarbeit"),

    RECHNUNGSWESEN1 ("Rechnungswesen 1"),
    RECHNUNGSWESEN2 ("Rechnungswesen 2"),
    BETRIEBSWIRTSCHAFT("Betriebswirtschaft"),
    DATENBANKEN2("Datenbanken 2 "),
    EFFIZIENTE_ALGORITHMEN("Effiziente Algorithmen"),
    FORTGESCHRITTENE_INTERNETTECHNOLOGIEN("Fortgeschrittene Internettechnologien"),
    MOBILE_APPLIKATIONEN ("Mobile Applikationen"),
    JAVA_PROGRAMMIERUNG2("Java Programmierung 2");

    public final String label;

    TestModuleEnum(String label) {
        this.label = label;
    }

}
