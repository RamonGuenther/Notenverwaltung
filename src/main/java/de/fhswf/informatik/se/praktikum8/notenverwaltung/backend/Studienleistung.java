package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.*;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.valueobjects.Notendurchschnitt;
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

public class Studienleistung {

    private final PflichtmodulService pflichtmodulService;
    private final WahlpflichtmodulService wahlpflichtmodulService;
    private final WahlmodulService wahlmodulService;
    private final AbschlussService abschlussService;

    public Studienleistung(PflichtmodulRepository pflichtmodulRepository,
                           WahlpflichtmodulRepository wahlpflichtmodulRepository,
                           WahlmodulRepository wahlmodulRepository,
                           AbschlussRepository abschlussRepository){

        pflichtmodulService = new PflichtmodulService(pflichtmodulRepository);
        wahlpflichtmodulService = new WahlpflichtmodulService(wahlpflichtmodulRepository);
        wahlmodulService = new WahlmodulService(wahlmodulRepository);
        abschlussService = new AbschlussService(abschlussRepository);
    }

    public List<Pflichtmodul> getPflichtmoduleByPflichtmodul() {
        return pflichtmodulService.findAllPflichtModule();
    }

    public List<Object> getWahlmodule(){
        List<Wahlmodul> wahlmodulList =wahlmodulService.findAllWahlmodule();
        List<Object> objectList = new ArrayList<>();

        objectList.addAll(wahlmodulList);

        return objectList;
    }

    /**
     * Die Methode gibt eine Liste mit allen
     * @return
     */
    public List<Object> getAllePflichtmoduleUndWahlpflichtmodule(){
       return Stream.of(
               pflichtmodulService.findAllPflichtModule(),
               wahlpflichtmodulService.findAllWahlpflichtModule())
               .flatMap(Collection::stream)
               .collect(Collectors.toList())
               ;
    }

    public List<Object> getOffenePflichtmoduleUndWahlpflichtmodule(){
        return Stream.of(
                        pflichtmodulService.findAllOffenePflichtmodule(),
                        wahlpflichtmodulService.findAllOffeneWahlpflichtmodule())
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                ;
    }

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
     * Die Methode pflichtmoduleAnlegen erstellt eine Liste mit allen von der
     * Studienrichtung unabhängigen Pflichtmodulen des Studiengangs Informatik B.sc.
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
     * Die Methode pflichtmoduleAnwendungsrichtungFestlegen fügt der Liste der
     * Pflichtmodule alle von der Studienrichtung abhängigen Pflichtmodule hinzu.
     * Dazu muss der Student vorher eine Studienrichtung gewählt haben.
     *
     * @param studienrichtung	Studienrichtung, die der Student gewählt hat
     */
    public void pflichtmoduleStudienrichtungFestlegen(Studienrichtung studienrichtung) {
        if(abschlussService.findAbschluss() == null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Es wurde kein Abschluss gefunden");
        }
        Abschluss abschluss = abschlussService.findAbschluss();
        if(abschluss == null){
            System.out.println("TETSTTTSTS");
        }
        if(abschluss.getStudienrichtung() != null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Studienrichtung bereits festgelegt.");
        }
        abschluss.setStudienrichtung(studienrichtung);
        abschlussService.saveAbschluss(abschluss);
        pflichtmodulService.savePflichtmodule(new ListeModuleStudienrichtung(abschluss.getStudienrichtung()));
    }

    /**
     * Die Methode pflichtmoduleWahlpflichtblockFestlegen fügt der Liste der Pflichtmodule
     * alle Pflichtmodule des gewählten Wahlpflichtblocks hinzu. Der Wahlpflichtblock darf
     * nicht der gleichen Richtung entsprechen, wie der gewählten Studienrichtung.
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
     * Mit der Methode wahlpflichtmodulHinzufügen wird der Liste der Wahlpflichtmodule
     * ein neues Wahlpflichtmodul hinzugefügt.
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

    public double getNotendurchschnittModule(){
        List<Notendurchschnitt> notenListe = new ArrayList<>();
        notenListe.addAll(pflichtmodulService.getNotenliste());
        notenListe.addAll(wahlpflichtmodulService.getNotenliste());
        return berechneNote(notenListe, getSummeCreditpointsOhneAbschluss());
    }


    public Double getNotendurchschnittAbschluss(){
        Abschluss abschluss = abschlussService.findAbschluss();
        if(abschluss.getBachelorarbeit().getEndNoteBachelor() == 0 || abschluss.getKolloquium().getEndNoteKolloquium() == 0){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Der Notendurchschnitt vom Abschluss lässt sich nicht berechnen, da die erforderlichen Leistungen fehlen!");
        }
        double note1 = abschluss.getBachelorarbeit().notenFaktor();
        double note2 = abschluss.getKolloquium().notenFaktor();

        int summeCreditpoints = abschluss.getBachelorarbeit().getCreditpointsBachelorarbeit() +
                abschluss.getKolloquium().getCreditpointsKolloquium();

        double notendurchschnitt = (note1 + note2)/summeCreditpoints;

        notendurchschnitt = Math.round((notendurchschnitt*100))/100.0;

        return notendurchschnitt;
    }

    public Double getNotendurchschnittGesamt(){
        if(getSummeCreditPointsMitAbschluss() != 180){
            throw new IllegalArgumentException(this.getClass().getSimpleName() +
                    ": Die erforderlichen Creditpoints sind nicht vorhanden");
        }
        List<Notendurchschnitt> noten = new ArrayList<>();
        noten.addAll(pflichtmodulService.getNotenliste());
        noten.addAll(wahlpflichtmodulService.getNotenliste());
        noten.addAll(abschlussService.getNotenliste());
        return berechneNote(noten,getSummeCreditPointsMitAbschluss());
    }

    private Double berechneNote(List<Notendurchschnitt> notenListe, Integer summeCreditpoints){
        double zaehler = 0.0;
        double notendurchschnitt;
        for(Notendurchschnitt n : notenListe){
            zaehler += n.getEndnote() * n.getCreditpoints();
        }
        notendurchschnitt = zaehler/summeCreditpoints;

        notendurchschnitt = Math.round(notendurchschnitt*100)/100.0;

        return  notendurchschnitt;
    }

    /**********************************************************************************************
                                    Creditpoints berechnen
     **********************************************************************************************/

    public Integer getSummeCreditpointsOhneAbschluss(){
        int summeCreditpoints = 0;
        List<Notendurchschnitt> noten = new ArrayList<>();
        noten.addAll(pflichtmodulService.getNotenliste());
        noten.addAll(wahlpflichtmodulService.getNotenliste());
        for(Notendurchschnitt n : noten){
            summeCreditpoints += n.getCreditpoints();
        }
        return summeCreditpoints;
    }

    public Integer getSummeCreditPointsMitAbschluss(){
        int summeCreditpoints = 0;
        List<Notendurchschnitt> noten = new ArrayList<>();
        noten.addAll(pflichtmodulService.getNotenliste());
        noten.addAll(wahlpflichtmodulService.getNotenliste());
        noten.addAll(abschlussService.getNotenliste());
        for(Notendurchschnitt notendurchschnitt1 : noten){
            summeCreditpoints += notendurchschnitt1.getCreditpoints();
        }
        return summeCreditpoints;
    }
}

