/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import logica.ColaboradorLogicaLocal;
import logica.VentasLogicaLocal;
import modelo.Colaborador;
import modelo.Ventas;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Laura
 */
@Named(value = "colaboradorVista")
@SessionScoped
@Default
@Any
public class ColaboradorVista implements Serializable {

    @EJB
    private ColaboradorLogicaLocal colaboradorLogica;
    @EJB
    private VentasLogicaLocal ventasLogica;

    private List<Colaborador> listaColaboradores;
    private InputText txtIdentificacion;
    private InputText txtNombre;
    private String txtUserLogueado;
    private InputText txtApellido;
    private InputText txtUsuario;
    private Password txtPassword;
    private InputText txtCorreo;
    private InputText txtTelefono;
    private InputText txtDireccion;
    private InputText txtCargo;
    private InputText usuario;
    private InputText regisVenta;
    private Password clave;
    private CommandButton ingresar;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    Ventas nuevaVenta = new Ventas();
    private Colaborador selectColaborador;
    private Colaborador usuarioLogueado;
    FacesContext fc;

    public List<Colaborador> getListaColaboradores() {

        listaColaboradores = colaboradorLogica.consultaColaboradores();
        return listaColaboradores;
    }

    public void setListaColaboradores(List<Colaborador> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }

    public InputText getTxtIdentificacion() {
        return txtIdentificacion;
    }

    public void setTxtIdentificacion(InputText txtIdentificacion) {
        this.txtIdentificacion = txtIdentificacion;
    }

    public InputText getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(InputText txtNombre) {
        this.txtNombre = txtNombre;
    }

    public InputText getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(InputText txtApellido) {
        this.txtApellido = txtApellido;
    }

