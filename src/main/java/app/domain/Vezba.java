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
@Table(name = "vezba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vezba.findAll", query = "SELECT v FROM Vezba v"),
    @NamedQuery(name = "Vezba.findByNaziv", query = "SELECT v FROM Vezba v WHERE v.naziv = :naziv"),
    @NamedQuery(name = "Vezba.findByNorma", query = "SELECT v FROM Vezba v WHERE v.norma = :norma"),
    @NamedQuery(name = "Vezba.findByOpis", query = "SELECT v FROM Vezba v WHERE v.opis = :opis")})
public class Vezba implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "naziv")
    private String naziv;
    @Column(name = "norma")
    private Integer norma;
    @Size(max = 255)
    @Column(name = "opis")
    private String opis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vezba")
    private List<SportistaVezba> sportistaVezbaList;

    public Vezba() {
    }

    public Vezba(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getNorma() {
        return norma;
    }

    public void setNorma(Integer norma) {
        this.norma = norma;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @XmlTransient
    public List<SportistaVezba> getSportistaVezbaList() {
        return sportistaVezbaList;
    }

    public void setSportistaVezbaList(List<SportistaVezba> sportistaVezbaList) {
        this.sportistaVezbaList = sportistaVezbaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (naziv != null ? naziv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vezba)) {
            return false;
        }
        Vezba other = (Vezba) object;
        if ((this.naziv == null && other.naziv != null) || (this.naziv != null && !this.naziv.equals(other.naziv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.Vezba[ naziv=" + naziv + " ]";
    }
    
}
