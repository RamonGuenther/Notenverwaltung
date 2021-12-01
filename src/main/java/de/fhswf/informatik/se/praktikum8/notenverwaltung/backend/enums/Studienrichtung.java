package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums;

/**
 * Die Enumeration Studienrichtung enthält alle wählbaren Studienrichtungen
 * für den Studiengang Informatik B.sc. an der Fachhochschule Südwestfalen nach BPO2019.
 *
 * @author Ramon Günther
 * @version 1.0 vom 20. November 2021
 */
public enum Studienrichtung {
	ANWENDUNGSENTWICKLUNG ("Anwendungsentwicklung"),
	SYSTEMINTEGRATION ("Systemintegration"),
	UMWELTINFORMATIK ("Umweltinformatik"),
	KUENSTLICHE_INTELLIGENZ ("Künstliche Intelligenz");

	public final String label;

	Studienrichtung(String label) {
		this.label = label;
	}
}