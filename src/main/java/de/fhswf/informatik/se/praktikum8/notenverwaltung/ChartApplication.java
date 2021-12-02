package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Die Klasse ChartApplication sorgt dafür, dass die JavaFX-Applikation mithilfe
 * von Spring Boot funktioniert.
 *
 * @author Ivonne Kneißig & Ramon Günther
 * @version 1.0 vom 25. November 2021
 */
public class ChartApplication extends javafx.application.Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(NotenverwaltungApplication.class).run();
    }

    @Override
    public void start(Stage stage) {
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}
