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
         Trener t = jdbcTemplate.queryForObject(
        "SELECT * FROM trener WHERE korisnickoIme=?",
        (rs,rowNum)->{

            Trener trener = new Trener();

            trener.setKorisnickoIme(rs.getString("korisnickoIme"));
            trener.setSifra(rs.getString("sifra"));
            trener.setIme(rs.getString("ime"));
            trener.setPrezime(rs.getString("prezime"));

            return trener;
        },
        id
    );


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
}
