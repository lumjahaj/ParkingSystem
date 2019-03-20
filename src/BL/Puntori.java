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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lumi
 */
@Entity
@Table(name = "Puntori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puntori.findAll", query = "SELECT p FROM Puntori p")
    , @NamedQuery(name = "Puntori.findByPuntoriID", query = "SELECT p FROM Puntori p WHERE p.puntoriID = :puntoriID")
    , @NamedQuery(name = "Puntori.findByEmri", query = "SELECT p FROM Puntori p WHERE p.emri = :emri")
    , @NamedQuery(name = "Puntori.findByMbiemri", query = "SELECT p FROM Puntori p WHERE p.mbiemri = :mbiemri")
    , @NamedQuery(name = "Puntori.findByGjinia", query = "SELECT p FROM Puntori p WHERE p.gjinia = :gjinia")
    , @NamedQuery(name = "Puntori.findByDataLindjes", query = "SELECT p FROM Puntori p WHERE p.dataLindjes = :dataLindjes")
    , @NamedQuery(name = "Puntori.findByEmail", query = "SELECT p FROM Puntori p WHERE p.email = :email")
    , @NamedQuery(name = "Puntori.findByNrTelefonit", query = "SELECT p FROM Puntori p WHERE p.nrTelefonit = :nrTelefonit")})
public class Puntori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PuntoriID")
    private Integer puntoriID;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @Column(name = "Gjinia")
    private Character gjinia;
    @Basic(optional = false)
    @Column(name = "DataLindjes")
    @Temporal(TemporalType.DATE)
    private Date dataLindjes;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "NrTelefonit")
    private String nrTelefonit;
    @JoinColumn(name = "AdresaID", referencedColumnName = "AdresaID")
    @ManyToOne(optional = false)
    private Adresa adresaID;
    @JoinColumn(name = "PerdoruesiID", referencedColumnName = "PerdoruesiID")
    @ManyToOne(optional = false)
    private Perdoruesi perdoruesiID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puntoriID")
    private Collection<Fatura> faturaCollection;

    public Puntori() {
    }

    public Puntori(Integer puntoriID) {
        this.puntoriID = puntoriID;
    }

    public Puntori(Integer puntoriID, String emri, String mbiemri, Character gjinia, Date dataLindjes, String email, String nrTelefonit) {
        this.puntoriID = puntoriID;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.gjinia = gjinia;
        this.dataLindjes = dataLindjes;
        this.email = email;
        this.nrTelefonit = nrTelefonit;
    }

    public Integer getPuntoriID() {
        return puntoriID;
    }

    public void setPuntoriID(Integer puntoriID) {
        this.puntoriID = puntoriID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public Character getGjinia() {
        return gjinia;
    }

    public void setGjinia(Character gjinia) {
        this.gjinia = gjinia;
    }

    public Date getDataLindjes() {
        return dataLindjes;
    }

    public void setDataLindjes(Date dataLindjes) {
        this.dataLindjes = dataLindjes;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefonit() {
        return nrTelefonit;
    }

    public void setNrTelefonit(String nrTelefonit) {
        this.nrTelefonit = nrTelefonit;
    }

    public Adresa getAdresaID() {
        return adresaID;
    }

    public void setAdresaID(Adresa adresaID) {
        this.adresaID = adresaID;
    }

    public Perdoruesi getPerdoruesiID() {
        return perdoruesiID;
    }

    public void setPerdoruesiID(Perdoruesi perdoruesiID) {
        this.perdoruesiID = perdoruesiID;
    }

    @XmlTransient
    public Collection<Fatura> getFaturaCollection() {
        return faturaCollection;
    }

    public void setFaturaCollection(Collection<Fatura> faturaCollection) {
        this.faturaCollection = faturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puntoriID != null ? puntoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puntori)) {
            return false;
        }
        Puntori other = (Puntori) object;
        if ((this.puntoriID == null && other.puntoriID != null) || (this.puntoriID != null && !this.puntoriID.equals(other.puntoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Puntori[ puntoriID=" + puntoriID + " ]";
    }
    
}
