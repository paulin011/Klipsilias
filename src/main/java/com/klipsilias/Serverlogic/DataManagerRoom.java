package com.klipsilias.Serverlogic;

interface DataManagerRoom extends DataManager {

         String getLocation();

         void setLocation(String location);

         boolean makeReservation(String day, int time);
}
