/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class SportistaDto {
    private String korisnickoIme;
    private String sifra;
    private String ime;
    private String prezime;
    private Character pol;
    private LocalDate datumRodjenja;

    private String trenerId;

    public SportistaDto() {
    }

    public SportistaDto(String korisnickoIme, String sifra, String ime, String prezime, Character pol, LocalDate datumRodjenja, String trenerId) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.trenerId = trenerId;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Character getPol() {
        return pol;
    }

    public void setPol(Character pol) {
        this.pol = pol;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getTrenerId() {
        return trenerId;
    }

    public void setTrenerId(String trenerId) {
        this.trenerId = trenerId;
    }
    
    
}
