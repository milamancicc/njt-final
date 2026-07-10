/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controller;

import app.service.IzvestajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api/izvestaj")
@CrossOrigin(origins = "http://localhost:5173")
public class IzvestajController {
    @Autowired
    private IzvestajService izvestajService;


     @GetMapping("/{id}")
    public ResponseEntity<byte[]> izvestaj(
            @PathVariable("id") String id
    ) throws Exception {


        byte[] pdf =
                izvestajService.generisiIzvestaj(id);


        return ResponseEntity.ok()
                .header(
                    "Content-Disposition",
                    "attachment; filename=izvestaj.pdf"
                )
                .contentType(
                    MediaType.APPLICATION_PDF
                )
                .body(pdf);
    }
}
