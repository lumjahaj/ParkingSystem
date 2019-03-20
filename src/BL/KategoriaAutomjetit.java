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
@Table(name = "KategoriaAutomjetit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KategoriaAutomjetit.findAll", query = "SELECT k FROM KategoriaAutomjetit k")
    , @NamedQuery(name = "KategoriaAutomjetit.findByKategoriaID", query = "SELECT k FROM KategoriaAutomjetit k WHERE k.kategoriaID = :kategoriaID")
    , @NamedQuery(name = "KategoriaAutomjetit.findByEmriKategorise", query = "SELECT k FROM KategoriaAutomjetit k WHERE k.emriKategorise = :emriKategorise")})
public class KategoriaAutomjetit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KategoriaID")
    private Integer kategoriaID;
    @Basic(optional = false)
    @Column(name = "EmriKategorise")
    private String emriKategorise;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoriaAutomjetitID")
    private Collection<Automjeti> automjetiCollection;

    public KategoriaAutomjetit() {
    }

    public KategoriaAutomjetit(Integer kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    public KategoriaAutomjetit(Integer kategoriaID, String emriKategorise) {
        this.kategoriaID = kategoriaID;
        this.emriKategorise = emriKategorise;
    }

    public Integer getKategoriaID() {
        return kategoriaID;
    }

    public void setKategoriaID(Integer kategoriaID) {
        this.kategoriaID = kategoriaID;
    }

    public String getEmriKategorise() {
        return emriKategorise;
    }

    public void setEmriKategorise(String emriKategorise) {
        this.emriKategorise = emriKategorise;
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
        hash += (kategoriaID != null ? kategoriaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KategoriaAutomjetit)) {
            return false;
        }
        KategoriaAutomjetit other = (KategoriaAutomjetit) object;
        if ((this.kategoriaID == null && other.kategoriaID != null) || (this.kategoriaID != null && !this.kategoriaID.equals(other.kategoriaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriKategorise;
    }
    
}
