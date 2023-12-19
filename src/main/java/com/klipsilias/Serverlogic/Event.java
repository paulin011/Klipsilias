package com.klipsilias.Serverlogic;
import com.klipsilias.Serverlogic.KlipsiliasWebFacade;
import java.util.ArrayList;


class Event implements DataManager, DataManagerEvent {
  private Integer id;
  private Room veranstaltungsort;
  private String zeitpunkt;
  private ArrayList<Users> teilnehmer = new ArrayList<>();

  public Event(Integer Id, Room veranstaltungsort, String zeitpunkt, ArrayList<Users> teilnehmer) {
    this.id = Id;
    this.veranstaltungsort = veranstaltungsort;
    this.zeitpunkt = zeitpunkt;
    this.teilnehmer = teilnehmer;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Room getVeranstaltungsort() {
    return veranstaltungsort;
  }

  public void setVeranstaltungsort(Room veranstaltungsort) {
    this.veranstaltungsort = veranstaltungsort;
  }

  public String getZeitpunkt() {
    return zeitpunkt;
  }

  public ArrayList<Users> getList() {
    return teilnehmer;
  }

  public void setTeilnehmer(ArrayList<Users> teilnehmer) {
    this.teilnehmer = teilnehmer;
  }

  public void addTeilnehmer(Users users){
    teilnehmer.add(users);
  }

  public void deleteTeilnehmer(Users users){
    teilnehmer.remove(users);
  }

  public void setZeitpunkt(String pZeitpunkt){
    zeitpunkt = pZeitpunkt;
    //todo: Ein-/Umtragung in Datenbank
  }
}
  
