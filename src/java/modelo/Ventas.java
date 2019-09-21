/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CANDELO
 */
@Entity
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdVentas", query = "SELECT v FROM Ventas v WHERE v.idVentas = :idVentas")
    , @NamedQuery(name = "Ventas.findByIva", query = "SELECT v FROM Ventas v WHERE v.iva = :iva")
    , @NamedQuery(name = "Ventas.findByImpuesto", query = "SELECT v FROM Ventas v WHERE v.impuesto = :impuesto")
    , @NamedQuery(name = "Ventas.findByDescripcion", query = "SELECT v FROM Ventas v WHERE v.descripcion = :descripcion")
    , @NamedQuery(name = "Ventas.findByValorTotal", query = "SELECT v FROM Ventas v WHERE v.valorTotal = :valorTotal")
    , @NamedQuery(name = "Ventas.findByFecha", query = "SELECT v FROM Ventas v WHERE v.fecha = :fecha")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVentas")
    private Integer idVentas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "iva")
    private Double iva;
    @Column(name = "impuesto")
    private Double impuesto;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valorTotal")
    private Long valorTotal;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idColaborador", referencedColumnName = "idUsuario")
    @ManyToOne
    private Colaborador idColaborador;

    public Ventas() {
    }

    public Ventas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Integer getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(Integer idVentas) {
        this.idVentas = idVentas;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Colaborador getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Colaborador idColaborador) {
        this.idColaborador = idColaborador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVentas != null ? idVentas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVentas == null && other.idVentas != null) || (this.idVentas != null && !this.idVentas.equals(other.idVentas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Ventas[ idVentas=" + idVentas + " ]";
    }
    
}
