/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;

import app.domain.Vezba;
import app.dto.VezbaDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository(value = "vezba-repository")
public class VezbaRepository {
    
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public VezbaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Vezba findById(String naziv){

        return jdbcTemplate.queryForObject(
            "SELECT * FROM vezba WHERE naziv=?",
            (rs, rowNum) -> {

                Vezba v = new Vezba();

                v.setNaziv(rs.getString("naziv"));
                v.setNorma(rs.getInt("norma"));
                v.setOpis(rs.getString("opis"));

                return v;
            },
            naziv
        );
    
    }
    
    public List<VezbaDto> findAll(){
        return jdbcTemplate.query("SELECT * FROM vezba", (rs, rowNum)->{
            VezbaDto v = new VezbaDto();
            v.setNaziv(rs.getString("naziv"));
            v.setOpis(rs.getString("opis"));
            v.setNorma(rs.getInt("norma"));
            
            return v;
        });
    }
    
}
