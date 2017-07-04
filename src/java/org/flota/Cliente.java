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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByDni", query = "SELECT c FROM Cliente c WHERE c.dni = :dni")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByDirecci\u00f3n", query = "SELECT c FROM Cliente c WHERE c.direcci\u00f3n = :direcci\u00f3n")
    , @NamedQuery(name = "Cliente.findByTel\u00e9fono", query = "SELECT c FROM Cliente c WHERE c.tel\u00e9fono = :tel\u00e9fono")
    , @NamedQuery(name = "Cliente.findByNotarjeta", query = "SELECT c FROM Cliente c WHERE c.notarjeta = :notarjeta")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "DNI")
    private Long dni;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Direcci\u00f3n")
    private String dirección;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Tel\u00e9fono")
    private long teléfono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "No_tarjeta")
    private long notarjeta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteDNI")
    private List<Alquiler> alquilerList;

    public Cliente() {
    }

    public Cliente(Long dni) {
        this.dni = dni;
    }

    public Cliente(Long dni, String nombre, String dirección, long teléfono, long notarjeta) {
        this.dni = dni;
        this.nombre = nombre;
        this.dirección = dirección;
        this.teléfono = teléfono;
        this.notarjeta = notarjeta;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public long getNotarjeta() {
        return notarjeta;
    }

    public void setNotarjeta(long notarjeta) {
        this.notarjeta = notarjeta;
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
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.flota.Cliente[ dni=" + dni + " ]";
    }
    
}
