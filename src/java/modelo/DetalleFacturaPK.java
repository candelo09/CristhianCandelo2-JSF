/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author CANDELO
 */
@Embeddable
public class DetalleFacturaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codVenta")
    private int codVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codProducto")
    private int codProducto;

    public DetalleFacturaPK() {
    }

    public DetalleFacturaPK(int codVenta, int codProducto) {
        this.codVenta = codVenta;
        this.codProducto = codProducto;
    }

    public int getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(int codVenta) {
        this.codVenta = codVenta;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codVenta;
        hash += (int) codProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaPK)) {
            return false;
        }
        DetalleFacturaPK other = (DetalleFacturaPK) object;
        if (this.codVenta != other.codVenta) {
            return false;
        }
        if (this.codProducto != other.codProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleFacturaPK[ codVenta=" + codVenta + ", codProducto=" + codProducto + " ]";
    }
    
}
