package com.klipsilias.Serverlogic;

import java.util.ArrayList;

class Room implements DataManager, DataManagerRoom {
    private Integer id;
    private String location;
    private Boolean[][] isNotAvailable = new Boolean[5][12]; //Liste der Verfügbarkeit nach Timeslots(5 Tage a 12 Stunden)

    private static ArrayList<Room> roomList = new ArrayList<Room>();

    public Room(Integer Id, String location) {
        this.id = Id;
        this.location = location;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 12; j++){
                isNotAvailable[i][j] = false;
            }
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void makeReservation(String day, int time){
        int dayindice = 0;
        int timeindice = time - 8 - 1;  /*Umwandeln der Stunde in Indize für die Liste (ausgehend davon, dass
                                        der Tag um 8 beginnt*/
        dayindice = switch (day) {   //Umwandeln des Tages in den richtigen Indize für das Array
            case "Monday" -> 0;
            case "Tuesday" -> 1;
            case "Wednesday" -> 2;
            case "Thursday" -> 3;
            case "Friday" -> 4;
            default -> throw new IllegalArgumentException("Invalid day of the week: " + day); /*falls falsche Eingabe
                                                                                              Fehlermeldung*/
        };
        if(timeindice < 0 || timeindice > 11){ //check ob ein gegebener Wert passt
            throw new IllegalArgumentException("Invalid time: " + time);
        }
        if(isNotAvailable[dayindice][timeindice]){ //Prüfung ob Raum bereits vergeben
            System.out.println("Already taken"); //falls ja text mit ist bereits belegt
        }
        else {
            isNotAvailable[dayindice][timeindice] = true; //falls nein ändere boolean zu reserviert
        }
    }

    public static ArrayList<Room> getRoomList() {
        return roomList;
    }
}
