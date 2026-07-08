/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "sportista")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sportista.findAll", query = "SELECT s FROM Sportista s"),
    @NamedQuery(name = "Sportista.findByKorisnickoIme", query = "SELECT s FROM Sportista s WHERE s.korisnickoIme = :korisnickoIme"),
    @NamedQuery(name = "Sportista.findBySifra", query = "SELECT s FROM Sportista s WHERE s.sifra = :sifra"),
    @NamedQuery(name = "Sportista.findByIme", query = "SELECT s FROM Sportista s WHERE s.ime = :ime"),
    @NamedQuery(name = "Sportista.findByPrezime", query = "SELECT s FROM Sportista s WHERE s.prezime = :prezime"),
    @NamedQuery(name = "Sportista.findByPol", query = "SELECT s FROM Sportista s WHERE s.pol = :pol"),
    @NamedQuery(name = "Sportista.findByDatumRodjenja", query = "SELECT s FROM Sportista s WHERE s.datumRodjenja = :datumRodjenja")})
public class Sportista implements Serializable {

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
    @Column(name = "pol")
    private Character pol;
    @Column(name = "datumRodjenja")
    @Temporal(TemporalType.DATE)
    private LocalDate datumRodjenja;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sportista")
    private List<SportistaVezba> sportistaVezbaList;
    @JoinColumn(name = "trener", referencedColumnName = "korisnickoIme")
    @ManyToOne
    private Trener trener;

    public Sportista() {
    }

    public Sportista(String korisnickoIme, String sifra, String ime, String prezime, Character pol, LocalDate datumRodjenja, Trener trener) {
        this.korisnickoIme = korisnickoIme;
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.sportistaVezbaList = sportistaVezbaList;
        this.trener = trener;
    }
    
    

    public Sportista(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
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

    public Character getPol() {
        return pol;
    }

    public void setPol(Character pol) {
        this.pol = pol;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @XmlTransient
    public List<SportistaVezba> getSportistaVezbaList() {
        return sportistaVezbaList;
    }

    public void setSportistaVezbaList(List<SportistaVezba> sportistaVezbaList) {
        this.sportistaVezbaList = sportistaVezbaList;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        this.trener = trener;
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
        if (!(object instanceof Sportista)) {
            return false;
        }
        Sportista other = (Sportista) object;
        if ((this.korisnickoIme == null && other.korisnickoIme != null) || (this.korisnickoIme != null && !this.korisnickoIme.equals(other.korisnickoIme))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.Sportista[ korisnickoIme=" + korisnickoIme + " ]";
    }
    
}
