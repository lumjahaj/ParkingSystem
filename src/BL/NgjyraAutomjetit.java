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
@Table(name = "NgjyraAutomjetit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NgjyraAutomjetit.findAll", query = "SELECT n FROM NgjyraAutomjetit n")
    , @NamedQuery(name = "NgjyraAutomjetit.findByNgjyraID", query = "SELECT n FROM NgjyraAutomjetit n WHERE n.ngjyraID = :ngjyraID")
    , @NamedQuery(name = "NgjyraAutomjetit.findByEmriNgjyres", query = "SELECT n FROM NgjyraAutomjetit n WHERE n.emriNgjyres = :emriNgjyres")})
public class NgjyraAutomjetit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NgjyraID")
    private Integer ngjyraID;
    @Column(name = "EmriNgjyres")
    private String emriNgjyres;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ngjyraAutomjetitID")
    private Collection<Automjeti> automjetiCollection;

    public NgjyraAutomjetit() {
    }

    public NgjyraAutomjetit(Integer ngjyraID) {
        this.ngjyraID = ngjyraID;
    }

    public Integer getNgjyraID() {
        return ngjyraID;
    }

    public void setNgjyraID(Integer ngjyraID) {
        this.ngjyraID = ngjyraID;
    }

    public String getEmriNgjyres() {
        return emriNgjyres;
    }

    public void setEmriNgjyres(String emriNgjyres) {
        this.emriNgjyres = emriNgjyres;
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
        hash += (ngjyraID != null ? ngjyraID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NgjyraAutomjetit)) {
            return false;
        }
        NgjyraAutomjetit other = (NgjyraAutomjetit) object;
        if ((this.ngjyraID == null && other.ngjyraID != null) || (this.ngjyraID != null && !this.ngjyraID.equals(other.ngjyraID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriNgjyres;
    }
    
}
