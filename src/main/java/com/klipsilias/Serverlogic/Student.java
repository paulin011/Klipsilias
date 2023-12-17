package com.klipsilias.Serverlogic;

import com.klipsilias.Database.DoubleData;

import java.util.ArrayList;

class Student extends Users implements DataManagerStudent { //Für Aufgabe 5 Blatt 5 entstanden
    private boolean immatriculated;
    //@invariant name != 0 && firstname != 0 && username != 0 && userid != 0 && immatriculated != 0
    public Student(String name, String firstname, String username, String password, boolean immatriculated) {
        super(name, firstname, username, password);
        this.setAccessLevel(1);
        this.immatriculated = immatriculated;
    }
    /*@requires Grade.getGradeList() != 0
    * @ensures Output of all Grades of the User */
    public void getUserGradeList(){//Aufgabe 5 Blatt 5 2tes funcionalrequirement ermittelt
        assert Grade.getList() != null;
        ArrayList<DoubleData> userGradelist = new ArrayList<DoubleData>(); //liste die ausgegeben werden soll
        ArrayList<DoubleData> listzwischenspeicher = Grade.getList(); //hilfliste in der alle Grades sind
        for(int i = 0; i < listzwischenspeicher.size(); i++){ // Iteration durch liste
            if(listzwischenspeicher.get(i).equalsSecond(this.getUsername())){ // Vergleich des namens mit 2ten Element falls gleich hinzufügen zur ergebnisliste
                userGradelist.add(listzwischenspeicher.get(i));
        }
        }
        System.out.println(userGradelist.toString()); // Ausgabe Ergebnis Liste
    }
    /*@requires immatriculated == true
    * @ensures event.getTeilnhemer().contains(this)*/
    public void registerEvent(Event event) {
        assert immatriculated;
        event.addTeilnehmer(this);
    }
    /*@requires event.getTeilnhemer().contains(this)
     * @ensures !event.getTeilnhemer().contains(this)*/
    public void deregisterEvent(Event event){
        assert event.getList().contains(this);
        event.deleteTeilnehmer(this);
    }


}
