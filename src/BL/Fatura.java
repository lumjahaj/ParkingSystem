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
@Table(name = "Fatura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f")
    , @NamedQuery(name = "Fatura.findByFaturaID", query = "SELECT f FROM Fatura f WHERE f.faturaID = :faturaID")
    , @NamedQuery(name = "Fatura.findByDataFatures", query = "SELECT f FROM Fatura f WHERE f.dataFatures = :dataFatures")})
public class Fatura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FaturaID")
    private Integer faturaID;
    @Basic(optional = false)
    @Column(name = "DataFatures")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFatures;
    @JoinColumn(name = "FaturaDetajetID", referencedColumnName = "FaturaDetajetID")
    @ManyToOne
    private FaturaDetajet faturaDetajetID;
    @JoinColumn(name = "PuntoriID", referencedColumnName = "PuntoriID")
    @ManyToOne(optional = false)
    private Puntori puntoriID;

    public Fatura() {
    }

    public Fatura(Integer faturaID) {
        this.faturaID = faturaID;
    }

    public Fatura(Integer faturaID, Date dataFatures) {
        this.faturaID = faturaID;
        this.dataFatures = dataFatures;
    }

    public Integer getFaturaID() {
        return faturaID;
    }

    public void setFaturaID(Integer faturaID) {
        this.faturaID = faturaID;
    }

    public Date getDataFatures() {
        return dataFatures;
    }

    public void setDataFatures(Date dataFatures) {
        this.dataFatures = dataFatures;
    }

    public FaturaDetajet getFaturaDetajetID() {
        return faturaDetajetID;
    }

    public void setFaturaDetajetID(FaturaDetajet faturaDetajetID) {
        this.faturaDetajetID = faturaDetajetID;
    }

    public Puntori getPuntoriID() {
        return puntoriID;
    }

    public void setPuntoriID(Puntori puntoriID) {
        this.puntoriID = puntoriID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (faturaID != null ? faturaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fatura)) {
            return false;
        }
        Fatura other = (Fatura) object;
        if ((this.faturaID == null && other.faturaID != null) || (this.faturaID != null && !this.faturaID.equals(other.faturaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Fatura[ faturaID=" + faturaID + " ]";
    }
    
}
