/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.ProveedoresLogicaLocal;
import modelo.Proveedores;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author CANDELO
 */
@Named(value = "proveedoresVista")
@RequestScoped
public class ProveedoresVista {

    @EJB
    private ProveedoresLogicaLocal proveedoresLogica;

    private List<Proveedores> listaProveedores;
    private InputText txtIdentificacion;
    private InputText txtNombre;
    private InputText txtemail;
    private InputText txtdireccion;
    private InputText txtTelefono;
    private InputText txtCiudad;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private Proveedores selectProveedor;

    public List<Proveedores> getListaProveedores() {
        listaProveedores = proveedoresLogica.consultarProveedores();
        return listaProveedores;
    }

    public void setListaProveedores(List<Proveedores> listaProveedores) {
        this.listaProveedores = listaProveedores;
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

    public InputText getTxtemail() {
        return txtemail;
    }

    public void setTxtemail(InputText txtemail) {
        this.txtemail = txtemail;
    }

    public InputText getTxtdireccion() {
        return txtdireccion;
    }

    public void setTxtdireccion(InputText txtdireccion) {
        this.txtdireccion = txtdireccion;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public InputText getTxtCiudad() {
        return txtCiudad;
    }

    public void setTxtCiudad(InputText txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /**
     * Creates a new instance of ProveedoresVista
     */
    public ProveedoresVista() {
    }

    public void registrarProveedor() {

        try {
            Proveedores nuevoProveedor = new Proveedores();

            nuevoProveedor.setIdentificacion(
                    Integer.parseInt(txtIdentificacion.getValue().toString()));

            nuevoProveedor.setNombre(txtNombre.getValue().toString());

            nuevoProveedor.setEmail(txtemail.getValue().toString());

            nuevoProveedor.setTelefono(txtTelefono.getValue().toString());

            nuevoProveedor.setDireccion(txtdireccion.getValue().toString());

            nuevoProveedor.setCiudad(txtCiudad.getValue().toString());

            proveedoresLogica.registrarProveedores(nuevoProveedor);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Proveedor registrado correctamente.")); // Muestra mensaje de información al usario.

        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El proveedor ya se encuenta registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));

        }
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public Proveedores getSelectProveedor() {
        return selectProveedor;
    }

    public void setSelectProveedor(Proveedores selectProveedor) {
        this.selectProveedor = selectProveedor;
    }
    
    public void seleccionarProveedor(SelectEvent pr){
        selectProveedor = (Proveedores) pr.getObject();
        txtIdentificacion.setValue(selectProveedor.getIdentificacion());
        txtNombre.setValue(selectProveedor.getNombre());
        txtemail.setValue(selectProveedor.getEmail());
        txtTelefono.setValue(selectProveedor.getTelefono());
        txtdireccion.setValue(selectProveedor.getDireccion());
        txtCiudad.setValue(selectProveedor.getCiudad());
    }
    
    

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public void modificarProveedor() {

        try {
            Proveedores modificaProveedor = selectProveedor;

            modificaProveedor.setIdentificacion(
                    Integer.parseInt(txtIdentificacion.getValue().toString()));

            modificaProveedor.setNombre(txtNombre.getValue().toString());

            modificaProveedor.setEmail(txtemail.getValue().toString());

            modificaProveedor.setTelefono(txtTelefono.getValue().toString());

            modificaProveedor.setDireccion(txtdireccion.getValue().toString());

            modificaProveedor.setCiudad(txtCiudad.getValue().toString());

            proveedoresLogica.modificarProveedores(modificaProveedor);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Proveedor modificado correctamente.")); // Muestra mensaje de información al usario.

        } catch (Exception ex) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El proveedor ya se encuenta modificado.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));

        }
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }
    
        public void eliminarProveedor() {

        try {
            proveedoresLogica.eliminarProveedores(selectProveedor);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Proveedor eliminado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El proveedor no se encuenta registrado.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

}
