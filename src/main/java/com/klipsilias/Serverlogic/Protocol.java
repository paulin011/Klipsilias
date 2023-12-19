package com.klipsilias.Serverlogic;
import com.klipsilias.Serverlogic.KlipsiliasWebFacade;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Observable;
import java.util.Observer;

class Protocol implements Observer{
    public void Protocol(String name) {}

        @Override
        public void update(Observable o, Object args) { //
            String message = (String) args;
            Writer output;
            try{
                output  = new BufferedWriter(new FileWriter("D:\\protokol.txt", true));
                output.append(message);
                output.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }

}


