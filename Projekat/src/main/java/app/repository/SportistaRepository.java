/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;
import app.domain.Sportista;
import app.domain.Trener;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PC
 */
@Repository(value = "sportista-repository")
public class SportistaRepository {
    
    private final JdbcTemplate jdbcTemplate;
    private final TrenerRepository tr;
    
    @Autowired
    public SportistaRepository(JdbcTemplate jdbcTemplate, TrenerRepository tr) {
        this.jdbcTemplate = jdbcTemplate;
        this.tr = tr;
    }
    
    
    public List<Sportista> findAllByTrener(String trenerId) {
        return jdbcTemplate.query("SELECT * FROM Sportista WHERE trener=?", (rs, rowNum)->{
            Sportista s = new Sportista();
            s.setKorisnickoIme(rs.getString("korisnickoIme"));
            s.setSifra(rs.getString("sifra"));
            s.setIme(rs.getString("ime"));
            s.setPrezime(rs.getString("prezime"));
            s.setPol(rs.getString("pol").charAt(0));
            s.setDatumRodjenja(rs.getDate("datumRodjenja").toLocalDate());
            Trener trener = new Trener();
            trener.setKorisnickoIme(rs.getString("trener"));

            s.setTrener(trener);
            return s;
        },
                trenerId);
    }


    public Sportista findById(String id) {
         List<Sportista> sportisti = jdbcTemplate.query(
            "SELECT * FROM sportista WHERE korisnickoIme=?",
            (rs, rowNum) -> {

                Sportista s = new Sportista();

                s.setKorisnickoIme(rs.getString("korisnickoIme"));
                s.setSifra(rs.getString("sifra"));
                s.setIme(rs.getString("ime"));
                s.setPrezime(rs.getString("prezime"));

                String trenerId = rs.getString("trener");

                if (trenerId != null) {
                    Trener trener = tr.findById(trenerId);
                    s.setTrener(trener);
                }

                String pol = rs.getString("pol");
                if (pol != null) {
                    s.setPol(pol.charAt(0));
                }

                if (rs.getDate("datumRodjenja") != null) {
                    s.setDatumRodjenja(
                        rs.getDate("datumRodjenja").toLocalDate()
                    );
                }

                return s;
            },
            id
        );

        if (sportisti.isEmpty()) {
            return null;
        }

        return sportisti.get(0);
    }


    public void save(Sportista sportista) {
        jdbcTemplate.update("INSERT INTO sportista (korisnickoIme, sifra, ime, prezime, trener, pol, datumRodjenja) VALUES (?,?,?,?,?,?,?)", 
                sportista.getKorisnickoIme(),
                sportista.getSifra(),
                sportista.getIme(),
                sportista.getPrezime(),
                sportista.getTrener().getKorisnickoIme(),
                sportista.getPol().toString(),
                sportista.getDatumRodjenja());
    
    }


    public void delete(String korisnickoIme) {
        
        jdbcTemplate.update(
            "DELETE FROM sportista_vezba WHERE sportista_id=?",
            korisnickoIme
        );

        jdbcTemplate.update(
            "DELETE FROM sportista WHERE korisnickoIme=?",
            korisnickoIme
        );
    }
    
    public Sportista login(String korisnickoIme, String sifra){
        Sportista s = findById(korisnickoIme);
        if(s != null && s.getSifra().equals(sifra)){
            return s;
        }
        return null;
    }
}
