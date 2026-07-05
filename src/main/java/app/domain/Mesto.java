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
@Table(name = "mesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesto.findAll", query = "SELECT m FROM Mesto m"),
    @NamedQuery(name = "Mesto.findByIdMesta", query = "SELECT m FROM Mesto m WHERE m.idMesta = :idMesta"),
    @NamedQuery(name = "Mesto.findByNaziv", query = "SELECT m FROM Mesto m WHERE m.naziv = :naziv")})
public class Mesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMesta")
    private Long idMesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "naziv")
    private String naziv;

    public Mesto() {
    }

    public Mesto(Long idMesta) {
        this.idMesta = idMesta;
    }

    public Mesto(Long idMesta, String naziv) {
        this.idMesta = idMesta;
        this.naziv = naziv;
    }

    public Long getIdMesta() {
        return idMesta;
    }

    public void setIdMesta(Long idMesta) {
        this.idMesta = idMesta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesta != null ? idMesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesto)) {
            return false;
        }
        Mesto other = (Mesto) object;
        if ((this.idMesta == null && other.idMesta != null) || (this.idMesta != null && !this.idMesta.equals(other.idMesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.Mesto[ idMesta=" + idMesta + " ]";
    }
    
}
