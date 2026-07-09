/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

import java.util.List;

/**
 *
 * @author PC
 */
public class TrenerDto {
    private String korisnickoIme;
    private String sifra;
    private String ime;
    private String prezime;
    private List<SportistaDto> sportisti;

    public TrenerDto() {
    }

    public TrenerDto(String korisnickoIme, String sifra, String ime, String prezime) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
    }

    public TrenerDto(String korisnickoIme, String sifra, String ime, String prezime, List<SportistaDto> sportisti) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.sportisti = sportisti;
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

    public List<SportistaDto> getSportisti() {
        return sportisti;
    }

    public void setSportisti(List<SportistaDto> sportisti) {
        this.sportisti = sportisti;
    }
    
    
}
