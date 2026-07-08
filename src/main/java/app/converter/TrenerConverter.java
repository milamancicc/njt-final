/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.converter;

import app.domain.Sportista;
import app.domain.Trener;
import app.dto.SportistaDto;
import app.dto.TrenerDto;
import app.repository.TrenerRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class TrenerConverter implements Converter<Trener, TrenerDto> {

    private SportistaConverter sc;

    public TrenerConverter( TrenerRepository tr) {
        this.sc = new SportistaConverter(tr);
    }
    
    
    
    @Override
    public Trener toEntity(TrenerDto dto) {
        List<SportistaDto> sportistiDto = dto.getSportisti();
        List<Sportista> sportisti = new ArrayList<>();
        for(SportistaDto sDto:sportistiDto){
            Sportista s = sc.toEntity(sDto);
            sportisti.add(s);
        }
        return new Trener(dto.getKorisnickoIme(), dto.getSifra(), dto.getIme(), dto.getPrezime(), sportisti);
    }

    @Override
    public TrenerDto toDto(Trener entity) {
        List<SportistaDto> sportistiDto = new ArrayList<>();
        List<Sportista> sportisti = entity.getSportistaList();
        for(Sportista s:sportisti){
            SportistaDto sDto = sc.toDto(s);
            sportistiDto.add(sDto);
        }
        return new TrenerDto(entity.getKorisnickoIme(), entity.getSifra(), entity.getIme(), entity.getPrezime(), sportistiDto);
    }
    
}
