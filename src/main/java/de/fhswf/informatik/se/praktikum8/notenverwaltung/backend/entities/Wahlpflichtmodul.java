package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtfach;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Wahlpflichtmodul enthält alle wichtigen Informationen zu einem
 * Wahlpflichtmodul für den Studiengang Informatik B.sc.
 * Ein Wahlpflichtmodul entspricht einem Modul aus der Enumeration-Klasse Wahlpflichtfach.
 *
 * @author Ramon Günther & Ivonne Kneißig
 * @version 1.0 vom 20. November 2021
 */

public class Wahlpflichtmodul {

	private Wahlpflichtfach wahlpflichtfach;
	private int creditpoints;
	private List<Double> noten;
	private int semester;
	private boolean bestanden;

	public Wahlpflichtmodul(Wahlpflichtfach wahlpflichtfach, int creditpoints, int semester) {
		this.wahlpflichtfach = wahlpflichtfach;
		this.creditpoints = creditpoints;
		this.noten = new ArrayList<>();
		this.semester = semester;
	}

	public String getWahlpflichtfach() {
		return wahlpflichtfach.label;
	} //Hier hab ich label hinzugefügt damit wir das nicht immer benutzen müssen sowie in Pflichtmodul

	public void setWahlpflichtfach(Wahlpflichtfach wahlpflichtfach) {
		this.wahlpflichtfach = wahlpflichtfach;
	}

	public int getCreditpoints() {
		return creditpoints;
	}

	public void setCreditpoints(int creditpoints) {
		this.creditpoints = creditpoints;
	}

	public List<Double> getNoten() {
		return noten;
	}

	public void setNoten(List<Double> noten) {
		this.noten = noten;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public boolean isBestanden() {
		return bestanden;
	}

	public void setBestanden(boolean bestanden) {
		this.bestanden = bestanden;
	}

//	/**
//	 * Die Methode notenEintragen trägt eine Note für das Wahpflichtmodul ein.
//	 * Es können maximal 3 Noten für ein Wahlpflichtmodul erfasst werden. Ist die
//	 * zuletzt eingetragene Note <= 4.0 wird das Attribut bestanden auf true gesetzt
//	 *
//	 * @param note Note, die für das Modul eingetragen werden soll
//	 */
//	public void noteEintragen(double note) {
//		if(noten.size() == 3){
//			throw new IllegalArgumentException( this.getClass().getSimpleName() + ": Es wurden bereits 3 Noten für dieses Modul eingetragen");
//		}
//		if(note <=4.0){
//			setBestanden(true);
//		}
//		this.noten.add(note);
//	}

}