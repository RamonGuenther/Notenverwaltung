package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.ChartApplication.StageReadyEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        stage.setTitle("Hello World!");
        StackPane root = new StackPane();
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }
}
