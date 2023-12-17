package com.klipsilias.Serverlogic;

interface DataManagerRoom extends DataManager {

         String getLocation();

         void setLocation(String location);

         void makeReservation(String day, int time);
}
