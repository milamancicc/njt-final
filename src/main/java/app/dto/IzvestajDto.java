/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

/**
 *
 * @author PC
 */
public class IzvestajDto {
    private String nazivVezbe;
    private Integer brojPonavljanja;

    public IzvestajDto() {
    }

    public IzvestajDto(String nazivVezbe, Integer brojPonavljanja) {
        this.nazivVezbe = nazivVezbe;
        this.brojPonavljanja = brojPonavljanja;
    }

    public String getNazivVezbe() {
        return nazivVezbe;
    }

    public void setNazivVezbe(String nazivVezbe) {
        this.nazivVezbe = nazivVezbe;
    }

    public Integer getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(Integer brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }
    
    
}
