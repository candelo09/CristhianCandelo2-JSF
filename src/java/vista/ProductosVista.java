/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import logica.ProductosLogicaLocal;
import modelo.Categoria;
import modelo.Productos;
import modelo.Proveedores;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectonemenu.SelectOneMenu;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Laura
 */
@Named(value = "productosVista")
@RequestScoped
public class ProductosVista {

    @EJB
    private ProductosLogicaLocal productosLogica;

    private List<Productos> listaProductos;
    private InputText txtNombreProducto;
    private InputText txtValorCompra;
    private InputText txtValorVenta;
    private InputText txtCantidadStock;
    private InputText txtCantidadActual;
    private CommandButton btnRegistrar;
    private CommandButton btnModificar;
    private CommandButton btnEliminar;
    private SelectOneMenu cmbCategorias;
    private SelectOneMenu cmbProveedores;
    private Productos selectProductos;
    private Categoria selectCategorias;
    private Proveedores selectProveedores;

    public List<Productos> getListaProductos() {
        listaProductos = productosLogica.consultarProductos();
        return listaProductos;
    }

    public void setListaProductos(List<Productos> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public InputText getTxtNombreProducto() {
        return txtNombreProducto;
    }

    public void setTxtNombreProducto(InputText txtNombreProducto) {
        this.txtNombreProducto = txtNombreProducto;
    }

    public InputText getTxtValorCompra() {
        return txtValorCompra;
    }

    public void setTxtValorCompra(InputText txtValorCompra) {
        this.txtValorCompra = txtValorCompra;
    }

    public InputText getTxtValorVenta() {
        return txtValorVenta;
    }

    public void setTxtValorVenta(InputText txtValorVenta) {
        this.txtValorVenta = txtValorVenta;
    }

    public InputText getTxtCantidadStock() {
        return txtCantidadStock;
    }

    public void setTxtCantidadStock(InputText txtCantidadStock) {
        this.txtCantidadStock = txtCantidadStock;
    }

    public InputText getTxtCantidadActual() {
        return txtCantidadActual;
    }

    public void setTxtCantidadActual(InputText txtCantidadActual) {
        this.txtCantidadActual = txtCantidadActual;
    }

    public CommandButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(CommandButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public Categoria getSelectCategorias() {
        return selectCategorias;
    }

    public void setSelectCategorias(Categoria selectCategorias) {
        this.selectCategorias = selectCategorias;
    }

    public Proveedores getSelectProveedores() {
        return selectProveedores;
    }

    public void setSelectProveedores(Proveedores selectProveedores) {
        this.selectProveedores = selectProveedores;
    }

    public SelectOneMenu getCmbCategorias() {
        return cmbCategorias;
    }

    public void setCmbCategorias(SelectOneMenu cmbCategorias) {
        this.cmbCategorias = cmbCategorias;
    }    
    
    public void seleccionarCategoria(SelectEvent ca){
        selectCategorias = (Categoria) ca.getObject();
        cmbCategorias.setValue(selectCategorias.getTipoCategoria());  
    }
    
     public SelectOneMenu getCmbProveedores() {
        return cmbProveedores;
    }

    public void setCmbProveedores(SelectOneMenu cmbProveedores) {
        this.cmbProveedores = cmbProveedores;
    }
    
    public void seleccionarProveedor(SelectEvent pr){
        selectProveedores = (Proveedores) pr.getObject();
        cmbProveedores.setValue(selectProveedores.getNombre());
    }
    
    

    public ProductosVista() {
    }

    public void registrarProductos() {
        try {
            Productos nuevoProducto = new Productos();
            
            Categoria categoria = selectCategorias;
            
            Proveedores proveedores = selectProveedores;

            nuevoProducto.setNombreProducto(txtNombreProducto.getValue().toString());

            nuevoProducto.setValorCompra(
                    Double.parseDouble(txtValorCompra.getValue().toString()));

            nuevoProducto.setValorVenta(
                    Double.parseDouble(txtValorVenta.getValue().toString()));

            nuevoProducto.setCantidadStock(
                    Integer.parseInt(txtCantidadStock.getValue().toString()));

            nuevoProducto.setCantidadActual(
                    Integer.parseInt(txtCantidadActual.getValue().toString()));
            
            nuevoProducto.setIdCategorias(categoria);
            
            nuevoProducto.setIdProveedor(proveedores);
            

            productosLogica.registrarProducto(nuevoProducto);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Producto registrado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El producto ya se encuenta registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public CommandButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(CommandButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public Productos getSelectProductos() {
        return selectProductos;
    }

    public void setSelectProductos(Productos selectProductos) {
        this.selectProductos = selectProductos;
    }

    public void seleccionarProducto(SelectEvent p) {
        selectProductos = (Productos) p.getObject();
        txtNombreProducto.setValue(selectProductos.getNombreProducto());
        txtValorCompra.setValue(selectProductos.getValorCompra());
        txtValorVenta.setValue(selectProductos.getValorVenta());
        txtCantidadStock.setValue(selectProductos.getCantidadStock());
        txtCantidadActual.setValue(selectProductos.getCantidadActual());
    }

    public void modificarProductos() {
        try {
            Productos modificaProductos = selectProductos;
            
            Categoria categoria = selectCategorias;
            
            Proveedores proveedores = selectProveedores;

            modificaProductos.setNombreProducto(txtNombreProducto.getValue().toString());

            modificaProductos.setValorCompra(
                    Double.parseDouble(txtValorCompra.getValue().toString()));

            modificaProductos.setValorVenta(
                    Double.parseDouble(txtValorVenta.getValue().toString()));

            modificaProductos.setCantidadStock(
                    Integer.parseInt(txtCantidadStock.getValue().toString()));

            modificaProductos.setCantidadActual(
                    Integer.parseInt(txtCantidadActual.getValue().toString()));
            
            modificaProductos.setIdCategorias(categoria);
            
            modificaProductos.setIdProveedor(proveedores);

            productosLogica.modificarProducto(modificaProductos);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Producto modificado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El producto ya se encuenta registrado", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

    public CommandButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(CommandButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }
    
    

    public void eliminarProductos() {

        try {
            productosLogica.eliminarProducto(selectProductos);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje",
                            "Producto eliminado correctamente.")); // Muestra mensaje de información al usario.
        } catch (Exception ex) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El producto no se encuenta registrado.", //Muestra mensaje de error al usuario.
                            ex.getMessage()));
        }
    }

}
