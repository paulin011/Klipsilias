package com.klipsilias.Serverlogic;

import com.klipsilias.Serverlogic.Event;

interface DataManagerStudent {
    void getUserGradeList();
    void registerEvent(Event event);
    void deregisterEvent(Event event);

}
