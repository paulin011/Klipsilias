package com.klipsilias.Serverlogic;

//import dependencies

import jakarta.persistence.*;

import java.util.ArrayList;


@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "access_level")
    private int accessLevel;

    private static ArrayList<Users> usersList = new ArrayList<Users>();

   //Create a constructor

    public Users(String name, String firstname, String username, String password) {
        this.setName(name);
        this.setFirstname(firstname);
        this.setUsername(username);
        this.setPassword(password);
        this.setAccessLevel(1);
    }
    public Users() {
    }

    void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String vorname) {
        this.firstname = vorname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public static ArrayList<Users> getList() {
        return usersList;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", username='" + username + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public boolean viewUser(Users dummy){//(Für Aufgabe 5 Blatt5) Methode um Daten eines anderen Nutzers anzusehen
        if(getAccessLevel() == 1 || getAccessLevel() == 2){ //Abfrage ob Zugriffsrecht auf Daten vorliegt
            throw new IllegalCallerException("access denied");  // Fehler falls falscher Zugriffsrecht vorliegt
        }
        else{
            if(dummy != null) {
                System.out.println(dummy.toString()); // Ausgabe falls Zugriffsrecht vorliegt
            }
            return true;
        }
    }

    protected void setAccessLevel(int i) {
        accessLevel = i;
    }

    //Auto generated
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

}
