package de.fhswf.informatik.se.praktikum8.notenverwaltung;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.exceptions.DuplicateEntityException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication/*(scanBasePackages = "de.fhswf.informatik.se.praktikum8.notenverwaltung.backend")*/
//@EntityScan(basePackages = "de.fhswf.informatik.se.praktikum8.notenverwaltung.backend")
public class NotenverwaltungApplication {


    public static void main(String[] args) {
        javafx.application.Application.launch(ChartApplication.class, args);
    }

    @PostConstruct
    public void testDB() throws DuplicateEntityException {
//        repostory.save(new Pflichtmodul("Test",5,1,"ka"));
//        ListeModuleStudienrichtung listeModuleStudienrichtung = new ListeModuleStudienrichtung(Studienrichtung.KUENSTLICHE_INTELLIGENZ);
    }

}