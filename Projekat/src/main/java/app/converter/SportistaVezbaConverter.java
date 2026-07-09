/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.converter;

import app.domain.SportistaVezba;
import app.domain.Vezba;
import app.dto.SportistaVezbaDto;
import app.repository.SportistaRepository;
import app.repository.VezbaRepository;

/**
 *
 * @author PC
 */
public class SportistaVezbaConverter implements Converter<SportistaVezba, SportistaVezbaDto> {

    private final SportistaRepository sr;
    private final VezbaRepository vr;

    public SportistaVezbaConverter(SportistaRepository sr, VezbaRepository vr) {
        this.sr = sr;
        this.vr = vr;
    }
    
    
    @Override
    public SportistaVezba toEntity(SportistaVezbaDto dto) {
        return new SportistaVezba(sr.findById(dto.getSportistaId()), vr.findById(dto.getVezbaId()), dto.getBrojPonavljanja());
    }

    @Override
    public SportistaVezbaDto toDto(SportistaVezba entity) {
        return new SportistaVezbaDto(entity.getSportista().getKorisnickoIme(), entity.getVezba().getNaziv(), entity.getBrojPonavljanja());
    }
    
}
