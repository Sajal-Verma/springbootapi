package com.firsrApi.Api.APP;


//POJO - plain old java object
public class User {
    private int id;
    private String name;
    private String eamil;

    public User(int id, String name, String eamil) {
        this.id = id;
        this.name = name;
        this.eamil = eamil;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEamil() {
        return eamil;
    }
}
