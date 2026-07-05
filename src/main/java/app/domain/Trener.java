/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "trener")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trener.findAll", query = "SELECT t FROM Trener t"),
    @NamedQuery(name = "Trener.findByIdTrenera", query = "SELECT t FROM Trener t WHERE t.idTrenera = :idTrenera"),
    @NamedQuery(name = "Trener.findByIme", query = "SELECT t FROM Trener t WHERE t.ime = :ime"),
    @NamedQuery(name = "Trener.findByPrezime", query = "SELECT t FROM Trener t WHERE t.prezime = :prezime"),
    @NamedQuery(name = "Trener.findByKontakt", query = "SELECT t FROM Trener t WHERE t.kontakt = :kontakt"),
    @NamedQuery(name = "Trener.findByKorisnickoIme", query = "SELECT t FROM Trener t WHERE t.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Trener.findBySifra", query = "SELECT t FROM Trener t WHERE t.sifra = :sifra")})
public class Trener implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrenera")
    private Long idTrenera;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kontakt")
    private String kontakt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "korisnickoIme")
    private String korisnickoIme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sifra")
    private String sifra;

    public Trener() {
    }

    public Trener(Long idTrenera) {
        this.idTrenera = idTrenera;
    }

    public Trener(Long idTrenera, String ime, String prezime, String kontakt, String korisnickoIme, String sifra) {
        this.idTrenera = idTrenera;
        this.ime = ime;
        this.prezime = prezime;
        this.kontakt = kontakt;
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
    }

    public Long getIdTrenera() {
        return idTrenera;
    }

    public void setIdTrenera(Long idTrenera) {
        this.idTrenera = idTrenera;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrenera != null ? idTrenera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trener)) {
            return false;
        }
        Trener other = (Trener) object;
        if ((this.idTrenera == null && other.idTrenera != null) || (this.idTrenera != null && !this.idTrenera.equals(other.idTrenera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.Trener[ idTrenera=" + idTrenera + " ]";
    }
    
}
