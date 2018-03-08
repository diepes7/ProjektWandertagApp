package com.example.oliver.wandertagapp;

import java.util.Date;
import java.util.List;

/**
 * Created by Oliver on 18.01.2018.
 */

public class Veranstaltung {
    private String bezeichnung;
    private String strasse;
    private String ort;
    private String land;
    private String telefon;
    private String email;
    private List<Teilnehmer> teilnehmerList;

    private Date StartDatum;
    private Date EndDatum;
    private String Art_Veranstaltung;
    private String Bemerkung;
    private String Veranstalter;
    private boolean Aktiv;



    public Veranstaltung(String bezeichnung, String strasse, String ort, String land, String telefon, String email, List<Teilnehmer> teilnehmerList, Date startDatum, Date endDatum, String art_Veranstaltung, String bemerkung, String veranstalter, boolean aktiv) {
        this.bezeichnung = bezeichnung;
        this.strasse = strasse;
        this.ort = ort;
        this.land = land;
        this.telefon = telefon;
        this.email = email;
        this.teilnehmerList = teilnehmerList;
        StartDatum = startDatum;
        EndDatum = endDatum;
        Art_Veranstaltung = art_Veranstaltung;
        Bemerkung = bemerkung;
        Veranstalter = veranstalter;
        Aktiv = aktiv;
    }

    public Date getStartDatum() {
        return StartDatum;
    }

    public void setStartDatum(Date startDatum) {
        StartDatum = startDatum;
    }

    public Date getEndDatum() {
        return EndDatum;
    }

    public void setEndDatum(Date endDatum) {
        EndDatum = endDatum;
    }

    public String getArt_Veranstaltung() {
        return Art_Veranstaltung;
    }

    public void setArt_Veranstaltung(String art_Veranstaltung) {
        Art_Veranstaltung = art_Veranstaltung;
    }

    public String getBemerkung() {
        return Bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        Bemerkung = bemerkung;
    }

    public String getVeranstalter() {
        return Veranstalter;
    }

    public void setVeranstalter(String veranstalter) {
        Veranstalter = veranstalter;
    }

    public boolean isAktiv() {
        return Aktiv;
    }

    public void setAktiv(boolean aktiv) {
        Aktiv = aktiv;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        strasse = strasse;
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

    public List<Teilnehmer> getTeilnehmerList() {
        return teilnehmerList;
    }

    public void setTeilnehmerList(List<Teilnehmer> teilnehmerList) {
        this.teilnehmerList = teilnehmerList;
    }


    @Override
    public String toString() {
        return bezeichnung + " --> " +ort + "/" + land;
    }
}
