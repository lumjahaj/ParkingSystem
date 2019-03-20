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
@Table(name = "Adresa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresa.findAll", query = "SELECT a FROM Adresa a")
    , @NamedQuery(name = "Adresa.findByAdresaID", query = "SELECT a FROM Adresa a WHERE a.adresaID = :adresaID")
    , @NamedQuery(name = "Adresa.findByQyteti", query = "SELECT a FROM Adresa a WHERE a.qyteti = :qyteti")
    , @NamedQuery(name = "Adresa.findByZipcode", query = "SELECT a FROM Adresa a WHERE a.zipcode = :zipcode")
    , @NamedQuery(name = "Adresa.findByRruga", query = "SELECT a FROM Adresa a WHERE a.rruga = :rruga")})
public class Adresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AdresaID")
    private Integer adresaID;
    @Column(name = "Qyteti")
    private String qyteti;
    @Column(name = "Zipcode")
    private String zipcode;
    @Column(name = "Rruga")
    private String rruga;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adresaID")
    private Collection<Puntori> puntoriCollection;

    public Adresa() {
    }

    public Adresa(Integer adresaID) {
        this.adresaID = adresaID;
    }

    public Integer getAdresaID() {
        return adresaID;
    }

    public void setAdresaID(Integer adresaID) {
        this.adresaID = adresaID;
    }

    public String getQyteti() {
        return qyteti;
    }

    public void setQyteti(String qyteti) {
        this.qyteti = qyteti;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getRruga() {
        return rruga;
    }

    public void setRruga(String rruga) {
        this.rruga = rruga;
    }

    @XmlTransient
    public Collection<Puntori> getPuntoriCollection() {
        return puntoriCollection;
    }

    public void setPuntoriCollection(Collection<Puntori> puntoriCollection) {
        this.puntoriCollection = puntoriCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adresaID != null ? adresaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adresa)) {
            return false;
        }
        Adresa other = (Adresa) object;
        if ((this.adresaID == null && other.adresaID != null) || (this.adresaID != null && !this.adresaID.equals(other.adresaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Adresa[ adresaID=" + adresaID + " ]";
    }
    
}
