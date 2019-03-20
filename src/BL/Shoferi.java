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
@Table(name = "Shoferi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoferi.findAll", query = "SELECT s FROM Shoferi s")
    , @NamedQuery(name = "Shoferi.findByNrPatentes", query = "SELECT s FROM Shoferi s WHERE s.nrPatentes = :nrPatentes")
    , @NamedQuery(name = "Shoferi.findByEmri", query = "SELECT s FROM Shoferi s WHERE s.emri = :emri")
    , @NamedQuery(name = "Shoferi.findByMbiemri", query = "SELECT s FROM Shoferi s WHERE s.mbiemri = :mbiemri")
    , @NamedQuery(name = "Shoferi.findByNrTelefonit", query = "SELECT s FROM Shoferi s WHERE s.nrTelefonit = :nrTelefonit")})
public class Shoferi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NrPatentes")
    private String nrPatentes;
    @Basic(optional = false)
    @Column(name = "Emri")
    private String emri;
    @Basic(optional = false)
    @Column(name = "Mbiemri")
    private String mbiemri;
    @Basic(optional = false)
    @Column(name = "NrTelefonit")
    private String nrTelefonit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrPatentes")
    private Collection<Parapagimi> parapagimiCollection;

    public Shoferi() {
    }

    public Shoferi(String nrPatentes) {
        this.nrPatentes = nrPatentes;
    }

    public Shoferi(String nrPatentes, String emri, String mbiemri, String nrTelefonit) {
        this.nrPatentes = nrPatentes;
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.nrTelefonit = nrTelefonit;
    }

    public String getNrPatentes() {
        return nrPatentes;
    }

    public void setNrPatentes(String nrPatentes) {
        this.nrPatentes = nrPatentes;
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

    public String getNrTelefonit() {
        return nrTelefonit;
    }

    public void setNrTelefonit(String nrTelefonit) {
        this.nrTelefonit = nrTelefonit;
    }

    @XmlTransient
    public Collection<Parapagimi> getParapagimiCollection() {
        return parapagimiCollection;
    }

    public void setParapagimiCollection(Collection<Parapagimi> parapagimiCollection) {
        this.parapagimiCollection = parapagimiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrPatentes != null ? nrPatentes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoferi)) {
            return false;
        }
        Shoferi other = (Shoferi) object;
        if ((this.nrPatentes == null && other.nrPatentes != null) || (this.nrPatentes != null && !this.nrPatentes.equals(other.nrPatentes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Shoferi[ nrPatentes=" + nrPatentes + " ]";
    }
    
}
