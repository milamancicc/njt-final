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
@Table(name = "vezba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vezba.findAll", query = "SELECT v FROM Vezba v"),
    @NamedQuery(name = "Vezba.findByIdVezbe", query = "SELECT v FROM Vezba v WHERE v.idVezbe = :idVezbe"),
    @NamedQuery(name = "Vezba.findByNaziv", query = "SELECT v FROM Vezba v WHERE v.naziv = :naziv"),
    @NamedQuery(name = "Vezba.findByOpis", query = "SELECT v FROM Vezba v WHERE v.opis = :opis"),
    @NamedQuery(name = "Vezba.findByNorma", query = "SELECT v FROM Vezba v WHERE v.norma = :norma"),
    @NamedQuery(name = "Vezba.findByJedinicaMere", query = "SELECT v FROM Vezba v WHERE v.jedinicaMere = :jedinicaMere"),
    @NamedQuery(name = "Vezba.findByKategorija", query = "SELECT v FROM Vezba v WHERE v.kategorija = :kategorija")})
public class Vezba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVezbe")
    private Long idVezbe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "opis")
    private String opis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "norma")
    private double norma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "jedinicaMere")
    private String jedinicaMere;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "kategorija")
    private String kategorija;

    public Vezba() {
    }

    public Vezba(Long idVezbe) {
        this.idVezbe = idVezbe;
    }

    public Vezba(Long idVezbe, String naziv, String opis, double norma, String jedinicaMere, String kategorija) {
        this.idVezbe = idVezbe;
        this.naziv = naziv;
        this.opis = opis;
        this.norma = norma;
        this.jedinicaMere = jedinicaMere;
        this.kategorija = kategorija;
    }

    public Long getIdVezbe() {
        return idVezbe;
    }

    public void setIdVezbe(Long idVezbe) {
        this.idVezbe = idVezbe;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public double getNorma() {
        return norma;
    }

    public void setNorma(double norma) {
        this.norma = norma;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVezbe != null ? idVezbe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vezba)) {
            return false;
        }
        Vezba other = (Vezba) object;
        if ((this.idVezbe == null && other.idVezbe != null) || (this.idVezbe != null && !this.idVezbe.equals(other.idVezbe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.Vezba[ idVezbe=" + idVezbe + " ]";
    }
    
}
