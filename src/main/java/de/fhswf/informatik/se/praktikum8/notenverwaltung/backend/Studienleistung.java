package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities.Pflichtmodul;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Studienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.enums.Wahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten.ListeModuleStudienrichtung;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten.ListeModuleWahlpflichtblock;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.modullisten.ListePflichtmodule;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.repositories.PflichtmodulRepository;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.service.PflichtmodulService;

import java.util.List;

public class Studienleistung {

    private PflichtmodulService service;


    private Studienrichtung studienrichtung;
    private Wahlpflichtblock wahlpflichtblock;
    private List<Pflichtmodul> pflichtmodule;


    public Studienleistung(PflichtmodulRepository repository) {
        service = new PflichtmodulService(repository);
    }

    /**
     * Die Methode pflichtmoduleAnlegen erstellt eine Liste mit allen von der
     * Studienrichtung unabhängigen Pflichtmodulen des Studiengangs Informatik B.sc.
     */
    public void pflichtmoduleAnlegen() {
        service.savePflichtmodule(new ListePflichtmodule());
    }

    /**
     * Die Methode pflichtmoduleAnwendungsrichtungFestlegen fügt der Liste der
     * Pflichtmodule alle von der Studienrichtung abhängigen Pflichtmodule hinzu.
     * Dazu muss der Student vorher eine Studienrichtung gewählt haben.
     *
     * @param studienrichtung	Studienrichtung, die der Student gewählt hat
     */
    public void pflichtmoduleStudienrichtungFestlegen(Studienrichtung studienrichtung) {
        setStudienrichtung(studienrichtung);
        service.savePflichtmodule(new ListeModuleStudienrichtung(studienrichtung));
    }

    /**
     * Die Methode pflichtmoduleWahlpflichtblockFestlegen fügt der Liste der Pflichtmodule
     * alle Pflichtmodule des gewählten Wahlpflichtblocks hinzu. Der Wahlpflichtblock darf
     * nicht der gleichen Richtung entsprechen, wie der gewählten Studienrichtung.
     *
     * @param wahlpflichtblock	Wahlpflichtblock, den der Student gewählt hat
     */
    public void pflichtmoduleWahlpflichtblockFestlegen(Wahlpflichtblock wahlpflichtblock){
        if(studienrichtung == null){
            throw new IllegalArgumentException(this.getClass().getSimpleName() + ": Es muss erst eine Studienrichtung eingetragen.");
        }
        if(wahlpflichtblock.label.equals(studienrichtung.label)){
            throw new IllegalArgumentException(this.getClass().getSimpleName() + ": Der Wahlpflichtblock muss sich von der Studienrichtung unterscheiden");
        }
        setWahlpflichtblock(wahlpflichtblock);
        service.savePflichtmodule(new ListeModuleWahlpflichtblock(wahlpflichtblock));
    }


    public void setStudienrichtung(Studienrichtung studienrichtung) {
        this.studienrichtung = studienrichtung;
    }

    public void setWahlpflichtblock(Wahlpflichtblock wahlpflichtblock) {
        this.wahlpflichtblock = wahlpflichtblock;
    }

    public void setPflichtmodule() {
        pflichtmodule = service.findAllPflichtModule("Pflichtmodul");
    }

    public List<Pflichtmodul> getPflichtmodule() {
        return pflichtmodule;
    }

//    public List<Pflichtmodul> test(double note){
//        return service.findByNote(note);
//    }
}
