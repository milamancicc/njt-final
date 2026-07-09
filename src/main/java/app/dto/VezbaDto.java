/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

/**
 *
 * @author PC
 */
public class VezbaDto {
    private String naziv;
    private Integer norma;
    private String opis;

    public VezbaDto() {
    }

    public VezbaDto(String naziv, Integer norma, String opis) {
        this.naziv = naziv;
        this.norma = norma;
        this.opis = opis;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getNorma() {
        return norma;
    }

    public void setNorma(Integer norma) {
        this.norma = norma;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    
}
