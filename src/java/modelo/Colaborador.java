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
 * @author CANDELO
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c")
    , @NamedQuery(name = "Colaborador.findByIdUsuario", query = "SELECT c FROM Colaborador c WHERE c.idUsuario = :idUsuario")
    , @NamedQuery(name = "Colaborador.findByIdentificacion", query = "SELECT c FROM Colaborador c WHERE c.identificacion = :identificacion")
    , @NamedQuery(name = "Colaborador.findByNombreuser", query = "SELECT c FROM Colaborador c WHERE c.nombreuser = :nombreuser")
    , @NamedQuery(name = "Colaborador.findByClaveUser", query = "SELECT c FROM Colaborador c WHERE c.claveUser = :claveUser")
    , @NamedQuery(name = "Colaborador.findByNombre", query = "SELECT c FROM Colaborador c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Colaborador.findByApellido", query = "SELECT c FROM Colaborador c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Colaborador.findByCorreo", query = "SELECT c FROM Colaborador c WHERE c.correo = :correo")
    , @NamedQuery(name = "Colaborador.findByTelefono", query = "SELECT c FROM Colaborador c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Colaborador.findByDireccion", query = "SELECT c FROM Colaborador c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Colaborador.findByCargo", query = "SELECT c FROM Colaborador c WHERE c.cargo = :cargo")})
public class Colaborador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUsuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "identificacion")
    private long identificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombreuser")
    private String nombreuser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "claveUser")
    private String claveUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cargo")
    private String cargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColaborador")
    private List<Ventas> ventasList;

    public Colaborador() {
    }

    public Colaborador(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Colaborador(Integer idUsuario, long identificacion, String nombreuser, String claveUser, String nombre, String apellido, String correo, String telefono, String cargo) {
        this.idUsuario = idUsuario;
        this.identificacion = identificacion;
        this.nombreuser = nombreuser;
        this.claveUser = claveUser;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getClaveUser() {
        return claveUser;
    }

    public void setClaveUser(String claveUser) {
        this.claveUser = claveUser;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Colaborador[ idUsuario=" + idUsuario + " ]";
    }
    
}
