package de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuBar;

import de.fhswf.informatik.se.praktikum8.notenverwaltung.userInterface.menuItems.QuitMenuItem;
import javafx.scene.control.Menu;

public class DataMenu extends Menu {

    public DataMenu(){
        setText("_Datei");
        setMnemonicParsing(true);
        getItems().add(new QuitMenuItem());
    }
}
