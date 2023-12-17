package com.klipsilias.Serverlogic;

interface DataManagerUser extends DataManager {
    void setUsername(String username);
    public String getName();

    void setName(String name);

    String getVorname();

    void setVorname(String vorname);

    void setId(Integer id);

    int getAccessLevel();

    boolean viewUser(Users dummy);

    String toString();
}
