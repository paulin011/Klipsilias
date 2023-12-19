package com.klipsilias.Serverlogic;
import com.klipsilias.Serverlogic.KlipsiliasWebFacade;
interface DataManagerRoom extends DataManager {

         String getLocation();

         void setLocation(String location);

         void makeReservation(String day, int time);
}
