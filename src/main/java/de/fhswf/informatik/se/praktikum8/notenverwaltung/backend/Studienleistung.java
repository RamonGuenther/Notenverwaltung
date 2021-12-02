package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.*;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.StudienleistungErgebnisliste;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.WahlmodulEnum;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtfach;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten.ListeModuleStudienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten.ListeModuleWahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten.ListePflichtmodule;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.AbschlussRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.WahlpflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service.AbschlussService;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service.PflichtmodulService;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service.WahlmodulService;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service.WahlpflichtmodulService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Die Klasse Studienleistung verwaltet die gesamte Notenverwaltung mithilfe
 * folgender Service-Klassen:
 *
 * - {@link PflichtmodulService}
 * - {@link WahlpflichtmodulService}
 * - {@link WahlmodulService}
 * - {@link AbschlussService}
 *
 * @author  Ramon Günther & Ivonne Kneißig (Verantwortlich: Ramon Günther)
 * @version 1.0 vom 2. Dezember 2021
 *
 */
public class Studienleistung {

    private final PflichtmodulService pflichtmodulService;
    private final WahlpflichtmodulService wahlpflichtmodulService;
    private final WahlmodulService wahlmodulService;
    private final AbschlussService abschlussService;

    /**
     * Der Konstruktor bekommt, die Repositories um die Service-Klassen
     * zu initialisieren.
     *
     * @param pflichtmodulRepository pflichtmodulRepository
     * @param wahlpflichtmodulRepository wahlpflichtmodulRepository
     * @param wahlmodulRepository wahlmodulRepository
     * @param abschlussRepository abschlussRepository
     */
    public Studienleistung(PflichtmodulRepository pflichtmodulRepository,
                           WahlpflichtmodulRepository wahlpflichtmodulRepository,
                           WahlmodulRepository wahlmodulRepository,
                           AbschlussRepository abschlussRepository){

        pflichtmodulService = new PflichtmodulService(pflichtmodulRepository);
        wahlpflichtmodulService = new WahlpflichtmodulService(wahlpflichtmodulRepository);
        wahlmodulService = new WahlmodulService(wahlmodulRepository);
        abschlussService = new AbschlussService(abschlussRepository);
    }


    /**********************************************************************************************
                                        Module finden
     **********************************************************************************************/


    /**
     * Methode um ein Pflichtmodul per Namen zu finden.
     *
     * @param modulname des gesuchten Pflichtmoduls
     * @return Pflichtmodul
     */
    public Pflichtmodul getPflichtmodulByModulname(String modulname){
        return pflichtmodulService.findByModulname(modulname);
    }

    /**
     * Methode um ein Pflichtmodul per Namen zu finden.
     *
     * @param modulname des gesuchten Wahlpflichtmoduls
     * @return Wahlpflichtmodul
     */
    public Wahlpflichtmodul getWahlpflichtmodulByModulname(String modulname){
        return wahlpflichtmodulService.findByModulname(modulname);
    }

    /**
     * Methode um ein Wahlmodul per Namen zu finden.
     *
     * @param modulname des gesuchten Wahlmoduls
     * @return Wahlmodul
     */
    public Wahlmodul getWahlmodulByModulname(String modulname){
        return wahlmodulService.findByModulname(modulname);
    }

    /**
     * Methode um den Abschluss zu finden.
     *
     * @return Abschluss
     */
    public Abschluss getAbschluss(){
       return abschlussService.findAbschluss();
    }

    /**
     * Methode um alle gespeicherten Wahlpflichtmodule als
     * Liste zu erhalten.
     *
     * @return Liste aus Wahlpflichtmodulen
     */
    public List<Wahlpflichtmodul> getWahlpflichtmodule() {
        return wahlpflichtmodulService.findAllWahlpflichtModule();
    }

    /**
     * Methode um alle gespeicherten Wahlmodule als
     * Liste zu erhalten.
     *
     * @return Liste aus Wahlmodulen
     */
    public List<Wahlmodul> getWahlmodule(){
        return wahlmodulService.findAllWahlmodule();
    }

    /**
     * Methode um alle gespeicherten Wahlmodule als
     * Liste vom Typ Object zu erhalten.
     *
     * @return Liste aus Objekten
     */
    public List<Object> getWahlmoduleForTable(){
        List<Wahlmodul> wahlmodulList =wahlmodulService.findAllWahlmodule();
        return new ArrayList<>(wahlmodulList);
    }

