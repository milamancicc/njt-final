/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;

import app.domain.Sportista;
import app.domain.SportistaVezba;
import app.domain.Vezba;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository(value = "sportistaVezba-repository")
public class SportistaVezbaRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SportistaVezbaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void save(SportistaVezba sv){
        jdbcTemplate.update("INSERT INTO sportista_vezba (sportista_id, vezba_id, brojPonavljanja) VALUES (?,?,?)", 
                sv.getSportista().getKorisnickoIme(),
                sv.getVezba().getNaziv(),
                sv.getBrojPonavljanja());
    
    }
    
    
    public void delete(String sportistaId, String vezbaId) {
        jdbcTemplate.update("DELETE FROM sportista_vezba WHERE sportista_id=? AND vezba_id=?",
                sportistaId,
                vezbaId);
    }
    
    
    public List<SportistaVezba> findBySportistaId(String sportistaId){

    return jdbcTemplate.query("SELECT\n" + "    sv.sportista_id,\n" + "    sv.vezba_id,\n" + "    sv.brojPonavljanja,\n" + "    v.naziv,\n" + "    v.norma,\n" + "    v.opis\n" + "FROM sportista_vezba sv\n" + "JOIN vezba v\n" + "ON sv.vezba_id = v.naziv\n" + "WHERE sv.sportista_id=?\n",
        (rs, rowNum) -> {

            SportistaVezba sv = new SportistaVezba();

            Sportista sportista = new Sportista();
            sportista.setKorisnickoIme(
                rs.getString("sportista_id")
            );


            Vezba vezba = new Vezba();

            vezba.setNaziv(
                rs.getString("naziv")
            );

            vezba.setNorma(
                rs.getInt("norma")
            );

            vezba.setOpis(
                rs.getString("opis")
            );


            sv.setSportista(sportista);
            sv.setVezba(vezba);


            sv.setBrojPonavljanja(
                rs.getInt("brojPonavljanja")
            );


            return sv;
        },
        sportistaId
    );
}
    
    public void update(SportistaVezba sv) {

        jdbcTemplate.update(
            "UPDATE sportista_vezba SET brojPonavljanja=? WHERE sportista_id=? AND vezba_id=?",
            sv.getBrojPonavljanja(),
            sv.getSportista().getKorisnickoIme(),
            sv.getVezba().getNaziv()
        );

}
    
}
