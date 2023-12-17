package com.klipsilias.Serverlogic;

import com.klipsilias.Database.DoubleData;

import java.util.ArrayList;

class Grade implements DataManager, DataManagerGrade {
    private double gradeNumber;
    private String username;

    private Integer id;
    private DoubleData<Double, String> note;
    private static ArrayList<DoubleData> gradelist = new ArrayList<DoubleData>();
    //@Invariants
    public Grade(double gradeNumber, String username) {
        this.gradeNumber = gradeNumber;
        this.username = username;
        note = new DoubleData<>(gradeNumber, username);
        gradelist.add(note);
    }

    public static ArrayList<DoubleData> getList() {
        return gradelist;
    }
    public double getGradeNumber() {
        return gradeNumber;
    }

    public void setGradeNumber(int gradeNumber) {
        this.gradeNumber = gradeNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = this.id;
    }
}
