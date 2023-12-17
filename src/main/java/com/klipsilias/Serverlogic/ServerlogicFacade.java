package com.klipsilias.Serverlogic;

import java.io.IOException;
import java.util.Observer;

public interface ServerlogicFacade {
    void addObserver(Observer observer);
    //void log(String message);
    void notifyObservers(Object arg);
    void viewProtocol() throws IOException;
    boolean viewUser(Users dummy);
    void setAccessLevel(int i);
}
