package com.airport.task.models;

public class Runaway {
    private String id;
    private String airport_ref;
    private String airport_ident;
    private String length_ft;
    private String width_ft;
    private String surface;
    private String lighted;
    private String closed;
    private String le_ident;
    private String le_latitude_deg;
    private String le_longitude_deg;
    private String le_elevation_ft;
    private String le_heading_degT;
    private String le_displaced_threshold_ft;
    private String he_ident;
    private String he_latitude_deg;
    private String he_longitude_deg;
    private String he_elevation_ft;
    private String he_heading_degT;
    private String he_displaced_threshold_ft;


    public Runaway(String id, String airport_ref, String airport_ident, String length_ft, String width_ft, String surface, String lighted, String closed, String le_ident, String le_latitude_deg, String le_longitude_deg, String le_elevation_ft, String le_heading_degT, String le_displaced_threshold_ft, String he_ident, String he_latitude_deg, String he_longitude_deg, String he_elevation_ft, String he_heading_degT, String he_displaced_threshold_ft) {
        this.id = id;
        this.airport_ref = airport_ref;
        this.airport_ident = airport_ident;
        this.length_ft = length_ft;
        this.width_ft = width_ft;
        this.surface = surface;
        this.lighted = lighted;
        this.closed = closed;
        this.le_ident = le_ident;
        this.le_latitude_deg = le_latitude_deg;
        this.le_longitude_deg = le_longitude_deg;
        this.le_elevation_ft = le_elevation_ft;
        this.le_heading_degT = le_heading_degT;
        this.le_displaced_threshold_ft = le_displaced_threshold_ft;
        this.he_ident = he_ident;
        this.he_latitude_deg = he_latitude_deg;
        this.he_longitude_deg = he_longitude_deg;
        this.he_elevation_ft = he_elevation_ft;
        this.he_heading_degT = he_heading_degT;
        this.he_displaced_threshold_ft = he_displaced_threshold_ft;
    }

    public String getAurport_ref(){
        return this.airport_ref;
    }

    public String getId() {
        return this.id;
    }

    public String getAirport_ref() {
        return this.airport_ref;
    }

    public String getAirport_ident() {
        return this.airport_ident;
    }

    public String getLength_ft() {
        return this.length_ft;
    }

    public String getWidth_ft() {
        return this.width_ft;
    }

    public String getSurface() {
        return this.surface;
    }

    public String getLighted() {
        return this.lighted;
    }

    public String getClosed() {
        return this.closed;
    }

    public String getLe_ident() {
        return this.le_ident;
    }

    public String getLe_latitude_deg() {
        return this.le_latitude_deg;
    }

    public String getLe_longitude_deg() {
        return this.le_longitude_deg;
    }

    public String getLe_elevation_ft() {
        return this.le_elevation_ft;
    }

    public String getLe_heading_degT() {
        return this.le_heading_degT;
    }

    public String getLe_displaced_threshold_ft() {
        return this.le_displaced_threshold_ft;
    }

    public String getHe_ident() {
        return this.he_ident;
    }

    public String getHe_latitude_deg() {
        return this.he_latitude_deg;
    }

    public String getHe_longitude_deg() {
        return this.he_longitude_deg;
    }

    public String getHe_elevation_ft() {
        return this.he_elevation_ft;
    }

    public String getHe_heading_degT() {
        return this.he_heading_degT;
    }

    public String getHe_displaced_threshold_ft() {
        return this.he_displaced_threshold_ft;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", airport_ref='" + getAirport_ref() + "'" +
            ", airport_ident='" + getAirport_ident() + "'" +
            ", length_ft='" + getLength_ft() + "'" +
            ", width_ft='" + getWidth_ft() + "'" +
            ", surface='" + getSurface() + "'" +
            ", lighted='" + getLighted() + "'" +
            ", closed='" + getClosed() + "'" +
            ", le_ident='" + getLe_ident() + "'" +
            ", le_latitude_deg='" + getLe_latitude_deg() + "'" +
            ", le_longitude_deg='" + getLe_longitude_deg() + "'" +
            ", le_elevation_ft='" + getLe_elevation_ft() + "'" +
            ", le_heading_degT='" + getLe_heading_degT() + "'" +
            ", le_displaced_threshold_ft='" + getLe_displaced_threshold_ft() + "'" +
            ", he_ident='" + getHe_ident() + "'" +
            ", he_latitude_deg='" + getHe_latitude_deg() + "'" +
            ", he_longitude_deg='" + getHe_longitude_deg() + "'" +
            ", he_elevation_ft='" + getHe_elevation_ft() + "'" +
            ", he_heading_degT='" + getHe_heading_degT() + "'" +
            ", he_displaced_threshold_ft='" + getHe_displaced_threshold_ft() + "'" +
            "}";
    }


}
