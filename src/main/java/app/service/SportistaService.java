/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.converter.SportistaConverter;
import app.domain.Sportista;
import app.dto.SportistaDto;
import app.repository.SportistaRepository;
import app.repository.TrenerRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class SportistaService {
    public final SportistaRepository sr;
    private SportistaConverter sc;

    public SportistaService(SportistaRepository sr, TrenerRepository tr) {
        this.sr = sr;
        this.sc = new SportistaConverter(tr);
    }
    
    public void save(SportistaDto dto){
        sr.save(sc.toEntity(dto));
    }
    
    public void delete(SportistaDto dto){
        sr.delete(dto.getKorisnickoIme());
    }
    
    public List<SportistaDto> findAllByTrener(String trenerId){
        List<Sportista> sportisti = sr.findAllByTrener(trenerId);
        List<SportistaDto> dtoList = new ArrayList<>();
        for(Sportista s: sportisti){
            dtoList.add(sc.toDto(s));
        }
        return dtoList;
    }
    
    public SportistaDto findById(String id){
        Sportista s = sr.findById(id);
        if(s == null)
            return null;
        return sc.toDto(s);
    }
}
