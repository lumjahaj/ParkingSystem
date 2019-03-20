/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lumi
 */
@Entity
@Table(name = "FaturaDetajet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaturaDetajet.findAll", query = "SELECT f FROM FaturaDetajet f")
    , @NamedQuery(name = "FaturaDetajet.findByFaturaDetajetID", query = "SELECT f FROM FaturaDetajet f WHERE f.faturaDetajetID = :faturaDetajetID")
    , @NamedQuery(name = "FaturaDetajet.findByKohaHyrjes", query = "SELECT f FROM FaturaDetajet f WHERE f.kohaHyrjes = :kohaHyrjes")
    , @NamedQuery(name = "FaturaDetajet.findByKohaDaljes", query = "SELECT f FROM FaturaDetajet f WHERE f.kohaDaljes = :kohaDaljes")
    , @NamedQuery(name = "FaturaDetajet.findByTotali", query = "SELECT f FROM FaturaDetajet f WHERE f.totali = :totali")})
public class FaturaDetajet implements Serializable {

    @OneToMany(mappedBy = "faturaDetajetID")
    private Collection<Fatura> faturaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FaturaDetajetID")
    private Integer faturaDetajetID;
    @Basic(optional = false)
    @Column(name = "KohaHyrjes")
    @Temporal(TemporalType.TIME)
    private Date kohaHyrjes;
    @Basic(optional = false)
    @Column(name = "KohaDaljes")
    @Temporal(TemporalType.TIME)
    private Date kohaDaljes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Totali")
    private Double totali;
    @JoinColumn(name = "FaturaID", referencedColumnName = "FaturaID")
    @ManyToOne(optional = false)
    private Fatura faturaID;

    public FaturaDetajet() {
    }

    public FaturaDetajet(Integer faturaDetajetID) {
        this.faturaDetajetID = faturaDetajetID;
    }

    public FaturaDetajet(Integer faturaDetajetID, Date kohaHyrjes, Date kohaDaljes) {
        this.faturaDetajetID = faturaDetajetID;
        this.kohaHyrjes = kohaHyrjes;
        this.kohaDaljes = kohaDaljes;
    }

    public Integer getFaturaDetajetID() {
        return faturaDetajetID;
    }

    public void setFaturaDetajetID(Integer faturaDetajetID) {
        this.faturaDetajetID = faturaDetajetID;
    }

    public Date getKohaHyrjes() {
        return kohaHyrjes;
    }

    public void setKohaHyrjes(Date kohaHyrjes) {
        this.kohaHyrjes = kohaHyrjes;
    }

    public Date getKohaDaljes() {
        return kohaDaljes;
    }

    public void setKohaDaljes(Date kohaDaljes) {
        this.kohaDaljes = kohaDaljes;
    }

    public Double getTotali() {
        return totali;
    }

    public void setTotali(Double totali) {
        this.totali = totali;
    }

    public Fatura getFaturaID() {
        return faturaID;
    }

    public void setFaturaID(Fatura faturaID) {
        this.faturaID = faturaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faturaDetajetID != null ? faturaDetajetID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FaturaDetajet)) {
            return false;
        }
        FaturaDetajet other = (FaturaDetajet) object;
        if ((this.faturaDetajetID == null && other.faturaDetajetID != null) || (this.faturaDetajetID != null && !this.faturaDetajetID.equals(other.faturaDetajetID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.FaturaDetajet[ faturaDetajetID=" + faturaDetajetID + " ]";
    }

    @XmlTransient
    public Collection<Fatura> getFaturaCollection() {
        return faturaCollection;
    }

    public void setFaturaCollection(Collection<Fatura> faturaCollection) {
        this.faturaCollection = faturaCollection;
    }
    
}
