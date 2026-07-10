/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.dto.VezbaDto;
import app.repository.VezbaRepository;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api/vezbe")
@CrossOrigin(origins = "http://localhost:5173")

public class VezbaController {
    private final VezbaRepository vr;

    public VezbaController(VezbaRepository vr) {
        this.vr = vr;
    }
    @GetMapping
    public List<VezbaDto> getAll(){
        return vr.findAll();
    }
}
