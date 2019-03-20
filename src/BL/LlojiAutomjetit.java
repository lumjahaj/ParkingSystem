/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lumi
 */
@Entity
@Table(name = "LlojiAutomjetit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlojiAutomjetit.findAll", query = "SELECT l FROM LlojiAutomjetit l")
    , @NamedQuery(name = "LlojiAutomjetit.findByLlojiAutomjetitID", query = "SELECT l FROM LlojiAutomjetit l WHERE l.llojiAutomjetitID = :llojiAutomjetitID")
    , @NamedQuery(name = "LlojiAutomjetit.findByEmriLlojit", query = "SELECT l FROM LlojiAutomjetit l WHERE l.emriLlojit = :emriLlojit")})
public class LlojiAutomjetit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LlojiAutomjetitID")
    private Integer llojiAutomjetitID;
    @Basic(optional = false)
    @Column(name = "EmriLlojit")
    private String emriLlojit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "llojiAutomjetitID")
    private Collection<TipiAutomjetit> tipiAutomjetitCollection;

    public LlojiAutomjetit() {
    }

    public LlojiAutomjetit(Integer llojiAutomjetitID) {
        this.llojiAutomjetitID = llojiAutomjetitID;
    }

    public LlojiAutomjetit(Integer llojiAutomjetitID, String emriLlojit) {
        this.llojiAutomjetitID = llojiAutomjetitID;
        this.emriLlojit = emriLlojit;
    }

    public Integer getLlojiAutomjetitID() {
        return llojiAutomjetitID;
    }

    public void setLlojiAutomjetitID(Integer llojiAutomjetitID) {
        this.llojiAutomjetitID = llojiAutomjetitID;
    }

    public String getEmriLlojit() {
        return emriLlojit;
    }

    public void setEmriLlojit(String emriLlojit) {
        this.emriLlojit = emriLlojit;
    }

    @XmlTransient
    public Collection<TipiAutomjetit> getTipiAutomjetitCollection() {
        return tipiAutomjetitCollection;
    }

    public void setTipiAutomjetitCollection(Collection<TipiAutomjetit> tipiAutomjetitCollection) {
        this.tipiAutomjetitCollection = tipiAutomjetitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (llojiAutomjetitID != null ? llojiAutomjetitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlojiAutomjetit)) {
            return false;
        }
        LlojiAutomjetit other = (LlojiAutomjetit) object;
        if ((this.llojiAutomjetitID == null && other.llojiAutomjetitID != null) || (this.llojiAutomjetitID != null && !this.llojiAutomjetitID.equals(other.llojiAutomjetitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriLlojit;
    }
    
}
