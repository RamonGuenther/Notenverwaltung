package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums;

/**
 * Die Enumeration Wahlpflichtfach enthält alle möglichen Wahlpflichtmodule
 * für den Studiengang Informatik B.sc. der Fachhochschule Südwestfalen BPO2019.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @version 1.1 vom 22. November 2021
 */
public enum Wahlpflichtfach {
	PRAKTISCHE_ANWENDUNG_VON_ALGORITHMEN ("Praktische Anwendung von Algorithmen"),
	GEOINFORMATIK ("Geoinformatik"),
	GRUNDLAGEN_DER_BILDVERARBEITUNG ("Grundlagen der Bildverarbeitung"),
	MULTIMEDIAPROGRAMMIERUNG ("Multimediaprogrammierung"),
	OPERATIONS_RESEARCH ("Operations Research"),
	RECHNERNETZE2 ("Rechnernetze 2"),
	BETRIEBSWIRTSCHAFTSLEHRE ("Betriebswirtschaftslehre"),
	CONTROLLING ("Controlling"),
	MARKETING ("Marketing"),
	RECHNUNGSWESEN1 ("Rechnungswesen 1"),
	RECHNUNGSWESEN2 ("Rechnungswesen 2"),
	DATENBANKEN2 ("Datenbanken 2"),
	GENDER_UND_DIVERSITY_IN_DER_INFORMATIK ("Gender und Diversity in der Informatik"),
	TECHNIK_UND_ETHIK ("Technik und Ethik"),
	DATENSCHUTZ ("Datenschutz"),
	IT_RECHT ("IT-Recht"),
	MACHINE_LEARNING ("Machine Learning"),
	NATURAL_LANGUAGE_PROCESSING ("Natural Language Processing"),
	FRONTEND_FRAMEWORKS_FUER_WEBANWENDUNGEN ("Frontend Frameworks für Webanwendungen"),
	FORTGESCHRITTENE_INTERNETTECHNOLOGIEN ("Fortgeschrittene Internettechnologien"),
	JAVA_PROGRAMMIERUNG2 ("Java Programmierung"),
	SKRIPTSPRACHEN ("Skriptsprachen"),
	EINFUEHRUNG_IN_DIE_THEORETISCHE_INFORMATIK ("Einführung in die theoretische Informatik"),
	BETRIEBSSYSTEME2 ("Betriebssysteme 2"),
	BETRIEBSSYSTEME3 ("Betriebssysteme 3"),
	VIRTUALISIERUNG ("Virtualisierung"),
	PARTIZIPATIVES_DESIGN ("Partizipatives Design");

	public final String label;

	Wahlpflichtfach(String label) {
		this.label = label;
	}
}