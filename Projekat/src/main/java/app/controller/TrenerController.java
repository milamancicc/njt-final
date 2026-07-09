/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dto.TrenerDto;
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


    public TrenerController(TrenerService trenerService){
        this.trenerService = trenerService;
    }


    @PostMapping("/login")
    public TrenerDto login(@RequestBody TrenerDto trener){

        return trenerService.login(
                trener.getKorisnickoIme(),
                trener.getSifra()
        );
    }
}
