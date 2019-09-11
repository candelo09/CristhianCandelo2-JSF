/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CANDELO
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByValorTotalFactura", query = "SELECT f FROM Factura f WHERE f.valorTotalFactura = :valorTotalFactura")
    , @NamedQuery(name = "Factura.findByCantidadP", query = "SELECT f FROM Factura f WHERE f.cantidadP = :cantidadP")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFactura")
    private Integer idFactura;
    @Column(name = "valorTotalFactura")
    private Integer valorTotalFactura;
    @Column(name = "cantidadP")
    private Integer cantidadP;
    @JoinColumn(name = "idProductos", referencedColumnName = "idProductos")
    @ManyToOne
    private Productos idProductos;
    @JoinColumn(name = "idVenta", referencedColumnName = "idVentas")
    @ManyToOne
    private Ventas idVenta;

    public Factura() {
    }

    public Factura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getValorTotalFactura() {
        return valorTotalFactura;
    }

    public void setValorTotalFactura(Integer valorTotalFactura) {
        this.valorTotalFactura = valorTotalFactura;
    }

    public Integer getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(Integer cantidadP) {
        this.cantidadP = cantidadP;
    }

    public Productos getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Productos idProductos) {
        this.idProductos = idProductos;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFactura != null ? idFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idFactura == null && other.idFactura != null) || (this.idFactura != null && !this.idFactura.equals(other.idFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Factura[ idFactura=" + idFactura + " ]";
    }
    
}
