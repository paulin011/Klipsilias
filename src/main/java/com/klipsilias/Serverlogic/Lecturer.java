package com.klipsilias.Serverlogic;
import com.klipsilias.Serverlogic.KlipsiliasWebFacade;
class Lecturer extends Users {//Für Aufgabe 5 Blatt 5 entstanden
    public Lecturer(String name, String firstname, String username, String password) {
       super(name, firstname, username, password);
        this.setAccessLevel(2);
    }
}
