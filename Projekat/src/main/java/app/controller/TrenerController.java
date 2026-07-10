/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dto.LoginResponseDto;
import app.dto.TrenerDto;
import app.dto.TrenerResponseDto;
import app.security.JwtUtil;
import app.service.TrenerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api/treneri")
@CrossOrigin(origins = "http://localhost:5173")
public class TrenerController {
    private final TrenerService trenerService;
    private final JwtUtil jwtUtil;

    public TrenerController(TrenerService trenerService, JwtUtil jwtUtil){
        this.trenerService = trenerService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody TrenerDto trener){
        TrenerDto t = trenerService.login(trener.getKorisnickoIme(), trener.getSifra());
        if(t == null)
            return null;
        TrenerResponseDto res = new TrenerResponseDto(t.getKorisnickoIme(), t.getIme(), t.getPrezime(), t.getSportisti());
        String token = jwtUtil.generateToken(t.getKorisnickoIme());
        return new LoginResponseDto(token, res);
    }
}
