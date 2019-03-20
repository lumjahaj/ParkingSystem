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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TipiAutomjetit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipiAutomjetit.findAll", query = "SELECT t FROM TipiAutomjetit t")
    , @NamedQuery(name = "TipiAutomjetit.findByTipiAutomjetitID", query = "SELECT t FROM TipiAutomjetit t WHERE t.tipiAutomjetitID = :tipiAutomjetitID")
    , @NamedQuery(name = "TipiAutomjetit.findByEmriTipit", query = "SELECT t FROM TipiAutomjetit t WHERE t.emriTipit = :emriTipit")})
public class TipiAutomjetit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TipiAutomjetitID")
    private Integer tipiAutomjetitID;
    @Basic(optional = false)
    @Column(name = "EmriTipit")
    private String emriTipit;
    @JoinColumn(name = "LlojiAutomjetitID", referencedColumnName = "LlojiAutomjetitID")
    @ManyToOne(optional = false)
    private LlojiAutomjetit llojiAutomjetitID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipiAutomjetitID")
    private Collection<Automjeti> automjetiCollection;

    public TipiAutomjetit() {
    }

    public TipiAutomjetit(Integer tipiAutomjetitID) {
        this.tipiAutomjetitID = tipiAutomjetitID;
    }

    public TipiAutomjetit(Integer tipiAutomjetitID, String emriTipit) {
        this.tipiAutomjetitID = tipiAutomjetitID;
        this.emriTipit = emriTipit;
    }

    public Integer getTipiAutomjetitID() {
        return tipiAutomjetitID;
    }

    public void setTipiAutomjetitID(Integer tipiAutomjetitID) {
        this.tipiAutomjetitID = tipiAutomjetitID;
    }

    public String getEmriTipit() {
        return emriTipit;
    }

    public void setEmriTipit(String emriTipit) {
        this.emriTipit = emriTipit;
    }

    public LlojiAutomjetit getLlojiAutomjetitID() {
        return llojiAutomjetitID;
    }

    public void setLlojiAutomjetitID(LlojiAutomjetit llojiAutomjetitID) {
        this.llojiAutomjetitID = llojiAutomjetitID;
    }

    @XmlTransient
    public Collection<Automjeti> getAutomjetiCollection() {
        return automjetiCollection;
    }

    public void setAutomjetiCollection(Collection<Automjeti> automjetiCollection) {
        this.automjetiCollection = automjetiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipiAutomjetitID != null ? tipiAutomjetitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipiAutomjetit)) {
            return false;
        }
        TipiAutomjetit other = (TipiAutomjetit) object;
        if ((this.tipiAutomjetitID == null && other.tipiAutomjetitID != null) || (this.tipiAutomjetitID != null && !this.tipiAutomjetitID.equals(other.tipiAutomjetitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriTipit;
    }
    
}
