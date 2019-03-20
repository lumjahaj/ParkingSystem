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
@Table(name = "LlojiVendparkimit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlojiVendparkimit.findAll", query = "SELECT l FROM LlojiVendparkimit l")
    , @NamedQuery(name = "LlojiVendparkimit.findByLlojiVendparkimitID", query = "SELECT l FROM LlojiVendparkimit l WHERE l.llojiVendparkimitID = :llojiVendparkimitID")
    , @NamedQuery(name = "LlojiVendparkimit.findByEmriLlojitVendparkimit", query = "SELECT l FROM LlojiVendparkimit l WHERE l.emriLlojitVendparkimit = :emriLlojitVendparkimit")})
public class LlojiVendparkimit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LlojiVendparkimitID")
    private Integer llojiVendparkimitID;
    @Basic(optional = false)
    @Column(name = "EmriLlojitVendparkimit")
    private String emriLlojitVendparkimit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "llojiVendparkimitID")
    private Collection<Vendparkimi> vendparkimiCollection;

    public LlojiVendparkimit() {
    }

    public LlojiVendparkimit(Integer llojiVendparkimitID) {
        this.llojiVendparkimitID = llojiVendparkimitID;
    }

    public LlojiVendparkimit(Integer llojiVendparkimitID, String emriLlojitVendparkimit) {
        this.llojiVendparkimitID = llojiVendparkimitID;
        this.emriLlojitVendparkimit = emriLlojitVendparkimit;
    }

    public Integer getLlojiVendparkimitID() {
        return llojiVendparkimitID;
    }

    public void setLlojiVendparkimitID(Integer llojiVendparkimitID) {
        this.llojiVendparkimitID = llojiVendparkimitID;
    }

    public String getEmriLlojitVendparkimit() {
        return emriLlojitVendparkimit;
    }

    public void setEmriLlojitVendparkimit(String emriLlojitVendparkimit) {
        this.emriLlojitVendparkimit = emriLlojitVendparkimit;
    }

    @XmlTransient
    public Collection<Vendparkimi> getVendparkimiCollection() {
        return vendparkimiCollection;
    }

    public void setVendparkimiCollection(Collection<Vendparkimi> vendparkimiCollection) {
        this.vendparkimiCollection = vendparkimiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (llojiVendparkimitID != null ? llojiVendparkimitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlojiVendparkimit)) {
            return false;
        }
        LlojiVendparkimit other = (LlojiVendparkimit) object;
        if ((this.llojiVendparkimitID == null && other.llojiVendparkimitID != null) || (this.llojiVendparkimitID != null && !this.llojiVendparkimitID.equals(other.llojiVendparkimitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.LlojiVendparkimit[ llojiVendparkimitID=" + llojiVendparkimitID + " ]";
    }
    
}
