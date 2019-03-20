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
@Table(name = "Vendparkimi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendparkimi.findAll", query = "SELECT v FROM Vendparkimi v")
    , @NamedQuery(name = "Vendparkimi.findByVendparkimiID", query = "SELECT v FROM Vendparkimi v WHERE v.vendparkimiID = :vendparkimiID")})
public class Vendparkimi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "VendparkimiID")
    private Integer vendparkimiID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendparkimiID")
    private Collection<Parapagimi> parapagimiCollection;
    @JoinColumn(name = "LlojiVendparkimitID", referencedColumnName = "LlojiVendparkimitID")
    @ManyToOne(optional = false)
    private LlojiVendparkimit llojiVendparkimitID;

    public Vendparkimi() {
    }

    public Vendparkimi(Integer vendparkimiID) {
        this.vendparkimiID = vendparkimiID;
    }

    public Integer getVendparkimiID() {
        return vendparkimiID;
    }

    public void setVendparkimiID(Integer vendparkimiID) {
        this.vendparkimiID = vendparkimiID;
    }

    @XmlTransient
    public Collection<Parapagimi> getParapagimiCollection() {
        return parapagimiCollection;
    }

    public void setParapagimiCollection(Collection<Parapagimi> parapagimiCollection) {
        this.parapagimiCollection = parapagimiCollection;
    }

    public LlojiVendparkimit getLlojiVendparkimitID() {
        return llojiVendparkimitID;
    }

    public void setLlojiVendparkimitID(LlojiVendparkimit llojiVendparkimitID) {
        this.llojiVendparkimitID = llojiVendparkimitID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendparkimiID != null ? vendparkimiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendparkimi)) {
            return false;
        }
        Vendparkimi other = (Vendparkimi) object;
        if ((this.vendparkimiID == null && other.vendparkimiID != null) || (this.vendparkimiID != null && !this.vendparkimiID.equals(other.vendparkimiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Vendparkimi[ vendparkimiID=" + vendparkimiID + " ]";
    }
    
}
