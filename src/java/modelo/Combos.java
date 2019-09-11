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
@Table(name = "combos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Combos.findAll", query = "SELECT c FROM Combos c")
    , @NamedQuery(name = "Combos.findByIdCombos", query = "SELECT c FROM Combos c WHERE c.idCombos = :idCombos")
    , @NamedQuery(name = "Combos.findByNombreCombo", query = "SELECT c FROM Combos c WHERE c.nombreCombo = :nombreCombo")
    , @NamedQuery(name = "Combos.findByValorCombo", query = "SELECT c FROM Combos c WHERE c.valorCombo = :valorCombo")})
public class Combos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCombos")
    private Integer idCombos;
    @Size(max = 50)
    @Column(name = "nombreCombo")
    private String nombreCombo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorCombo")
    private Double valorCombo;
    @JoinColumn(name = "idProducto", referencedColumnName = "idProductos")
    @ManyToOne
    private Productos idProducto;

    public Combos() {
    }

    public Combos(Integer idCombos) {
        this.idCombos = idCombos;
    }

    public Integer getIdCombos() {
        return idCombos;
    }

    public void setIdCombos(Integer idCombos) {
        this.idCombos = idCombos;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public Double getValorCombo() {
        return valorCombo;
    }

    public void setValorCombo(Double valorCombo) {
        this.valorCombo = valorCombo;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCombos != null ? idCombos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Combos)) {
            return false;
        }
        Combos other = (Combos) object;
        if ((this.idCombos == null && other.idCombos != null) || (this.idCombos != null && !this.idCombos.equals(other.idCombos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Combos[ idCombos=" + idCombos + " ]";
    }
    
}
