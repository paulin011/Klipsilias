package com.klipsilias.Serverlogic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class ITSupport extends Users {//Für Aufgabe 5 Blatt 5 entstanden
    public ITSupport(String name, String firstname, String username, String password) {
        super(name, firstname, username, password);
        this.setAccessLevel(3);
    }
    public void viewProtocol() throws IOException { // schön ist das Dokument nicht aber es ist da. Zum Testen muss wohl eine eigene
        //Datei erstellt werden und der Path hier eingefügt
        try{
            String s = Files.readString(Path.of("D:\\protokol.txt"));
            System.out.println(s);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}