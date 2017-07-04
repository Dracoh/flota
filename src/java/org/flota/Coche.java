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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "coche")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coche.findAll", query = "SELECT c FROM Coche c")
    , @NamedQuery(name = "Coche.findByMatricula", query = "SELECT c FROM Coche c WHERE c.matricula = :matricula")
    , @NamedQuery(name = "Coche.findByMarcaIdMarca", query = "SELECT c FROM Coche c WHERE c.marcaIdMarca = :marcaIdMarca")
    , @NamedQuery(name = "Coche.findByOficinaIdOficina", query = "SELECT c FROM Coche c WHERE c.oficinaIdOficina = :oficinaIdOficina")
    , @NamedQuery(name = "Coche.findByModelo", query = "SELECT c FROM Coche c WHERE c.modelo = :modelo")
    , @NamedQuery(name = "Coche.findByPlazas", query = "SELECT c FROM Coche c WHERE c.plazas = :plazas")
    , @NamedQuery(name = "Coche.findByNopuertas", query = "SELECT c FROM Coche c WHERE c.nopuertas = :nopuertas")
    , @NamedQuery(name = "Coche.findByCapMaletero", query = "SELECT c FROM Coche c WHERE c.capMaletero = :capMaletero")
    , @NamedQuery(name = "Coche.findByEdadmin", query = "SELECT c FROM Coche c WHERE c.edadmin = :edadmin")})
public class Coche implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "Matricula")
    private String matricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Marca_Id_Marca")
    private short marcaIdMarca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Oficina_Id_Oficina")
    private int oficinaIdOficina;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Modelo")
    private short modelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Plazas")
    private short plazas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "No_puertas")
    private short nopuertas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cap_Maletero")
    private short capMaletero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Edad_min")
    private short edadmin;
    @JoinColumn(name = "Grupo_id_Grupo", referencedColumnName = "id_Grupo")
    @ManyToOne(optional = false)
    private Grupo grupoidGrupo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cocheMatricula")
    private List<Alquiler> alquilerList;

    public Coche() {
    }

    public Coche(String matricula) {
        this.matricula = matricula;
    }

    public Coche(String matricula, short marcaIdMarca, int oficinaIdOficina, short modelo, short plazas, short nopuertas, short capMaletero, short edadmin) {
        this.matricula = matricula;
        this.marcaIdMarca = marcaIdMarca;
        this.oficinaIdOficina = oficinaIdOficina;
        this.modelo = modelo;
        this.plazas = plazas;
        this.nopuertas = nopuertas;
        this.capMaletero = capMaletero;
        this.edadmin = edadmin;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public short getMarcaIdMarca() {
        return marcaIdMarca;
    }

    public void setMarcaIdMarca(short marcaIdMarca) {
        this.marcaIdMarca = marcaIdMarca;
    }

    public int getOficinaIdOficina() {
        return oficinaIdOficina;
    }

    public void setOficinaIdOficina(int oficinaIdOficina) {
        this.oficinaIdOficina = oficinaIdOficina;
    }

    public short getModelo() {
        return modelo;
    }

    public void setModelo(short modelo) {
        this.modelo = modelo;
    }

    public short getPlazas() {
        return plazas;
    }

    public void setPlazas(short plazas) {
        this.plazas = plazas;
    }

    public short getNopuertas() {
        return nopuertas;
    }

    public void setNopuertas(short nopuertas) {
        this.nopuertas = nopuertas;
    }

    public short getCapMaletero() {
        return capMaletero;
    }

    public void setCapMaletero(short capMaletero) {
        this.capMaletero = capMaletero;
    }

    public short getEdadmin() {
        return edadmin;
    }

    public void setEdadmin(short edadmin) {
        this.edadmin = edadmin;
    }

    public Grupo getGrupoidGrupo() {
        return grupoidGrupo;
    }

    public void setGrupoidGrupo(Grupo grupoidGrupo) {
        this.grupoidGrupo = grupoidGrupo;
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
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coche)) {
            return false;
        }
        Coche other = (Coche) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.flota.Coche[ matricula=" + matricula + " ]";
    }
    
}
