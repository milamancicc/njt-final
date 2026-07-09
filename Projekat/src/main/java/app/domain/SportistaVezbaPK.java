/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author PC
 */
@Embeddable
public class SportistaVezbaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "sportista_id")
    private String sportistaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "vezba_id")
    private String vezbaId;

    public SportistaVezbaPK() {
    }

    public SportistaVezbaPK(String sportistaId, String vezbaId) {
        this.sportistaId = sportistaId;
        this.vezbaId = vezbaId;
    }

    public String getSportistaId() {
        return sportistaId;
    }

    public void setSportistaId(String sportistaId) {
        this.sportistaId = sportistaId;
    }

    public String getVezbaId() {
        return vezbaId;
    }

    public void setVezbaId(String vezbaId) {
        this.vezbaId = vezbaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sportistaId != null ? sportistaId.hashCode() : 0);
        hash += (vezbaId != null ? vezbaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SportistaVezbaPK)) {
            return false;
        }
        SportistaVezbaPK other = (SportistaVezbaPK) object;
        if ((this.sportistaId == null && other.sportistaId != null) || (this.sportistaId != null && !this.sportistaId.equals(other.sportistaId))) {
            return false;
        }
        if ((this.vezbaId == null && other.vezbaId != null) || (this.vezbaId != null && !this.vezbaId.equals(other.vezbaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.domain.SportistaVezbaPK[ sportistaId=" + sportistaId + ", vezbaId=" + vezbaId + " ]";
    }
    
}
