package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Noten {
    @ElementCollection
    private List<Double> noten;

    public Noten(List<Double> noten) {
        this.noten = new ArrayList<>();
    }

    public Noten() {

    }
}
