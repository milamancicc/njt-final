/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.converter.SportistaVezbaConverter;
import app.domain.SportistaVezba;
import app.dto.SportistaVezbaDto;
import app.repository.SportistaRepository;
import app.repository.SportistaVezbaRepository;
import app.repository.VezbaRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class SportistaVezbaService {
    public final SportistaVezbaRepository svr;
    private SportistaVezbaConverter svc;
    private final SportistaRepository sr;
    private final VezbaRepository vr;

    public SportistaVezbaService(SportistaVezbaRepository svr, SportistaRepository sr, VezbaRepository vr) {
        this.svr = svr;
        this.sr = sr;
        this.vr = vr;
        this.svc = new SportistaVezbaConverter(sr, vr);
    }
    
    
    public void save(SportistaVezbaDto dto){
        svr.save(svc.toEntity(dto));
    }
    
    
    public void delete(String sportista, String vezba){
        svr.delete(sportista, vezba);
    }
    
    public void update(String sportistaId, String vezbaId, Integer br){
        SportistaVezbaDto dto = new SportistaVezbaDto(sportistaId, vezbaId, br);
        svr.update(svc.toEntity(dto));
    }
    
    public List<SportistaVezbaDto> findAllBySportista(String sportistaId){
        List<SportistaVezba> sportistavezbe = svr.findBySportistaId(sportistaId);
        List<SportistaVezbaDto> dtoList = new ArrayList<>();
        for(SportistaVezba s: sportistavezbe){
            SportistaVezbaDto svd = svc.toDto(s);
            svd.setNorma(vr.findById(svd.getVezbaId()).getNorma());
            dtoList.add(svd);
        }
        return dtoList;
    }
}
