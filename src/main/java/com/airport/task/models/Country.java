package com.airport.task.models;

public class Country {
    private String id;
    private String code;
    private String name;

    public Country(String id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getId(){
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

}
