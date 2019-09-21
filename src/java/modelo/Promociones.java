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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CANDELO
 */
@Entity
@Table(name = "promociones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p")
    , @NamedQuery(name = "Promociones.findByIdPromociones", query = "SELECT p FROM Promociones p WHERE p.idPromociones = :idPromociones")
    , @NamedQuery(name = "Promociones.findByDesto", query = "SELECT p FROM Promociones p WHERE p.desto = :desto")
    , @NamedQuery(name = "Promociones.findByEstado", query = "SELECT p FROM Promociones p WHERE p.estado = :estado")})
public class Promociones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPromociones")
    private Integer idPromociones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "desto")
    private Double desto;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idProductos", referencedColumnName = "idProductos")
    @ManyToOne(optional = false)
    private Productos idProductos;

    public Promociones() {
    }

    public Promociones(Integer idPromociones) {
        this.idPromociones = idPromociones;
    }

    public Integer getIdPromociones() {
        return idPromociones;
    }

    public void setIdPromociones(Integer idPromociones) {
        this.idPromociones = idPromociones;
    }

    public Double getDesto() {
        return desto;
    }

    public void setDesto(Double desto) {
        this.desto = desto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Productos getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Productos idProductos) {
        this.idProductos = idProductos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromociones != null ? idPromociones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.idPromociones == null && other.idPromociones != null) || (this.idPromociones != null && !this.idPromociones.equals(other.idPromociones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Promociones[ idPromociones=" + idPromociones + " ]";
    }
    
}
