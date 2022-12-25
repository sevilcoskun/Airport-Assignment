package com.airport.task.models;

public class Airport {
    private String id;
    private String name;
    private String iso_country;
   
    public Airport(String id, String name, String iso_country){
        this.id = id;
        this.name = name;
        this.iso_country = iso_country;
    }

    public String getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getIso_country() {
        return this.iso_country;
    }
    
}
