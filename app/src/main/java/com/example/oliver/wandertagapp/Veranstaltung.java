package com.example.oliver.wandertagapp;

/**
 * Created by Oliver on 18.01.2018.
 */

public class Veranstaltung {
    private String bezeichnung;
    private String Strasse;
    private String ort;
    private String land;
    private String telefon;
    private String email;

    public Veranstaltung(String bezeichnung, String strasse, String ort, String land, String telefon, String email) {
        this.bezeichnung = bezeichnung;
        Strasse = strasse;
        this.ort = ort;
        this.land = land;
        this.telefon = telefon;
        this.email = email;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return bezeichnung + " --> " +ort + "/" + land;
    }
}
