package com.klipsilias.Serverlogic;
import com.klipsilias.Serverlogic.KlipsiliasWebFacade;
class Module {
    Integer id;
    String name;
    String coursename;
    public Module(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        coursename = coursename;
    }
}
