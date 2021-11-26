package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.StageInitializer;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.BachelorThesisAndKolloquiumMenuItem;
import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.GradeManagementMenuItem;
import javafx.scene.control.Menu;

public class GradeManagementMenu extends Menu {

    public GradeManagementMenu(StageInitializer initializer){
        setText("_Prüfungsleistungen");
        setMnemonicParsing(true);
        getItems().addAll(new BachelorThesisAndKolloquiumMenuItem(initializer), new GradeManagementMenuItem(initializer));
    }
}
