package de.fhswf.informatik.se.praktikum8.notenverwaltung;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.ChartApplication.StageReadyEvent;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.panes.GradeManagementBorderPane;
import javafx.scene.Parent;
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
        stage.setTitle("Notenverwaltung Informatik B.sc.");
        Parent root = new GradeManagementBorderPane();
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
        stage.setMaximized(true);
    }
}
