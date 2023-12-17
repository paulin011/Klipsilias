package com.klipsilias.Database;

//Für Aufgabe 5 Blatt 5 entstanden
public class DoubleData<T, U>{ //neues generisches Elemnt um 2 Daten verbunden abspeichern zu könnwn.
    private T firstelement;
    private U secondelement;

    //@invariant firstelement
    public DoubleData(T erstesObjekt, U zweitesObjekt) {
        this.firstelement = erstesObjekt;
        this.secondelement = zweitesObjekt;
    }

    public T getFirstelement() {
        return firstelement;
    } //nachfrage nach ersten Element des Objektes

    public void setFirstelement(T firstelement) {
        this.firstelement = firstelement;
    } //Anpassungsmöglichkeit erstes Element

    public U getSecondelement() {
        return secondelement;
    }//abfragen des zweiten Elements des Datentypen

    public void setSecondelement(U secondelement) {
        this.secondelement = secondelement;
    } // setzen des zweiten Elements

    @Override
    public boolean equals(Object o) { // override für die super-class Object um neue equals Methode zu erstellen
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubleData<T, U> datatype = (DoubleData<T, U>) o;

        return firstelement.equals(datatype.getFirstelement()) && secondelement.equals(datatype.getSecondelement());
    }

    public boolean equalsSecond(U o) { // Neue Klasse die zweites element der Double Data mit etwas vergleicht
        if (this.getSecondelement() == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoubleData<T, U> datatype = (DoubleData<T, U>) o;

        return secondelement.equals(datatype.getSecondelement());
    }

    @Override
    public String toString() {
        return ("(" + firstelement + " " + secondelement + ")");
    }// Override der String methode aus superclass Objekt um ein Objekt doble Data vernünftig ausgeben zu können
}


