package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import javafx.scene.control.MenuBar;

public class GradeManagementMenuBar extends MenuBar {

    public GradeManagementMenuBar(){
        getMenus().addAll(new DataMenu(), new GradeManagementMenu(), new HelpMenu());
    }
}
