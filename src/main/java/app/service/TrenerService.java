/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.service;

import app.converter.SportistaConverter;
import app.converter.TrenerConverter;
import app.domain.Trener;
import app.dto.TrenerDto;
import app.repository.TrenerRepository;

/**
 *
 * @author PC
 */
public class TrenerService {
     public final TrenerRepository tr;
     private TrenerConverter tc;
     

    public TrenerService(TrenerRepository tr) {
        this.tr = tr;
        this.tc = new TrenerConverter(tr);
    }
    
    public TrenerDto findById(String id){
        Trener t = tr.findById(id);
        if (t == null) {
            return null;
        }
        return tc.toDto(t);
    }
    
}
