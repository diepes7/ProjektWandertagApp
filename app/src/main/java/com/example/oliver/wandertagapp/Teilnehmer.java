package com.example.oliver.wandertagapp;

import java.io.Serializable;

/**
 * Created by Oliver on 01.02.2018.
 */

public class Teilnehmer implements Serializable{
    private String vorname;
    private String nachname;
    private String geburtsdatum;
    private String geschlecht;
    private String strasse;
    private String ort;
    private String land;
    private String email;
    private String telefon;

    public Teilnehmer(String vorname, String nachname, String geburtsdatum, String geschlecht, String strasse, String ort, String land, String email, String telefon) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.geschlecht = geschlecht;
        this.strasse = strasse;
        this.ort = ort;
        this.land = land;
        this.email = email;
        this.telefon = telefon;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return vorname + " " + nachname + " ("+ ort+")\t" + geschlecht;
    }
}
