/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dto.LoginResponseDto;
import app.dto.SportistaDto;
import app.dto.SportistaResponseDto;
import app.security.JwtUtil;
import app.service.SportistaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api/sportisti")
@CrossOrigin(origins = "http://localhost:5173")
public class SportistaController {
    private final SportistaService sportistaService;
    private final JwtUtil jwtUtil;

    @Autowired
    public SportistaController(SportistaService sportistaService, JwtUtil jwtUtil) {
        this.sportistaService = sportistaService;
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody SportistaDto sportista){
        SportistaDto s = sportistaService.login(sportista.getKorisnickoIme(), sportista.getSifra());
        if(s == null){
            return null;
        }
        String token = jwtUtil.generateToken(s.getKorisnickoIme());
        SportistaResponseDto res = new SportistaResponseDto(s.getKorisnickoIme(), s.getIme(), s.getPrezime(), s.getPol(), s.getDatumRodjenja());
        return new LoginResponseDto(token, res);

    }
    
    @GetMapping("/trener/{trenerId}")
    public List<SportistaDto> findAllByTrener(
            @PathVariable("trenerId") String trenerId){

        return sportistaService.findAllByTrener(trenerId);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        sportistaService.delete(id);
    }
    
    
    @PostMapping
    public void save(@RequestBody SportistaDto sportista){
        sportistaService.save(sportista);
    }
}
