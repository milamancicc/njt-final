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
public class TrenerResponseDto {
    private String korisnickoIme;
    private String ime;
    private String prezime;
    private List<SportistaDto> sportisti;

    public TrenerResponseDto(String korisnickoIme, String ime, String prezime, List<SportistaDto> sportisti) {
        this.korisnickoIme = korisnickoIme;
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
