/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CANDELO
 */
@Entity
@Table(name = "detalle_factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d")
    , @NamedQuery(name = "DetalleFactura.findByCodVenta", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.codVenta = :codVenta")
    , @NamedQuery(name = "DetalleFactura.findByCodProducto", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.codProducto = :codProducto")
    , @NamedQuery(name = "DetalleFactura.findByCantidad", query = "SELECT d FROM DetalleFactura d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleFactura.findByValorPro", query = "SELECT d FROM DetalleFactura d WHERE d.valorPro = :valorPro")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFacturaPK detalleFacturaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorPro")
    private Double valorPro;
    @JoinColumn(name = "codProducto", referencedColumnName = "idProductos", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    @JoinColumn(name = "codVenta", referencedColumnName = "idVentas", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ventas ventas;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK, int cantidad) {
        this.detalleFacturaPK = detalleFacturaPK;
        this.cantidad = cantidad;
    }

    public DetalleFactura(int codVenta, int codProducto) {
        this.detalleFacturaPK = new DetalleFacturaPK(codVenta, codProducto);
    }

    public DetalleFacturaPK getDetalleFacturaPK() {
        return detalleFacturaPK;
    }

    public void setDetalleFacturaPK(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorPro() {
        return valorPro;
    }

    public void setValorPro(Double valorPro) {
        this.valorPro = valorPro;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFacturaPK != null ? detalleFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.detalleFacturaPK == null && other.detalleFacturaPK != null) || (this.detalleFacturaPK != null && !this.detalleFacturaPK.equals(other.detalleFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleFactura[ detalleFacturaPK=" + detalleFacturaPK + " ]";
    }
    
}
