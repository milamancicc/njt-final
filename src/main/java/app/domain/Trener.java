/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "trener")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trener.findAll", query = "SELECT t FROM Trener t"),
    @NamedQuery(name = "Trener.findByKorisnickoIme", query = "SELECT t FROM Trener t WHERE t.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Trener.findBySifra", query = "SELECT t FROM Trener t WHERE t.sifra = :sifra"),
    @NamedQuery(name = "Trener.findByIme", query = "SELECT t FROM Trener t WHERE t.ime = :ime"),
    @NamedQuery(name = "Trener.findByPrezime", query = "SELECT t FROM Trener t WHERE t.prezime = :prezime")})
public class Trener implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "korisnickoIme")
    private String korisnickoIme;
    @Size(max = 255)
    @Column(name = "sifra")
    private String sifra;
    @Size(max = 255)
    @Column(name = "ime")
    private String ime;
    @Size(max = 255)
    @Column(name = "prezime")
    private String prezime;
    @OneToMany(mappedBy = "trener")
    private List<Sportista> sportistaList;

    public Trener() {
    }

    public Trener(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public Trener(String korisnickoIme, String sifra, String ime, String prezime, List<Sportista> sportistaList) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.sportistaList = sportistaList;
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

    @XmlTransient
    public List<Sportista> getSportistaList() {
        return sportistaList;
    }

    public void setSportistaList(List<Sportista> sportistaList) {
        this.sportistaList = sportistaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (korisnickoIme != null ? korisnickoIme.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trener)) {
            return false;
        }
        Trener other = (Trener) object;
        if ((this.korisnickoIme == null && other.korisnickoIme != null) || (this.korisnickoIme != null && !this.korisnickoIme.equals(other.korisnickoIme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.Trener[ korisnickoIme=" + korisnickoIme + " ]";
    }
    
}
