/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;

import app.domain.Sportista;
import app.domain.Trener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author PC
 */
@Repository(value = "trener-repository")
public class TrenerRepository {
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    public TrenerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public Trener findById(String id) {
         List<Trener> treneri = jdbcTemplate.query(
            "SELECT * FROM trener WHERE korisnickoIme=?",
            (rs, rowNum) -> {
                Trener t = new Trener();
                t.setKorisnickoIme(rs.getString("korisnickoIme"));
                t.setSifra(rs.getString("sifra"));
                t.setIme(rs.getString("ime"));
                t.setPrezime(rs.getString("prezime"));
                
                return t;
            },
            id
        );

        if (treneri.isEmpty()) {
            return null;
        }

        Trener t = treneri.get(0);
         

        List<Sportista> sportisti = jdbcTemplate.query(
            "SELECT * FROM sportista WHERE trener=?",
            (rs,rowNum)->{

                Sportista s = new Sportista();

                s.setKorisnickoIme(rs.getString("korisnickoIme"));
                s.setSifra(rs.getString("sifra"));
                s.setIme(rs.getString("ime"));
                s.setPrezime(rs.getString("prezime"));
                s.setTrener(t);

                return s;
            },
            id
        );

        t.setSportistaList(sportisti);

        return t;
    }
    
    public Trener login(String korisnickoIme, String sifra){
        Trener t = findById(korisnickoIme);

        if(t != null && t.getSifra().equals(sifra)){
            return t;
        }

        return null;
    }
}
