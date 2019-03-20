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
@Table(name = "LlojiNgjyres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlojiNgjyres.findAll", query = "SELECT l FROM LlojiNgjyres l")
    , @NamedQuery(name = "LlojiNgjyres.findByLlojiNgjyresID", query = "SELECT l FROM LlojiNgjyres l WHERE l.llojiNgjyresID = :llojiNgjyresID")
    , @NamedQuery(name = "LlojiNgjyres.findByEmriLlojit", query = "SELECT l FROM LlojiNgjyres l WHERE l.emriLlojit = :emriLlojit")})
public class LlojiNgjyres implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LlojiNgjyresID")
    private Integer llojiNgjyresID;
    @Basic(optional = false)
    @Column(name = "EmriLlojit")
    private String emriLlojit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "llojiNgjyresID")
    private Collection<Automjeti> automjetiCollection;

    public LlojiNgjyres() {
    }

    public LlojiNgjyres(Integer llojiNgjyresID) {
        this.llojiNgjyresID = llojiNgjyresID;
    }

    public LlojiNgjyres(Integer llojiNgjyresID, String emriLlojit) {
        this.llojiNgjyresID = llojiNgjyresID;
        this.emriLlojit = emriLlojit;
    }

    public Integer getLlojiNgjyresID() {
        return llojiNgjyresID;
    }

    public void setLlojiNgjyresID(Integer llojiNgjyresID) {
        this.llojiNgjyresID = llojiNgjyresID;
    }

    public String getEmriLlojit() {
        return emriLlojit;
    }

    public void setEmriLlojit(String emriLlojit) {
        this.emriLlojit = emriLlojit;
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
        hash += (llojiNgjyresID != null ? llojiNgjyresID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlojiNgjyres)) {
            return false;
        }
        LlojiNgjyres other = (LlojiNgjyres) object;
        if ((this.llojiNgjyresID == null && other.llojiNgjyresID != null) || (this.llojiNgjyresID != null && !this.llojiNgjyresID.equals(other.llojiNgjyresID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emriLlojit;
    }
    
}
