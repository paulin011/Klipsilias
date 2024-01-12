package com.klipsilias.Serverlogic;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "rooms")
public class Room implements DataManager, DataManagerRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "location")
    private String location;
    @Column(name = "isNotAvailable")
    @ElementCollection
    public ArrayList<Boolean> isNotAvailable = new ArrayList<Boolean>();
   // private Boolean[][] isNotAvailable = new Boolean[5*12]; //Liste der Verfügbarkeit nach Timeslots(5 Tage a 12 Stunden)




//    private static ArrayList<Room> roomList = new ArrayList<Room>();

    public Room() {
       for (int i = 0; i <= 60; i++)
        isNotAvailable.add(false);
    }
    /*
    public Room(Integer Id, String location) {
        this.id = Id;
        this.location = location;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 12; j++){
                isNotAvailable[i][j] = false;
            }
        }
    }
    */


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

    public Boolean getAvailability(String day, int time) {
        //int dayindice = 0;
        time = time - 8 - 1;
        int timeindice = 0;

        /*Umwandeln der Stunde in Indize für die Liste (ausgehend davon, dass
        der Tag um 8 beginnt*/

        timeindice = switch (day) {   //Umwandeln des Tages in den richtigen Indize für das Array
            case "Monday" -> time;
            case "Tuesday" -> time + 12;
            case "Wednesday" -> time +24;
            case "Thursday" -> time + 36;
            case "Friday" -> time +48;
            default -> throw new IllegalArgumentException("Invalid day of the week: " + day);
        };
        return isNotAvailable.get(timeindice);

    }



    public boolean makeReservation(String day, int time){
//        int timeindice = 0;
        time = time - 8 - 1;
        int timeindice = 0;
        if(time < 0 || time > 10){ //check ob ein gegebener Wert passt
            throw new IllegalArgumentException("Invalid time: " + time);
        }

        /*Umwandeln der Stunde in Indize für die Liste (ausgehend davon, dass
                                        der Tag um 8 beginnt*/
        timeindice = switch (day) {   //Umwandeln des Tages in den richtigen Indize für das Array
            case "Monday" -> time;
            case "Tuesday" -> time + 12;
            case "Wednesday" -> time +24;
            case "Thursday" -> time + 36;
            case "Friday" -> time +48;
            default -> throw new IllegalArgumentException("Invalid day of the week: " + day);
        };

        if(isNotAvailable.get(timeindice)){ //Prüfung ob Raum bereits vergeben
            System.out.println("Already taken");
            return false;                           //falls ja text mit ist bereits belegt
        }
        else {
            isNotAvailable.add(timeindice,true); //falls nein ändere boolean zu reserviert
        }
        return isNotAvailable.get(timeindice);
    }

  //  public static ArrayList<Room> getRoomList() {
    //    return roomList;
   // }
}
