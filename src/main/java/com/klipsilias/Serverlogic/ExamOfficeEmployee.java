package com.klipsilias.Serverlogic;

class ExamOfficeEmployee extends Users {
    public ExamOfficeEmployee(String name, String firstname, String username, String password) {
        super(name, firstname, username, password);
        this.setName(name);
        this.setFirstname(firstname);
        this.setUsername(username);
        this.setAccessLevel(5);
    }
    public void makeGrade(double note, String name){
        Grade grade = new Grade(note, name);
    }
}
