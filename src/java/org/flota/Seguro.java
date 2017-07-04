/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flota;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author hectorsantossv
 */
@Entity
@Table(name = "seguro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguro.findAll", query = "SELECT s FROM Seguro s")
    , @NamedQuery(name = "Seguro.findByIdseguro", query = "SELECT s FROM Seguro s WHERE s.idseguro = :idseguro")
    , @NamedQuery(name = "Seguro.findBySeguro", query = "SELECT s FROM Seguro s WHERE s.seguro = :seguro")})
public class Seguro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Id_seguro")
    private String idseguro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Seguro")
    private String seguro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seguroIdseguro")
    private List<Alquiler> alquilerList;

    public Seguro() {
    }

    public Seguro(String idseguro) {
        this.idseguro = idseguro;
    }

    public Seguro(String idseguro, String seguro) {
        this.idseguro = idseguro;
        this.seguro = seguro;
    }

    public String getIdseguro() {
        return idseguro;
    }

    public void setIdseguro(String idseguro) {
        this.idseguro = idseguro;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    @XmlTransient
    public List<Alquiler> getAlquilerList() {
        return alquilerList;
    }

    public void setAlquilerList(List<Alquiler> alquilerList) {
        this.alquilerList = alquilerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idseguro != null ? idseguro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguro)) {
            return false;
        }
        Seguro other = (Seguro) object;
        if ((this.idseguro == null && other.idseguro != null) || (this.idseguro != null && !this.idseguro.equals(other.idseguro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.flota.Seguro[ idseguro=" + idseguro + " ]";
    }
    
}
