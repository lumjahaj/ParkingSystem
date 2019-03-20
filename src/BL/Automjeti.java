/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lumi
 */
@Entity
@Table(name = "Automjeti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Automjeti.findAll", query = "SELECT a FROM Automjeti a")
    , @NamedQuery(name = "Automjeti.findByNrTarges", query = "SELECT a FROM Automjeti a WHERE a.nrTarges = :nrTarges")})
public class Automjeti implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NrTarges")
    private String nrTarges;
    @JoinColumn(name = "KategoriaAutomjetitID", referencedColumnName = "KategoriaID")
    @ManyToOne(optional = false)
    private KategoriaAutomjetit kategoriaAutomjetitID;
    @JoinColumn(name = "LlojiNgjyresID", referencedColumnName = "LlojiNgjyresID")
    @ManyToOne(optional = false)
    private LlojiNgjyres llojiNgjyresID;
    @JoinColumn(name = "NgjyraAutomjetitID", referencedColumnName = "NgjyraID")
    @ManyToOne(optional = false)
    private NgjyraAutomjetit ngjyraAutomjetitID;
    @JoinColumn(name = "TipiAutomjetitID", referencedColumnName = "TipiAutomjetitID")
    @ManyToOne(optional = false)
    private TipiAutomjetit tipiAutomjetitID;

    public Automjeti() {
    }

    public Automjeti(String nrTarges) {
        this.nrTarges = nrTarges;
    }

    public String getNrTarges() {
        return nrTarges;
    }

    public void setNrTarges(String nrTarges) {
        this.nrTarges = nrTarges;
    }

    public KategoriaAutomjetit getKategoriaAutomjetitID() {
        return kategoriaAutomjetitID;
    }

    public void setKategoriaAutomjetitID(KategoriaAutomjetit kategoriaAutomjetitID) {
        this.kategoriaAutomjetitID = kategoriaAutomjetitID;
    }

    public LlojiNgjyres getLlojiNgjyresID() {
        return llojiNgjyresID;
    }

    public void setLlojiNgjyresID(LlojiNgjyres llojiNgjyresID) {
        this.llojiNgjyresID = llojiNgjyresID;
    }

    public NgjyraAutomjetit getNgjyraAutomjetitID() {
        return ngjyraAutomjetitID;
    }

    public void setNgjyraAutomjetitID(NgjyraAutomjetit ngjyraAutomjetitID) {
        this.ngjyraAutomjetitID = ngjyraAutomjetitID;
    }

    public TipiAutomjetit getTipiAutomjetitID() {
        return tipiAutomjetitID;
    }

    public void setTipiAutomjetitID(TipiAutomjetit tipiAutomjetitID) {
        this.tipiAutomjetitID = tipiAutomjetitID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrTarges != null ? nrTarges.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automjeti)) {
            return false;
        }
        Automjeti other = (Automjeti) object;
        if ((this.nrTarges == null && other.nrTarges != null) || (this.nrTarges != null && !this.nrTarges.equals(other.nrTarges))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BL.Automjeti[ nrTarges=" + nrTarges + " ]";
    }
    
}
