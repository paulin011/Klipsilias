package com.klipsilias.Serverlogic;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Groupy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Users> users;

    public Groupy(String name) {
        this.name = name;
    }

    public Groupy() {

    }
    public Groupy(String name, List<Users> users) {
        this.name = name;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    public void addUser(Users user){
        this.users.add(user);
    }
}
