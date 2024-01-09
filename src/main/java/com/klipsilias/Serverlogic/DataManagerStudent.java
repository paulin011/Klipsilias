package com.klipsilias.Serverlogic;

import com.klipsilias.Database.DoubleData;

import java.util.List;

interface DataManagerStudent {
    List<DoubleData> getUserGradeList();
    void registerEvent(Event event);
    void deregisterEvent(Event event);

}
