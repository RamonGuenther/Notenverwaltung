package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Die Klasse NotenverwaltungApplication sorgt dafür, dass die SpringBoot-
 * Applikation gestartet wird.
 *
 * @author Ivonne Kneißig & Ramon Günther
 * @version 1.0 vom 25. November 2021
 */
@SpringBootApplication
public class NotenverwaltungApplication {

    public static void main(String[] args) {
        javafx.application.Application.launch(ChartApplication.class, args);
    }

}