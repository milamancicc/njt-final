/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dto.SportistaVezbaDto;
import app.service.SportistaVezbaService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api/sportista-vezbe")
@CrossOrigin(origins = "http://localhost:5173")
public class SportistaVezbaController {
    private final SportistaVezbaService service;

    public SportistaVezbaController(SportistaVezbaService service) {
        this.service = service;
    }
    
    
    @GetMapping("/{sportistaId}")
    public List<SportistaVezbaDto> getVezbe(@PathVariable("sportistaId") String sportistaId){
        return service.findAllBySportista(sportistaId);
    }
    
    
    @DeleteMapping("/{sportistaId}/{vezbaId}")
    public void delete(
            @PathVariable("sportistaId") String sportistaId,
            @PathVariable("vezbaId") String vezbaId
    ){
        service.delete(sportistaId, vezbaId);
    }
    
    
    @PostMapping
    public void save(@RequestBody SportistaVezbaDto dto){

        service.save(dto);

    }
    
    
    @PutMapping("/{sportistaId}/{vezbaId}")
    public void update(
            @PathVariable("sportistaId") String sportistaId,
            @PathVariable("vezbaId") String vezbaId,
            @RequestBody SportistaVezbaDto dto
    ){

        service.update(
            sportistaId,
            vezbaId,
            dto.getBrojPonavljanja()
        );

    }
}
