package com.example.oliver.wandertagapp;

import java.io.Serializable;

/**
 * Created by Oliver on 18.01.2018.
 */

public class User implements Serializable{
    private String vorname;
    private String nachname;
    private String email;
    private String passwort;
    private String rolle;

    public User(String vorname, String nachname, String email, String passwort, String rolle) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.passwort = passwort;
        this.rolle = rolle;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }
}
