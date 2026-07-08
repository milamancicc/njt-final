/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

/**
 *
 * @author PC
 */
public class SportistaVezbaDto {
    private String sportistaId;
    private String vezbaId;
    private Integer brojPonavljanja;

    public SportistaVezbaDto(String sportistaId, String vezbaId, Integer brojPonavljanja) {
        this.sportistaId = sportistaId;
        this.vezbaId = vezbaId;
        this.brojPonavljanja = brojPonavljanja;
    }

    public SportistaVezbaDto() {
    }

    public String getSportistaId() {
        return sportistaId;
    }

    public void setSportistaId(String sportistaId) {
        this.sportistaId = sportistaId;
    }

    public String getVezbaId() {
        return vezbaId;
    }

    public void setVezbaId(String vezbaId) {
        this.vezbaId = vezbaId;
    }

    public Integer getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(Integer brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }
    
    
}
