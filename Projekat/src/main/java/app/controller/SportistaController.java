/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dto.SportistaDto;
import app.service.SportistaService;
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

    @Autowired
    public SportistaController(SportistaService sportistaService) {
        System.out.println("SPORTISTA CONTROLLER UCITAN");
        this.sportistaService = sportistaService;
    }


    @PostMapping("/login")
    public SportistaDto login(@RequestBody SportistaDto sportista){

        return sportistaService.login(
                sportista.getKorisnickoIme(),
                sportista.getSifra()
        );
    }
    
    @GetMapping("/trener/{trenerId}")
    public List<SportistaDto> findAllByTrener(
            @PathVariable("trenerId") String trenerId){

        return sportistaService.findAllByTrener(trenerId);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id){
        System.out.println("BRISEM SPORTISTU: " + id);
        sportistaService.delete(id);
    }
    
    
    @PostMapping
    public void save(@RequestBody SportistaDto sportista){
        sportistaService.save(sportista);
    }
}