    /**
     * Methode um alle gespeicherten Pflicht- und Wahlpflichtmodule als
     * Liste vom Typ Object zu erhalten.
     *
     * @return Liste aus Objekten
     */
    public List<Object> getAllePflichtmoduleUndWahlpflichtmodule(){
       return Stream.of(
               pflichtmodulService.findAllPflichtModule(),
               wahlpflichtmodulService.findAllWahlpflichtModule())
               .flatMap(Collection::stream)
               .collect(Collectors.toList())
       ;
    }

    /**
     * Methode um alle gespeicherten Pflicht- und Wahlpflichtmodule, die nicht bestanden sind,
     * als Liste vom Typ Object zu erhalten.
     *
     * @return Liste aus Objekten
     */
    public List<Object> getOffenePflichtmoduleUndWahlpflichtmodule(){
        return Stream.of(
                pflichtmodulService.findAllOffenePflichtmodule(),
                wahlpflichtmodulService.findAllOffeneWahlpflichtmodule())
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
        ;
    }

    /**
     * Methode um alle gespeicherten Pflicht- und Wahlmodule, die bestanden sind,
     * als Liste vom Typ Object zu erhalten.
     *
     * @return Liste aus Objekten
     */
    public List<Object> getBestandenePflichtmoduleUndWahlpflichtmodule(){
         return Stream.of(
               pflichtmodulService.findAllBestandenePflichtmodule(),
               wahlpflichtmodulService.findAllBestandeneWahlpflichtmodule())
               .flatMap(Collection::stream)
               .collect(Collectors.toList())
         ;
    }

    /**********************************************************************************************
                                         Module Hinzufügen
     **********************************************************************************************/

