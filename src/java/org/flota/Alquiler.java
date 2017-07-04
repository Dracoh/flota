/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flota;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hectorsantossv
 */
@Entity
@Table(name = "alquiler")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alquiler.findAll", query = "SELECT a FROM Alquiler a")
    , @NamedQuery(name = "Alquiler.findByIdAlquiler", query = "SELECT a FROM Alquiler a WHERE a.idAlquiler = :idAlquiler")
    , @NamedQuery(name = "Alquiler.findByFechainicio", query = "SELECT a FROM Alquiler a WHERE a.fechainicio = :fechainicio")
    , @NamedQuery(name = "Alquiler.findByFechafinal", query = "SELECT a FROM Alquiler a WHERE a.fechafinal = :fechafinal")
    , @NamedQuery(name = "Alquiler.findByNodias", query = "SELECT a FROM Alquiler a WHERE a.nodias = :nodias")
    , @NamedQuery(name = "Alquiler.findByValor", query = "SELECT a FROM Alquiler a WHERE a.valor = :valor")})
public class Alquiler implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Alquiler")
    private Integer idAlquiler;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_final")
    @Temporal(TemporalType.DATE)
    private Date fechafinal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "No_dias")
    private short nodias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor")
    private double valor;
    @JoinColumn(name = "Cliente_DNI", referencedColumnName = "DNI")
    @ManyToOne(optional = false)
    private Cliente clienteDNI;
    @JoinColumn(name = "Seguro_Id_seguro", referencedColumnName = "Id_seguro")
    @ManyToOne(optional = false)
    private Seguro seguroIdseguro;
    @JoinColumn(name = "Coche_Matricula", referencedColumnName = "Matricula")
    @ManyToOne(optional = false)
    private Coche cocheMatricula;

    public Alquiler() {
    }

    public Alquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Alquiler(Integer idAlquiler, Date fechainicio, Date fechafinal, short nodias, double valor) {
        this.idAlquiler = idAlquiler;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.nodias = nodias;
        this.valor = valor;
    }

    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public short getNodias() {
        return nodias;
    }

    public void setNodias(short nodias) {
        this.nodias = nodias;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getClienteDNI() {
        return clienteDNI;
    }

    public void setClienteDNI(Cliente clienteDNI) {
        this.clienteDNI = clienteDNI;
    }

    public Seguro getSeguroIdseguro() {
        return seguroIdseguro;
    }

    public void setSeguroIdseguro(Seguro seguroIdseguro) {
        this.seguroIdseguro = seguroIdseguro;
    }

    public Coche getCocheMatricula() {
        return cocheMatricula;
    }

    public void setCocheMatricula(Coche cocheMatricula) {
        this.cocheMatricula = cocheMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlquiler != null ? idAlquiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alquiler)) {
            return false;
        }
        Alquiler other = (Alquiler) object;
        if ((this.idAlquiler == null && other.idAlquiler != null) || (this.idAlquiler != null && !this.idAlquiler.equals(other.idAlquiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.flota.Alquiler[ idAlquiler=" + idAlquiler + " ]";
    }
    
}
