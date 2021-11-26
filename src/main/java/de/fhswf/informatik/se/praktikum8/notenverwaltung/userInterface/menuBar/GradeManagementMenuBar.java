package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import javafx.scene.control.MenuBar;

public class GradeManagementMenuBar extends MenuBar {

    public GradeManagementMenuBar(StageInitializer initializer){
        getMenus().addAll(new DataMenu(), new GradeManagementMenu(initializer), new HelpMenu());
    }
}
