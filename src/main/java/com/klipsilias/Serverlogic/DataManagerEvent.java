package com.klipsilias.Serverlogic;

import java.util.ArrayList;

interface DataManagerEvent extends DataManager {

         Room getVeranstaltungsort();

         void setVeranstaltungsort(Room veranstaltungsort);

         String getZeitpunkt();

         ArrayList<Users> getList();

         void setTeilnehmer(ArrayList<Users> teilnehmer);

         void addTeilnehmer(Student users);

         void deleteTeilnehmer(Users users);

         void setZeitpunkt(String pZeitpunkt);
}
