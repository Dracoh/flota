/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flota;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hectorsantossv
 */
@Entity
@Table(name = "oficina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oficina.findAll", query = "SELECT o FROM Oficina o")
    , @NamedQuery(name = "Oficina.findByIdOficina", query = "SELECT o FROM Oficina o WHERE o.idOficina = :idOficina")
    , @NamedQuery(name = "Oficina.findByDirecci\u00f3n", query = "SELECT o FROM Oficina o WHERE o.direcci\u00f3n = :direcci\u00f3n")
    , @NamedQuery(name = "Oficina.findByTel\u00e9fono", query = "SELECT o FROM Oficina o WHERE o.tel\u00e9fono = :tel\u00e9fono")})
public class Oficina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Oficina")
    private Integer idOficina;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "Direcci\u00f3n")
    private String dirección;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tel\u00e9fono")
    private long teléfono;
    @JoinColumn(name = "Ciudad_Id_Ciudad", referencedColumnName = "Id_Ciudad")
    @ManyToOne(optional = false)
    private Ciudad ciudadIdCiudad;

    public Oficina() {
    }

    public Oficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public Oficina(Integer idOficina, String dirección, long teléfono) {
        this.idOficina = idOficina;
        this.dirección = dirección;
        this.teléfono = teléfono;
    }

    public Integer getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(Integer idOficina) {
        this.idOficina = idOficina;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public long getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(long teléfono) {
        this.teléfono = teléfono;
    }

    public Ciudad getCiudadIdCiudad() {
        return ciudadIdCiudad;
    }

    public void setCiudadIdCiudad(Ciudad ciudadIdCiudad) {
        this.ciudadIdCiudad = ciudadIdCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOficina != null ? idOficina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficina)) {
            return false;
        }
        Oficina other = (Oficina) object;
        if ((this.idOficina == null && other.idOficina != null) || (this.idOficina != null && !this.idOficina.equals(other.idOficina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.flota.Oficina[ idOficina=" + idOficina + " ]";
    }
    
}
