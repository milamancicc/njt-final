/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "sportista_vezba")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SportistaVezba.findAll", query = "SELECT s FROM SportistaVezba s"),
    @NamedQuery(name = "SportistaVezba.findBySportistaId", query = "SELECT s FROM SportistaVezba s WHERE s.sportistaVezbaPK.sportistaId = :sportistaId"),
    @NamedQuery(name = "SportistaVezba.findByVezbaId", query = "SELECT s FROM SportistaVezba s WHERE s.sportistaVezbaPK.vezbaId = :vezbaId"),
    @NamedQuery(name = "SportistaVezba.findByBrojPonavljanja", query = "SELECT s FROM SportistaVezba s WHERE s.brojPonavljanja = :brojPonavljanja")})
public class SportistaVezba implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SportistaVezbaPK sportistaVezbaPK;
    @Column(name = "brojPonavljanja")
    private Integer brojPonavljanja;
    @JoinColumn(name = "sportista_id", referencedColumnName = "korisnickoIme", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Sportista sportista;
    @JoinColumn(name = "vezba_id", referencedColumnName = "naziv", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vezba vezba;

    public SportistaVezba() {
    }

    
    public SportistaVezba(SportistaVezbaPK sportistaVezbaPK) {
        this.sportistaVezbaPK = sportistaVezbaPK;
    }

    public SportistaVezba( Sportista sportista, Vezba vezba, Integer brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
        this.sportista = sportista;
        this.vezba = vezba;
    }
    
    

    public SportistaVezba(String sportistaId, String vezbaId) {
        this.sportistaVezbaPK = new SportistaVezbaPK(sportistaId, vezbaId);
    }

    public SportistaVezbaPK getSportistaVezbaPK() {
        return sportistaVezbaPK;
    }

    public void setSportistaVezbaPK(SportistaVezbaPK sportistaVezbaPK) {
        this.sportistaVezbaPK = sportistaVezbaPK;
    }

    public Integer getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(Integer brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    public Sportista getSportista() {
        return sportista;
    }

    public void setSportista(Sportista sportista) {
        this.sportista = sportista;
    }

    public Vezba getVezba() {
        return vezba;
    }

    public void setVezba(Vezba vezba) {
        this.vezba = vezba;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sportistaVezbaPK != null ? sportistaVezbaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SportistaVezba)) {
            return false;
        }
        SportistaVezba other = (SportistaVezba) object;
        if ((this.sportistaVezbaPK == null && other.sportistaVezbaPK != null) || (this.sportistaVezbaPK != null && !this.sportistaVezbaPK.equals(other.sportistaVezbaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.SportistaVezba[ sportistaVezbaPK=" + sportistaVezbaPK + " ]";
    }
    
}
