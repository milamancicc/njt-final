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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "sportista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sportista.findAll", query = "SELECT s FROM Sportista s"),
    @NamedQuery(name = "Sportista.findByIdSportiste", query = "SELECT s FROM Sportista s WHERE s.idSportiste = :idSportiste"),
    @NamedQuery(name = "Sportista.findByIme", query = "SELECT s FROM Sportista s WHERE s.ime = :ime"),
    @NamedQuery(name = "Sportista.findByPrezime", query = "SELECT s FROM Sportista s WHERE s.prezime = :prezime"),
    @NamedQuery(name = "Sportista.findByDatumRodjenja", query = "SELECT s FROM Sportista s WHERE s.datumRodjenja = :datumRodjenja"),
    @NamedQuery(name = "Sportista.findByPol", query = "SELECT s FROM Sportista s WHERE s.pol = :pol"),
    @NamedQuery(name = "Sportista.findByKontakt", query = "SELECT s FROM Sportista s WHERE s.kontakt = :kontakt")})
public class Sportista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSportiste")
    private Long idSportiste;
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
    @Column(name = "datumRodjenja")
    @Temporal(TemporalType.DATE)
    private LocalDate datumRodjenja;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pol")
    private char pol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kontakt")
    private String kontakt;

    public Sportista() {
    }

    public Sportista(Long idSportiste) {
        this.idSportiste = idSportiste;
    }

    public Sportista(String ime, String prezime, LocalDate datumRodjenja, char pol, String kontakt) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.kontakt = kontakt;
    }
    

    public Sportista(Long idSportiste, String ime, String prezime, LocalDate datumRodjenja, char pol, String kontakt) {
        this.idSportiste = idSportiste;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.kontakt = kontakt;
    }

    public Long getIdSportiste() {
        return idSportiste;
    }

    public void setIdSportiste(Long idSportiste) {
        this.idSportiste = idSportiste;
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

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSportiste != null ? idSportiste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sportista)) {
            return false;
        }
        Sportista other = (Sportista) object;
        if ((this.idSportiste == null && other.idSportiste != null) || (this.idSportiste != null && !this.idSportiste.equals(other.idSportiste))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.Sportista[ idSportiste=" + idSportiste + " ]";
    }
    
}
