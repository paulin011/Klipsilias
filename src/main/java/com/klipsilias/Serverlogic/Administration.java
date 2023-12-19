package com.klipsilias.Serverlogic;
import com.klipsilias.Serverlogic.KlipsiliasWebFacade;

public class Administration extends Users {//Für Aufgabe 5 Blatt 5 entstanden
    public Administration(String name, String firstname, String username, String password) {
        super(name, firstname, username, password);
        this.setName(name);
        this.setFirstname(firstname);
        this.setUsername(username);
        this.setAccessLevel(4);
        this.setPassword(password);
    }
}
