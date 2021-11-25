package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;


import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.HelpMenuItem;
import javafx.scene.control.Menu;

public class HelpMenu extends Menu {

    public HelpMenu(){
        setText("_Hilfe");
        setMnemonicParsing(true);
        getItems().add(new HelpMenuItem());
    }
}
