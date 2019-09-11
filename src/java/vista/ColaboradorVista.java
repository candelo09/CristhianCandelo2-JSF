/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.ColaboradorLogicaLocal;
import modelo.Colaborador;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.password.Password;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Laura
 */
@Named(value = "colaboradorVista")
@RequestScoped
public class ColaboradorVista {

    @EJB
    private ColaboradorLogicaLocal colaboradorLogica;

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
    private Password clave;
    private CommandButton ingresar;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private Colaborador selectColaborador;

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

            String encriptar = DigestUtils.md5Hex(pass);

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
    
    public void ingresarUser() {

        try {

            Colaborador nuevoUsuario = new Colaborador();

            nuevoUsuario.setNombreuser(usuario.getValue().toString());

            nuevoUsuario.setClaveUser(clave.getValue().toString());

            Colaborador usuarioLogueado = colaboradorLogica.ingresar(nuevoUsuario);

            // Guardo al usuario en la sesión.
            FacesContext.getCurrentInstance().getExternalContext()
                    .getSessionMap().put("usuario", usuarioLogueado);

            if (usuarioLogueado.getCargo().equals("administrador")) {
                //Redirecciono a la página.
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("admin/principal.xhtml");
                
               txtUserLogueado = usuarioLogueado.getNombre() + usuarioLogueado.getApellido();

                usuario.setValue(txtUserLogueado);
                
                System.out.println("Usuario"+ usuario.getValue().toString());
            }

            if (usuarioLogueado.getCargo().equals("colaborador")) {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("colaborador/principal.xhtml");
                System.out.println("Nombre Usuario " +usuarioLogueado.getNombre() + usuarioLogueado.getApellido());
            }

        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensaje",
                            ex.getMessage())); // Muestra mensaje de información al usario.

            Logger.getLogger(ColaboradorVista.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cerrarSesion() {
        try {
            FacesContext.getCurrentInstance().getExternalContext()
                    .
                    getSessionMap().remove("usuario");
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("../index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ColaboradorVista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
