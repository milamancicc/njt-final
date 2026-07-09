/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.converter;

import app.domain.Sportista;
import app.dto.SportistaDto;
import app.repository.TrenerRepository;

/**
 *
 * @author PC
 */
public class SportistaConverter implements Converter<Sportista, SportistaDto> {

    private final TrenerRepository tr;

    public SportistaConverter(TrenerRepository trenerRepository) {
        this.tr = trenerRepository;
    }
    
    
    @Override
    public Sportista toEntity(SportistaDto dto) {
        
        return new Sportista(dto.getKorisnickoIme(), dto.getSifra(), dto.getIme(), dto.getPrezime(), dto.getPol(), dto.getDatumRodjenja(), tr.findById(dto.getTrenerId()));
    }

    @Override
    public SportistaDto toDto(Sportista entity) {
        return new SportistaDto(entity.getKorisnickoIme(), entity.getSifra(), entity.getIme(), entity.getPrezime(), entity.getPol(), entity.getDatumRodjenja(), entity.getTrener().getKorisnickoIme());
    }
    
}
