package de.fhswf.informatik.se.praktikum8.notenverwaltung.backend.input;

public class CreatePflichtModulInput {
    private String modulname;
    private int creditpoints;
    private int semester;
    private String modulart;

    public CreatePflichtModulInput(String modulname, int creditpoints, int semester, String modulart) {
        this.modulname = modulname;
        this.creditpoints = creditpoints;
        this.semester = semester;
        this.modulart = modulart;
    }

    public String getModulname() {
        return modulname;
    }

    public int getCreditpoints() {
        return creditpoints;
    }

    public int getSemester() {
        return semester;
    }

    public String getModulart() {
        return modulart;
    }
}