    /**
     * Die Methode pflichtmoduleAnlegen speichert eine Liste mit allen von der
     * Studienrichtung unabhängigen Pflichtmodulen des Studiengangs Informatik B.sc
     * in der Datenbank. Im gleichen Zug wird auch ein Abschlussobjekt erstellt
     * und ebenfalls gespeichert.
     */
    public void pflichtmoduleAnlegen() {
        if(!pflichtmodulService.findAllPflichtModule().isEmpty()) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Pflichtmodule bereits angelegt.");
        }
        pflichtmodulService.savePflichtmodule(new ListePflichtmodule());
        abschlussService.saveAbschluss(new Abschluss());
    }


    /**
     * Die Methode pflichtmoduleAnwendungsrichtungFestlegen speichert eine Liste mit allen von der
     * Studienrichtung abhängigen Pflichtmodulen des Studiengangs Informatik B.sc
     * in der Datenbank. Dazu muss der Student vorher eine Studienrichtung gewählt haben.
     *
     * @param studienrichtung Studienrichtung, die der Student gewählt hat
     */
    public void pflichtmoduleStudienrichtungFestlegen(Studienrichtung studienrichtung) {
        if(abschlussService.findAbschluss() == null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Es wurde kein Abschluss gefunden");
        }
        Abschluss abschluss = abschlussService.findAbschluss();
        if(abschluss.getStudienrichtung() != null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Studienrichtung bereits festgelegt.");
        }
        abschluss.setStudienrichtung(studienrichtung);
        abschlussService.saveAbschluss(abschluss);
        pflichtmodulService.savePflichtmodule(new ListeModuleStudienrichtung(abschluss.getStudienrichtung()));
    }

    /**
     *
     * Die Methode pflichtmoduleWahlpflichtblockFestlegen speichert eine Liste mit allen von dem
     * Wahlpflichtblock abhängigen Pflichtmodulen des Studiengangs Informatik B.sc
     * in der Datenbank. Dazu muss der Student vorher einen Wahlpflichtblock gewählt haben.
     *
     * @param wahlpflichtblock	Wahlpflichtblock, den der Student gewählt hat
     */
    public void pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock wahlpflichtblock){
        if(abschlussService.findAbschluss() == null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                ": Es wurde kein Abschluss gefunden");
        }
        Abschluss abschluss = abschlussService.findAbschluss();
        if(abschluss.getWahlpflichtblock() != null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Wahlpflichtbock bereits festgelegt.");
        }
        if(abschluss.getStudienrichtung() == null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Es muss erst eine Studienrichtung eingetragen.");
        }
        if(wahlpflichtblock.label.equals(abschluss.getStudienrichtung().label)){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Der Wahlpflichtblock muss sich von der Studienrichtung unterscheiden");
        }
        abschluss.setWahlpflichtblock(wahlpflichtblock);
        abschlussService.saveAbschluss(abschluss);
        pflichtmodulService.savePflichtmodule(new ListeModuleWahlpflichtblock(wahlpflichtblock));
    }

    /**
     * Die Methode wahlpflichtmodulHinzufügen erstellt ein Wahlpflichtfach und speichert
     * dieses in der Datenbank.
     *
     * @param wahlpflichtfach 	Wahlpflichtfach, das der Student gewählt hat
     * @param semester			Semester, in dem das gewählte Wahlpflichtfach belegt wird.
     */
    public void wahlpflichtmodulHinzufuegen(Wahlpflichtfach wahlpflichtfach, int semester) {
        List<Wahlpflichtmodul> wahlpflichtmodulList = wahlpflichtmodulService.findAllWahlpflichtModule();
        List<Pflichtmodul> pflichtmodulList = pflichtmodulService.findAllPflichtModule();
        if(wahlpflichtmodulList.size() == 2){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Es wurden bereits 2 Wahlpflichtmodule eingetragen");
        }
        for(Wahlpflichtmodul wahlpflichtmodul: wahlpflichtmodulList){
            if(wahlpflichtmodul.getModulname().equals(wahlpflichtfach.label)){
                throw new IllegalArgumentException(this.getClass().getSimpleName() +
                        ": Dieses Modul ist bereits als Wahlpflichtmodul belegt worden");
            }
        }
        for(Pflichtmodul pflichtmodul: pflichtmodulList){
            if(pflichtmodul.getModulname().equals(wahlpflichtfach.label)){
                throw new IllegalArgumentException(this.getClass().getSimpleName() +
                        ": Dieses Modul ist bereits als Pflichtmodul belegt worden");
            }
        }

        Wahlpflichtmodul wahlpflichtmodul = new Wahlpflichtmodul(wahlpflichtfach.label, semester);
        wahlpflichtmodulService.saveWahlpflichtmodul(wahlpflichtmodul);
        System.out.println("Das Wahlpflichtmodul " + wahlpflichtmodul.getModulname() + " wurde erstellt.");
    }

    /**
     * Die Methode wahlmodulHinzufügen erstellt ein Wahlmodul und speichert
     * dieses in der Datenbank.
     *
     * @param wahlmodulEnum 	Wahlmodul, das der Student gewählt hat
     * @param semester			Semester, in dem das gewählte Wahlpflichtfach belegt wird.
     */
    public void wahlmodulHinzufuegen(WahlmodulEnum wahlmodulEnum, int semester){
        List<Wahlmodul> wahlpflichtmodulList = wahlmodulService.findAllWahlmodule();

        for(Wahlmodul wahlpflichtmodul: wahlpflichtmodulList){
            if(wahlpflichtmodul.getModulname().equals(wahlmodulEnum.label)){
                throw new IllegalArgumentException(this.getClass().getSimpleName() +
                        ": Dieses Modul ist bereits als Wahlmodul belegt worden");
            }
        }
        Wahlmodul wahlmodul = new Wahlmodul(wahlmodulEnum.label, semester);
        wahlmodulService.saveWahlmodul(wahlmodul);
        System.out.println("Das Wahlmodul " + wahlmodul.getModulname() + " wurde erstellt.");
    }

    /**********************************************************************************************
                                         Module löschen
     **********************************************************************************************/

    public void deleteWahlpflichtmodul(String modulname){
        wahlpflichtmodulService.deleteWahlpflichtmodul(modulname);
    }

    public void deleteWahlmodul(String modulname){
        wahlmodulService.deleteWahlmodul(modulname);
    }

    public void deleteAllByWahlpflichtblock(){
        pflichtmodulService.deleteAllByWahlpflichtblock(abschlussService);
    }

    public void deleteAllByStudienrichtung(){
        pflichtmodulService.deleteAllByStudienrichtung(abschlussService);
    }


    /**********************************************************************************************
                                Note zu einem Modul hinzufügen
     **********************************************************************************************/
    public void updateNotePflichtmodul(String modulname, Double note){
        pflichtmodulService.setNote(modulname, note);
    }

    public void updateNoteWahlpflichtmodul(String modulname, Double note){
        wahlpflichtmodulService.setNote(modulname,note);
    }

    public void updateNoteWahlmodul(String modulname, Double note){
        wahlmodulService.setNote(modulname,note);
    }

    public void updateNoteBachelor(Double note){
        abschlussService.setNoteBachelor(note);
    }

    public void updateNoteKolloquium(Double note){
        abschlussService.setNoteKolloquium(note);
    }


    /**********************************************************************************************
                                Notendurchschnitt berechnen
     **********************************************************************************************/

    /**
     * Die Methode getNotendurchschnitt erstellt die StudienleistungsErgebnisliste
     * aus Pflicht - und Wahlpflichtmodulen und übergibt sie der Methode berechneNote().
     *
     * @return Notendurchschnitt aller Module
     */
    public double getNotendurchschnittModule(){
        List<StudienleistungErgebnisliste> notenListe = new ArrayList<>();
        notenListe.addAll(pflichtmodulService.getNotenliste());
        notenListe.addAll(wahlpflichtmodulService.getNotenliste());
        return berechneNote(notenListe, getSummeCreditpointsOhneAbschluss());
    }

    /**
     * Die Methode getNotendurchschnittAbschluss berechnet den Notendurchschnitt der Bachelorarbeit
     * und des Kolloquiums.
     *
     * @return Notendurchschnitt der Bachelorarbeit und des Kolloquiums
     */

    public Double getNotendurchschnittAbschluss(){
        Abschluss abschluss = abschlussService.findAbschluss();
        if(abschluss.getBachelorarbeit().getEndNoteBachelor() == 0 || abschluss.getKolloquium().getEndNoteKolloquium() == 0){
            return 0.0;
        }
        double note1 = abschluss.getBachelorarbeit().notenFaktor();
        double note2 = abschluss.getKolloquium().notenFaktor();

        int summeCreditpoints = abschluss.getBachelorarbeit().getCreditpointsBachelorarbeit() +
                abschluss.getKolloquium().getCreditpointsKolloquium();

        double notendurchschnitt = (note1 + note2)/summeCreditpoints;

        notendurchschnitt = Math.round((notendurchschnitt*100))/100.0;

        return notendurchschnitt;
    }

    /**
     * Die Methode getNotenliste holt sich alle Pflichtmodule,
     * Wahlpflichtmodule und den Abschluss als Liste und übergibt sie der
     * Methode berechneNote().
     *
     * @return Liste der Endnoten und Creditpoints der jeweiligen Module
     */
    public Double getNotendurchschnittGesamt(){
        if(getSummeCreditPointsMitAbschluss() != 180){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Die erforderlichen Creditpoints sind nicht vorhanden");
        }
        List<StudienleistungErgebnisliste> noten = new ArrayList<>();
        noten.addAll(pflichtmodulService.getNotenliste());
        noten.addAll(wahlpflichtmodulService.getNotenliste());
        noten.addAll(abschlussService.getNotenliste());
        return berechneNote(noten,getSummeCreditPointsMitAbschluss());
    }

    /**
     * Die Methode berechneNote berechnet aus der Notenliste und der Summe der Creditpoints
     * den Notendurchschnitt.
     *
     * @param notenListe notenListe der ausgewählten Module für die Berechnung des Durchschnitts
     * @param summeCreditpoints Summe der Creditpoints der bestandenen Module
     * @return Notendurchschnitt
     */
    private Double berechneNote(List<StudienleistungErgebnisliste> notenListe, Integer summeCreditpoints){
        if(notenListe.isEmpty()){
            return 0.0;
        }
        double zaehler = 0.0;
        double notendurchschnitt;
        for(StudienleistungErgebnisliste n : notenListe){
            zaehler += n.getEndnote() * n.getCreditpoints();
        }
        notendurchschnitt = zaehler/summeCreditpoints;

        notendurchschnitt = Math.round(notendurchschnitt*100)/100.0;

        return  notendurchschnitt;
    }

    /**********************************************************************************************
                                    Creditpoints berechnen
     **********************************************************************************************/

    /**
     * Die Methode berechnet alle Creditpoints der bestandenen Pflicht-
     * und Wahlpflichtmodule und gibt diese zurück.
     *
     * @return Summe der Creditpoints
     */
    public Integer getSummeCreditpointsOhneAbschluss(){
        int summeCreditpoints = 0;
        List<StudienleistungErgebnisliste> noten = new ArrayList<>();
        noten.addAll(pflichtmodulService.getNotenliste());
        noten.addAll(wahlpflichtmodulService.getNotenliste());
        for(StudienleistungErgebnisliste n : noten){
            summeCreditpoints += n.getCreditpoints();
        }
        return summeCreditpoints;
    }

    /**
     * Die Methode berechnet alle Creditpoints der bestandenen Pflicht-
     * und Wahlpflichtmodule, mit Beachtung der Bachelorarbeit und des
     * Kolloquiums und gibt diese zurück.
     *
     * @return Summe der Creditpoints
     */
    public Integer getSummeCreditPointsMitAbschluss(){
        int summeCreditpoints = 0;
        List<StudienleistungErgebnisliste> noten = new ArrayList<>();
        noten.addAll(pflichtmodulService.getNotenliste());
        noten.addAll(wahlpflichtmodulService.getNotenliste());
        noten.addAll(abschlussService.getNotenliste());
        for(StudienleistungErgebnisliste studienleistungErgebnisliste1 : noten){
            summeCreditpoints += studienleistungErgebnisliste1.getCreditpoints();
        }
        return summeCreditpoints;
    }
}