    public InputText getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(InputText txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    public Password getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(Password txtPassword) {
        this.txtPassword = txtPassword;
    }

    public InputText getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(InputText txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public InputText getTxtCargo() {
        return txtCargo;
    }

    public void setTxtCargo(InputText txtCargo) {
        this.txtCargo = txtCargo;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /**
     * Creates a new instance of ColaboradorVista
     */
    public ColaboradorVista() {
    }

    public void registrarColaborador() {
        try {

            Colaborador nuevoColaborador = new Colaborador();

            nuevoColaborador.setIdentificacion(
                    Integer.parseInt(txtIdentificacion.getValue().toString()));

            nuevoColaborador.setNombre(txtNombre.getValue().toString());

            nuevoColaborador.setApellido(txtApellido.getValue().toString());

            nuevoColaborador.setNombreuser(txtUsuario.getValue().toString());

//            nuevoColaborador.setClaveUser(txtPassword.getValue().toString());
            String pass = txtPassword.getValue().toString();

            nuevoColaborador.setClaveUser(pass);

            nuevoColaborador.setCorreo(txtCorreo.getValue().toString());

            nuevoColaborador.setTelefono(txtTelefono.getValue().toString());

            nuevoColaborador.setDireccion(txtDireccion.getValue().toString());

            nuevoColaborador.setCargo(txtCargo.getValue().toString());

            colaboradorLogica.registrarColaborador(nuevoColaborador);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Colaborador registrado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El colaborador ya se encuenta registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public Colaborador getSelectColaborador() {
        return selectColaborador;
    }

    public void setSelectColaborador(Colaborador selectColaborador) {
        this.selectColaborador = selectColaborador;
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public void seleccionarColaborador(SelectEvent co) {
        selectColaborador = (Colaborador) co.getObject();
        txtIdentificacion.setValue(selectColaborador.getIdentificacion());
        txtNombre.setValue(selectColaborador.getNombre());
        txtApellido.setValue(selectColaborador.getApellido());
        txtUsuario.setValue(selectColaborador.getNombreuser());
        txtCorreo.setValue(selectColaborador.getCorreo());
        txtTelefono.setValue(selectColaborador.getTelefono());
        txtDireccion.setValue(selectColaborador.getDireccion());
        txtCargo.setValue(selectColaborador.getCargo());
    }

    public void modificarColaborador() {
        try {

            Colaborador modificaColaborador = selectColaborador;

            modificaColaborador.setIdentificacion(
                    Integer.parseInt(txtIdentificacion.getValue().toString()));

            modificaColaborador.setNombre(txtNombre.getValue().toString());

            modificaColaborador.setApellido(txtApellido.getValue().toString());

            modificaColaborador.setNombreuser(txtUsuario.getValue().toString());

            modificaColaborador.setClaveUser(txtPassword.getValue().toString());

            modificaColaborador.setCorreo(txtCorreo.getValue().toString());

            modificaColaborador.setTelefono(txtTelefono.getValue().toString());

            modificaColaborador.setDireccion(txtDireccion.getValue().toString());

            modificaColaborador.setCargo(txtCargo.getValue().toString());

            colaboradorLogica.modificarColaborador(modificaColaborador);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Colaborador modificado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El producto ya se encuentra registrado.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public void eliminarColaborador() {

        try {
            colaboradorLogica.eliminarColaborador(selectColaborador);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Colaborador eliminado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El empleado no se encuenta registrado.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public InputText getUsuario() {
        return usuario;
    }

    public void setUsuario(InputText usuario) {
        this.usuario = usuario;
    }

    public Password getClave() {
        return clave;
    }

    public void setClave(Password clave) {
        this.clave = clave;
    }

    public String getTxtUserLogueado() {
        return txtUserLogueado;
    }

    public void setTxtUserLogueado(String txtUserLogueado) {
        this.txtUserLogueado = txtUserLogueado;
    }

    public CommandButton getIngresar() {
        return ingresar;
    }

    public void setIngresar(CommandButton ingresar) {
        this.ingresar = ingresar;
    }

    public Colaborador getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Colaborador usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public FacesContext getFc() {
        return fc;
    }

    public void setFc(FacesContext fc) {
        this.fc = fc;
    }

    public void ingresarUser() {

        try {

            Colaborador nuevoUsuario = new Colaborador();

            nuevoUsuario.setNombreuser(usuario.getValue().toString());

            nuevoUsuario.setClaveUser(clave.getValue().toString());

            usuarioLogueado = colaboradorLogica.ingresar(nuevoUsuario);

            // Guardo al usuario en la sesión.
            while(usuarioLogueado.getCargo().equals("administrador")) {
                //Redirecciono a la página.
                fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().getSessionMap().put("usuario", usuarioLogueado);
                
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("admin/principal.xhtml");
                txtUserLogueado = usuarioLogueado.getNombre() + " " + usuarioLogueado.getApellido();
                
                FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().remove("usuario2");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("../index.xhtml");
            
                break;
            }

            while(usuarioLogueado.getCargo().equals("colaborador")) {
                fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().getSessionMap().put("usuario2", usuarioLogueado);
                
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("colaborador/principalC.xhtml");
                
                txtUserLogueado = usuarioLogueado.getNombre() + " " + usuarioLogueado.getApellido();
                
                FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().remove("usuario");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("../index.xhtml");
            
                break;
            }

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage())); // Muestra mensaje de información al usario.

            Logger.getLogger(ColaboradorVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public InputText getRegisVenta() {
        return regisVenta;
    }

    public void setRegisVenta(InputText regisVenta) {
        this.regisVenta = regisVenta;
    }

    public void registrarVenta() {

        try {

            nuevaVenta.setIdColaborador(usuarioLogueado);
            Ventas objIdVentas = ventasLogica.traerCodVenta();

            Long idVentasPrin = ventasLogica.totalRegistros();

            if (objIdVentas == null) {

                nuevaVenta.setIdVentas(Integer.parseInt(idVentasPrin.toString()));
                regisVenta.setValue(nuevaVenta.getIdVentas());
            } else {

                regisVenta.setValue(objIdVentas.getIdVentas());
                nuevaVenta.setIdVentas(Integer.parseInt(regisVenta.getValue().toString()));
            }

            ventasLogica.registrarVenta(nuevaVenta);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Venta Registrada correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "La venta ya se encuentra registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }

    }

    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().remove("usuario");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("../index.xhtml");
            
            FacesContext.getCurrentInstance().getExternalContext().
                    getSessionMap().remove("usuario2");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ColaboradorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
