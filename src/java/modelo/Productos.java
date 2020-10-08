/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author CrisCande
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByIdProductos", query = "SELECT p FROM Productos p WHERE p.idProductos = :idProductos")
    , @NamedQuery(name = "Productos.findByNombreProducto", query = "SELECT p FROM Productos p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Productos.findByValorCompra", query = "SELECT p FROM Productos p WHERE p.valorCompra = :valorCompra")
    , @NamedQuery(name = "Productos.findByValorVenta", query = "SELECT p FROM Productos p WHERE p.valorVenta = :valorVenta")
    , @NamedQuery(name = "Productos.findByCantidadStock", query = "SELECT p FROM Productos p WHERE p.cantidadStock = :cantidadStock")
    , @NamedQuery(name = "Productos.findByCantidadActual", query = "SELECT p FROM Productos p WHERE p.cantidadActual = :cantidadActual")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProductos")
    private Integer idProductos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCompra")
    private Double valorCompra;
    @Column(name = "valorVenta")
    private Double valorVenta;
    @Column(name = "cantidadStock")
    private Integer cantidadStock;
    @Column(name = "CantidadActual")
    private Integer cantidadActual;
    @OneToMany(mappedBy = "idProductos")
    private List<Factura> facturaList;
    @OneToMany(mappedBy = "idProducto")
    private List<Combos> combosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Promociones> promocionesList;
    @JoinColumn(name = "idCategorias", referencedColumnName = "idCategoria")
    @ManyToOne
    private Categoria idCategorias;
    @JoinColumn(name = "idProveedor", referencedColumnName = "idProveedores")
    @ManyToOne
    private Proveedores idProveedor;

    public Productos() {
    }

    public Productos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public Productos(Integer idProductos, String nombreProducto) {
        this.idProductos = idProductos;
        this.nombreProducto = nombreProducto;
    }

    public Integer getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Integer idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Integer getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Integer cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @XmlTransient
    public List<Combos> getCombosList() {
        return combosList;
    }

    public void setCombosList(List<Combos> combosList) {
        this.combosList = combosList;
    }

    @XmlTransient
    public List<Promociones> getPromocionesList() {
        return promocionesList;
    }

    public void setPromocionesList(List<Promociones> promocionesList) {
        this.promocionesList = promocionesList;
    }

    public Categoria getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Categoria idCategorias) {
        this.idCategorias = idCategorias;
    }

    public Proveedores getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedores idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProductos != null ? idProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.idProductos == null && other.idProductos != null) || (this.idProductos != null && !this.idProductos.equals(other.idProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Productos[ idProductos=" + idProductos + " ]";
    }
    
}
