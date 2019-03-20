/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lumi
 */
@Entity
@Table(name = "Parapagimi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parapagimi.findAll", query = "SELECT p FROM Parapagimi p")
    , @NamedQuery(name = "Parapagimi.findByParapagimiID", query = "SELECT p FROM Parapagimi p WHERE p.parapagimiID = :parapagimiID")
    , @NamedQuery(name = "Parapagimi.findByParapaguarPrej", query = "SELECT p FROM Parapagimi p WHERE p.parapaguarPrej = :parapaguarPrej")
    , @NamedQuery(name = "Parapagimi.findByParapaguarDeri", query = "SELECT p FROM Parapagimi p WHERE p.parapaguarDeri = :parapaguarDeri")})
public class Parapagimi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ParapagimiID")
    private Integer parapagimiID;
    @Basic(optional = false)
    @Column(name = "ParapaguarPrej")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parapaguarPrej;
    @Basic(optional = false)
    @Column(name = "ParapaguarDeri")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parapaguarDeri;
    @JoinColumn(name = "NrPatentes", referencedColumnName = "NrPatentes")
    @ManyToOne(optional = false)
    private Shoferi nrPatentes;
    @JoinColumn(name = "VendparkimiID", referencedColumnName = "VendparkimiID")
    @ManyToOne(optional = false)
    private Vendparkimi vendparkimiID;

    public Parapagimi() {
    }

    public Parapagimi(Integer parapagimiID) {
        this.parapagimiID = parapagimiID;
    }

    public Parapagimi(Integer parapagimiID, Date parapaguarPrej, Date parapaguarDeri) {
        this.parapagimiID = parapagimiID;
        this.parapaguarPrej = parapaguarPrej;
        this.parapaguarDeri = parapaguarDeri;
    }

    public Integer getParapagimiID() {
        return parapagimiID;
    }

    public void setParapagimiID(Integer parapagimiID) {
        this.parapagimiID = parapagimiID;
    }

    public Date getParapaguarPrej() {
        return parapaguarPrej;
    }

    public void setParapaguarPrej(Date parapaguarPrej) {
        this.parapaguarPrej = parapaguarPrej;
    }

    public Date getParapaguarDeri() {
        return parapaguarDeri;
    }

    public void setParapaguarDeri(Date parapaguarDeri) {
        this.parapaguarDeri = parapaguarDeri;
    }

    public Shoferi getNrPatentes() {
        return nrPatentes;
    }

    public void setNrPatentes(Shoferi nrPatentes) {
        this.nrPatentes = nrPatentes;
    }

    public Vendparkimi getVendparkimiID() {
        return vendparkimiID;
    }

    public void setVendparkimiID(Vendparkimi vendparkimiID) {
        this.vendparkimiID = vendparkimiID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parapagimiID != null ? parapagimiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parapagimi)) {
            return false;
        }
        Parapagimi other = (Parapagimi) object;
        if ((this.parapagimiID == null && other.parapagimiID != null) || (this.parapagimiID != null && !this.parapagimiID.equals(other.parapagimiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Parapagimi[ parapagimiID=" + parapagimiID + " ]";
    }
    
}
