/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dto;

/**
 *
 * @author PC
 */
public class LoginResponseDto {
    private String token;
    private Object korisnik;

    public LoginResponseDto(String token, Object korisnik) {
        this.token = token;
        this.korisnik = korisnik;
    }

    public Object getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Object korisnik) {
        this.korisnik = korisnik;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
